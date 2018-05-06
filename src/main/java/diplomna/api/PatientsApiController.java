package diplomna.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import diplomna.model.Diseases;
import diplomna.model.Patient;
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
    public PatientsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addPatients(@ApiParam(value = "Patients object that needs to be added in our application " ,required=true )  @Valid @RequestBody Patient body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Patient>> patientsGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Patient>>(objectMapper.readValue("[ {  \"firstName\" : \"firstName\",  \"lastName\" : \"lastName\",  \"address\" : \"address\",  \"patient_id\" : 0,  \"middleName\" : \"middleName\",  \"telephone\" : \"telephone\",  \"egn\" : \"egn\",  \"email\" : \"email\"}, {  \"firstName\" : \"firstName\",  \"lastName\" : \"lastName\",  \"address\" : \"address\",  \"patient_id\" : 0,  \"middleName\" : \"middleName\",  \"telephone\" : \"telephone\",  \"egn\" : \"egn\",  \"email\" : \"email\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Patient>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Patient>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> patientsPatientIdDelete(@ApiParam(value = "",required=true) @PathVariable("patientId") Long patientId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> patientsPatientIdDiseasesDiseasedIdDelete(@ApiParam(value = "",required=true) @PathVariable("patientId") Long patientId,@ApiParam(value = "",required=true) @PathVariable("diseasedId") Long diseasedId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> patientsPatientIdDiseasesDiseasedIdPut(@ApiParam(value = "Disease object that needs to be added in our application " ,required=true )  @Valid @RequestBody Diseases body,@ApiParam(value = "",required=true) @PathVariable("patientId") Long patientId,@ApiParam(value = "",required=true) @PathVariable("diseasedId") Long diseasedId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Diseases>> patientsPatientIdDiseasesGet(@ApiParam(value = "",required=true) @PathVariable("patientId") Long patientId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Diseases>>(objectMapper.readValue("[ {  \"dateOfDiagnose\" : \"dateOfDiagnose\",  \"name\" : \"name\",  \"description\" : \"description\"}, {  \"dateOfDiagnose\" : \"dateOfDiagnose\",  \"name\" : \"name\",  \"description\" : \"description\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Diseases>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Diseases>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> patientsPatientIdDiseasesPost(@ApiParam(value = "Disease object that needs to be added in our application " ,required=true )  @Valid @RequestBody Diseases body,@ApiParam(value = "",required=true) @PathVariable("patientId") Long patientId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Patient> patientsPatientIdGet(@ApiParam(value = "",required=true) @PathVariable("patientId") Long patientId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Patient>(objectMapper.readValue("{  \"firstName\" : \"firstName\",  \"lastName\" : \"lastName\",  \"address\" : \"address\",  \"patient_id\" : 0,  \"middleName\" : \"middleName\",  \"telephone\" : \"telephone\",  \"egn\" : \"egn\",  \"email\" : \"email\"}", Patient.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Patient>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Patient>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> patientsPatientIdPut(@ApiParam(value = "Patients object that needs to be added in our application " ,required=true )  @Valid @RequestBody Patient body,@ApiParam(value = "",required=true) @PathVariable("patientId") Long patientId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
