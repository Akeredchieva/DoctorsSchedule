package com.anakeredchieva.doctor.sheduler.services;

import com.anakeredchieva.doctor.sheduler.converters.DiseaseConverter;
import com.anakeredchieva.doctor.sheduler.converters.PatientConverter;
import com.anakeredchieva.doctor.sheduler.entities.Diseases;
import com.anakeredchieva.doctor.sheduler.entities.PatientsDiseases;
import com.anakeredchieva.doctor.sheduler.model.DiseasesTO;
import com.anakeredchieva.doctor.sheduler.model.PatientTO;
import com.anakeredchieva.doctor.sheduler.repositories.DiseaseRepository;
import org.springframework.stereotype.Service;

/**
 * Created by akere on 05/14/2018.
 */
@Service
public class DiseaseServiceImpl implements DiseaseService {

   private final DiseaseRepository diseaseRepository;

    public DiseaseServiceImpl(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;

    }

    // TODO: за да създам самата болест трябва ТО-то да го преобразувам в болест. Тук би трябвало да има създаване на две entity-та - едно за самата болест и едно за връската пациент-болест нали?
    public void createDisease(DiseasesTO diseasesTO, PatientTO patientTO){
        Diseases diseases = DiseaseConverter.F.toEntity(diseasesTO);
     //   patientsDiseases.setPatient(PatientConverter.F.toEntity(patientTO));
//        patientsDiseases.setDescription();
//        patientsDiseases.setDiagnoseDate();
      //  patientsDiseases.setDisease(diseases);

    }
}
