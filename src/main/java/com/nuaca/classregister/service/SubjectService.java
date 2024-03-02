package com.nuaca.classregister.service;

import com.nuaca.classregister.model.Subject;
import com.nuaca.classregister.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public Optional<Subject> getProfessorSubject(Long id){
        return subjectRepository.professorSubject(id);
    }
}
