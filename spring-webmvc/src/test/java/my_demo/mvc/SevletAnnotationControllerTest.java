package my_demo.mvc;

import org.junit.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.expression.spel.SpelCompilationCoverageTests;
import org.springframework.mock.web.test.MockHttpServletRequest;
import org.springframework.mock.web.test.MockHttpServletResponse;
import org.springframework.mock.web.test.MockServletConfig;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.handler.MappedInterceptor;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.HashMap;

/**
 * 名称: SevletAnnotationControllerTest.java
 * 描述: 测试spring mvc项目
 *
 * @author gaoshudian
 * @date 2019/10/26 1:22 PM
 */
public class SevletAnnotationControllerTest {

    private DispatcherServlet servlet;

    /**
     * 从spring 3.1 开始我们应该用RequestMappingHandlerMapping 来替换 DefaultAnnotationHandlerMapping,
     * RequestMappingHandlerAdapter 来替换 AnnotationMethodHandlerAdapter
     */
    @Test
    public void standardHandleMethod() throws Exception {
        servlet = new DispatcherServlet() {
            @Override
            protected WebApplicationContext createWebApplicationContext(WebApplicationContext parent) {
                GenericWebApplicationContext wac = new GenericWebApplicationContext();
                wac.registerBeanDefinition("testController", new RootBeanDefinition(TestController.class));
                wac.registerBeanDefinition("myInterceptor", new RootBeanDefinition(MyInterceptor.class));

//                wac.registerBeanDefinition("handlerMapping",new RootBeanDefinition(RequestMappingHandlerMapping.class));
                /**
                 * 可以向RequestMappingHandlerMapping中添加拦截器，spring mvc中的拦截器其实就是添加在RequestMappingHandlerMapping的父类
                 * AbstractHandlerMapping中的interceptors属性中，所以这里可以手动将自定义的拦截器添加到RequestMappingHandlerMapping类的
                 * interceptors属性中，注意拦截器要用MappedInterceptor包装一下
                 */
                MutablePropertyValues propertyValues = new MutablePropertyValues(
                        new HashMap<String, Object>(){{ put("interceptors", new MappedInterceptor(null,new MyInterceptor())); }}
                );
                GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
                beanDefinition.setBeanClass(RequestMappingHandlerMapping.class);
                beanDefinition.setPropertyValues(propertyValues);
                wac.registerBeanDefinition("handlerMapping",beanDefinition);

                wac.registerBeanDefinition("handlerAdapter",new RootBeanDefinition(RequestMappingHandlerAdapter.class));
                wac.refresh();
                return wac;
            }
        };
        servlet.init(new MockServletConfig());

        MockHttpServletRequest request = new MockHttpServletRequest("GET", "/testController/test");
        MockHttpServletResponse response = new MockHttpServletResponse();
        servlet.service(request, response);
        System.out.println("返回值========"+response.getContentAsString());
    }
}
