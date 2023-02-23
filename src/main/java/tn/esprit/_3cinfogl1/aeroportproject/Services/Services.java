package tn.esprit._3cinfogl1.aeroportproject.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit._3cinfogl1.aeroportproject.DAO.Entities.*;
import tn.esprit._3cinfogl1.aeroportproject.DAO.Repositories.AeroportRepository;
import tn.esprit._3cinfogl1.aeroportproject.DAO.Repositories.ReservationRepository;
import tn.esprit._3cinfogl1.aeroportproject.DAO.Repositories.VolRepository;
import tn.esprit._3cinfogl1.aeroportproject.DAO.Repositories.VoyageurRepository;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class Services implements IServices{

    @Autowired
    private AeroportRepository aeroportRepo;
    @Autowired
    private ReservationRepository reservationRepo;
    @Autowired
    private VolRepository volRepo;
    @Autowired
    private VoyageurRepository voyageurRepo;


    @Override
    public String ajouterVolEtAeroport(Vol vol) {
        Aeroport aeroportdepart=vol.getDepartureairport();
        Aeroport aeroportarrivee=vol.getArrivalairport();
        if(aeroportdepart.getCodeAITA()==aeroportarrivee.getCodeAITA()){
            return "<< Vérifier les aéroports saisis ! >>";
        }
        else{
            aeroportRepo.save(aeroportdepart);
            aeroportRepo.save(aeroportarrivee);
            volRepo.save(vol);
            return "<< Le vol est ajouté avec succès !>>";

        }

    }

    @Override
    public List<Voyageur> ajouterVoyageurs(List<Voyageur> voyageurs) {
        for (Voyageur v :voyageurs) {
           voyageurRepo.save(v);
        }

        return voyageurs;
    }

    @Override
    public String reserverVol(int voyageurId, int volId, ClassePlace classPlace) {
        String msg = "";
        Reservation reservation;
        Voyageur voyageuraffecte = voyageurRepo.findById(voyageurId).get();
        Vol volaffecte = volRepo.findById(volId).get();
        // Vérification du nbre place pour classe Business
        if (classPlace == ClassePlace.BUSINESS) {
            if (reservationRepo.findReservationByVolIdVolAndClassPlaceAndEtatReservation(volaffecte.getIdVol(), ClassePlace.BUSINESS, EtatReservation.CONFIRMEE).size() < 2) {
                reservation = Reservation.builder()
                        .idReservation(ClassePlace.BUSINESS.toString().substring(0, 3) + "-" + volaffecte.getIdVol() + "-" + voyageuraffecte.getIdVoyageur())
                        .classPlace(ClassePlace.BUSINESS)
                        .dateReservation(new Date())
                        .etatReservation(EtatReservation.ENCOURS)
                        .voyageur(voyageuraffecte)
                        .vol(volaffecte)
                        .build();
                reservation=reservationRepo.save(reservation);
                msg = "<< L'affectation du voyageur est effectuée avec succès >> L'ID de la réservation est: " + reservation.getIdReservation();

            } else {
                msg = "<<La classe" + ClassePlace.BUSINESS + "du vol" + volaffecte.getIdVol() + "est complet>>";
            }

        }
        // Vérification du nbre place pour classe Economique
        else if (classPlace == ClassePlace.ECONOMIQUE) {
        
            if (reservationRepo.findReservationByVolIdVolAndClassPlaceAndEtatReservation(volaffecte.getIdVol(), ClassePlace.ECONOMIQUE, EtatReservation.CONFIRMEE).size() < 3) {
                reservation = Reservation.builder()
                        .idReservation(ClassePlace.ECONOMIQUE.toString().substring(0, 3) + "-" + volaffecte.getIdVol() + "-" + voyageuraffecte.getIdVoyageur()).
                        classPlace(ClassePlace.ECONOMIQUE).
                        dateReservation(new Date()).
                        etatReservation(EtatReservation.ENCOURS).
                        voyageur(voyageuraffecte).
                        vol(volaffecte).
                        build();


                reservation=reservationRepo.save(reservation);

                msg = "<< L'affectation du voyageur est effectuée avec succès >> L'ID de la réservation est: " + reservation.getIdReservation();

            } else {
                msg = "<<La classe" + ClassePlace.ECONOMIQUE + "du vol" + volaffecte.getIdVol() + "est complet>>";
            }

        }
            return msg;
        }

    @Override
    public Reservation confirmerReservation(String resId) {

        Reservation reservation=reservationRepo.findById(resId).get();
        reservation.setEtatReservation(EtatReservation.CONFIRMEE);
        reservationRepo.save(reservation);
        return reservation;
    }
@Scheduled(cron = "8 * * * * *")
    @Override
    public void annulerReservation() {
        List<Reservation> reservationsannulees= (List<Reservation>) reservationRepo.findAll();
    for (Reservation r :reservationsannulees) {
         if(r.getEtatReservation().equals(EtatReservation.ENCOURS)&&(calculDiff(new Date(),r.getDateReservation())<=1)){
             r.setEtatReservation(EtatReservation.ANNULEE);
             reservationRepo.save(r);
             log.info("tn.esprit._3cinfogl1.aeroportproject.Services : Reservation annulée :"+r.getIdReservation());
         }
    }
    }

    @Override
    public String supprimerVoyageurById(int voyageurId) {

        Voyageur voyageursupprime=voyageurRepo.findById(voyageurId).get();
        voyageurRepo.deleteByIdVoyageurjpql(voyageurId);
        return "Le voyageur "+ voyageursupprime.getNom()+ " "+voyageursupprime.getPrenom() +" a été supprimé avec sucès ! ";
    }

    public long calculDiff(Date dateDepart, Date dateArrivee) {
        long diffInMillies = dateArrivee.getTime() - dateDepart.getTime();
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }


}
