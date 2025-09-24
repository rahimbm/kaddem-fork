package tn.esprit.spring.khaddemmaramarfaoui.Service;

import tn.esprit.spring.khaddemmaramarfaoui.enties.Departement;
import tn.esprit.spring.khaddemmaramarfaoui.enties.DetailEquipe;

import java.util.List;

public interface IDetailEquipeService {
    List<DetailEquipe> retrieveAllDetailEquipes();

    DetailEquipe addDetailEquipe(DetailEquipe de);

    DetailEquipe updateDetailEquipe (DetailEquipe de);

    DetailEquipe retrieveDetailEquipe (Integer idDetailEquipe);
    void deleteDetailEquipe (Integer idDetailEquipe);
}
