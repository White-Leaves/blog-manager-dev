package com.example.pcb4.mapper;

import com.example.pcb4.entity.Request.ResetPwdRequest;
import com.example.pcb4.entity.SysRole;
import com.example.pcb4.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author renhq
* @description 针对表【sys_user(用户表)】的数据库操作Mapper
* @createDate 2025-08-04 23:32:42
* @Entity generator.entity.SysUser
*/
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    SysUser selectByName(String name);

    void UpdateUserInfo(Long id,String name,String mobile);
    void ResetPwd(Long id,String newPwd);
}




