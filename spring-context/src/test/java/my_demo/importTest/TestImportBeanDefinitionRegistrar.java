package my_demo.importTest;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 名称: TestImportBeanDefinitionRegistrar.java
 * 描述: TODO
 *
 * @author gaoshudian
 * @date 2019/11/28 11:49 AM
 */
public class TestImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(TestBean4.class);
        registry.registerBeanDefinition("TestBean4", rootBeanDefinition);
    }
}
