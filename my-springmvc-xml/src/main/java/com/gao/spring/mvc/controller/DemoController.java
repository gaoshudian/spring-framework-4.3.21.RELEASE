package com.gao.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@Controller
public class DemoController {

	@RequestMapping("/helloworld")
	public String hello(){
		System.out.println("hello world");
		return "success";
	}

    @RequestMapping("/redirect")
    public String redirect(){
        System.out.println("重定向测试");
        return "redirect:/helloworld";
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

	/**
	 * 目标方法可以添加 ModelMap 类型,这里的modelMap里保存值后其它地方可以在request作用域拿到，原理如下:
     *
     * 当目标方法参数类型是Map时，传到目标方法里的参数是ModelAndViewContainer的defaultModel属性，类型为BindingAwareModelMap
     * InvocableHandlerMethod#invokeForRequest方法里有这两行代码:
     * Object[] args = getMethodArgumentValues(request, mavContainer, providedArgs);
     * Object returnValue = doInvoke(args);
     *
     * 由于args是ModelAndViewContainer的defaultModel属性，所以args作为参数传到目标方法后，实际上目标参数里现在拿到的参数modelMap是
     * ModelAndViewContainer的defaultModel属性的引用，所以在目标方法里向modelMap里set数据后,defaultModel属性自然就有数据了。
     * 而ModelAndViewContainer就是承担着整个请求过程中数据的传递工作
	 */
	@RequestMapping("/testMap")
	public String testMap(ModelMap modelMap){
		System.out.println(modelMap.getClass().getName());
        modelMap.put("names", Arrays.asList("Tom", "Jerry", "Mike"));
		return "success";
	}



}
