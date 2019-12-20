package com.xyh.game.aop;


import com.xyh.game.Util.FieldUtil;
import com.xyh.game.comm.Constants;
import com.xyh.game.res.Result;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.apache.commons.lang.ArrayUtils;


import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

@Aspect
@Component
@Slf4j
public class ParamsValidAspect {
    @Pointcut("@annotation(com.xyh.game.annotation.ParamsValid)")
    private void anyMethod(){}

    @Around(value = "anyMethod()")
    public <T> T doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Result resultEntity = new Result();
        resultEntity.setCode(Constants.ResultCode.ERROR);
        Object[] args = proceedingJoinPoint.getArgs();
        BindingResult result = null;
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        String[] parameterNames = signature.getParameterNames();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();

        if (null != args && args.length != 0) {
            for (Object object : args) {
                if (object instanceof BindingResult) {
                    result = (BindingResult) object;
                    break;
                }
            }
        }

        if (result != null && result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                log.info(fieldError.getField() + "-----" + fieldError.getDefaultMessage());
                String[] codes = fieldError.getCodes();
                Object[] arguments = fieldError.getArguments();
                if("Length".equals(codes[3])){//codes[3]获取校验的注解名
                    String fieldName = fieldError.getField();
                    int maxLength = Integer.parseInt(String.valueOf(arguments[1]));
                    String objectName = fieldError.getObjectName();
                    int objectNameIndex = ArrayUtils.indexOf(parameterNames, objectName);
                    if(objectNameIndex != -1){
                        //@valid 注解的参数
                        Object paramValue = args[objectNameIndex];
                        String value = FieldUtil.getFieldValueByFieldName(fieldName,paramValue);
                        FieldUtil.setFieldValueByFieldName(fieldError.getField(),paramValue,value.substring(0,maxLength));
                        args[objectNameIndex] = paramValue;
                    }
                }else{
                    resultEntity.setMessage(fieldError.getDefaultMessage());
                    return (T) resultEntity;
                }
            }
        }
        return (T) proceedingJoinPoint.proceed(args);
    }

    @AfterReturning(value = "@within(org.springframework.web.bind.annotation.RestController)",returning = "result")
    public void doAfterReturning(Result result){
        if(result.getCode()==0) {
            log.info(result.toString());
        }else{
            log.error(result.toString());
        }
    }


}
