package com.example.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.HandlerMethod;

public class GlobalExceptionHandler {
    //注解：出现异常会来到这个方法处理
    //ExceptionHandler的value参数：捕获控制器出现的异常类型，可传入集合捕获多种类型的异常
    @ExceptionHandler(RuntimeException.class)
    public void handlerError(RuntimeException ex, HandlerMethod hm) {
        System.out.println("统一异常处理 ");
        System.out.println(ex.getMessage());//异常信息
        System.out.println(hm.getBean().getClass());//哪个类下
        System.out.println(hm.getMethod().getName());//在哪个方法的
    }
}
