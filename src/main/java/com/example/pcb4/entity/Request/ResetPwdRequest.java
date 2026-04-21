package com.example.pcb4.entity.Request;

import lombok.Data;

@Data
public class ResetPwdRequest {
    private String id;
    private String oldPassword;
    private String newPassword;
}
