package com.anakeredchieva.doctor.sheduler.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users_doctors")
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Data
public class UsersDoctors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctors doctor;
}
