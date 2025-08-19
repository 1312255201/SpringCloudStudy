package cn.gugufish.service.client;

import cn.gugufish.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserFallbackClient implements UserClient{
    @Override
    public User getUserById(int uid) {   //这里我们自行对其进行实现，并返回我们的替代方案
        User user = new User();
        user.setName("我是替代方案");
        return user;
    }
}