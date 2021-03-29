package iorl.rpc.rpc6;

import iorl.rpc.IUserService;
import iorl.rpc.rpc01.User;
import iorl.rpc.rpc6.Stub;

public class Client {
    public static void main(String[] args) {
        Stub stub = new Stub();
        IUserService stub1 = stub.getStub(IUserService.class);
        User byId = stub1.findById(1);
        System.out.println(byId);
    }
}
