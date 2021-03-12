package iorl.rpc;

import iorl.rpc.rpc01.User;

public class UserServiceImpl implements IUserService {
    @Override
    public User findById(int id) {
        return new User(id, "am");
    }

    @Override
    public User findById2(int id) {
        return new User(id, "is");
    }

    @Override
    public int getAndAdd(int id) {
        return ++id;
    }
}
