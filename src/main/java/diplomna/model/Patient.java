package diplomna.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Patient
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-06T12:51:14.120Z")
@AllArgsConstructor
public class Patient   {
  @JsonProperty("patient_id")
  private Integer patientId = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("middleName")
  private String middleName = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("telephone")
  private String telephone = null;

  @JsonProperty("address")
  private String address = null;

  @JsonProperty("egn")
  private String egn = null;

  public Patient patientId(Integer patientId) {
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

  public Patient firstName(String firstName) {
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

  public Patient lastName(String lastName) {
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

  public Patient middleName(String middleName) {
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

  public Patient email(String email) {
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

  public Patient telephone(String telephone) {
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

  public Patient address(String address) {
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

  public Patient egn(String egn) {
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
    Patient patient = (Patient) o;
    return Objects.equals(this.patientId, patient.patientId) &&
        Objects.equals(this.firstName, patient.firstName) &&
        Objects.equals(this.lastName, patient.lastName) &&
        Objects.equals(this.middleName, patient.middleName) &&
        Objects.equals(this.email, patient.email) &&
        Objects.equals(this.telephone, patient.telephone) &&
        Objects.equals(this.address, patient.address) &&
        Objects.equals(this.egn, patient.egn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(patientId, firstName, lastName, middleName, email, telephone, address, egn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Patient {\n");
    
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

