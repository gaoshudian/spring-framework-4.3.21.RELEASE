package com.gao.config;


import com.gao.controller.JamesInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;


/**
 * SpringMVC只扫描Controller；子容器
 * useDefaultFilters=false 禁用默认的过滤规则；
 */
@ComponentScan(
        value="com.gao",
		includeFilters={@Filter(type= FilterType.ANNOTATION,classes={Controller.class})},
        useDefaultFilters=false)
@EnableWebMvc
public class MyAppConfig extends WebMvcConfigurerAdapter {
	
	//定制视图解析器
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		//比如我们想用JSP解析器,默认所有的页面都从/WEB-INF/AAA.jsp
		registry.jsp("/WEB-INF/pages/",".jsp");
	}
	
	//静态资源访问,静态资源交给tomcat来处理
	 @Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		 configurer.enable();
	}
	
	 //拦截器
	 @Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new JamesInterceptor()).addPathPatterns("/**");
	}
}
