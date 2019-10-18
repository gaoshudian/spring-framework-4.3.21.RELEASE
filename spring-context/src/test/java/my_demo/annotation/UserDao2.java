package my_demo.annotation;

import org.springframework.stereotype.Repository;

@Repository("userDao2")
public class UserDao2 implements IUserDao{

    public void save(User entity){
        System.out.println("Save:" + entity);
    }
}
