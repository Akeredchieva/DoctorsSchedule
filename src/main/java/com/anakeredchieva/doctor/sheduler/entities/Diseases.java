package com.anakeredchieva.doctor.sheduler.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "diseases")
public class Diseases implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "disease_name",nullable = false,unique = true)
    private String diseaseName;

    @Column
    private String description;

    public Diseases(String diseaseName) {
        this.setDiseaseName(diseaseName);
    }

    public Diseases(String diseaseName, String description) {
        this.setDiseaseName(diseaseName);
        this.setDescription(description);
    }

    public int getId() {
        return id;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
