package com.anakeredchieva.doctor.sheduler.converters;

import com.anakeredchieva.doctor.sheduler.entities.Users;
import com.anakeredchieva.doctor.sheduler.model.UserTO;

/**
 * Created by akere on 4.11.2018 г..
 */
public enum UserConverter implements Converter<Users,UserTO> {
    F;

    @Override
    public Users toEntity(UserTO userTO) {
        return Users.builder()
                .username(userTO.getUsername())
                .email(userTO.getEmail())
                .password(userTO.getPassword())
                .build();
    }

    @Override
    public UserTO toTransfer(Users user) {
        return UserTO.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .build();
    }
}
