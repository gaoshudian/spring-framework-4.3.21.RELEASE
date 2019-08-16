package my_demo.factory;

import org.springframework.beans.factory.FactoryBean;

import java.util.ArrayList;
import java.util.List;


public class UserBean implements FactoryBean<User> {

	@Override
	public User getObject(){
		User user = new User();
		user.setUserName("abc");

		List<Car> cars = new ArrayList<>();
		cars.add(new Car("ShangHai", "BuiKe", 180, 300000));
		cars.add(new Car("ShangHai", "CRUZE", 130, 150000));
		
		user.setCars(cars);
		return user;
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
