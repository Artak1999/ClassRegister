package com.nuaca.classregister.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surName;
    private String middleName;
    @Column(unique = true)
    private String email;
    private Date dateOfBirth;
    private String placeOfBirth;
    private String gender;
    private String lastStudy;
    private String biography;
    private String profession;
    private boolean remote;
    @Column(unique = true)
    private String phone;
    private String address;
    private boolean militaries;
    private String awarding;
    private boolean olimpiada;
    @ManyToOne(targetEntity = Faculty.class, cascade = CascadeType.ALL)
    private Faculty faculty;
    @ManyToOne(targetEntity = StudentGroup.class, cascade = CascadeType.ALL)
    private StudentGroup studentGroup;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Attendance> attendances;
}
