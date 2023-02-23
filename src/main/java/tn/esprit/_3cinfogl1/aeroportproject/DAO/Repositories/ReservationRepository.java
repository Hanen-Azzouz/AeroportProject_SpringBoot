package tn.esprit._3cinfogl1.aeroportproject.DAO.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit._3cinfogl1.aeroportproject.DAO.Entities.ClassePlace;
import tn.esprit._3cinfogl1.aeroportproject.DAO.Entities.EtatReservation;
import tn.esprit._3cinfogl1.aeroportproject.DAO.Entities.Reservation;

import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation,String> {


List<Reservation> findReservationByVolIdVolAndClassPlaceAndEtatReservation(int idVol, ClassePlace classPlace, EtatReservation eta);


}
