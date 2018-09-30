package com.anakeredchieva.doctor.sheduler.repositories;


import com.anakeredchieva.doctor.sheduler.entities.PatientsDiseases;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by akere on 09/30/2018.
 */
@Repository
public interface PatientDiseasesRepository extends CrudRepository<PatientsDiseases, Integer> {

    List<PatientsDiseases> getAllDiseasesByPatientId(Integer patientId);

    PatientsDiseases findByPatientIdAndDiseaseId(Integer patientId, Integer diseaseId);
}

