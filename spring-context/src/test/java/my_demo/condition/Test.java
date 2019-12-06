package my_demo.condition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 名称: Test.java
 * 描述: 测试@Conditional注解
 *
 * @author gaoshudian
 * @date 2019/12/6 10:49 AM
 */
public class Test {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        System.out.println(ac.getBean("mac"));
    }
}
