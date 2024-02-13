package com.nuaca.classregister.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(targetEntity = Professor.class, cascade = CascadeType.ALL)
    private Professor professor;
    @OneToOne(targetEntity = Grade.class, cascade = CascadeType.ALL)
    private Grade grade;
}
