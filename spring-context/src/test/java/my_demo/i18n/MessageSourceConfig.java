package my_demo.i18n;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * 名称: MessageSourceConfig.java
 * 描述: 资源包配置
 * ReloadableResourceBundleMessageSource：直接使用读取文件的方式实现国际化，规则跟java的相同，支持动态修改后刷新配置
 *
 * @author gaoshudian
 * @date 2019/8/15 2:16 PM
 */
@Configuration
public class MessageSourceConfig {

    @Bean
    public static MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:message");
        messageSource.setCacheSeconds(5);
        return messageSource;
    }

}
