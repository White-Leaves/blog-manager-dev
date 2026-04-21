package com.example.pcb4.filter;


import com.example.pcb4.common.CheckPermissions;
import com.example.pcb4.mapper.SysMenuMapper;
import com.mysql.cj.util.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

@Aspect
@Component
public class CheckPermissionsAspect {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Pointcut("@annotation(com.example.pcb4.common.CheckPermissions)")
    public void checkPermission() {
    }

    @Before("checkPermission()")
    public void beforeCheckPermission(JoinPoint joinPoint) throws Throwable {
        Long userId = null;
        Object[] args = joinPoint.getArgs();
        Object parobj = args[0];

        if (!Objects.isNull(parobj)) {
            Class<?> userClass = parobj.getClass();
            Field field = userClass.getDeclaredField("userId");
            field.setAccessible(true);
            userId = (Long) field.get(parobj);
        }

        if (!Objects.isNull(userId)) {
            Class<?> cla = joinPoint.getTarget().getClass();
            String methodName = joinPoint.getSignature().getName();
            Class<?>[] parameterTypes = ((MethodSignature)joinPoint.getSignature()).getMethod().getParameterTypes();
            Method method = cla.getMethod(methodName, parameterTypes);

            CheckPermissions annotation = method.getAnnotation(CheckPermissions.class);
            String menuCode = Arrays.toString(annotation.value());
            //通过是否有菜单查询是否有权限
            if(StringUtils.isNullOrEmpty(menuCode)){
                int count = sysMenuMapper.selectAuthByUserIdAndMenuId(userId, menuCode);
                if(count == 0){
                    throw new Exception("无权限访问接口");
                }
            }

        }

    }
}
