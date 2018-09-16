package com.anakeredchieva.doctor.sheduler.services;

import com.anakeredchieva.doctor.sheduler.model.DiseasesTO;
import com.anakeredchieva.doctor.sheduler.model.PatientTO;

import java.util.List;

/**
 * Created by akere on 05/12/2018.
 */
public interface PatientService {
    //TODO: направи си javadoc за всиччки методи и за самия интърфейс
    /**
     *
     * @param patientTO {@link PatientTO}
     */
    void createPatients(PatientTO patientTO);

    List<PatientTO> findAllPatients();

    PatientTO updatePatients(PatientTO patientTO, Integer id);

    PatientTO findOnPatient(Integer id);

    void deletePatient(Integer id);

    List<DiseasesTO> findDiseaseByPatientId(Integer patientId);
}
