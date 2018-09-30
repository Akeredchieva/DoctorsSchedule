package com.anakeredchieva.doctor.sheduler.services;


import com.anakeredchieva.doctor.sheduler.converters.DiseaseConverter;
import com.anakeredchieva.doctor.sheduler.converters.PatientConverter;
import com.anakeredchieva.doctor.sheduler.entities.Diseases;
import com.anakeredchieva.doctor.sheduler.entities.Patients;
import com.anakeredchieva.doctor.sheduler.entities.PatientsDiseases;
import com.anakeredchieva.doctor.sheduler.model.DiseasesTO;
import com.anakeredchieva.doctor.sheduler.model.PatientTO;
import com.anakeredchieva.doctor.sheduler.repositories.PatientDiseasesRepository;
import com.anakeredchieva.doctor.sheduler.repositories.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by akere on 08/12/2017.
 */
@Service
public class PatientsServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientDiseasesRepository patientDiseasesRepository;

    private static final Logger LOG = LoggerFactory.getLogger(PatientService.class);

    @Autowired
    public PatientsServiceImpl(PatientRepository patientRepository, PatientDiseasesRepository patientDiseasesRepository) {
        this.patientRepository = patientRepository;
        this.patientDiseasesRepository = patientDiseasesRepository;
    }

    // TODO: return PatientTo with ID
    @Override
    public void createPatients(PatientTO patientTO){
        LOG.info("You start creating patient with name {} {} ",patientTO.getFirstName(), patientTO.getLastName());
        Patients patients = PatientConverter.F.toEntity(patientTO);
        Patients patient = patientRepository.save(patients);
        LOG.info("You successfully create patient with name {} {} with id {}",patient.getFirstName(), patient.getLastName(), patient.getId());
    }

    @Override
    public List<PatientTO> findAllPatients(){
        LOG.info("You start searching for all patients in the DB");
        List<PatientTO> patientTO = new ArrayList<>();
        patientRepository.findAll().forEach(patients -> {
            patientTO.add(PatientConverter.F.toTransfer(patients));
//            patientTO.add(new PatientTO(patients.getId(),patients.getFirstName(),patients.getLastName(),
//                   patients.getMiddleName(),patients.getEmail(),patients.getPhone(), patients.getAddress(),patients.getEgn() ));
        });
        LOG.info("You found {} number of patients",patientTO.size());
        return patientTO;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public PatientTO updatePatients(PatientTO patientTO, Integer id){
        LOG.info("You start updating patient with {} id",id);
        Patients patients = patientRepository.findOne(id);
        //TODO: update all fields
        patients.setFirstName(patientTO.getFirstName());
        patients.setLastName(patientTO.getLastName());
        patients.setMiddleName(patientTO.getMiddleName());
        patients.setAddress(patientTO.getAddress());
        patients.setEgn(patientTO.getEgn());
        patients.setEmail(patientTO.getEmail());
        patients.setPhone(patientTO.getTelephone());
        //        patients.builder().firstName(patientTO.getFirstName())
//                .middleName(patientTO.getMiddleName())

        Patients patientsUpdate = patientRepository.save(patients);
        //TODO: transform patientsUpdate entity to TO
        patientTO = PatientConverter.F.toTransfer(patientsUpdate);

        LOG.info("You successfully update patient with id {} ",id);
        return patientTO;
    }

    @Override
    public PatientTO findPatientById(Integer id){
        LOG.info("You start searching for patient with {} id ",id);
        Patients patients = patientRepository.findOne(id);
        LOG.info("You found patient with id {} ",id);
        return (PatientConverter.F.toTransfer(patients));

    }

    public void deletePatient(Integer id){
        LOG.info("You start deleting patient with id {} ",id);
        patientRepository.delete(id);
        LOG.info("You successfully delete patient with id {} ",id);
    }

    @Override
    public List<DiseasesTO> findDiseaseByPatientId(Integer patientId) {
        LOG.info("You start searching diseases for patient with {} id ",patientId);
        List<DiseasesTO> listOfDiseases =  patientDiseasesRepository.getAllDiseasesByPatientId(patientId)
                    .stream().map(x -> {
                        DiseasesTO diseasesTO = DiseaseConverter.F.toTransfer(x.getDisease());
                        return diseasesTO.dateOfDiagnose(x.getDiagnoseDate()).description(x.getDescription());
                    })
                    .collect(Collectors.toList());

        LOG.info("You found {} diseases for patient with id {}",listOfDiseases.size(), patientId);
        return listOfDiseases;
    }

    @Override
    public void deletePatientDisease(Integer patientId, Integer diseaseId) {
        LOG.info("You start deleting disease with id {} for patient with {} id ",diseaseId,patientId);
       PatientsDiseases patientsDiseases = patientDiseasesRepository.findByPatientIdAndDiseaseId(patientId,diseaseId);
       patientDiseasesRepository.delete(patientsDiseases);
        LOG.info("You successfully delete disease with id {} for patient with {} id ",diseaseId,patientId);
    }

    @Override
    public void updatePatientDisease(DiseasesTO diseasesTO, Integer patientId, Integer diseaseId) {
        LOG.info("You start updating disease with id {} for patient with {} id ",diseaseId,patientId);

        LOG.info("You successfully update disease with id {} for patient with {} id ",diseaseId,patientId);

    }

//    @Override
//    public void updatePatientDisease(Integer patientId, Integer diseaseId) {
//        PatientsDiseases patientsDiseases = patientDiseasesRepository.findByPatientIdAndDiseaseId(patientId,diseaseId);
//
//    }

}
