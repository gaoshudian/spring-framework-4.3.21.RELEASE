package my_demo.property;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *   名称: DatePropertyEditor.java
 *   描述: 自定义Date类型的属性解析
 *   类型: JAVA
 *   最近修改时间:2018/6/28 11:07
 *   @version [版本号, V1.0]
 *   @since 2018/6/28 11:07
 *   @author gaoshudian
 */
public class DatePropertyEditor implements PropertyEditorRegistrar {

    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
    }
}