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

    @Autowired
    public PatientsServiceImpl(PatientRepository patientRepository, PatientDiseasesRepository patientDiseasesRepository) {
        this.patientRepository = patientRepository;
        this.patientDiseasesRepository = patientDiseasesRepository;
    }

    // TODO: return PatientTo with ID
    @Override
    public void createPatients(PatientTO patientTO){
        Patients patients = PatientConverter.F.toEntity(patientTO);
        patientRepository.save(patients);
    }

    @Override
    public List<PatientTO> findAllPatients(){
        List<PatientTO> patientTO = new ArrayList<>();
        patientRepository.findAll().forEach(patients -> {
            patientTO.add(PatientConverter.F.toTransfer(patients));
//            patientTO.add(new PatientTO(patients.getId(),patients.getFirstName(),patients.getLastName(),
//                   patients.getMiddleName(),patients.getEmail(),patients.getPhone(), patients.getAddress(),patients.getEgn() ));
        });
        return patientTO;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public PatientTO updatePatients(PatientTO patientTO, Integer id){
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
        return patientTO;
    }

    @Override
    public PatientTO findOnPatient(Integer id){
        Patients patients = patientRepository.findOne(id);
        return (PatientConverter.F.toTransfer(patients));

    }

    public void deletePatient(Integer id){
        patientRepository.delete(id);
    }

    @Override
    public List<DiseasesTO> findDiseaseByPatientId(Integer patientId) {
        return  patientDiseasesRepository.getAllDiseasesByPatientId(patientId)
                    .stream().map(x -> {
                        DiseasesTO diseasesTO = DiseaseConverter.F.toTransfer(x.getDisease());
                        return diseasesTO.dateOfDiagnose(x.getDiagnoseDate()).description(x.getDescription());
                    })
                    .collect(Collectors.toList());
    }

    @Override
    public void deletePatientDisease(Integer patientId, Integer diseaseId) {
       PatientsDiseases patientsDiseases = patientDiseasesRepository.findByPatientIdAndDiseaseId(patientId,diseaseId);
       patientDiseasesRepository.delete(patientsDiseases);
    }

}
