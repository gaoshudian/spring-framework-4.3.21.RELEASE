package com.gao.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DemoController {

	@RequestMapping("/helloworld")
	@ResponseBody
	public String hello(){
		System.out.println("hello world");
		return "success";
	}

	/**
	 * @RequestParam 来映射请求参数. value 值即请求参数的参数名 required 该参数是否必须. 默认为 true
	 *               defaultValue 请求参数的默认值
	 */
	@RequestMapping(value = "/testRequestParam",method = RequestMethod.POST)
    @ResponseBody
	public String testRequestParam(
			@RequestParam(value = "username") String un,
			@RequestParam(value = "age", required = false, defaultValue = "0") int age) {
		System.out.println("testRequestParam, username: " + un + ", age: " + age);
		return "success";
	}

    /**
     * 测试@RequestBody注解和@ResponseBody注解
     */
    @RequestMapping(value = "/testRequestResonseBody",method = RequestMethod.POST)
    @ResponseBody
    public User testRequestResonseBody(@RequestBody User user) {
        System.out.println(user);
        user.setName("高2");
        return user;
    }

}
