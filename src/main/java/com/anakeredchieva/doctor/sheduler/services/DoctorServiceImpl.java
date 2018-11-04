package com.anakeredchieva.doctor.sheduler.services;

import com.anakeredchieva.doctor.sheduler.converters.DoctorsConverter;
import com.anakeredchieva.doctor.sheduler.converters.PatientConverter;
import com.anakeredchieva.doctor.sheduler.entities.Doctors;
import com.anakeredchieva.doctor.sheduler.entities.Patients;
import com.anakeredchieva.doctor.sheduler.model.DoctorsTO;
import com.anakeredchieva.doctor.sheduler.model.PatientTO;
import com.anakeredchieva.doctor.sheduler.repositories.DoctorRepository;
import com.anakeredchieva.doctor.sheduler.services.exceptions.AlreadyExistException;
import com.anakeredchieva.doctor.sheduler.services.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    private static final Logger LOG = LoggerFactory.getLogger(DoctorService.class);

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public void createDoctor(DoctorsTO doctorsTO) {
        LOG.info("You start creating doctor with name {} {} ",doctorsTO.getFirstName(), doctorsTO.getLastName());
        Doctors doctorValidate = doctorRepository.findByEmail(doctorsTO.getEmail());
        if (doctorValidate != null){
            throw new AlreadyExistException("This doctor already exist in the DB !");
        }
        Doctors doctors = DoctorsConverter.F.toEntity(doctorsTO);
        Doctors doctor = doctorRepository.save(doctors);
        LOG.info("You successfully create doctor with name {} {} and id {}",doctor.getFirstName(), doctor.getLastName(), doctor.getId());

    }

    //TODO: Test it!
    @Override
    public List<DoctorsTO> findAllDoctors() {
        LOG.info("You start searching for all doctors in the DB");
        List<DoctorsTO> doctorsTO = new ArrayList<>();

        doctorRepository.findAll().forEach(doctors -> {
            doctorsTO.add(DoctorsConverter.F.toTransfer(doctors));
//            patientTO.add(new PatientTO(patients.getId(),patients.getFirstName(),patients.getLastName(),
//                   patients.getMiddleName(),patients.getEmail(),patients.getPhone(), patients.getAddress(),patients.getEgn() ));
        });
        if (doctorsTO.size() == 0){
            throw new NotFoundException("There is no doctors in the DB!");
        }
        LOG.info("You found {} number of doctors",doctorsTO.size());
        return doctorsTO;
    }

    @Override
    public DoctorsTO updateDoctors(DoctorsTO body, Integer doctorId) {
        LOG.info("You start updating patient with {} id",doctorId);
        Doctors doctors = doctorRepository.findOne(doctorId);
        if (doctors == null){
            throw new NotFoundException("There is no doctor with this id in the DB!");
        }

        doctors.setFirstName(body.getFirstName());
        doctors.setLastName(body.getLastName());
        doctors.setEmail(body.getEmail());
        doctors.setTypeOfDoctor(body.getTypeOfDoctor());
        doctors.setTelephone(body.getTelephone());

        Doctors doctorUpdate = doctorRepository.save(doctors);
        DoctorsTO doctorTO = DoctorsConverter.F.toTransfer(doctorUpdate);

        LOG.info("You successfully update doctor with id {} ",doctorId);
        return doctorTO;
    }
}
