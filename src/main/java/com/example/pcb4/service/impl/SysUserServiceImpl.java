package com.example.pcb4.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.pcb4.entity.Request.ResetPwdRequest;
import com.example.pcb4.entity.Request.UserInfoRequest;
import com.example.pcb4.entity.SysUser;
import com.example.pcb4.service.SysUserService;
import com.example.pcb4.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author renhq
* @description 针对表【sys_user(用户表)】的数据库操作Service实现
* @createDate 2025-08-04 23:32:42
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService{

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public SysUser selectByName(String username) {
        return sysUserMapper.selectByName(username);
    }

    @Override
    public SysUser selectById(Long id) {
        return sysUserMapper.selectById(id);
    }

    @Override
    public void updateUserInfo(UserInfoRequest request) {
        sysUserMapper.UpdateUserInfo(Long.parseLong(request.getId()),request.getName(),request.getMobile());
    }

    @Override
    public void updatePassword(ResetPwdRequest request) {
        sysUserMapper.ResetPwd(Long.parseLong(request.getId()),request.getNewPassword());
    }

    @Override
    public boolean checkPassword(String password1, String password2) {
        return password1.equals(password2);
    }
}




