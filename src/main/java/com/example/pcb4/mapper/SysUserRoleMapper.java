package com.example.pcb4.mapper;

import com.example.pcb4.entity.SysRole;
import com.example.pcb4.entity.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author renhq
* @description 针对表【sys_user_role(用户角色表)】的数据库操作Mapper
* @createDate 2025-08-04 23:32:42
* @Entity generator.entity.SysUserRole
*/
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
    List<SysRole> selectRoleByUserId(Long id);
}




