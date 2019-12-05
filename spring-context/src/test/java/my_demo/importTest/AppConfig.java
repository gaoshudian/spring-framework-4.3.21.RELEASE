package my_demo.importTest;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 名称: AppConfig.java
 * 描述: 这里可以通过@Import注解注册一系列bean
 *
 * @author gaoshudian
 * @date 2019/11/28 11:49 AM
 */
@Import({TestBean1.class,TestConfig.class,TestImportSelector.class,TestImportBeanDefinitionRegistrar.class})
@Configuration
public class AppConfig {
}
