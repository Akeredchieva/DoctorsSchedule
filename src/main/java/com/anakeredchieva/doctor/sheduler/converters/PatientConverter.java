package com.anakeredchieva.doctor.sheduler.converters;

import com.anakeredchieva.doctor.sheduler.entities.Patients;
import com.anakeredchieva.doctor.sheduler.model.PatientTO;

/**
 * Created by akere on 05/12/2018.
 */
public enum PatientConverter implements Converter<Patients, PatientTO> {
    F;
    @Override
    public Patients toEntity(PatientTO patientTO) {
        return Patients.builder()
                .firstName(patientTO.getFirstName())
                .middleName(patientTO.getMiddleName())
                .lastName(patientTO.getLastName())
                .address(patientTO.getAddress())
                .EGN(patientTO.getEgn())
                .email(patientTO.getEmail())
                .phone(patientTO.getTelephone())
                .build();
        }

    @Override
    public PatientTO toTransfer(Patients patients) {

        return PatientTO.builder()
                .patientId(patients.getId())
                .firstName(patients.getFirstName())
                .middleName(patients.getMiddleName())
                .lastName(patients.getLastName())
                .address(patients.getAddress())
                .egn(patients.getEgn())
                .email(patients.getEmail())
                .telephone(patients.getPhone())
                .build();
    }
}
