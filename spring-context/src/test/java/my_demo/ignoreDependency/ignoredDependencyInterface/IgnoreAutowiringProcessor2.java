package my_demo.ignoreDependency.ignoredDependencyInterface;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * 名称: IgnoreAutowiringProcessor.java
 * 描述:
 *
 * @author gaoshudian
 * @date 2019/9/16 4:25 PM
 */
public class IgnoreAutowiringProcessor2 implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanFactory.ignoreDependencyInterface(IgnoreInterface.class);
    }
}
