package com.example.pcb4.controller;

import com.example.pcb4.entity.Vo.MenuVo;
import com.example.pcb4.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @PostMapping(value = "/queryMenuTree")
    public List<MenuVo> queryMenuTree() throws InvocationTargetException, IllegalAccessException {
        return sysMenuService.queryMenuTree();
    }

    @PostMapping(value = "/queryMenus")
    public List<MenuVo> queryMenus(Long userId){
        return sysMenuService.queryMenus(userId);
    }

}
