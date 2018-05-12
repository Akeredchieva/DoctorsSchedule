package diplomna.services;

import diplomna.model.PatientTO;

import java.util.List;

/**
 * Created by akere on 05/12/2018.
 */
public interface PatientService {
    /**
     *
     * @param patientTO {@link PatientTO}
     */
    void createPatients(PatientTO patientTO);

    List<PatientTO> findAllPatients();

    PatientTO updatePatients(PatientTO patientTO, Integer id);

    PatientTO findOnPatient(Integer id);
}
