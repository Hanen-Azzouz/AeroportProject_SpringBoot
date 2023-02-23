package tn.esprit._3cinfogl1.aeroportproject.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Reservation implements Serializable {


    @Id
    @Column(length = 100)
    String idReservation;
    @Temporal(TemporalType.DATE)
    Date dateReservation;
    @Enumerated(EnumType.STRING)
    ClassePlace classPlace;
    @Enumerated(EnumType.STRING)
    EtatReservation etatReservation;
    //1er relation Reservation est le parent de Voyageur
    @JsonIgnore
    @ManyToOne
    Voyageur voyageur;
    //2eme relation Reservation est le parent de Vol
    @JsonIgnore
    @ManyToOne
    Vol vol;




}
