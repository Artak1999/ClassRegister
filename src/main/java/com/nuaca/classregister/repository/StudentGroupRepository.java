package com.nuaca.classregister.repository;

import com.nuaca.classregister.model.StudentGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentGroupRepository extends JpaRepository<StudentGroup,Long> {
    @Query("Select g from StudentGroup g join Professor as p " +
            "on p.email=:email where g.professor.id=p.id")
    List<StudentGroup> findGroupByProfessor(String email);
}
