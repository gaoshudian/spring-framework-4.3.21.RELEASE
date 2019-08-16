package my_demo.demo;

import my_demo.helloworld.ref.Action;
import my_demo.helloworld.ref.Dao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;


public class DemoTest {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-demo.xml");

    //测试自动装配:autowire
    @Test
	public void test1(){
        Action action = ctx.getBean(Action.class);
        action.execute();
    }

    //测试bean的作用域
    @Test
    public void test2(){
        Dao dao1 = (Dao)ctx.getBean("dao");
        Dao dao2 = (Dao)ctx.getBean("dao");
        Dao dao3 = (Dao)ctx.getBean("dao2");
        Dao dao4 = (Dao)ctx.getBean("dao2");
        System.out.println(dao1+"--"+dao1.hashCode());
        System.out.println(dao2+"--"+dao2.hashCode());
        System.out.println(dao1 == dao2);
        System.out.println(dao3+"--"+dao3.hashCode());
        System.out.println(dao4+"--"+dao4.hashCode());
        System.out.println(dao3 == dao4);
    }

    //测试引用外部属性文件
    @Test
    public void test3(){
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        System.out.println(dataSource);
    }

    //测试SPEL
    @Test
    public void test4(){
        //字面量的表示
        SPELCar spel = (SPELCar) ctx.getBean("spel");
        System.out.println(spel);
        //引用bean的属性和方法
        SPELCar spel2 = (SPELCar) ctx.getBean("spel2");
        System.out.println(spel2);

    }

    //测试bean的生命周期
    @Test
    public void test5(){
        BeanCycle cycle = (BeanCycle)ctx.getBean("beanCycle");
        System.out.println(cycle);
    }

}
