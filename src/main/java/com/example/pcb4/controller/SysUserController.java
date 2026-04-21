package com.example.pcb4.controller;

import com.example.pcb4.entity.Request.LoginRequest;
import com.example.pcb4.entity.Request.ResetPwdRequest;
import com.example.pcb4.entity.Request.UserInfoRequest;
import com.example.pcb4.entity.SysMenu;
import com.example.pcb4.entity.SysRole;
import com.example.pcb4.entity.SysUser;
import com.example.pcb4.entity.Vo.MenuVo;
import com.example.pcb4.mapper.SysUserMapper;
import com.example.pcb4.mapper.SysUserRoleMapper;
import com.example.pcb4.service.SysMenuService;
import com.example.pcb4.service.SysUserRoleService;
import com.example.pcb4.service.SysUserService;
import com.example.pcb4.utils.JwtUtils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserRoleService sysUserRoleService;
    @Autowired
    private SysMenuService sysMenuService;

    @PostMapping(value = "/login",consumes = {"*/*"})
    public ResponseEntity<Map<String,Object>> login(@RequestBody LoginRequest loginRequest){
        SysUser user = sysUserService.selectByName(loginRequest.getUsername());
        System.out.println(user);
        if(user != null && sysUserService.checkPassword(loginRequest.getPassword(),user.getPassword())){
            Map<String,Object> claims = new HashMap<>();
            claims.put("username",user.getName());
            claims.put("mobile",user.getMobile());
            List<SysRole> roleList = sysUserRoleService.selectRoleByUserId(user.getId());
            List<String> roleNamesList = roleList.stream().map(SysRole::getName).toList();
            StringBuilder roleNames = new StringBuilder();
            for(SysRole role:roleList) {
                roleNames.append(role.getName());
            }
            claims.put("roles",roleNames.toString());
            String jwt = JwtUtils.generateToken(claims,user.getName());

            List<MenuVo> menulist = sysMenuService.queryMenus(user.getId());
            System.out.println(menulist);

            System.out.println(Map.of("user", user,"token",jwt));

            return ResponseEntity.ok(Map.of("id",user.getId(),"token",jwt,"user",Map.of("username",user.getName(),"roles",roleNamesList),"menulist",menulist));

        }else {
            return ResponseEntity.status(401).body(Map.of("result","登录失败"));
        }
    }

    @GetMapping(value = "/profile")
    public ResponseEntity<Map<String,Object>> getProfile(@RequestParam(value = "userId") String userId){
        SysUser user = sysUserService.selectById(Long.parseLong(userId));
        System.out.println(user);
        if(user != null){
            return ResponseEntity.ok(Map.of("name",user.getName(),"mobile",user.getMobile()));
        }
        else{
            return ResponseEntity.status(401).body(Map.of("result","获取用户信息失败"));
        }
    }

    @PostMapping(value = "/updateInfo")
    public ResponseEntity<Map<String,Object>> updateUserInfo(@RequestBody UserInfoRequest request){
        SysUser user = sysUserService.selectById(Long.parseLong(request.getId()));
        if(user != null){
            sysUserService.updateUserInfo(request);
            return ResponseEntity.ok(Map.of("result","修改成功"));
        }else{
            return ResponseEntity.status(401).body(Map.of("result","修改失败"));
        }
    }

    @PostMapping(value = "/updatePassword")
    public ResponseEntity<Map<String,Object>> updatePassword(@RequestBody ResetPwdRequest request){
        SysUser user = sysUserService.selectById(Long.parseLong(request.getId()));
        if(user != null){
            sysUserService.updatePassword(request);
            return ResponseEntity.ok(Map.of("result","修改成功"));
        }else{
            return ResponseEntity.status(401).body(Map.of("result","修改失败"));
        }
    }

}
