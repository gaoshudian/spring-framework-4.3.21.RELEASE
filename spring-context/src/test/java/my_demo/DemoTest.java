package my_demo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoTest {

    @Test
    public void helloWorld(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:my-demo/demo.xml");
        System.out.println(ac.getBean("helloWorld"));
    }
}
