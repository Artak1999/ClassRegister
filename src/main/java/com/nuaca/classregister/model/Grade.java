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
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ElementCollection
    private List<Integer> score;
    @ManyToOne(targetEntity = Student.class, cascade = CascadeType.ALL)
    private Student student;
    @OneToOne(targetEntity = Subject.class, cascade = CascadeType.ALL)
    private Subject subject;
}
