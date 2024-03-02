package com.nuaca.classregister.service;

import com.nuaca.classregister.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public void addAttendances(String attendance){
        List<String> list = new ArrayList<>();
        attendance = attendance.replaceAll(",","");
        for (int i = 0; i < attendance.length(); i++) {
            list.add(String.valueOf(attendance.charAt(i)));
        }
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals("Ն"))
                attendanceRepository.saveStudentPresent(i, list.get(i));
            else if(list.get(i).equals("Բ"))
                attendanceRepository.saveStudentAbsent(i, list.get(i));
        }
    }
}
