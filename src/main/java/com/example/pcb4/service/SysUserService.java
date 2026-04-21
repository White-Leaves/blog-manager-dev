package com.example.pcb4.service;

import com.example.pcb4.entity.Request.ResetPwdRequest;
import com.example.pcb4.entity.Request.UserInfoRequest;
import com.example.pcb4.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
* @author renhq
* @description 针对表【sys_user(用户表)】的数据库操作Service
* @createDate 2025-08-04 23:32:42
*/
@Service
public interface SysUserService extends IService<SysUser> {
    SysUser selectByName(String username);
    SysUser selectById(Long id);
    void updateUserInfo(UserInfoRequest request);
    void updatePassword(ResetPwdRequest request);
    boolean checkPassword(String password1, String password2);
}
