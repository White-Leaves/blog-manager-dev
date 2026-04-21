package com.example.pcb4.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.pcb4.entity.SysRole;
import com.example.pcb4.mapper.SysRoleMapper;
import com.example.pcb4.mapper.SysUserMapper;
import com.example.pcb4.service.SysRoleMenuService;
import com.example.pcb4.service.SysUserRoleService;
import com.mysql.cj.util.StringUtils;
import com.example.pcb4.entity.SysMenu;
import com.example.pcb4.entity.Vo.MenuVo;
import com.example.pcb4.service.SysMenuService;
import com.example.pcb4.mapper.SysMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
* @author renhq
* @description 针对表【sys_menu(菜单表)】的数据库操作Service实现
* @createDate 2025-08-04 23:32:42
*/
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu>
    implements SysMenuService{

    @Autowired
    private SysUserRoleService sysUserRoleService;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public void addMenu(SysMenu menu) {
        if(menu.getParentId() == 0){
            menu.setLevel(1);
            menu.setParentId(null);
        }else{
            SysMenu parentMenu = baseMapper.selectById(menu.getParentId());
            if(parentMenu == null){
                System.out.println("未查询到对应的父节点");
            }else{
                menu.setLevel(parentMenu.getLevel()+1);
                if(!StringUtils.isNullOrEmpty(parentMenu.getPath())){
                    menu.setPath(parentMenu.getPath()+parentMenu.getId());
                }else{
                    menu.setPath(parentMenu.getId().toString());
                }
            }

        }

        menu.setId(System.currentTimeMillis());
        super.save(menu);
    }

    @Override
    public List<MenuVo> queryMenuTree() throws InvocationTargetException, IllegalAccessException {
        Wrapper<SysMenu> queryObj = new QueryWrapper<SysMenu>().orderByAsc("level","sort");
        List<SysMenu> allMenu = super.list(queryObj);

        List<MenuVo> resultList = transferMenuVo(allMenu,0L);
        return resultList;
    }

    private List<MenuVo> transferMenuVo(List<SysMenu> allMenu,Long parentId) throws InvocationTargetException, IllegalAccessException {
//        System.out.println(parentId);

        List<MenuVo> resultList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(allMenu)){
            for(SysMenu source : allMenu){

                if(source.getParentId() != null){
//                    System.out.println(source.getId());

                    if(parentId.equals(source.getParentId())){
                        MenuVo menuVo = new MenuVo();
                        menuVo.setId(source.getId());
                        menuVo.setName(source.getName());
                        menuVo.setMenuCode(source.getMenuCode());
                        menuVo.setParentId(source.getParentId());
                        menuVo.setNodeType(source.getNodeType());
                        menuVo.setIconUrl(source.getIconUrl());
                        menuVo.setSort(source.getSort());
                        menuVo.setUrl(source.getUrl());
                        menuVo.setLevel(source.getLevel());
                        menuVo.setPath(source.getPath());

                        List<MenuVo> childList = transferMenuVo(allMenu,source.getId());
                        if(!CollectionUtils.isEmpty(childList)){
                            menuVo.setChildMenu(childList);
                        }
                        resultList.add(menuVo);

                    }
                }

            }
        }
        return resultList;
    }


    @Override
    public List<MenuVo> queryMenus(Long userId) {
        List<SysRole> userRoles = sysUserRoleService.selectRoleByUserId(userId);

        if(userRoles != null){

            List<SysMenu> menus = new ArrayList<>();
            for(SysRole role : userRoles){
                List<SysMenu> roleMenu = sysRoleMapper.selectMenusByRoleId(role.getId());
                for(SysMenu menu : roleMenu){
                    if(!menus.contains(menu)){
//                        System.out.println(menu);
                        menus.add(menu);
                    }
                }
            }


            if(!CollectionUtils.isEmpty(menus)){
                //通过path查询父节点id
                Set<Long> allMenuIds = new HashSet<>();
                for(SysMenu menu : menus){
                    allMenuIds.add(menu.getId());
                    if(!StringUtils.isNullOrEmpty(menu.getPath())){
                        List<String> pathIds = StringUtils.split(menu.getPath(), ",", true);
                        for(String pathId : pathIds){
//                            System.out.println(pathId);
                            allMenuIds.add(Long.valueOf(pathId));
                        }
                    }
                }

                List<SysMenu> allMenus = super.list(new QueryWrapper<SysMenu>().in("id",new ArrayList<>(allMenuIds)));
                try {
                    return transferMenuVo(allMenus,0L);
                } catch (InvocationTargetException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }

            }

        }

        return null;
    }


}



