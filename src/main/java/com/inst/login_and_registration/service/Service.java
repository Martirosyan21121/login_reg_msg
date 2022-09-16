package com.inst.login_and_registration.service;

import com.inst.login_and_registration.moduls.User;
import com.inst.login_and_registration.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service {

    @Autowired
    public UserRepo userRepo;

    public void saveUser(User user){
        userRepo.save(user);
    }
}
