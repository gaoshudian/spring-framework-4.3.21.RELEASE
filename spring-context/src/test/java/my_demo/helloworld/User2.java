package my_demo.helloworld;

import java.util.Map;

public class User2 {

	private String userName;
	private Map<String,Car> cars;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Map<String, Car> getCars() {
		return cars;
	}

	public void setCars(Map<String, Car> cars) {
		this.cars = cars;
	}

	public User2() {
		System.out.println("User's Construtor...");
	}


    @Override
    public String toString() {
        return "User2{" +
                "userName='" + userName + '\'' +
                ", cars=" + cars +
                '}';
    }

    public void init(){
		System.out.println("init method...");
	}
	
	public void destroy(){
		System.out.println("destroy method...");
	}

}
