package com.example.pcb4.entity.Request;

import lombok.Data;

@Data
public class LoginRequest {
    private long mobile;
    private String username;
    private String password;


}
