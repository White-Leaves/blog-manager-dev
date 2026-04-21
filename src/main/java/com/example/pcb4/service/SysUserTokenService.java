package com.example.pcb4.service;

import org.springframework.stereotype.Service;

@Service
public interface SysUserTokenService {
    void saveToken(String token, Long userId);

    String getToken(String userId);
    void deleteToken(String userId);
}
