package com.xyh.game.controller;

import com.xyh.game.comm.Constants;
import com.xyh.game.res.Result;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.PrintWriter;
import java.io.StringWriter;

@RestControllerAdvice
//@Slf4j
public class ControllerAdvice {
    private Logger log = LoggerFactory.getLogger(ControllerAdvice.class);
    @ExceptionHandler(Exception.class)
    public Result exceptionHandle(Exception ex){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String msg=sw.toString();
        Result resultEntity = new Result();
        resultEntity.setCode(Constants.ResultCode.ERROR);
        resultEntity.setMessage(msg);
        log.error(resultEntity.toString());
        return resultEntity;
    }
}
