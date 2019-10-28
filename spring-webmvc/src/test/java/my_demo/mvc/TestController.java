package my_demo.mvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 名称: TestController.java
 * 描述: 测试controller
 *
 * @author gaoshudian
 * @date 2019/10/26 1:23 PM
 */

@RequestMapping("/testController")
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public String test(HttpServletRequest request, HttpServletResponse response){
        System.out.println("test.....");
        return "ok";
    }

    /**
     * 下面两个方法测试路径通配符，主要测试spring当多个handler方法都可以处理请求时，怎么选择出最优的处理器
     */
    @RequestMapping("/test/ab*")
    public String test1(HttpServletRequest request, HttpServletResponse response){
        System.out.println("test1...../test/ab*)");
        return "ok";
    }

    @RequestMapping("/test/a*")
    public String test2(HttpServletRequest request, HttpServletResponse response){
        System.out.println("test2...../test/a*)");
        return "ok";
    }
}
