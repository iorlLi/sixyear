package iorl.rpc;

import iorl.rpc.rpc01.User;

public interface IUserService {

    public User findById(int id);

    public User findById2(int id);

    public int getAndAdd(int id);

}
