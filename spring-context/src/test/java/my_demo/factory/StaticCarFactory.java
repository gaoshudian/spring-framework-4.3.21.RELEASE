package my_demo.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 静态工厂方法,直接调用某一个类的静态方法就可以返回Bean的实例
 */
public class StaticCarFactory {

    private static Map<String,Car>  cars = new HashMap<>();

    public static Car getCar(String name){
        return cars.get(name);
    }

    static {
        cars.put("audi",new Car("audi","BuiKe",30000));
        cars.put("baoma",new Car("ford","BuiKe",40000));
    }

}
