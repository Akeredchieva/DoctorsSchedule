package com.anakeredchieva.doctor.sheduler.api.controller;

import com.anakeredchieva.doctor.sheduler.entities.PatientsDiseases;
import com.anakeredchieva.doctor.sheduler.services.DiseaseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.anakeredchieva.doctor.sheduler.model.DiseasesTO;
import com.anakeredchieva.doctor.sheduler.model.PatientTO;
import com.anakeredchieva.doctor.sheduler.services.PatientService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-06T12:51:14.120Z")

@Controller
public class PatientsApiController implements PatientsApi {

    private static final Logger log = LoggerFactory.getLogger(PatientsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    PatientService patientsService;

    @Autowired
    DiseaseService diseaseService;

    @Autowired
    public PatientsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addPatients(@ApiParam(value = "Patients object that needs to be added in our application " ,required=true )  @Valid @RequestBody PatientTO patientTO) {
        patientsService.createPatients(patientTO);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    public ResponseEntity<List<PatientTO>> patientsGet() {
        return new ResponseEntity<List<PatientTO>>(patientsService.findAllPatients(),HttpStatus.OK);
    }

    public ResponseEntity<Void> patientsPatientIdDelete(@ApiParam(value = "",required=true) @PathVariable("patientId") Integer patientId) {
        patientsService.deletePatient(patientId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> patientsPatientIdDiseasesDiseasedIdDelete(@ApiParam(value = "",required=true) @PathVariable("patientId") Integer patientId,@ApiParam(value = "",required=true) @PathVariable("diseasedId") Integer diseasedId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> patientsPatientIdDiseasesDiseasedIdPut(@ApiParam(value = "Disease object that needs to be added in our application " ,required=true )  @Valid @RequestBody DiseasesTO body, @ApiParam(value = "",required=true) @PathVariable("patientId") Integer patientId, @ApiParam(value = "",required=true) @PathVariable("diseasedId") Integer diseasedId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<DiseasesTO>> patientsPatientIdDiseasesGet(@ApiParam(value = "",required=true) @PathVariable("patientId") Integer patientId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<DiseasesTO>>(objectMapper.readValue("[ {  \"dateOfDiagnose\" : \"dateOfDiagnose\",  \"name\" : \"name\",  \"description\" : \"description\"}, {  \"dateOfDiagnose\" : \"dateOfDiagnose\",  \"name\" : \"name\",  \"description\" : \"description\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<DiseasesTO>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<DiseasesTO>>(HttpStatus.NOT_IMPLEMENTED);
    }

    //TODO: Това трябва да е коректно
    public ResponseEntity<Void> patientsPatientIdDiseasesPost(@ApiParam(value = "Disease object that needs to be added in our application " ,required=true )  @Valid @RequestBody DiseasesTO body, @ApiParam(value = "",required=true) @PathVariable("patientId") Integer patientId) {
        PatientTO patientTO = patientsService.findOnPatient(patientId);
        diseaseService.createDisease(body,patientTO);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<PatientTO> patientsPatientIdGet(@ApiParam(value = "",required=true) @PathVariable("patientId") Integer patientId) {
        // patientsService.findOnPatient()
        PatientTO patient = patientsService.findOnPatient(patientId);
        return new ResponseEntity<PatientTO>(patient, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Void> patientsPatientIdPut(@ApiParam(value = "Patients object that needs to be added in our application " ,required=true )  @Valid @RequestBody PatientTO body, @ApiParam(value = "",required=true) @PathVariable("patientId") Integer patientId) {
        PatientTO patientTO = patientsService.updatePatients(body,patientId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}