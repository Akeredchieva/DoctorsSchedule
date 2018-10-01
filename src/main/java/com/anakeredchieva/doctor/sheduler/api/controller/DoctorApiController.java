package com.anakeredchieva.doctor.sheduler.api.controller;

import com.anakeredchieva.doctor.sheduler.model.DiseasesTO;
import com.anakeredchieva.doctor.sheduler.model.DoctorsTO;
import com.anakeredchieva.doctor.sheduler.model.PatientTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-06T12:51:14.120Z")

@Controller
public class DoctorApiController implements DoctorApi {

    //TODO: implement all methods.
    @Override
    public ResponseEntity<Void> addDoctors(DoctorsTO body) {
        return null;
    }

    @Override
    public ResponseEntity<List<DiseasesTO>> doctorsGet() {
        return null;
    }

    @Override
    public ResponseEntity<Void> doctorIdPut(DoctorsTO body, Integer doctorId) {
        return null;
    }

    @Override
    public ResponseEntity<Void> doctorIdDelete(Integer doctorId) {
        return null;
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
