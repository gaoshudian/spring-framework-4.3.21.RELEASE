package my_demo.helloworld.ref;


public class Service {

	private Dao dao;
	
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	public Dao getDao() {
		return dao;
	}
	
	public void save(){
		System.out.println("Service's save");
		dao.save();
	}

    @Override
    public String toString() {
        return "Service{" +
                "dao=" + dao +
                '}';
    }
}
