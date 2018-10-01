package com.anakeredchieva.doctor.sheduler.services;

import com.anakeredchieva.doctor.sheduler.converters.DoctorsConverter;
import com.anakeredchieva.doctor.sheduler.entities.Doctors;
import com.anakeredchieva.doctor.sheduler.entities.Patients;
import com.anakeredchieva.doctor.sheduler.model.DoctorsTO;
import com.anakeredchieva.doctor.sheduler.repositories.DoctorRepository;
import com.anakeredchieva.doctor.sheduler.services.exceptions.AlreadyExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    private static final Logger LOG = LoggerFactory.getLogger(DoctorService.class);

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public void createDoctor(DoctorsTO doctorsTO) {
        LOG.info("You start creating patient with name {} {} ",doctorsTO.getFirstName(), doctorsTO.getLastName());
        Doctors patientsValidate = doctorRepository.findByEmail(doctorsTO.getEmail());
        if (patientsValidate != null){
            throw new AlreadyExistException("This doctor already exist in the DB !");
        }
        Doctors doctors = DoctorsConverter.F.toEntity(doctorsTO);
        Doctors doctor = doctorRepository.save(doctors);
        LOG.info("You successfully create patient with name {} {} with id {}",doctor.getFirstName(), doctor.getLastName(), doctor.getId());

    }
}
