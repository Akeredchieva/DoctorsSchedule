package com.anakeredchieva.doctor.sheduler.services.exceptions;

/**
 * Created by akere on 10/01/2018.
 */
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
