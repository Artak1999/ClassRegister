package com.nuaca.classregister.repository;

import com.nuaca.classregister.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {
    @Query("select s from Subject s join Professor as p " +
            "on p.id=:id where s.professor.id=p.id")
    Optional<Subject> professorSubject(Long id);
}
