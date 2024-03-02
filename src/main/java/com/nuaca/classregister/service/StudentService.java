package com.nuaca.classregister.service;

import com.nuaca.classregister.model.Student;
import com.nuaca.classregister.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void create(Student student){
        studentRepository.save(student);
    }

    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    public List<Student> findStudentsByGroup(String name){
        return studentRepository.findStudentsByGroup(name);
    }

    public Student getStudentById(Long id){
        Optional<Student> optional = studentRepository.findById(id);
        Student student;
        if (optional.isPresent())
            student = optional.get();
        else
            throw new RuntimeException("Student not found for id :: " + id);
        return student;
    }

    public void deleteStudentById(Long id){
        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isPresent())
            studentRepository.deleteById(id);
        else
            throw new RuntimeException("Student not found for id :: " + id);
    }
}
