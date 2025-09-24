package tn.esprit.spring.khaddemmaramarfaoui.Service;

import tn.esprit.spring.khaddemmaramarfaoui.enties.Departement;

import java.util.List;

public interface IDepartementService {
    List<Departement> retrieveAllDepartements();

    Departement addDepartement(Departement d);

    Departement updateDepartement (Departement d);

    Departement retrieveDepartement (Integer idDepartement);
    void deleteDepartement (Integer idDepartement);
}
