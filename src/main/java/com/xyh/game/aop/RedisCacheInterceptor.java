package com.xyh.game.aop;

import com.xyh.game.annotation.RCache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class RedisCacheInterceptor {

    @Value("${spring.application.name}")
    private String cache_key_prefix;

    @Resource
    private RedisTemplate redisTemplate;

    @Pointcut("@annotation(com.xyh.game.annotation.RCache)")
    private void anyMethod() { // 声明一个切入点
    }

    @Around("anyMethod()")
    public <T> T doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {

        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();

        // 获取注解对像
        int time = -1;
        String defaultKey = "";
        try {
            RCache rCache = targetMethod.getAnnotation(RCache.class);
            time = rCache.time();
            defaultKey = rCache.key();
        } catch (Exception e) {
        }

        StringBuilder sb = new StringBuilder();
        if ("".equals(defaultKey)) {
            // 类名、方法名与参数
            String className = pjp.getTarget().getClass().getName();
            Object[] params = pjp.getArgs();
            String signatureStr = signature.toString();// 获取目标方法签名
            String methodName = signatureStr.substring(signatureStr.lastIndexOf(".") + 1, signatureStr.indexOf("("));


            sb.append(cache_key_prefix + "::" + className + "_" + methodName);
            for (Object param : params) {
                sb.append("_" + param.toString());
            }
        } else {
            sb.append(cache_key_prefix + "::" + defaultKey);
        }

        String key = sb.toString();

        Object value = null;
        try {
            value = redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            //System.out.println("redis没连接");
            //e.printStackTrace();
        }

        if (value == null) {
            //处理
            value = pjp.proceed();
            try {
                if (time > 0) {
                    redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
                } else {
                    redisTemplate.opsForValue().set(key, value);
                }
            } catch (Exception e) {
                //System.out.println("redis没连接");
                //e.printStackTrace();
            }
        }

        return (T) value;
    }
}
