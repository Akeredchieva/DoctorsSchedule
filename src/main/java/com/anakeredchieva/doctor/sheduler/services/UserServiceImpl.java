package com.anakeredchieva.doctor.sheduler.services;

import com.anakeredchieva.doctor.sheduler.converters.UserConverter;
import com.anakeredchieva.doctor.sheduler.entities.Patients;
import com.anakeredchieva.doctor.sheduler.entities.Users;
import com.anakeredchieva.doctor.sheduler.model.UserTO;
import com.anakeredchieva.doctor.sheduler.repositories.UserRepository;
import com.anakeredchieva.doctor.sheduler.services.exceptions.AlreadyExistException;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOG = LoggerFactory.getLogger(PatientService.class);

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(UserTO userTO) {
        LOG.info("You start creating user with username {} ",userTO.getUsername());
        Users userValidate = userRepository.findByUsername(userTO.getUsername());
        if (userValidate != null){
            throw new AlreadyExistException("User with this username already exist in the DB !");
        }
        userValidate = userRepository.findByEmail(userTO.getEmail());
        if (userValidate != null){
            throw new AlreadyExistException("User with this email already exist in the DB !");
        }
        Users users = UserConverter.F.toEntity(userTO);
        Users user = userRepository.save(users);
        LOG.info("You successfully create user with username {} with id {}",user.getUsername(), user.getId());

    }
}
