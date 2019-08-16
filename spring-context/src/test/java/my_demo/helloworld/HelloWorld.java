package my_demo.helloworld;

public class HelloWorld {

	private String user;

	public HelloWorld() {
		System.out.println("默认构造函数...");
	}

	public HelloWorld(String user) {
		System.out.println("带参数的构造函数...");
		this.user = user;
	}

	public void setUser(String user) {
		System.out.println("setUser:" + user);
		this.user = user;
	}

	public void hello(){
		System.out.println("Hello: " + user);
	}
	
}
