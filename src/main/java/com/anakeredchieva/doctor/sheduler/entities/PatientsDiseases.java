package com.anakeredchieva.doctor.sheduler.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "patients_diseases")
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Data
public class PatientsDiseases implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patients patient;

    @ManyToOne
    @JoinColumn(name = "disease_id")
    private Diseases disease;

    @Column(nullable = false,name = "diagnose_date")
    private String diagnoseDate;

    @Column(name = "end_diagnose_date")
    private String endDiagnoseDate;

    @Column(name = "description")
    private String description;

}
