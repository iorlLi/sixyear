package iorl.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import iorl.beans.UserAddress;
import iorl.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    OrderServiceImpl orderService;
    private List<UserAddress> userAddresses;

    @RequestMapping("/initOrder")
    @ResponseBody
    public List<UserAddress> initOrder(@RequestParam("uid") String userId) {
        userAddresses = orderService.initOrder(userId);
        return userAddresses;
    }
}
