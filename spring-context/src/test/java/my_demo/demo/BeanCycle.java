package my_demo.demo;

import org.springframework.beans.factory.InitializingBean;

/**
 * Created by gao on 2018/6/11.
 */
public class BeanCycle implements InitializingBean {

    public BeanCycle() {
        System.out.println("构造方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setter...");
        this.name = name;
    }

    private String name;


    public void init(){
        System.out.println("BeanCycle ...init method...");
    }

    public void destroy(){
        System.out.println("BeanCycle ...destroy method...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("走了afterPropertiesSet方法");
    }
}
