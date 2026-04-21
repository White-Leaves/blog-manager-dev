package com.example.pcb4.filter;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.pcb4.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception {
        String url = request.getRequestURL().toString();

        System.out.println(url);
        if (url.contains("login") || url.contains("register") || url.contains("logout")) {
            System.out.println("login");
            return true;
        }

        if (url.contains("error")){
            System.out.println("error");
            return true;
        }

        String jwt = request.getHeader("token");

        if(StringUtils.isEmpty(jwt)){
            System.out.println(jwt);
            response.setContentType("application/json;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

            JSONObject json = new JSONObject();
            json.put("success",false);
            json.put("message","token 不存在");

            response.getWriter().write(json.toString());
            return false;
        }

        try{
            JwtUtils.parseToken(jwt);
        }catch (Exception e){
            response.setContentType("application/json;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            JSONObject json = new JSONObject();
            json.put("success",false);
            json.put("message","token无效"+e.getMessage());

            response.getWriter().write(json.toString());
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("postHandle运行");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("afterCompletion运行");
    }


}
