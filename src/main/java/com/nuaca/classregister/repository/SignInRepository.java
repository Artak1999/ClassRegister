package com.nuaca.classregister.repository;

import com.nuaca.classregister.model.Professor;
import com.nuaca.classregister.model.SignIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SignInRepository extends JpaRepository<SignIn, Long> {
    @Query("Select p from Professor p join SignIn as s " +
            "on s.login=:login and s.password=:password where p.id=s.id")
    Optional<Professor> findProfessorByLogin(String login, String password);
}
