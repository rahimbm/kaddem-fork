package tn.esprit.spring.khaddemmaramarfaoui.enties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "Contrat")
public class Contrat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idContrat")
    private Integer idContrat; // Clé primaire
    @Temporal(TemporalType.DATE)
    private Date dateDebutContrat;
    private Date dateFinContrat;
    @Enumerated(EnumType.STRING)
    private Specialte specialite ;
    private Boolean archive;
    private Integer montantContrat;
    @ManyToOne
    Etudiant etudiant ;


}
