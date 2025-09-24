package tn.esprit.spring.khaddemmaramarfaoui.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.khaddemmaramarfaoui.Service.EtudiantServiceIM;
import tn.esprit.spring.khaddemmaramarfaoui.Service.IEquipeService;
import tn.esprit.spring.khaddemmaramarfaoui.Service.IEtudiantService;
import tn.esprit.spring.khaddemmaramarfaoui.enties.Equipe;
import tn.esprit.spring.khaddemmaramarfaoui.enties.Etudiant;
import tn.esprit.spring.khaddemmaramarfaoui.enties.Niveau;
import tn.esprit.spring.khaddemmaramarfaoui.enties.Option;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class   EtudiantRestController {
    EtudiantServiceIM etudiantService;

    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> getEtudiants() {
        List<Etudiant> listEtudiants = etudiantService.retrieveAllEtudiants();
        return listEtudiants;
    }

    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Integer idEtudiant) {
        return etudiantService.retrieveEtudiant(idEtudiant);
    }

    @PostMapping("/add-etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant = etudiantService.addEtudiant(e);
        return etudiant;
    }

    @DeleteMapping("/remove-etudiant/{idEtudiant}")
    public void removeOperateur(@PathVariable("equipe-id") Integer idEtudiant) {
        etudiantService.removeEtudiant(idEtudiant);
    }

    @PutMapping("/update-etudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant = etudiantService.updateEtudiant(e);
        return etudiant;
    }

    // http://localhost:8082/Kaddem/etudiant/getEtudiantsByDepartement
    @PostMapping("/getEtudiantsByDepartement/{idDepartement}")
    public Set<Etudiant> getEtudiantsByDepartement(@PathVariable("idDepartement") Long idDepartement) {
        return etudiantService.getEtudiantsByDepartement(idDepartement);
    }

    // http://localhost:8089/Kaddem/etudiant/assignEtudiantDepartement
    @PutMapping("/assignEtudiantDepartement/{idEtudiant}/{idDepart}")
    public void assignEtudiantDepartement(@PathVariable("idEtudiant") Integer idEtudiant, @PathVariable("idDepart") Long idDepart) {
        etudiantService.assignEtudiantDepartement(idEtudiant, idDepart);
    }

    // http://localhost:8089/Kaddem/etudiant/addAndAssignEtudiantToEquipeAndContract
    @PostMapping("/addAndAssignEtudiantToEquipeAndContract/{contrat-id}/{equipe-id}")
    public Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant e, @PathVariable("contrat-id") Long idContrat, @PathVariable("equipe-id") Long idEquipe) {
        etudiantService.addAndAssignEtudiantToEquipeAndContract(e, idContrat, idEquipe);
        return e;
    }

    @GetMapping("/getEtudiantByOption/{option}")
    public int getEtudiantByOption(@PathVariable("option") Option option) {
        return etudiantService.getEtudiantByOption(option);
    }



    @GetMapping("/findEtudiantByPrenomE/{prenomE}")
    public Etudiant findEtudiantByPrenomE(@PathVariable("prenomE") String prenomE){
        return etudiantService.findEtudiantByPrenomE(prenomE);
    }
}


