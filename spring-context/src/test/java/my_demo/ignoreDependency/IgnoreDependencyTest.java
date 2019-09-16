package my_demo.ignoreDependency;

import my_demo.ignoreDependency.ignoreDependencyType.ListHolder;
import my_demo.ignoreDependency.ignoredDependencyInterface.IgnoreInterface;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 ignoreDependencyType:
 执行beanFactory.ignoreDependencyType(ArrayList.class)方法后，spring的bean中属性只要是ArrayList类型，
 那么在自动装配时就会忽略这些属性的依赖注入

 ignoreDependencyInterface:
 执行beanFactory.ignoreDependencyInterface(IgnoreInterface.class)后，spring的bean中的属性对应的setter方法如果
 在IgnoreInterface接口中存在（setter方法的参数类型要一样，参数类型就是IgnoreInterface类型），那么在自动装配时就会忽略
 这些属性的依赖注入
 */
public class IgnoreDependencyTest {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:my-demo/beans-ignoreDependency.xml");

    //测试ignoreDependencyType方法
    @Test
    public void test1() {
        ListHolder listHolder = (ListHolder) ctx.getBean("listHolder");
        System.out.println(listHolder);
    }


    //测试ignoreDependencyInterface方法
    @Test
    public void test2() {
        IgnoreInterface ignoreInterface = (IgnoreInterface) ctx.getBean("ii");
        System.out.println(ignoreInterface);
    }



}
