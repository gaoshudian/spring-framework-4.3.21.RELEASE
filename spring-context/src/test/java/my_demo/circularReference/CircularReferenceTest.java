package my_demo.circularReference;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: 循环依赖测试
 * @Auther: gaoshudian
 * @Date: 2019/9/11 22:17
 */
public class CircularReferenceTest {

    @Test
    public void test1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:my-demo/spring-circularReference.xml");
        A a = (A) ctx.getBean("a");
        System.out.println(a.getUsername());

    }
}
