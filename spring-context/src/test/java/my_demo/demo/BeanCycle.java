package my_demo.demo;

/**
 * Created by gao on 2018/6/11.
 */
public class BeanCycle {

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
}
