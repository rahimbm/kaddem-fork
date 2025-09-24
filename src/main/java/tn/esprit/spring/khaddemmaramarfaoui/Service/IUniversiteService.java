package tn.esprit.spring.khaddemmaramarfaoui.Service;

import tn.esprit.spring.khaddemmaramarfaoui.enties.Equipe;
import tn.esprit.spring.khaddemmaramarfaoui.enties.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversites();

    Universite addUniversite(Universite u);

    Universite updateUniversite(Universite u);

    Universite retrieveUniversite (Integer idUniversite);
    void deleteUniversite (Integer idUniversite);
    public void assignUniversiteToDepartement(Long idUniversite, Long idDepartement);
    }
