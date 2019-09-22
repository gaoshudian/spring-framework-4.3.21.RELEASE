package my_demo.ignoreDependency.ignoredDependencyInterface;

import java.util.List;

/**
 * 名称: IgnoreInterfaceImpl.java
 * 描述:
 *
 * @author gaoshudian
 * @date 2019/9/16 5:09 PM
 */
public class IgnoreInterfaceImpl implements IgnoreInterface {

    private List<String> list;

    @Override
    public void setList(List<String> list) {
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "IgnoreInterfaceImpl{" +
                "list=" + list +
                '}';
    }
}
