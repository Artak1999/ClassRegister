package com.nuaca.classregister.repository;

import com.nuaca.classregister.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance,Long> {
    @Query("update Attendance as a set a.present=:attendance where a.id=:id")
    void saveStudentPresent(int id, String attendance);
    @Query("update Attendance as a set a.absent=:attendance where a.id=:id")
    void saveStudentAbsent(int id, String attendance);
}
