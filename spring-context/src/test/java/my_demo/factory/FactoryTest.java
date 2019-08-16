package my_demo.factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryTest {

    ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:my-demo/factory.xml");

    //静态工厂方法配置bean
    @Test
    public void test1(){
        Car car = (Car)ac.getBean("car");
        System.out.println(car);
    }

    //实例工厂方法配置bean
    @Test
    public void test2(){
        Car car = (Car)ac.getBean("car2");
        System.out.println(car);
    }

    //factoryBean方式配置bean
    @Test
    public void test3(){
        User user = (User)ac.getBean("user");
        System.out.println(user);
//        UserBean userBean = (UserBean) ac.getBean("&user");
//        System.out.println(userBean.getObject());
    }
}
