package tn.esprit.spring.khaddemmaramarfaoui.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import tn.esprit.spring.khaddemmaramarfaoui.Service.IUniversiteService;
import tn.esprit.spring.khaddemmaramarfaoui.enties.Universite;

import java.util.List;
@RestController
@AllArgsConstructor
@Tag(name="Gestion des universités")
@RequestMapping("/universite")
public class UniversiteRestController {
    IUniversiteService universiteService;
    @Operation(description="Récupérer la liste des univirsités")
    // http://localhost:8089/Kaddem/equipe/retrieve-all-equipes
    @GetMapping("/retrieve-all-universites")
    public List<Universite> getUniversites() {
        List<Universite> listUniversites = universiteService.retrieveAllUniversites();
        return listUniversites;
    }
    @GetMapping("/retrieve-universite/{universite-id}")
    public Universite retrieveUniversite(@PathVariable("universite-id") Integer idUniversite) {
        return universiteService.retrieveUniversite(idUniversite);
    }
    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite c) {
        Universite universite = universiteService.addUniversite(c);
        return universite;
    }
    @DeleteMapping("/remove-universite/{idUniversite}")
    public void removeOperateur(@PathVariable("equipe-id") Integer idUniversite) {
        universiteService.deleteUniversite(idUniversite);
    }

    @PutMapping("/update-universite")
    public Universite updateUniversite(@RequestBody Universite e) {
        Universite universite= universiteService.updateUniversite(e);
        return universite;
    }
    // http://localhost:8089/Kaddem/universite/assignUniversiteToDepartement
    @PutMapping("/assignUniversiteToDepartement/{idUniversite}/{idDepartement}")
    public void assignUniversiteToDepartement(@PathVariable("idUniversite") Long idUniversite,@PathVariable("idDepartement") Long idDepartement) {
        universiteService.assignUniversiteToDepartement(idUniversite,idDepartement);
    }
}
