package my_demo.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    @Conditional(MyCondition.class)
    public MacService mac() {
        return new MacService();
    }

}
