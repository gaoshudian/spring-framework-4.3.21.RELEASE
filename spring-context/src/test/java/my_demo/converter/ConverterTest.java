package my_demo.converter;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 名称: ConverterTest.java
 * 描述: TODO
 *
 * @author gaoshudian
 * @date 2019/9/14 9:07 PM
 */
public class ConverterTest {

    @Test
    public void helloworld(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("my-demo/beans-converter.xml");
        ConvertClass convertClass = (ConvertClass) ctx.getBean("convertClass");
        System.out.println(convertClass);
    }
}
