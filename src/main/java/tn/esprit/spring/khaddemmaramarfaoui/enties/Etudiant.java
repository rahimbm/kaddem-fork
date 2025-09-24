package tn.esprit.spring.khaddemmaramarfaoui.enties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "Etudiant")
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idEtudiant")
    private Integer idEtudiant; // Clé primaire
    private String prenomE;
    private String nomE;
    @Column(name = "option_etud")
    private String option;
    @ManyToOne(cascade = CascadeType.ALL)
    Departement departement ;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "etudiant")
    private Set<Contrat> contrats ;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Equipe> equipe ;

// Constructeur et accesseurs (getters) et mutateurs (setters)
}
