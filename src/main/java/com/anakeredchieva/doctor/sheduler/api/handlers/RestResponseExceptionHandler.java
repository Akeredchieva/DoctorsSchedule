package com.anakeredchieva.doctor.sheduler.api.handlers;


import com.anakeredchieva.doctor.sheduler.model.ErrorTO;
import com.anakeredchieva.doctor.sheduler.services.exceptions.AlreadyExistException;
import com.anakeredchieva.doctor.sheduler.services.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestResponseExceptionHandler {

    @ExceptionHandler(value = AlreadyExistException.class)
    public ResponseEntity<ErrorTO> alreadyExist(RuntimeException re){
        return new ResponseEntity<>(new ErrorTO().code(403).message(re.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ErrorTO> notFound(RuntimeException re){
        return new ResponseEntity<>(new ErrorTO().code(404).message(re.getMessage()), HttpStatus.NOT_FOUND);
    }
}
