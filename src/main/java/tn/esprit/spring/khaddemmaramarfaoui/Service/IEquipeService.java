package tn.esprit.spring.khaddemmaramarfaoui.Service;

import tn.esprit.spring.khaddemmaramarfaoui.enties.Equipe;

import java.util.List;

public interface IEquipeService {
    List<Equipe> retrieveAllEquipes();

    Equipe addEquipe(Equipe e);

    Equipe updateEquipe (Equipe e);

    Equipe retrieveEquipe (Integer idEquipe);
    void deleteEquipe (Integer idEquipe);
}

