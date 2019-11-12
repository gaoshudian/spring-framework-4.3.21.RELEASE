package com.gao.spring.mvc.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


/**
 * 统一异常处理
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public Map<String, Object> error(Throwable error, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("error", error.getMessage());
        map.put("result", "error");
        return map;
    }
}
