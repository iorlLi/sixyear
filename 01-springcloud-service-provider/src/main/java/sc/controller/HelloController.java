package sc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sc.model.User;

@RestController
public class HelloController {
    @RequestMapping("/service/hello")
    public String hello() {
        System.out.println("p hello");
        int a = 10/ 0;
        return "provider1==>hello.";
    }

    @GetMapping("/service/user")
    public User getUser(@RequestParam("name") String name) {
        User user = new User();
        user.setName("p1" + name);
        return user;
    }
}
