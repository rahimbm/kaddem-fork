package tn.esprit.spring.khaddemmaramarfaoui.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.khaddemmaramarfaoui.enties.Contrat;
import tn.esprit.spring.khaddemmaramarfaoui.enties.Departement;

public interface DepartementRepository extends JpaRepository<Departement,Long> {
}
