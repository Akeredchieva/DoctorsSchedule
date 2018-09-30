package com.anakeredchieva.doctor.sheduler.repositories;

import com.anakeredchieva.doctor.sheduler.entities.Diseases;
import com.anakeredchieva.doctor.sheduler.entities.PatientsDiseases;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatientDiseasesRepository extends CrudRepository<PatientsDiseases, Integer> {

    List<PatientsDiseases> getAllDiseasesByPatientId(Integer patientId);
    PatientsDiseases findByPatientIdAndDiseaseId(Integer patientId, Integer diseaseId);

}
