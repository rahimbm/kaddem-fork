package tn.esprit.spring.khaddemmaramarfaoui.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.khaddemmaramarfaoui.Service.IContratService;
import tn.esprit.spring.khaddemmaramarfaoui.Service.IDepartementService;
import tn.esprit.spring.khaddemmaramarfaoui.enties.Contrat;
import tn.esprit.spring.khaddemmaramarfaoui.enties.Departement;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/departement")
public class DepartementRestController {
    IDepartementService departementService;


    @GetMapping("/retrieveAllDepartements")
    public List<Departement> getDepartements() {
        List<Departement> listDepartements = departementService.retrieveAllDepartements();
        return listDepartements;
    }
    @GetMapping("/retrieve-departement/{departement-id}")
    public Departement retrieveDepartement(@PathVariable("departement-id") Integer idDepartement) {
        return departementService.retrieveDepartement(idDepartement);
    }
    @PostMapping("/add-departement")
    public Departement addDepartement(@RequestBody Departement d) {
        Departement departement = departementService.addDepartement(d);
        return departement;
    }
    @DeleteMapping("/remove-departement/{idDepartement}")
    public void removeOperateur(@PathVariable("departement-id") Integer idDepartement){
        departementService.deleteDepartement ( idDepartement);
    }
    @PutMapping("/update-departement")
    public Departement updateDepartement(@RequestBody Departement d) {
        Departement departement= departementService.updateDepartement(d);
        return departement;
    }
}
