package my_demo.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;


public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
			System.out.println("postProcessBeforeInitialization..." + bean + "," + beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization..." + bean + "," + beanName);
		if(bean instanceof BeanCycle){
			BeanCycle cycle = (BeanCycle) bean;
			cycle.setName("更改名字");
		}
		return bean;
	}

}
