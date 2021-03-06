package com.anakeredchieva.doctor.sheduler.services;

import com.anakeredchieva.doctor.sheduler.model.DoctorsTO;

import java.util.List;

/**
 * Created by akere on 10/01/2018.
 */
public interface DoctorService {

    void createDoctor(DoctorsTO doctorsTO);

    void deleteDoctor(Integer doctorId);
    List<DoctorsTO> findAllDoctors();

    DoctorsTO updateDoctors(DoctorsTO body,Integer doctorId);
}
