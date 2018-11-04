package com.anakeredchieva.doctor.sheduler.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
@Builder
public class UserTO {

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("username")
    @NotNull
    private String username;

    @JsonProperty("password")
    @NotNull
    private String password;

    @JsonProperty("email")
    @NotNull
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
