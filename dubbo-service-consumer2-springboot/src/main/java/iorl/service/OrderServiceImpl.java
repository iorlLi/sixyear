package iorl.service;

import iorl.beans.UserAddress;
import iorl.interfaces.OrderService;
import iorl.interfaces.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Reference(version = "1.0.0")
    UserService userService;

    @Override
    public List<UserAddress> initOrder(String userID) {
        List<UserAddress> userAddressList = userService.getUserAddressList("1");

        return userAddressList;
    }
}
