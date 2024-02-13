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
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ElementCollection
    private List<Integer> present;
    @ElementCollection
    private List<Integer> absent;
    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;
}
