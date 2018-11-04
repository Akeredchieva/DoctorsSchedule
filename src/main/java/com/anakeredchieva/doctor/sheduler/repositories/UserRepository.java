package com.anakeredchieva.doctor.sheduler.repositories;

import com.anakeredchieva.doctor.sheduler.entities.Users;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by akere on 4.11.2018 г..
 */
public interface UserRepository extends CrudRepository<Users, Integer> {

    Users findByUsername(String username);

    Users findByEmail(String email);
}
