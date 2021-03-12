package sc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sc.mapper.UserMapper;
import sc.model.User;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user")
    public User get() {

        User user = userMapper.selectById(1);
        return  user;
    }

    @GetMapping("/list")
    public List<User> getList(){
        return userMapper.selectList(null);
    }
}
