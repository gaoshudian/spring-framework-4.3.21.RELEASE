package my_demo.importTest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

/**
 * 名称: AppConfig.java
 * 描述: 这里可以通过@Import注解注册一系列bean
 *
 * @author gaoshudian
 * @date 2019/11/28 11:49 AM
 */
@Import({TestBean1.class,TestConfig.class,TestImportSelector.class,TestImportBeanDefinitionRegistrar.class})
//这里是测试ConfigurationClassParser怎么解析@PropertySource注解的
@PropertySource(value = "my-demo/ConfigurationTest/test.properties")
//测试@ImportResource的用法
@ImportResource(value = "my-demo/ConfigurationTest/testImportResource.xml")
@ComponentScan
@Configuration
public class AppConfig {

    @Value("${test.name}")
    private String name;
}
