package com.anakeredchieva.doctor.sheduler.converters;

import com.anakeredchieva.doctor.sheduler.entities.Doctors;
import com.anakeredchieva.doctor.sheduler.model.DoctorsTO;

/**
 * Created by akere on 10/01/2018.
 */
public enum DoctorsConverter implements Converter<Doctors, DoctorsTO> {
    F;
    @Override
    public Doctors toEntity(DoctorsTO doctorsTO) {
        return Doctors.builder()
                .firstName(doctorsTO.getFirstName())
                .lastName(doctorsTO.getLastName())
                .email(doctorsTO.getEmail())
                .telephone(doctorsTO.getTelephone())
                .username(doctorsTO.getUsername())
                .password(doctorsTO.getPassword())
                .build();
    }

    @Override
    public DoctorsTO toTransfer(Doctors doctors) {
        return DoctorsTO.builder()
                .firstName(doctors.getFirstName())
                .lastName(doctors.getLastName())
                .email(doctors.getEmail())
                .telephone(doctors.getTelephone())
                .username(doctors.getUsername())
                .password(doctors.getPassword())
                .build();
    }
}
