package com.example.pcb4.service;

import com.example.pcb4.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.pcb4.entity.Vo.MenuVo;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;


/**
* @author renhq
* @description 针对表【sys_menu(菜单表)】的数据库操作Service
* @createDate 2025-08-04 23:32:42
*/

@Service
public interface SysMenuService extends IService<SysMenu> {
    public void addMenu(SysMenu menu);
    public List<MenuVo> queryMenuTree() throws InvocationTargetException, IllegalAccessException;
    List<MenuVo> queryMenus(Long userId);
}
