package my_demo.importTest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 名称: DemoApplicationTests.java
 * 描述: 测试@Import注解的用法
 *
 * @author gaoshudian
 * @date 2019/11/28 11:50 AM
 */
public class DemoApplicationTests {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        System.out.println("--------------------------------------------------------");
        for (String beanDefinitionName: beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("--------------------------------------------------------");
    }
}
