package com.anakeredchieva.doctor.sheduler.api.controller;

import com.anakeredchieva.doctor.sheduler.model.PatientTO;
import com.anakeredchieva.doctor.sheduler.model.UserTO;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by akere on 4.11.2018 г..
 */
@Api(value = "users", description = "the users API")
public interface UserApi {
    @ApiOperation(value = "Create a new users", nickname = "addUsers", notes = "With this method we want to create a new user in our application", tags={ "Users", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation") })
    @RequestMapping(value = "/users",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Void> addUsers(@ApiParam(value = "Users object that needs to be added in our application " ,required=true )  @Valid @RequestBody UserTO body);

}
