package my_demo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 名称: DemoTest.java
 * 描述: TODO
 *
 * @author gaoshudian
 * @date 2019/8/15 4:03 PM
 */
public class DemoTest {

    @Test
    public void helloWorld(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:my-demo/demo.xml");
        System.out.println(ac.getBean("helloWorld"));
    }
}
