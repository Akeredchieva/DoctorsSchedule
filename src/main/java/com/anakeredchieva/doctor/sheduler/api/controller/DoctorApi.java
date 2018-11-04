package com.anakeredchieva.doctor.sheduler.api.controller;

import com.anakeredchieva.doctor.sheduler.model.DiseasesTO;
import com.anakeredchieva.doctor.sheduler.model.DoctorsTO;
import com.anakeredchieva.doctor.sheduler.model.PatientTO;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Api(value = "doctors", description = "the doctors API")
public interface DoctorApi {

    @ApiOperation(value = "Create a new doctor", nickname = "addDoctor", notes = "With this method we want to create a new doctor in our application", tags={ "Doctors", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation") })
    @RequestMapping(value = "/doctors",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Void> addDoctors(@ApiParam(value = "Doctors object that needs to be added in our application " ,required=true )  @Valid @RequestBody DoctorsTO doctorsTO);

    @ApiOperation(value = "GET all doctors", nickname = "doctorsGet", notes = "", response = DoctorsTO.class, responseContainer = "List", tags={ "Doctors", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "An array of diseases", response = DoctorsTO.class, responseContainer = "List"),
            @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/doctors",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<DoctorsTO>> doctorsGet();

    @ApiOperation(value = "Update a doctor", nickname = "doctorIdPut", notes = "With this method we want to update the information about a doctor in our application", tags={ "Doctors", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation") })
    @RequestMapping(value = "/doctors/{doctorId}",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<Void> doctorIdPut(@ApiParam(value = "Doctor object that needs to be updated in our application " ,required=true )  @Valid @RequestBody DoctorsTO body, @ApiParam(value = "",required=true) @PathVariable("doctorId") Integer doctorId);

    @ApiOperation(value = "Delete the current doctor", nickname = "doctorIdDelete", notes = "With this methow we will be able to delete a current doctor", tags={ "Doctors", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/doctors/{doctorId}",
            produces = { "application/json" },
            method = RequestMethod.DELETE)
    ResponseEntity<Void> doctorIdDelete(@ApiParam(value = "",required=true) @PathVariable("doctorId") Integer doctorId);

    @ApiOperation(value = "Delete the current patient", nickname = "doctorIdPatientIdDelete", notes = "With this methow we will be able to delete a current patient for doctor", tags={ "Doctors", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/doctors/{doctorId}/patients/{patientId}",
            produces = { "application/json" },
            method = RequestMethod.DELETE)
    ResponseEntity<Void> doctorIdPatientIdDelete(@ApiParam(value = "",required=true) @PathVariable("doctorId") Integer doctorId,@ApiParam(value = "",required=true) @PathVariable("patientId") Integer patientId);

    @ApiOperation(value = "Create a new patient", nickname = "doctorIdPatientsPost", notes = "With this method we want to create a new patient for specific doctor in our application", tags={ "Doctors", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation") })
    @RequestMapping(value = "/doctors/{doctorId}/patients",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Void> doctorIdPatientsPost(@ApiParam(value = "Patients object that needs to be added in our application " ,required=true )  @Valid @RequestBody PatientTO body, @ApiParam(value = "",required=true) @PathVariable("doctorId") Integer doctorId);

    @ApiOperation(value = "Update a patient", nickname = "doctorIdPatientIdPut", notes = "With this method we want to update a current patient for specific doctor in our application", tags={ "Doctors", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation") })
    @RequestMapping(value = "/doctors/{doctorId}/patients/{patientId}",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<Void> doctorIdPatientIdPut(@ApiParam(value = "Patients object that needs to be added in our application " ,required=true )  @Valid @RequestBody PatientTO body, @ApiParam(value = "",required=true) @PathVariable("doctorId") Integer doctorId, @ApiParam(value = "",required=true) @PathVariable("patientId") Integer patientId);

    @ApiOperation(value = "Get all patients", nickname = "doctorIdPatientsGet", notes = "With this method we want to get all patients of a current doctor", response = PatientTO.class, responseContainer = "List", tags={ "Doctors", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = PatientTO.class, responseContainer = "List"),
            @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/doctors/{doctorsId}/patients",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<PatientTO>> doctorIdPatientsGet(@ApiParam(value = "",required=true) @PathVariable("doctorId") Integer doctorId);

}
