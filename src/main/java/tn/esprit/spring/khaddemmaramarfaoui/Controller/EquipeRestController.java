package tn.esprit.spring.khaddemmaramarfaoui.Controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.khaddemmaramarfaoui.Service.IEquipeService;
import tn.esprit.spring.khaddemmaramarfaoui.enties.Equipe;

import java.util.List;

@RestController
    @AllArgsConstructor
    @RequestMapping("/equipe")
    public class EquipeRestController {
        IEquipeService equipeService;
        // http://localhost:8089/Kaddem/equipe/retrieve-all-equipes
        @GetMapping("/retrieve-all-equipes")
        public List<Equipe> getEquipes() {
            List<Equipe> listEquipes = equipeService.retrieveAllEquipes();
            return listEquipes;
        }
    @GetMapping("/retrieve-equipe/{equipe-id}")
    public Equipe retrieveEquipe(@PathVariable("equipe-id") Integer idEquipe) {
        return equipeService.retrieveEquipe(idEquipe);
    }
    @PostMapping("/add-equipe")
    public Equipe addEquipe(@RequestBody Equipe e) {
        Equipe equipe = equipeService.addEquipe(e);
        return equipe;
    }
    @DeleteMapping("/remove-equipe/{idEquipe}")
    public void removeOperateur(@PathVariable("equipe-id") Integer idEquipe) {
        equipeService.deleteEquipe(idEquipe);
    }

    @PutMapping("/update-equipe")
    public Equipe updateEquipe(@RequestBody Equipe e) {
        Equipe equipe= equipeService.updateEquipe(e);
        return equipe;
    }
}
