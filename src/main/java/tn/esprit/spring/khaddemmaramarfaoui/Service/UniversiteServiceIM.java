package tn.esprit.spring.khaddemmaramarfaoui.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.khaddemmaramarfaoui.Repository.DepartementRepository;
import tn.esprit.spring.khaddemmaramarfaoui.Repository.UniversiteRepository;
import tn.esprit.spring.khaddemmaramarfaoui.enties.Departement;
import tn.esprit.spring.khaddemmaramarfaoui.enties.Universite;

import javax.transaction.Transactional;
import java.util.List;
@Service
@AllArgsConstructor
public class UniversiteServiceIM implements IUniversiteService{
 UniversiteRepository universiteRepository;
 DepartementRepository departementRepository ;
    @Override
    public List<Universite> retrieveAllUniversites() {
        return universiteRepository.findAll();
    }

     @Transactional
    public  Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        return universiteRepository.findById(idUniversite.longValue()).get();
    }

    @Override
    public void deleteUniversite(Integer idUniversite) {
        universiteRepository.deleteById(idUniversite.longValue());
    }
    @Transactional
    public void assignUniversiteToDepartement(Long idUniversite, Long idDepartement) {
        Universite uni = universiteRepository.findById(idUniversite).get();
        Departement dep = departementRepository.findById(idDepartement).get();
       uni.getDepartements().add(dep);
    }
}
