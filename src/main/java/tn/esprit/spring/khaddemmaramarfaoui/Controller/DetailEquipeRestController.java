package tn.esprit.spring.khaddemmaramarfaoui.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.khaddemmaramarfaoui.Service.IDetailEquipeService;
import tn.esprit.spring.khaddemmaramarfaoui.Service.IEquipeService;
import tn.esprit.spring.khaddemmaramarfaoui.enties.DetailEquipe;
import tn.esprit.spring.khaddemmaramarfaoui.enties.Equipe;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/detailEquipe")
public class DetailEquipeRestController {
    IDetailEquipeService detailEquipeService;

    @GetMapping("/retrieve-all-detailequipes")
    public List<DetailEquipe> getDetailEquipes() {
        List<DetailEquipe> listDetailEquipes = detailEquipeService.retrieveAllDetailEquipes();
        return listDetailEquipes;
    }
    @GetMapping("/retrieve-detailequipe/{detailequipe-id}")
    public DetailEquipe retrieveDetailEquipe(@PathVariable("detailequipe-id") Integer idDetailEquipe) {
        return detailEquipeService.retrieveDetailEquipe(idDetailEquipe);
    }
    @PostMapping("/add-detailequipe")
    public DetailEquipe addDetailEquipe(@RequestBody DetailEquipe e) {
        DetailEquipe detailequipe = detailEquipeService.addDetailEquipe(e);
        return detailequipe;
    }
    @DeleteMapping("/remove-detailequipe/{idDetailEquipe}")
    public void removeOperateur(@PathVariable("detailequipe-id") Integer idDetailEquipe) {
        detailEquipeService.deleteDetailEquipe(idDetailEquipe);
    }

    @PutMapping("/update-detailequipe")
    public DetailEquipe updateDetailEquipe(@RequestBody DetailEquipe e) {
        DetailEquipe detailequipe= detailEquipeService.updateDetailEquipe(e);
        return detailequipe;
    }
}
