package com.gao.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
public class ModelAttributeController {

    private static final String SUCCESS = "success";

    /*
      1. 有 @ModelAttribute 标记的方法, 会在每个目标方法执行之前被 SpringMVC 调用!
      2. @ModelAttribute 注解也可以来修饰目标方法 POJO 类型的入参, 其 value 属性值有如下的作用:
         1). SpringMVC 会使用 value 属性值在 ModelAndViewContainer的model 中查找对应的对象, 若存在则会直接传入到目标方法的入参中.
         2). SpringMVC 会以 value 为 key, POJO 类型的对象为 value, 存入到 request 中.
     */
    @ModelAttribute
    public void getUser( Map<String, Object> map){
        System.out.println("modelAttribute method");
        User user = new User("tom","35");
        map.put("user2", user);
    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("user2") User user){
        user.setAge("40");
        return SUCCESS;
    }
}
