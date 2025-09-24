package tn.esprit.spring.khaddemmaramarfaoui.Service;

import tn.esprit.spring.khaddemmaramarfaoui.enties.Contrat;
import tn.esprit.spring.khaddemmaramarfaoui.enties.Equipe;

import java.util.List;

public interface IContratService {
    List<Contrat> retrieveAllContrats();

    Contrat addContrat(Contrat c);

    Contrat updateContrat (Contrat c);

    Contrat retrieveContrat (Integer idContrat);
    void deleteContrat (Integer idContrat);

    void retrieveAndUpdateStatusContrat();
}
