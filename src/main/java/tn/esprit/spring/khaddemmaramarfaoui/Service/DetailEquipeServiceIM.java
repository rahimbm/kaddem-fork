package tn.esprit.spring.khaddemmaramarfaoui.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.khaddemmaramarfaoui.Repository.DetailEquipeRepositoryy;
import tn.esprit.spring.khaddemmaramarfaoui.enties.DetailEquipe;

import java.util.List;
@Service
@AllArgsConstructor
public class DetailEquipeServiceIM implements IDetailEquipeService{
    DetailEquipeRepositoryy detailEquipeRepositoryy;
    @Override
    public List<DetailEquipe> retrieveAllDetailEquipes() {
        return detailEquipeRepositoryy.findAll();
    }

    @Override
    public DetailEquipe addDetailEquipe(DetailEquipe de) {
        detailEquipeRepositoryy.save(de);
        return null;
    }

    @Override
    public DetailEquipe updateDetailEquipe(DetailEquipe de) {
       return detailEquipeRepositoryy.save(de);

    }

    @Override
    public DetailEquipe retrieveDetailEquipe(Integer idDetailEquipe) {
        return detailEquipeRepositoryy.findById(idDetailEquipe.longValue()).get();
    }

    @Override
    public void deleteDetailEquipe(Integer idDetailEquipe) {
        detailEquipeRepositoryy.deleteById(idDetailEquipe.longValue());
    }
}
