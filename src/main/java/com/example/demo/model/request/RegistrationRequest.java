package com.example.demo.model.request;


import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;

@Getter
public final class RegistrationRequest {
    private String login;
    private String password;
    private String role;
}
