package my_demo.importTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 名称: TestConfig.java
 * 描述: TODO
 *
 * @author gaoshudian
 * @date 2019/11/28 11:47 AM
 */
@Configuration
public class TestConfig {

    @Bean
    public TestBean2 getTestBean2(){
        return new TestBean2();
    }
}
