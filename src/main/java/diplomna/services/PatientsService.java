package diplomna.services;

import diplomna.entities.Patients;
import diplomna.model.Patient;
import diplomna.repositories.PatientRepository;
import diplomna.to.PatientTO;
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
public class PatientsService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientsService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // TODO: return PatientTo with ID
    public void createPatients(Patient patient){
        String firstName =  patient.getFirstName();
        String middleName = patient.getMiddleName();
        String lastName = patient.getLastName();
        String address  = patient.getAddress();
        String email = patient.getEmail();

        Patients patients = new Patients(firstName,middleName,lastName, patient.getEgn(),address, email,
                Collections.emptyList());
        patientRepository.save(patients);
    }

    public List<diplomna.model.Patient> findAllPatients(){
        List<diplomna.model.Patient> patientTOS = new ArrayList<>();
        patientRepository.findAll().forEach(patients -> {
           patientTOS.add(new diplomna.model.Patient(patients.getId(),patients.getFirstName(),patients.getMiddleName(),
                   patients.getLastName(),patients.getEgn(), patients.getAddress(), patients.getEmail()));
        });
        return  patientTOS;
    }

    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public PatientTO updatePatients(PatientTO patientTO, Integer id){
        Patients patients = patientRepository.findOne(id);
        //TODO: update all fields
        patients.setFirstName(patientTO.getFirstName());
        Patients patientsUpdate = patientRepository.save(patients);
        //TODO: transform patientsUpdate entity to TO
        return patientTO;
    }
}
