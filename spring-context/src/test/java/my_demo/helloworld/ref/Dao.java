package my_demo.helloworld.ref;

public class Dao {

	private String dataSource = "dbcp";
	
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	
	public void save(){
		System.out.println("save by " + dataSource);
	}
	
	public Dao() {
//		System.out.println("Dao's Constructor...");
	}

    @Override
    public String toString() {
        return "Dao{" +
                "dataSource='" + dataSource + '\'' +
                '}';
    }
}
