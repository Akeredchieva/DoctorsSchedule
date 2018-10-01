package com.anakeredchieva.doctor.sheduler.services;

import com.anakeredchieva.doctor.sheduler.converters.DiseaseConverter;
import com.anakeredchieva.doctor.sheduler.entities.Diseases;
import com.anakeredchieva.doctor.sheduler.entities.Patients;
import com.anakeredchieva.doctor.sheduler.entities.PatientsDiseases;
import com.anakeredchieva.doctor.sheduler.model.DiseasesTO;
import com.anakeredchieva.doctor.sheduler.repositories.DiseaseRepository;
import com.anakeredchieva.doctor.sheduler.repositories.PatientDiseasesRepository;
import com.anakeredchieva.doctor.sheduler.repositories.PatientRepository;
import com.anakeredchieva.doctor.sheduler.services.exceptions.AlreadyExistException;
import com.anakeredchieva.doctor.sheduler.services.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by akere on 05/14/2018.
 */
@Service
public class DiseaseServiceImpl implements DiseaseService {

   private final DiseaseRepository diseaseRepository;
   private final PatientRepository patientRepository;
   private final PatientDiseasesRepository patientDiseasesRepository;

   private static final Logger LOG = LoggerFactory.getLogger(DiseaseService.class);

    public DiseaseServiceImpl(DiseaseRepository diseaseRepository, PatientRepository patientRepository, PatientDiseasesRepository patientDiseasesRepository) {
        this.diseaseRepository = diseaseRepository;

        this.patientRepository = patientRepository;
        this.patientDiseasesRepository = patientDiseasesRepository;
    }

    // TODO: за да създам самата болест трябва ТО-то да го преобразувам в болест. Тук би трябвало да има създаване на две entity-та - едно за самата болест и едно за връската пациент-болест нали?
    @Override
    public void createDisease(DiseasesTO diseasesTO, Integer patientId){
        LOG.info("You start creating disease with name {} for patient with id {} ",diseasesTO.getName(),patientId);
        Diseases diseases = diseaseRepository.findByDiseaseName(diseasesTO.getName());
        if (diseases == null){

            diseases = DiseaseConverter.F.toEntity(diseasesTO);
            diseaseRepository.save(diseases);
        }
        Patients patient = patientRepository.findOne(patientId);
        PatientsDiseases patientDisease = patientDiseasesRepository.findByPatientIdAndDiseaseId(patientId,diseases.getId());
        if (patientDisease != null){
            throw new AlreadyExistException("This disease for this patient already exist.");
        }
        PatientsDiseases patientsDiseases = PatientsDiseases.builder()
                .patient(patient)
                .disease(diseases)
                .description(diseasesTO.getDescription())
                .diagnoseDate(diseasesTO.getDateOfDiagnose())
                .build();
        patientDiseasesRepository.save(patientsDiseases);

        LOG.info("You've successfully create a disease with name {} for patient with id {} ",diseasesTO.getName(), patientId);

     //   patientsDiseases.setPatient(PatientConverter.F.toEntity(patientTO));
//        patientsDiseases.setDescription();
//        patientsDiseases.setDiagnoseDate();
      //  patientsDiseases.setDisease(diseases);

    }

    @Override
    public List<DiseasesTO> findAllDiseases() {
        LOG.info("You start searching for all diseases in the DB");
        List<DiseasesTO> listOfDiseases = diseaseRepository.findAll().stream().map(DiseaseConverter.F::toTransfer).collect(Collectors.toList());
        if (listOfDiseases.size() == 0){
            throw new NotFoundException("There is no diseases in the DB!");
        }
        LOG.info("You found {} diseases in the DB",listOfDiseases.size());
        return listOfDiseases;
    }

    @Override
    public void updateDisease(DiseasesTO diseasesTO, Integer diseaseId) {
        LOG.info("You start searching for disease with id {} and will start updating",diseaseId);
        Diseases disease = diseaseRepository.findOne(diseaseId);
        if (disease == null){
            throw new NotFoundException("This disease does not present in the DB!");
        }
        disease.setDiseaseName(diseasesTO.getName());
        disease.setDescription(diseasesTO.getDescription());
        diseaseRepository.save(disease);
        LOG.info("You successfully updated disease with id {}",diseaseId);
    }
}
