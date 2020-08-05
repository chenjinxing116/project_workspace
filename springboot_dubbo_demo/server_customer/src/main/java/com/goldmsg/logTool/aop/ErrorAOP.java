package com.goldmsg.logTool.aop;

import com.goldmsg.logTool.entity.response.LogResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorAOP {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public LogResponse exceptionTest(){
        System.out.println("异常测试：1111111111111111111111");
        LogResponse s = new LogResponse();
        return s;
    }
}
