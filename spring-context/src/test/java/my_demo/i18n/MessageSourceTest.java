package my_demo.i18n;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 名称: MessageSourceTest.java
 * 描述: 国际化测试
 *
 * @author gaoshudian
 * @date 2019/8/15 11:29 AM
 */
public class MessageSourceTest {


    /**
     * java提供的格式化工具类MessageFormat
     */
    @Test
    public void javaFormat(){
        String value = MessageFormat.format("oh, {0} is 'a' pig", "ZhangSan");
        System.out.println(value);
    }
    /**
     * JAVA方式国际化
     */
    @Test
    public void javaI18n(){
//        Locale locale = new Locale("en","CN");
        Locale locale = new Locale("zh","CN");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message",locale);
        System.out.println(resourceBundle.getString("test"));
    }

    /**
     * spring方式国际化(直接new对应的工具类)
     */
    @Test
    public void springI18n(){

        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:message");
        messageSource.setCacheSeconds(5);

        System.out.println(messageSource.getMessage("test",null,new Locale("zh","CN")));

    }

    /**
     * spring方式国际化(实际项目应该讲ReloadableResourceBundleMessageSource配置为bean)
     */
    @Test
    public void springI18n2(){

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-message.xml");
        MessageService messageService = (MessageService)ctx.getBean("messageService");
        System.out.println(messageService.getMessage("test"));

    }
}
