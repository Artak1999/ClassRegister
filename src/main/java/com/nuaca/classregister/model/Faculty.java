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
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "faculty",cascade = CascadeType.ALL)
    private List<Student> student;
    @OneToOne(targetEntity = SignIn.class, cascade = CascadeType.ALL)
    private SignIn signIn;
    @ManyToMany(mappedBy = "faculty",targetEntity = Professor.class, cascade = CascadeType.ALL)
    private List<Professor> professor;
}
