package com.anakeredchieva.doctor.sheduler.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Validated
@Builder
public class DoctorsTO {

    @JsonProperty("FirstName")
    private String firstName;

    @JsonProperty("LastName")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("typeOfDoctor")
    private String typeOfDoctor;

    @JsonProperty("telephone")
    private String telephone;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTypeOfDoctor() {
        return typeOfDoctor;
    }

    public void setTypeOfDoctor(String typeOfDoctor) {
        this.typeOfDoctor = typeOfDoctor;
    }
}
