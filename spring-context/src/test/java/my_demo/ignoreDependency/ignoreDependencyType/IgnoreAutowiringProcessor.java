package my_demo.ignoreDependency.ignoreDependencyType;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.ArrayList;

/**
 * 名称: IgnoreAutowiringProcessor.java
 * 描述:
 * ignoreDependencyInterface:在自动装配时忽略该接口实现类中和setter方法入参相同的类型
 *
 * @author gaoshudian
 * @date 2019/9/16 4:25 PM
 */
public class IgnoreAutowiringProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanFactory.ignoreDependencyType(ArrayList.class);
    }
}
