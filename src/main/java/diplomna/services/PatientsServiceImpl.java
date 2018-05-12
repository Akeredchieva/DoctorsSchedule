package diplomna.services;


import diplomna.entities.Patients;
import diplomna.model.PatientTO;
import diplomna.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by akere on 08/12/2017.
 */
@Service
public class PatientsServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientsServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // TODO: return PatientTo with ID
    @Override
    public void createPatients(PatientTO patientTO){
        String firstName =  patientTO.getFirstName();
        String middleName = patientTO.getMiddleName();
        String lastName = patientTO.getLastName();
        String address  = patientTO.getAddress();
        String email = patientTO.getEmail();

        Patients patients = new Patients(firstName,middleName,lastName, patientTO.getEgn(),address, email,
                Collections.emptyList());
        patientRepository.save(patients);
    }

    @Override
    public List<PatientTO> findAllPatients(){
        List<PatientTO> patientTOTOS = new ArrayList<>();
        patientRepository.findAll().forEach(patients -> {
           patientTOTOS.add(new PatientTO(patients.getId(),patients.getFirstName(),patients.getLastName(),
                   patients.getMiddleName(),patients.getEmail(),patients.getPhone(), patients.getAddress(),patients.getEgn() ));
        });
        return patientTOTOS;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public PatientTO updatePatients(PatientTO patientTO, Integer id){
        Patients patients = patientRepository.findOne(id);
        //TODO: update all fields
        patients.setFirstName(patientTO.getFirstName());
        Patients patientsUpdate = patientRepository.save(patients);
        //TODO: transform patientsUpdate entity to TO
        return patientTO;
    }

    @Override
    public PatientTO findOnPatient(Integer id){
        Patients patients = patientRepository.findOne(id);
        return (new PatientTO(patients.getId(),patients.getFirstName(),patients.getLastName(),patients.getMiddleName(),patients.getEmail(),patients.getPhone(),patients.getAddress(),patients.getEgn()));

    }
}
