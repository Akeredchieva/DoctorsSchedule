package com.anakeredchieva.doctor.sheduler.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * PatientTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-06T12:51:14.120Z")
@Builder
public class PatientTO {
  @JsonProperty("patient_id")
  private Integer patientId = null;

  @JsonProperty("firstName")
  @NotNull
  private String firstName = null;

  @JsonProperty("lastName")
  @NotNull
  private String lastName = null;

  @JsonProperty("middleName")
  @NotNull
  private String middleName = null;

  @JsonProperty("email")
  @NotNull
  private String email = null;

  @JsonProperty("telephone")
  @NotNull
  private String telephone = null;

  @JsonProperty("address")
  @NotNull
  private String address = null;

  @JsonProperty("egn")
  @NotNull
  private String egn = null;

  public PatientTO patientId(Integer patientId) {
    this.patientId = patientId;
    return this;
  }

  /**
   * this is the uqueue id for partient
   * @return patientId
  **/
  @ApiModelProperty(value = "this is the uqueue id for partient")


  public Integer getPatientId() {
    return patientId;
  }

  public void setPatientId(Integer patientId) {
    this.patientId = patientId;
  }

  public PatientTO firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * The first name of patient
   * @return firstName
  **/
  @ApiModelProperty(value = "The first name of patient")


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public PatientTO lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * The last name of patient
   * @return lastName
  **/
  @ApiModelProperty(value = "The last name of patient")


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public PatientTO middleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  /**
   * The middle name of patient
   * @return middleName
  **/
  @ApiModelProperty(value = "The middle name of patient")


  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public PatientTO email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Email address of patient
   * @return email
  **/
  @ApiModelProperty(value = "Email address of patient")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public PatientTO telephone(String telephone) {
    this.telephone = telephone;
    return this;
  }

  /**
   * The telephone of patient
   * @return telephone
  **/
  @ApiModelProperty(value = "The telephone of patient")


  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public PatientTO address(String address) {
    this.address = address;
    return this;
  }

  /**
   * The address of patient
   * @return address
  **/
  @ApiModelProperty(value = "The address of patient")


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public PatientTO egn(String egn) {
    this.egn = egn;
    return this;
  }

  /**
   * The EGN of patients
   * @return egn
  **/
  @ApiModelProperty(value = "The EGN of patients")


  public String getEgn() {
    return egn;
  }

  public void setEgn(String egn) {
    this.egn = egn;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PatientTO patientTO = (PatientTO) o;
    return Objects.equals(this.patientId, patientTO.patientId) &&
        Objects.equals(this.firstName, patientTO.firstName) &&
        Objects.equals(this.lastName, patientTO.lastName) &&
        Objects.equals(this.middleName, patientTO.middleName) &&
        Objects.equals(this.email, patientTO.email) &&
        Objects.equals(this.telephone, patientTO.telephone) &&
        Objects.equals(this.address, patientTO.address) &&
        Objects.equals(this.egn, patientTO.egn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(patientId, firstName, lastName, middleName, email, telephone, address, egn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PatientTO {\n");
    
    sb.append("    patientId: ").append(toIndentedString(patientId)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    middleName: ").append(toIndentedString(middleName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    telephone: ").append(toIndentedString(telephone)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    egn: ").append(toIndentedString(egn)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

