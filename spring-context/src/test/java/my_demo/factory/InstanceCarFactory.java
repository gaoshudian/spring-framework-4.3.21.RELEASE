package my_demo.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 实例工厂方法:实例工厂的方法,即需要先创建工厂本身，再调用工厂的实例方法来返回bean的实例
 */
public class InstanceCarFactory {

    private static Map<String,Car> cars = new HashMap<>();

    public InstanceCarFactory(){
        cars.put("audi",new Car("audi","BuiKe",30000));
        cars.put("baoma",new Car("ford","BuiKe",40000));
    }

    public Car getCar(String brand){
        return cars.get(brand);
    }
}
