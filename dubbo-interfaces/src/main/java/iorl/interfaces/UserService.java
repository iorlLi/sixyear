package iorl.interfaces;

import iorl.beans.UserAddress;

import java.util.List;

public interface UserService {
    /**
     * 按照用户id返回所有的收货地址
     *
     * @param userId
     * @return
     */
    public List<UserAddress> getUserAddressList(String userId);
}
