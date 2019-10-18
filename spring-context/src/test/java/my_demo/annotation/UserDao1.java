package my_demo.annotation;

import org.springframework.stereotype.Repository;

@Repository("userDao1")
public class UserDao1 implements IUserDao{

    public void save(User entity){
        System.out.println("Save:" + entity);
    }
}
