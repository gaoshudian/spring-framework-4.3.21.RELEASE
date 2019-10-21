package my_demo.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//若注解没有指定 bean 的 id, 则类名第一个字母小写即为 bean 的 id
@Service
public class UserService{

    /**
     * 当有多个候选者时，确定出正确的候选者
     * 1.处理@Primary注解
     * 2.处理@Priority注解
     * 3.属性名等于哪个bean的id就选用哪个bean
     */
    @Autowired
    private IUserDao userDao1;

    public void addNew(User entity){
        System.out.println("addNew by " + userDao1);
        userDao1.save(entity);
    }
}
