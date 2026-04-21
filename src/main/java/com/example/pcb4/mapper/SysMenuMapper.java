package com.example.pcb4.mapper;

import com.example.pcb4.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author renhq
* @description 针对表【sys_menu(菜单表)】的数据库操作Mapper
* @createDate 2025-08-04 23:32:42
* @Entity generator.entity.SysMenu
*/
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    int selectAuthByUserIdAndMenuId(Long userId, String menuCode);
}




