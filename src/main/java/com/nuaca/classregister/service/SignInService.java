package com.nuaca.classregister.service;

import com.nuaca.classregister.model.Professor;
import com.nuaca.classregister.repository.SignInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SignInService {

    @Autowired
    private SignInRepository signInRepository;

    public Optional<Professor> findProfessor(String login, String password){
        return signInRepository.findProfessorByLogin(login,password);
    }
}
