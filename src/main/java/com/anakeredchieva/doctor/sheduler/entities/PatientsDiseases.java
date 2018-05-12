package com.anakeredchieva.doctor.sheduler.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "patients_diseases")
public class PatientsDiseases implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patients patient;

    @Id
    @ManyToOne
    @JoinColumn(name = "disease_id")
    private Diseases disease;

    @Column(nullable = false,name = "diagnose_date")
    private String diagnoseDate;

    @Column(name = "end_diagnose_date")
    private String endDiagnoseDate;

    @Column(name = "description")
    private String description;

    public PatientsDiseases(Patients patient, Diseases disease, String diagnoseDate) {
        this.setPatient(patient);
        this.setDisease(disease);
        this.setDiagnoseDate(diagnoseDate);
    }

    public PatientsDiseases(Patients patient, Diseases disease,String diagnoseDate, String description) {
        this.setPatient(patient);
        this.setDisease(disease);
        this.setDescription(description);
        this.setDiagnoseDate(diagnoseDate);
    }
    public Patients getPatient() {
        return patient;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
    }

    public Diseases getDisease() {
        return disease;
    }

    public void setDisease(Diseases disease) {
        this.disease = disease;
    }

    public String getDiagnoseDate() {
        return diagnoseDate;
    }

    public void setDiagnoseDate(String diagnoseDate) {
        this.diagnoseDate = diagnoseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
