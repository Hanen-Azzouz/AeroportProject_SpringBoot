package tn.esprit._3cinfogl1.aeroportproject.DAO.Repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit._3cinfogl1.aeroportproject.DAO.Entities.Voyageur;

import javax.transaction.Transactional;

@Repository
public interface VoyageurRepository extends CrudRepository<Voyageur,Integer> {



    @Modifying
    @Query(value = "delete from voyageur where  id_voyageur=:ident",nativeQuery = true)
    @Transactional
    void deleteByIdVoyageurjpql(@Param("ident") int id);
}
//)
