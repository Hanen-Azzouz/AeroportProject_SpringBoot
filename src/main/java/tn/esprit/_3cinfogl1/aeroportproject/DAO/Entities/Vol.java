package tn.esprit._3cinfogl1.aeroportproject.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Vol implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idVol;
    @Temporal(TemporalType.DATE)
    Date dateDepart;
    @Temporal(TemporalType.DATE)
    Date dateArrive;
    //2eme relation:  Vol est le Child de Reservation
    @OneToMany(mappedBy = "vol",cascade = CascadeType.ALL)
    List<Reservation> reservations;


    //3eme Relation Vol est le parent de Aeroport (Aéroport de départ)
   @JsonIgnore
    @ManyToOne
    Aeroport departureairport;

    // 4eme Relation Vol est le parent de Aeroport (Aéroport d'arrivée)
    @JsonIgnore
     @ManyToOne
    Aeroport arrivalairport;

}
