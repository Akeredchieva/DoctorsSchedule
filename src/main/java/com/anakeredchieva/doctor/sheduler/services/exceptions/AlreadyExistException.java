package com.anakeredchieva.doctor.sheduler.services.exceptions;

/**
 * Throw exception when the record already exist.
 */
public class AlreadyExistException extends RuntimeException {

    public AlreadyExistException(String message) {
        super(message);
    }
}
