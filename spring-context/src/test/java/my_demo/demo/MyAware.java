package my_demo.demo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyAware implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private String user;

    public MyAware() {
        System.out.println("默认构造函数...");
    }

    public MyAware(String user) {
        System.out.println("带参数的构造函数...");
        this.user = user;
    }

    public void setUser(String user) {
        System.out.println("setUser:" + user);
        this.user = user;
    }

    public void hello() {
        System.out.println("Hello: " + user);
        System.out.println(applicationContext.getBean("spel"));
    }


}
