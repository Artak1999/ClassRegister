package com.nuaca.classregister.controller;

import com.nuaca.classregister.model.Professor;
import com.nuaca.classregister.model.SignIn;
import com.nuaca.classregister.model.Student;
import com.nuaca.classregister.service.AttendanceService;
import com.nuaca.classregister.service.SignInService;
import com.nuaca.classregister.service.StudentGroupService;
import com.nuaca.classregister.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class Controllers {

    @Autowired
    private SignInService signInService;
    @Autowired
    private StudentGroupService studentGroupService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private AttendanceService attendanceService;
    Optional<Professor> professor;
    Optional<SignIn> admin;
    String groupName;

    @GetMapping("/")
    public String login(Model model){
        model.addAttribute("signIn", new SignIn());
        return "login";
    }

    @PostMapping("/group")
    public String afterLogin(@ModelAttribute("signIn") SignIn signIn, Model model){
        String direction;
        admin = signInService.findAdmin(signIn.getLogin(), signIn.getPassword());
        professor = signInService.findProfessor(signIn.getLogin(), signIn.getPassword());
        if(professor.isPresent()) {
            model.addAttribute("groups", studentGroupService.findGroup(professor.get().getEmail()));
            direction =  "group";
        }
        else if(admin.isPresent()){
            direction = "admin";
        }
        else
            direction = "redirect:/?loginError";
        return direction;
    }

    @GetMapping("/group")
    public String group(Model model){
        professor.ifPresent(value -> model.addAttribute("groups", studentGroupService.findGroup(value.getEmail())));
        return "group";
    }

    @GetMapping("/dashboard/{name}")
    public String dashboard(@PathVariable String name, Model model){
        groupName = name;
        model.addAttribute("student", new Student());
        model.addAttribute("students", studentService.findStudentsByGroup(name));
        professor.ifPresent(p -> model.addAttribute("professor", p.getName() + " " + p.getSurName()));
        return "dashboard";
    }

    @PostMapping("/dashboard")
    public String dashboards(@RequestParam("attendance") String attendance, Model model){
        attendanceService.addAttendances(attendance);
        model.addAttribute("students", studentService.findStudentsByGroup(groupName));
        professor.ifPresent(p -> model.addAttribute("professor", p.getName() + " " + p.getSurName()));
        return "dashboard";
    }

    @GetMapping("/attendance")
    public String attendance(Model model){
        Map<String, Integer> data = new LinkedHashMap<>();
        for (int i=0; i<studentService.findStudentsByGroup(groupName).size(); i++) {
            data.put(studentService.getAll().get(i).getName() + " " +
                    studentService.getAll().get(i).getSurName() + " " +
                    studentService.getAll().get(i).getMiddleName(), 30);
        }
        model.addAttribute("keySet", data.keySet());
        model.addAttribute("values", data.values());
        return "attendance";
    }
}
