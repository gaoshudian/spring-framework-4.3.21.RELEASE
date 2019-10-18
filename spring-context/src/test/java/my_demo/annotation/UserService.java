package my_demo.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//若注解没有指定 bean 的 id, 则类名第一个字母小写即为 bean 的 id
@Service
public class UserService{

    @Autowired
    private IUserDao userDao1;

    public void addNew(User entity){
        System.out.println("addNew by " + userDao1);
        userDao1.save(entity);
    }
}
