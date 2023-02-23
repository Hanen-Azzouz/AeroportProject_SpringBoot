package tn.esprit._3cinfogl1.aeroportproject.Services;

import tn.esprit._3cinfogl1.aeroportproject.DAO.Entities.ClassePlace;
import tn.esprit._3cinfogl1.aeroportproject.DAO.Entities.Reservation;
import tn.esprit._3cinfogl1.aeroportproject.DAO.Entities.Vol;
import tn.esprit._3cinfogl1.aeroportproject.DAO.Entities.Voyageur;

import java.util.List;
import java.util.Map;

public interface IServices {
          public  String ajouterVolEtAeroport(Vol vol);
          public List<Voyageur> ajouterVoyageurs(List<Voyageur> voyageurs);
          public String reserverVol(int voyageurId, int volId, ClassePlace classPlace);
          public Reservation confirmerReservation(String resId);

         public  void annulerReservation();
         public String supprimerVoyageurById(int voyageurId);

























}
