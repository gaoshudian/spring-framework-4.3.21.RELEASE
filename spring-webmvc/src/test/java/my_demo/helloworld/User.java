package my_demo.helloworld;

import java.util.List;

public class User {

	private String userName;
	private List<Car> cars;

    private String wifeName;

    public String getWifeName() {
        return wifeName;
    }

    public void setWifeName(String wifeName) {
        this.wifeName = wifeName;
    }

    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	public User() {
//		System.out.println("User's Construtor...");
	}

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", cars=" + cars +
                ", wifeName='" + wifeName + '\'' +
                '}';
    }


}
