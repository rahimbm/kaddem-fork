package tn.esprit.spring.khaddemmaramarfaoui.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.khaddemmaramarfaoui.enties.Universite;
@Repository
public interface UniversiteRepository extends JpaRepository<Universite,Long> {
}
