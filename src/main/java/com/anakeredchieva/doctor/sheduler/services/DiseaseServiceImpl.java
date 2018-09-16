package com.anakeredchieva.doctor.sheduler.services;

import com.anakeredchieva.doctor.sheduler.converters.DiseaseConverter;
import com.anakeredchieva.doctor.sheduler.entities.Diseases;
import com.anakeredchieva.doctor.sheduler.entities.Patients;
import com.anakeredchieva.doctor.sheduler.entities.PatientsDiseases;
import com.anakeredchieva.doctor.sheduler.model.DiseasesTO;
import com.anakeredchieva.doctor.sheduler.repositories.DiseaseRepository;
import com.anakeredchieva.doctor.sheduler.repositories.PatientDiseasesRepository;
import com.anakeredchieva.doctor.sheduler.repositories.PatientRepository;
import org.springframework.stereotype.Service;

/**
 * Created by akere on 05/14/2018.
 */
@Service
public class DiseaseServiceImpl implements DiseaseService {

   private final DiseaseRepository diseaseRepository;
   private final PatientRepository patientRepository;
   private final PatientDiseasesRepository patientDiseasesRepository;

    public DiseaseServiceImpl(DiseaseRepository diseaseRepository, PatientRepository patientRepository, PatientDiseasesRepository patientDiseasesRepository) {
        this.diseaseRepository = diseaseRepository;

        this.patientRepository = patientRepository;
        this.patientDiseasesRepository = patientDiseasesRepository;
    }

    // TODO: за да създам самата болест трябва ТО-то да го преобразувам в болест. Тук би трябвало да има създаване на две entity-та - едно за самата болест и едно за връската пациент-болест нали?
    public void createDisease(DiseasesTO diseasesTO, Integer patientId){
        Diseases diseases = diseaseRepository.findByDiseaseName(diseasesTO.getName());
        if (diseases == null){

            diseases = DiseaseConverter.F.toEntity(diseasesTO);
            diseaseRepository.save(diseases);
        }
        Patients patient = patientRepository.findOne(patientId);
        PatientsDiseases patientsDiseases = PatientsDiseases.builder()
                .patient(patient)
                .disease(diseases)
                .description(diseasesTO.getDescription())
                .diagnoseDate(diseasesTO.getDateOfDiagnose())
                .build();
        patientDiseasesRepository.save(patientsDiseases);

     //   patientsDiseases.setPatient(PatientConverter.F.toEntity(patientTO));
//        patientsDiseases.setDescription();
//        patientsDiseases.setDiagnoseDate();
      //  patientsDiseases.setDisease(diseases);

    }
}
