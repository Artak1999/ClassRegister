package com.nuaca.classregister.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surName;
    private String middleName;
    private String email;
    @OneToMany(mappedBy = "professor",cascade = CascadeType.ALL)
    private List<StudentGroup> studentGroup;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Faculty> faculty;
}
