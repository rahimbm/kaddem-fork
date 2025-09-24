package tn.esprit.spring.khaddemmaramarfaoui.enties;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table( name = "Equipe")
public class Equipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEquipe")
    private Integer idEquipe; // Clé primaire
    private String nomEquipe ;
    @Enumerated(EnumType.STRING)
    private Niveau niveau ;

    @OneToOne(cascade = CascadeType.ALL) ///nzidouha 5ater ahna bch njiibou kiima n9oulou clinique m3ah liste des medecin nwaliou nziidou hedhy

    private DetailEquipe detailEquipe;

    @ManyToMany(mappedBy="equipe",cascade=CascadeType.ALL)
    private Set<Etudiant> etudiant;

}
