package my_demo.ignoreDependency.ignoreDependencyType;

import java.util.ArrayList;

/**
 * 名称: ListHolder.java
 * 描述:
 *
 * @author gaoshudian
 * @date 2019/9/16 4:22 PM
 */
public class ListHolder {

    private ArrayList<String> list;

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ListHolder{" +
                "list=" + list +
                '}';
    }
}
