package com.anakeredchieva.doctor.sheduler.entities;



import lombok.AllArgsConstructor;
import lombok.Builder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patients")
@Builder
@AllArgsConstructor
public class Patients implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "middle_name",nullable = false)
    private String middleName;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column(name = "phone_number",nullable = false)
    private String phone;

    @Column(nullable = false)
    private String egn;

    @Column
    private String address;

    @Column
    private String email;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "patient" , fetch = FetchType.EAGER)
    private List<Time> time;

    @Fetch(FetchMode.SUBSELECT)
    @ManyToMany(mappedBy = "patients" , fetch = FetchType.EAGER)
    private List<Doctors> doctors;
// създава празен пациент
    public Patients() {
        this.setTime(new ArrayList<>());
        this.setDoctors(new ArrayList<>());
    }
// създава пациент без записан час,адрес и имейл
    public Patients(String firstName, String middleName, String lastName, String egn, List<Doctors> doctors) {
        this.setFirstName(firstName);
        this.setMiddleName(middleName);
        this.setLastName(lastName);
        this.setEgn(egn);
        this.setDoctors(doctors);
    }
// създава пациент без записан час, но с имейл
    public Patients(String firstName, String middleName, String lastName, String egn, String email, List<Doctors> doctors) {
        this.setFirstName(firstName);
        this.setMiddleName(middleName);
        this.setLastName(lastName);
        this.setEgn(egn);
        this.setDoctors(doctors);
        this.setEmail(email);
    }
// създава пациент без записан час, но с имейл и адрес
    public Patients(String firstName, String middleName, String lastName, String egn, String address, String email, List<Doctors> doctors) {
        this.setFirstName(firstName);
        this.setMiddleName(middleName);
        this.setLastName(lastName);
        this.setEgn(egn);
        this.setDoctors(doctors);
        this.setEmail(email);
        this.setAddress(address);
    }
//създава пациент със записан час
    public Patients(String firstName, String middleName, String lastName, String egn, String address, String email,
                    List<Time> time, List<Doctors> doctors) {
        this.setFirstName(firstName);
        this.setMiddleName(middleName);
        this.setLastName(lastName);
        this.setEgn(egn);
        this.setDoctors(doctors);
        this.setEmail(email);
        this.setTime(time);
        this.setAddress(address);
    }
// създава пациент със записан час, но без имейл и адрес
    public Patients(String firstName, String middleName, String lastName, String egn, List<Time> time,
                    List<Doctors> doctors) {
        this.setFirstName(firstName);
        this.setMiddleName(middleName);
        this.setLastName(lastName);
        this.setEgn(egn);
        this.setDoctors(doctors);
        this.setEmail(email);
        this.setTime(time);
    }
// създава пациент със записан час, но без адрес
    public Patients(String firstName, String middleName, String lastName, String egn, String email, List<Time> time, List<Doctors> doctors) {
        this.setFirstName(firstName);
        this.setMiddleName(middleName);
        this.setLastName(lastName);
        this.setEgn(egn);
        this.setDoctors(doctors);
        this.setTime(time);
        this.setEmail(email);
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEgn() {
        return egn;
    }

    public void setEgn(String EGN) {
        this.egn = EGN;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Time> getTime() {
        return time;
    }

    public void setTime(List<Time> time) {
        this.time = time;
    }

    public List<Doctors> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctors> doctors) {
        this.doctors = doctors;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
