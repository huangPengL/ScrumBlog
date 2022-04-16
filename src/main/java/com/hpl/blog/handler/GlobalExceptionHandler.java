package com.hpl.blog.handler;

import com.hpl.blog.Exceptions.MyTestException;
import com.hpl.blog.utils.ReturnResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/3/1 17:12
 */

@Slf4j      // logback记录日志
@ControllerAdvice // 可对controller中被 @RequestMapping注解的方法加一些逻辑处理。最常用的就是异常处理
public class GlobalExceptionHandler {

    //指定出现什么异常会执行这个方法
    @ExceptionHandler(Exception.class)
    //因为他不在Controller中。没有@RestController，所以数据不会返回，需要加@ResponeseBody返回数据
    @ResponseBody
    public ReturnResult exception(Exception e){
        e.printStackTrace();
        return ReturnResult.error().message("执行了全局异常处理。。。");
    }

    //指定出现ArithmeticException异常会执行这个方法
    @ExceptionHandler(ArithmeticException.class)
    //因为他不在Controller中。没有@RestController，所以数据不会返回，需要加@ResponeseBody返回数据
    @ResponseBody
    public ReturnResult arithmeticException(ArithmeticException e){
        e.printStackTrace();
        return ReturnResult.error().message("执行了ArithmeticException处理。。。");
    }

    //指定出现myTestException异常会执行这个方法
    @ExceptionHandler(MyTestException.class)
    @ResponseBody
    public ReturnResult myTestException(MyTestException e){
        e.printStackTrace();
        log.error(e.getMessage());
        return ReturnResult.error().code(e.getCode()).message(e.getMsg());
    }
}

