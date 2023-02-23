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
public class Voyageur implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idVoyageur;
    String nom;
    String prenom;
    @Temporal(TemporalType.DATE)
    Date dateNaissance;


    //1er relation:  Voyageur est le Child de Reservation
    @JsonIgnore
    @OneToMany(mappedBy = "voyageur",cascade = CascadeType.ALL)
    List<Reservation> reservationslist;




}
