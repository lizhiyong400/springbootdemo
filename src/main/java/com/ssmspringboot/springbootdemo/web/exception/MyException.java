package com.ssmspringboot.springbootdemo.web.exception;

/**
 * 自定义异常类
 */
public class MyException extends  Exception {
    public  MyException(String message){
        super(message);
    }
}
