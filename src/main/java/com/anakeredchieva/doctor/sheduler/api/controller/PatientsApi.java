/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.anakeredchieva.doctor.sheduler.api.controller;

import com.anakeredchieva.doctor.sheduler.model.DiseasesTO;
import com.anakeredchieva.doctor.sheduler.model.PatientTO;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-06T12:51:14.120Z")

@Api(value = "patients", description = "the patients API")
public interface PatientsApi {

    @ApiOperation(value = "Create a new patients", nickname = "addPatients", notes = "With this method we want to create a new patient in our application", tags={ "Patients", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation") })
    @RequestMapping(value = "/patients",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> addPatients(@ApiParam(value = "Patients object that needs to be added in our application " ,required=true )  @Valid @RequestBody PatientTO body);


    @ApiOperation(value = "GET all patients", nickname = "patientsGet", notes = "", response = PatientTO.class, responseContainer = "List", tags={ "Patients", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of patient", response = PatientTO.class, responseContainer = "List"),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/patients",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<PatientTO>> patientsGet();


    @ApiOperation(value = "Delete the current patient", nickname = "patientsPatientIdDelete", notes = "With this methow we will be able to delete a current patient", tags={ "Patients", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/patients/{patientId}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> patientsPatientIdDelete(@ApiParam(value = "",required=true) @PathVariable("patientId") Integer patientId);


    @ApiOperation(value = "Delete the current disease", nickname = "patientsPatientIdDiseasesDiseasedIdDelete", notes = "With this methow we will be able to delete a current disease for pattient", tags={ "Patients", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/patients/{patientId}/diseases/{diseasedId}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> patientsPatientIdDiseasesDiseasedIdDelete(@ApiParam(value = "",required=true) @PathVariable("patientId") Integer patientId,@ApiParam(value = "",required=true) @PathVariable("diseasedId") Integer diseasedId);


    @ApiOperation(value = "Create a new disease", nickname = "patientsPatientIdDiseasesDiseasedIdPut", notes = "With this method we want to create a new disease for specific patient in our application", tags={ "Patients", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation") })
    @RequestMapping(value = "/patients/{patientId}/diseases/{diseasedId}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> patientsPatientIdDiseasesDiseasedIdPut(@ApiParam(value = "Disease object that needs to be added in our application " ,required=true )  @Valid @RequestBody DiseasesTO body, @ApiParam(value = "",required=true) @PathVariable("patientId") Integer patientId, @ApiParam(value = "",required=true) @PathVariable("diseasedId") Integer diseasedId);


    @ApiOperation(value = "", nickname = "patientsPatientIdDiseasesGet", notes = "", response = DiseasesTO.class, responseContainer = "List", tags={ "Patients", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = DiseasesTO.class, responseContainer = "List"),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/patients/{patientId}/diseases",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<DiseasesTO>> patientsPatientIdDiseasesGet(@ApiParam(value = "",required=true) @PathVariable("patientId") Integer patientId);


    @ApiOperation(value = "Create a new disease", nickname = "patientsPatientIdDiseasesPost", notes = "With this method we want to create a new disease for specific patient in our application", tags={ "Patients", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation") })
    @RequestMapping(value = "/patients/{patientId}/diseases",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> patientsPatientIdDiseasesPost(@ApiParam(value = "Disease object that needs to be added in our application " ,required=true )  @Valid @RequestBody DiseasesTO body, @ApiParam(value = "",required=true) @PathVariable("patientId") Integer patientId);


    @ApiOperation(value = "", nickname = "patientsPatientIdGet", notes = "", response = PatientTO.class, tags={ "Patients", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = PatientTO.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/patients/{patientId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<PatientTO> patientsPatientIdGet(@ApiParam(value = "",required=true) @PathVariable("patientId") Integer patientId);


    @ApiOperation(value = "Update a new patients", nickname = "patientsPatientIdPut", notes = "With this method we want to create a new patient in our application", tags={ "Patients", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation") })
    @RequestMapping(value = "/patients/{patientId}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> patientsPatientIdPut(@ApiParam(value = "Patients object that needs to be added in our application " ,required=true )  @Valid @RequestBody PatientTO body, @ApiParam(value = "",required=true) @PathVariable("patientId") Integer patientId);

}
