package com.anakeredchieva.doctor.sheduler.repositories;

import com.anakeredchieva.doctor.sheduler.entities.Patients;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by akere on 08/12/2017.
 */
@Repository
public interface PatientRepository extends CrudRepository<Patients, Integer> {

    Patients findByEgn(String egn);
}
