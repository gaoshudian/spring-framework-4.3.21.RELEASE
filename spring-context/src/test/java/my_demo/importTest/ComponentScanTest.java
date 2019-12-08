package my_demo.importTest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ComponentScanTest {
    @Value("test.name")
    private String name;

    public ComponentScanTest(){
        System.out.println("这个类的name是："+name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
