package com.example.pcb4.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.pcb4.entity.SysRole;
import com.example.pcb4.entity.SysUserRole;
import com.example.pcb4.service.SysUserRoleService;
import com.example.pcb4.mapper.SysUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author renhq
* @description 针对表【sys_user_role(用户角色表)】的数据库操作Service实现
* @createDate 2025-08-04 23:32:42
*/
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole>
    implements SysUserRoleService{

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public List<SysRole> selectRoleByUserId(Long userId) {
        return sysUserRoleMapper.selectRoleByUserId(userId);
    }
}




