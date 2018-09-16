package com.anakeredchieva.doctor.sheduler.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * DiseasesTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-06T12:51:14.120Z")
@Data
@NoArgsConstructor
public class DiseasesTO {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("dateOfDiagnose")
  private String dateOfDiagnose = null;

  @JsonProperty("description")
  private String description = null;

  public DiseasesTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of diseases
   * @return name
  **/
  @ApiModelProperty(value = "The name of diseases")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DiseasesTO dateOfDiagnose(String dateOfDiagnose) {
    this.dateOfDiagnose = dateOfDiagnose;
    return this;
  }

  /**
   * Date of diagnose
   * @return dateOfDiagnose
  **/
  @ApiModelProperty(value = "Date of diagnose")


  public String getDateOfDiagnose() {
    return dateOfDiagnose;
  }

  public void setDateOfDiagnose(String dateOfDiagnose) {
    this.dateOfDiagnose = dateOfDiagnose;
  }

  public DiseasesTO description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DiseasesTO diseasesTO = (DiseasesTO) o;
    return Objects.equals(this.name, diseasesTO.name) &&
        Objects.equals(this.dateOfDiagnose, diseasesTO.dateOfDiagnose) &&
        Objects.equals(this.description, diseasesTO.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, dateOfDiagnose, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DiseasesTO {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    dateOfDiagnose: ").append(toIndentedString(dateOfDiagnose)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

