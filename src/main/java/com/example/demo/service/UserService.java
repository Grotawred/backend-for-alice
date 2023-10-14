package com.example.demo.service;


import com.example.demo.model.User;
import com.example.demo.model.request.RegistrationRequest;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;


    public User registerUser(RegistrationRequest request) throws Exception {
        List<User> user = userRepository.findByLogin(request.getLogin());
        if(!user.isEmpty()){
            throw new Exception();
        }
        var newUser =
        User.builder()
                .login(request.getLogin())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(roleRepository.findByName(request.getRole()))
                .build();
        return userRepository.save(newUser);
    }


}
