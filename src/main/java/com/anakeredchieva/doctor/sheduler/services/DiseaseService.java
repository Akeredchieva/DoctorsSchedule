package com.anakeredchieva.doctor.sheduler.services;

import com.anakeredchieva.doctor.sheduler.model.DiseasesTO;
import com.anakeredchieva.doctor.sheduler.model.PatientTO;

import java.util.List;

/**
 * Created by akere on 05/14/2018.
 */
public interface DiseaseService {
    void createDisease(DiseasesTO diseasesTO, Integer patientId);
    List<DiseasesTO> findAllDiseases();
    void updateDisease(DiseasesTO diseasesTO, Integer diseaseId);

}
