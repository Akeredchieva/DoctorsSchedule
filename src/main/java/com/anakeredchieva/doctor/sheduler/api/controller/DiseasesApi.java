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

@Api(value = "diseases", description = "the diseases API")
public interface DiseasesApi {

    @ApiOperation(value = "GET all diseases", nickname = "diseasesGet", notes = "", response = DiseasesTO.class, responseContainer = "List", tags={ "Diseases", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "An array of diseases", response = DiseasesTO.class, responseContainer = "List"),
            @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/diseases",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<DiseasesTO>> diseasesGet();

    @ApiOperation(value = "Update a new diseases", nickname = "diseasesDiseaseIdPut", notes = "With this method we want to update a diseases in our application", tags={ "Diseases", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation") })
    @RequestMapping(value = "/diseases/{diseaseId}",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<Void> diseasesDiseasesIdPut(@ApiParam(value = "Diseases object that needs to be updated in our application " ,required=true )  @Valid @RequestBody DiseasesTO body, @ApiParam(value = "",required=true) @PathVariable("diseaseId") Integer diseaseId);

}
