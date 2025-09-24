package tn.esprit.spring.khaddemmaramarfaoui.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring.khaddemmaramarfaoui.enties.Contrat;
import tn.esprit.spring.khaddemmaramarfaoui.enties.Etudiant;
import tn.esprit.spring.khaddemmaramarfaoui.enties.Niveau;
import tn.esprit.spring.khaddemmaramarfaoui.enties.Option;

import java.util.List;
import java.util.Set;

public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {

    Etudiant findByPrenomE(String prenomE);
    @Query("select count (et) from Etudiant et where et.option=:option")
    int getEtudiantByOption(@Param("option") Option option);
    int countEtudiantByOptionAndContratsIsNotNull(Option Option);


}