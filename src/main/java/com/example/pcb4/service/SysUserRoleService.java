package com.example.pcb4.service;

import com.example.pcb4.entity.SysRole;
import com.example.pcb4.entity.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author renhq
* @description 针对表【sys_user_role(用户角色表)】的数据库操作Service
* @createDate 2025-08-04 23:32:42
*/
@Service
public interface SysUserRoleService extends IService<SysUserRole> {
    List<SysRole> selectRoleByUserId(Long userId);
}
