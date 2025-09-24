package tn.esprit.spring.khaddemmaramarfaoui.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.khaddemmaramarfaoui.Service.ContratServiceIM;
import tn.esprit.spring.khaddemmaramarfaoui.Service.IContratService;
import tn.esprit.spring.khaddemmaramarfaoui.enties.Contrat;
import tn.esprit.spring.khaddemmaramarfaoui.enties.Equipe;

import java.util.List;

@RestController
@AllArgsConstructor
@Tag(name = "Contrat Management" )
@RequestMapping("/contrat")
public class ContratRestController {
    IContratService contratService;
    @Operation(description = "Liste des Contrat")

    // http://localhost:8089/Kaddem/contrat/retrieveAllContrats
    @GetMapping("/retrieveAllContrats")
    public List<Contrat> getContrats() {
        List<Contrat> listContrats = contratService.retrieveAllContrats();
        return listContrats;
    }
    @GetMapping("/retrieve-contrat/{contrat-id}")
    public Contrat retrieveContrat(@PathVariable("contrat-id") Integer idContrat) {
        return contratService.retrieveContrat(idContrat);
    }
    @PostMapping("/add-contrat")
    public Contrat addContrat(@RequestBody Contrat c) {
        Contrat contrat = contratService.addContrat(c);
        return contrat;
    }
    @DeleteMapping("/remove-contrat/{idContrat}")
    public void removeOperateur(@PathVariable("contrat-id") Integer idContrat){
        contratService.deleteContrat ( idContrat);
    }
    @PutMapping("/update-contrat")
    public Contrat updateContrat(@RequestBody Contrat c) {
        Contrat contrat= contratService.updateContrat(c);
        return contrat;
    }
}