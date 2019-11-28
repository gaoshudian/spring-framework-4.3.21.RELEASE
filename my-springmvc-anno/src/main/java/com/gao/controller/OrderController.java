package com.gao.controller;

import com.gao.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController   {
	@Autowired
	OrderService orderService;
	
	@ResponseBody
	@RequestMapping("/buy")
	public String buy(){
		return orderService.goBuy("12345678");
	}
	
	//相当于会找 /WEB-INF/pages/ok.jsp
	@RequestMapping("/ok")
	public String ok(){
		return "ok";
	}
}
