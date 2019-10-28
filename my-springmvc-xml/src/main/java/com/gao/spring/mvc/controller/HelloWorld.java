package com.gao.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorld {

	@RequestMapping("/helloworld")
	@ResponseBody
	public String hello(){
		System.out.println("hello world");
		return "success";
	}

}
