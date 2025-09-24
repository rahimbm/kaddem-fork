package tn.esprit.spring.khaddemmaramarfaoui.Service;

import tn.esprit.spring.khaddemmaramarfaoui.enties.Etudiant;
import tn.esprit.spring.khaddemmaramarfaoui.enties.Niveau;
import tn.esprit.spring.khaddemmaramarfaoui.enties.Option;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Set;

public interface IEtudiantService {
    List<Etudiant> retrieveAllEtudiants();

    Etudiant addEtudiant (Etudiant e);

    Etudiant updateEtudiant (Etudiant e);

    Etudiant retrieveEtudiant(Integer idEtudiant);

    void removeEtudiant(Integer idEtudiant);
    void assignEtudiantToDepartement (Integer idEtudiant, Integer idDepart) ;
    public Set<Etudiant> getEtudiantsByDepartement(Long idDepart);
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Long idContrat, Long idEquipe);
    int getEtudiantByOption(Option option);



    Etudiant findEtudiantByPrenomE(String prenomE);

    }
