package my_demo.converter;

/**
 * 名称: StringObject.java
 * 描述: 测试
 *
 * @author gaoshudian
 * @date 2019/9/14 9:03 PM
 */
public class StringObject {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StringObject{" +
                "name='" + name + '\'' +
                '}';
    }
}
