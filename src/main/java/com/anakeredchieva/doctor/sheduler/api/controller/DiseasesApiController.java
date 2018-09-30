package com.anakeredchieva.doctor.sheduler.api.controller;

import com.anakeredchieva.doctor.sheduler.model.DiseasesTO;
import com.anakeredchieva.doctor.sheduler.model.PatientTO;
import com.anakeredchieva.doctor.sheduler.services.DiseaseService;
import com.anakeredchieva.doctor.sheduler.services.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-06T12:51:14.120Z")

@Controller
public class DiseasesApiController implements DiseasesApi{


    private static final Logger log = LoggerFactory.getLogger(PatientsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    DiseaseService diseaseService;


    public DiseasesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public ResponseEntity<List<DiseasesTO>> diseasesGet() {
        return new ResponseEntity<List<DiseasesTO>>(diseaseService.findAllDiseases(), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<Void> diseasesDiseasesIdPut(@ApiParam(value = "Diseases object that needs to be updated in our application " ,required=true )  @Valid @RequestBody DiseasesTO body, @ApiParam(value = "",required=true) @PathVariable("diseaseId") Integer diseaseId){
        diseaseService.updateDisease(body, diseaseId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
