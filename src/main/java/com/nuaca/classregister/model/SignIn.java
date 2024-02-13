package com.nuaca.classregister.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SignIn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Role role;
    private String login;
    private String password;
    @OneToOne(targetEntity = Faculty.class, cascade = CascadeType.ALL)
    private Faculty faculty;
}
