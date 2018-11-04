package com.anakeredchieva.doctor.sheduler.api.controller;

import com.anakeredchieva.doctor.sheduler.model.UserTO;
import com.anakeredchieva.doctor.sheduler.services.DiseaseService;
import com.anakeredchieva.doctor.sheduler.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class UserApiController implements UserApi {

    private static final Logger log = LoggerFactory.getLogger(PatientsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    UserService userService;

    //@Autowired
    public UserApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }
    @Override
    public ResponseEntity<Void> addUsers(@ApiParam(value = "Users object that needs to be added in our application ", required = true) @Valid @RequestBody UserTO usersTO) {
        userService.createUser(usersTO);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
