package com.example.pcb4.mapper;

import com.example.pcb4.entity.SysMenu;
import com.example.pcb4.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
* @author renhq
* @description 针对表【sys_role(角色表)】的数据库操作Mapper
* @createDate 2025-08-04 23:32:42
* @Entity generator.entity.SysRole
*/
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
    List<SysMenu> selectMenusByRoleId(Long id);
}




