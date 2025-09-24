package tn.esprit.spring.khaddemmaramarfaoui.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.khaddemmaramarfaoui.enties.Equipe;
@Repository

public interface EquipeRepository extends JpaRepository <Equipe,Long> {
}
