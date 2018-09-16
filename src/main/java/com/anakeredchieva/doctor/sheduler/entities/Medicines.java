package com.anakeredchieva.doctor.sheduler.entities;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "medicines")
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Medicines implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,name = "medicine_name",unique = true)
    private String medicineName;

    @Column
    private String description;

    public Medicines(String medicineName) {
        this.setMedicineName(medicineName);
    }

    public Medicines(String medicineName, String description) {
        this.setMedicineName(medicineName);
        this.setDescription(description);
    }

    public int getId() {
        return id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
