package tn.esprit.spring.khaddemmaramarfaoui.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.khaddemmaramarfaoui.Repository.DepartementRepository;
import tn.esprit.spring.khaddemmaramarfaoui.enties.Departement;

import java.util.List;
@Service
@AllArgsConstructor
public class DepartementServiceIM implements IDepartementService{
    DepartementRepository departementRepository;
    @Override
    public List<Departement> retrieveAllDepartements() {
        return departementRepository.findAll();
    }

    @Override
    public Departement addDepartement(Departement d) {
        departementRepository.save(d);
        return null;
    }

    @Override
    public Departement updateDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement retrieveDepartement(Integer idDepartement) {
        return departementRepository.findById(idDepartement.longValue()).get();
    }

    @Override
    public void deleteDepartement(Integer idDepartement) {
        departementRepository.deleteById(idDepartement.longValue());

    }
}
