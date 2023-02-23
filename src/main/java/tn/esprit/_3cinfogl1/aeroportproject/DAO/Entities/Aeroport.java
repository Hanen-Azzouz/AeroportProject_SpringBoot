package tn.esprit._3cinfogl1.aeroportproject.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Aeroport implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  int idAeroport;
    String nom;
    @Column(unique = true,length = 3)
    String codeAITA;
    long telephone;
    //3eme Relation :  Aeroport est le Child de Vol   (Aéroport de départ)
    @JsonIgnore
    @OneToMany(mappedBy = "departureairport",cascade = CascadeType.ALL)
    List<Vol> volsdepart;

    //4eme Relation :  Aeroport est le Child de Vol   (Aéroport d'arrivée)
    @JsonIgnore
    @OneToMany(mappedBy = "arrivalairport",cascade = CascadeType.ALL)
    List<Vol> volsarrivee;


}
