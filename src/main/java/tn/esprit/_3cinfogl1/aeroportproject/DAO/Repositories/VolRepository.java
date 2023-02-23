package tn.esprit._3cinfogl1.aeroportproject.DAO.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit._3cinfogl1.aeroportproject.DAO.Entities.Vol;

@Repository
public interface VolRepository extends CrudRepository<Vol,Integer> {
}
