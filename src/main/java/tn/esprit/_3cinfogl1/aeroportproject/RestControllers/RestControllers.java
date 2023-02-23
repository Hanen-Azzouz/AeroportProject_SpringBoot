package tn.esprit._3cinfogl1.aeroportproject.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit._3cinfogl1.aeroportproject.DAO.Entities.ClassePlace;
import tn.esprit._3cinfogl1.aeroportproject.DAO.Entities.Reservation;
import tn.esprit._3cinfogl1.aeroportproject.DAO.Entities.Vol;
import tn.esprit._3cinfogl1.aeroportproject.DAO.Entities.Voyageur;
import tn.esprit._3cinfogl1.aeroportproject.Services.IServices;

import java.util.List;

@RequestMapping("Aeroport")
@RestController
public class RestControllers {
    @Autowired
    private IServices airportRest;
@PostMapping("ajouterVolEtAeroport")
    String ajouterVolEtAeroport(@RequestBody Vol vol){
        return airportRest.ajouterVolEtAeroport(vol);

    }
    @PostMapping("ajouterVoyageurs")
    List<Voyageur> ajouterVoyageurs(@RequestBody List<Voyageur> voyageurs){
    return airportRest.ajouterVoyageurs(voyageurs);

    }
    @PostMapping("reserverVol")
    String reserverVol(@RequestParam int voyageurId,@RequestParam int volId,@RequestParam ClassePlace classPlace){
    return airportRest.reserverVol(voyageurId,volId,classPlace);


    }
    @PutMapping("confirmerReservation")
    Reservation confirmerReservation(@RequestParam String resId){
    return airportRest.confirmerReservation(resId);
    }

  @DeleteMapping("supprimerVoyageurById/{voyageurId}")
    String supprimerVoyageurById(@PathVariable int voyageurId){
    return airportRest.supprimerVoyageurById(voyageurId);


    }















}
