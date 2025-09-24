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
@Table( name = "Universite")
public class Universite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUniv")
    private Integer idUniv; // Clé primaire
    private String nomUniv ;
    @OneToMany(cascade =CascadeType.ALL)
    private Set<Departement> departements ;
}
