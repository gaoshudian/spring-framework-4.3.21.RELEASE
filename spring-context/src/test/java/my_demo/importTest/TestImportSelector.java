package my_demo.importTest;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 名称: TestImportSelector.java
 * 描述: TODO
 *
 * @author gaoshudian
 * @date 2019/11/28 11:48 AM
 */
public class TestImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"my_demo.importTest.TestBean3"};
    }
}
