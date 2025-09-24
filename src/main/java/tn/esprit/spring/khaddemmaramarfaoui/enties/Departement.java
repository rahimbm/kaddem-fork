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
@Table( name = "Departement")
public class Departement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idDepart")
    private Integer idDepart; // Clé primaire
    private String nomDepart ;
   @OneToMany(cascade = CascadeType.ALL,mappedBy = "departement")
    private Set<Etudiant> Etudiants ;
}
