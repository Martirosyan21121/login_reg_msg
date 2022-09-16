package com.inst.login_and_registration.repo;

import com.inst.login_and_registration.moduls.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findByNameAndEmailAndPassword(String name, String email, String password);

    Optional<User> findByEmail(String email);

}
