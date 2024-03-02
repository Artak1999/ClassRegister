package com.nuaca.classregister.service;

import com.nuaca.classregister.model.StudentGroup;
import com.nuaca.classregister.repository.StudentGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentGroupService {

    @Autowired
    private StudentGroupRepository studentGroupRepository;

    public List<StudentGroup> findGroup(String email){
        return studentGroupRepository.findGroupByProfessor(email);
    }
}
