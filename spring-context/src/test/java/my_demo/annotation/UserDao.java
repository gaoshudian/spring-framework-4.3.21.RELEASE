package my_demo.annotation;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao{

    public void save(User entity){
        System.out.println("Save:" + entity);
    }
}
