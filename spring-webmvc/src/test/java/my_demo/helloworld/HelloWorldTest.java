package my_demo.helloworld;


import my_demo.helloworld.ref.Action;
import my_demo.helloworld.ref.Dao;
import my_demo.helloworld.ref.Service;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {

    ApplicationContext ctx = null;

    @Before
    public void before(){
        ctx = new ClassPathXmlApplicationContext("classpath:my-demo/beans-helloworld.xml");
    }
	@Test
	public void helloworld(){
        HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld");
        helloWorld.hello();
    }

    @Test
    public void demo(){
        HelloWorld helloWorld2 = (HelloWorld) ctx.getBean("helloWorld2");
        helloWorld2.hello();
    }

    @Test
    public void test(){
        Car car = (Car) ctx.getBean("car");
        System.out.println(car);

        Car car2 = (Car) ctx.getBean("car2");
        System.out.println(car2);
    }

    @Test
    public void test1(){
        Service service = (Service) ctx.getBean("service");
        System.out.println(service);

        Action action = (Action) ctx.getBean("action");
        System.out.println(action);

        Dao dao2 = (Dao) ctx.getBean("dao2");
        System.out.println(dao2);
    }

    @Test
    public void test2(){
        //测试使用list属性
        User user = (User) ctx.getBean("user");
        System.out.println(user);

        //测试使用map属性
        User2 userMap = (User2) ctx.getBean("userMap");
        System.out.println(userMap);

        //测试装配Properties属性
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        System.out.println(dataSource);

        //测试引用外部声明的list
        User user2 = (User) ctx.getBean("user2");
        System.out.println(user2);
    }

    @Test
    public void test4(){
        //测试特殊方式装配list和map属性
        ListInjectTest listInjectTest = (ListInjectTest) ctx.getBean("injectTest");
        System.out.println(listInjectTest);

    }

    @Test
    public void test3(){
        //测试p命名空间
        User user3 = (User) ctx.getBean("user3");
        System.out.println(user3);

        //测试bean的继承
        User user4 = (User) ctx.getBean("user4");
        System.out.println(user4);

        User user5 = (User) ctx.getBean("user5");
        System.out.println(user5);

        //测试bean的依赖
        User user6 = (User) ctx.getBean("user6");
        System.out.println(user6);
    }

}
