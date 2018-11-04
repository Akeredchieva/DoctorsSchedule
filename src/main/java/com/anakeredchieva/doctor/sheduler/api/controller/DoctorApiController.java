package com.anakeredchieva.doctor.sheduler.api.controller;

import com.anakeredchieva.doctor.sheduler.model.DoctorsTO;
import com.anakeredchieva.doctor.sheduler.model.PatientTO;
import com.anakeredchieva.doctor.sheduler.services.DoctorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class DoctorApiController implements DoctorApi {

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    DoctorService doctorService;

    //@Autowired
    public DoctorApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    //TODO: implement all methods.
    @Override
    public ResponseEntity<Void> addDoctors(@ApiParam(value = "Doctors object that needs to be added in our application ", required = true) @Valid @RequestBody DoctorsTO doctorsTO) {

        doctorService.createDoctor(doctorsTO);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<DoctorsTO>> doctorsGet() {
        return new ResponseEntity<List<DoctorsTO>>(doctorService.findAllDoctors(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> doctorIdPut(@ApiParam(value = "Doctors object that needs to be added in our application ", required = true) @Valid @RequestBody DoctorsTO body, @ApiParam(value = "", required = true) @PathVariable("doctorId") Integer doctorId) {
        DoctorsTO doctorTO = doctorService.updateDoctors(body, doctorId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> doctorIdDelete(@ApiParam(value = "",required=true) @PathVariable("doctorId") Integer doctorId) {
        doctorService.deleteDoctor(doctorId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> doctorIdPatientIdDelete(Integer doctorId, Integer patientId) {
        return null;
    }

    @Override
    public ResponseEntity<Void> doctorIdPatientsPost(PatientTO body, Integer doctorId) {
        return null;
    }

    @Override
    public ResponseEntity<Void> doctorIdPatientIdPut(PatientTO body, Integer doctorId, Integer patientId) {
        return null;
    }

    @Override
    public ResponseEntity<List<PatientTO>> doctorIdPatientsGet(Integer doctorId) {
        return null;
    }
}
