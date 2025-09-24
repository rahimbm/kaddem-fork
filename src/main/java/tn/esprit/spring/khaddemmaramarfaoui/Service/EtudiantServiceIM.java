package tn.esprit.spring.khaddemmaramarfaoui.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.spring.khaddemmaramarfaoui.Repository.ContratRepository;
import tn.esprit.spring.khaddemmaramarfaoui.Repository.DepartementRepository;
import tn.esprit.spring.khaddemmaramarfaoui.Repository.EquipeRepository;
import tn.esprit.spring.khaddemmaramarfaoui.Repository.EtudiantRepository;
import tn.esprit.spring.khaddemmaramarfaoui.enties.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class EtudiantServiceIM implements IEtudiantService {
    EtudiantRepository etiudiantRepository;
    EquipeRepository equipeRepository;
    ContratRepository contratRepository;
    DepartementRepository departementRepository;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etiudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etiudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etiudiantRepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(Integer idEtudiant) {
        return etiudiantRepository.findById(idEtudiant).get();
    }

    @Override
    public void removeEtudiant(Integer idEtudiant) {
        etiudiantRepository.deleteById(idEtudiant);
    }

    @Override
    public void assignEtudiantToDepartement(Integer idEtudiant, Integer idDepart) {
        Etudiant etudiant = etiudiantRepository.findById(idEtudiant).get();
        Departement departement = departementRepository.findById(idDepart.longValue()).get();

        etudiant.setDepartement(departement);
        etiudiantRepository.save(etudiant);


    }

    public Set<Etudiant> getEtudiantsByDepartement(Long idDepartement) {
        Departement departement = departementRepository.findById(idDepartement).get();
        return departement.getEtudiants();

    }

    @Transactional
    public void assignEtudiantDepartement(Integer etudiantId, Long departementId) {
        Etudiant etudiant = etiudiantRepository.findById(etudiantId).get();
        Departement departement = departementRepository.findById(departementId).get();
        etudiant.setDepartement(departement);
        etiudiantRepository.save(etudiant);
    }

    @Transactional
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Long idContrat, Long idEquipe) {
        Etudiant etudiant = etiudiantRepository.save(e);
        Equipe equipe = equipeRepository.findById(idEquipe).get();
        Contrat contrat = contratRepository.findById(idContrat).get();
        log.info("contrat: " + contrat.getSpecialite());
        log.info("equipe: " + equipe.getNomEquipe());
        log.info("etudiant: " + etudiant.getNomE());
        equipe.getEtudiant().add(etudiant);
        contrat.setEtudiant(etudiant);
        return e;
    }

    @Override
    public int getEtudiantByOption(Option option) {
        return etiudiantRepository.getEtudiantByOption(option);
    }




    @Override
    public Etudiant findEtudiantByPrenomE(String prenomE) {
        return  etiudiantRepository.findByPrenomE(prenomE);
    }

}