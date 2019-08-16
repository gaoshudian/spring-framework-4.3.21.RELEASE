package my_demo.i18n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * 名称: MessageService.java
 * 描述: 获取资源处理
 *
 * @author gaoshudian
 * @date 2019/8/15 11:49 AM
 */

@Component
public class MessageService {

    @Autowired
    private MessageSource messageSource;

    private Locale currentLocale = new Locale("zh","CN");

    public String getMessage(String key) {
        return messageSource.getMessage(key, null, "默认值", currentLocale);
    }
}
