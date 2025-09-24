package tn.esprit.spring.khaddemmaramarfaoui.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.khaddemmaramarfaoui.Repository.EquipeRepository;
import tn.esprit.spring.khaddemmaramarfaoui.enties.Equipe;
import tn.esprit.spring.khaddemmaramarfaoui.enties.Niveau;

import java.util.List;
@Service
@AllArgsConstructor
public class EquipeServiceIM implements IEquipeService{
    EquipeRepository equipeRepository ;



    @Override
    public List<Equipe> retrieveAllEquipes() {
        return equipeRepository.findAll();

    }

    @Override
    public Equipe addEquipe(Equipe e) {
        equipeRepository.save(e);
        return null;
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return equipeRepository.save(e);

    }

    @Override
    public Equipe retrieveEquipe(Integer idEquipe) {
        return equipeRepository.findById(idEquipe.longValue()).get();
    }

    @Override
    public void deleteEquipe(Integer idEquipe) {
   equipeRepository.deleteById(idEquipe.longValue());
    }
}
