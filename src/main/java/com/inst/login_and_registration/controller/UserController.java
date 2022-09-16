package com.inst.login_and_registration.controller;

import com.inst.login_and_registration.moduls.User;
import com.inst.login_and_registration.repo.UserRepo;
import com.inst.login_and_registration.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    public Service service;
    @Autowired
    public UserRepo userRepo;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/userSuccess")
    public String success() {
        return "success";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
        Optional<User> byNameAndEmailAndPassword = userRepo.findByNameAndEmailAndPassword(user.getName(), user.getEmail(), user.getPassword());
        if (byNameAndEmailAndPassword.isPresent()){
            return "redirect:/userSuccess";
        }else {
            String msg = "Wrong Email or Password";
            model.addAttribute("msg", msg);
           return "login";
        }
    }

    @PostMapping("/save")
    public String userSave(@ModelAttribute User user, Model model) {
        Optional<User> byEmail = userRepo.findByEmail(user.getEmail());
        if (byEmail.isPresent()){
            String msg = "User already exists... Please Login";
            model.addAttribute("msg", msg);
            return "index";
        }else {
            service.saveUser(user);
            return "redirect:/userSuccess";
        }


    }

}
