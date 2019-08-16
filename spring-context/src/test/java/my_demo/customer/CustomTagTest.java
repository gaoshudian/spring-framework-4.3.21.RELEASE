package my_demo.customer;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomTagTest {

	@Test
	public void helloworld(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-customer.xml");
        SimpleDateFormat info = (SimpleDateFormat) ctx.getBean("dateFormat");
        System.out.println(info.format(new Date()));
    }

}
