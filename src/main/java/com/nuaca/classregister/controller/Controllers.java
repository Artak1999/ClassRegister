package com.nuaca.classregister.controller;

import com.nuaca.classregister.model.SignIn;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Controllers {

    @GetMapping("/")
    public String login(){
        return "login";
    }

    @GetMapping("/")
    public String afterLogin(Model model){
        model.addAttribute("signIn", new SignIn());
        return "login";
    }
    @PostMapping
    public String afterLogin(@ModelAttribute("signIn") SignIn signIn){
        System.out.println(signIn.getLogin() + " " + signIn.getPassword());
        return "login";
    }
}
