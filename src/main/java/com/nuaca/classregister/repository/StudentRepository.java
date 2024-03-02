package com.nuaca.classregister.repository;

import com.nuaca.classregister.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("select s from Student s join StudentGroup as g " +
            "on g.name=:groupName where s.studentGroup.id=g.id")
    List<Student> findStudentsByGroup(String groupName);
}
