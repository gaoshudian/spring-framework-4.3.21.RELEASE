package my_demo.circularReference;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: 循环依赖测试
 * @Auther: gaoshudian
 * @Date: 2019/9/11 22:17
 */
public class CircularReferenceTest {

    ApplicationContext ac = null;
    @Before
    public void before(){
        ac = new ClassPathXmlApplicationContext("classpath:my-demo/spring-circularReference.xml");
    }

    @Test
    public void test1() {
        A a = (A) ac.getBean("a");
        System.out.println(a.getUsername());

    }

    //测试bean的作用域为"prototype"的情况,每次获取的bean不是同一对象，hashCode不一样
    @Test
    public void prototypeTest() {
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> System.err.println(ac.getBean("prototypeTest"))).start();
//        }
        ac.getBean("prototypeTest");

    }

    //测试bean的作用域为"prototype"时循环依赖的情况，这时会报错
    @Test
    public void prototypecircularreference() {
        ac.getBean("prototypeTestA");
        ac.getBean("prototypeTestB");
    }
}
