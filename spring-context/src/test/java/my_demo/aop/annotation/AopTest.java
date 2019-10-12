package my_demo.aop.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

    /**
     * 真正的AOP示例（注解方式）
     */
    @Test
    public void testAop(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:my-demo/aop/aop-annotation.xml");
        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
        System.out.println("获取的bean是代理类..."+arithmeticCalculator.getClass().getName());
        arithmeticCalculator.add(11, 12);
//        arithmeticCalculator.div(21, 0);
    }

}
