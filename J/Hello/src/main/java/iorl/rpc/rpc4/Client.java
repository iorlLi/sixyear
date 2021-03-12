package iorl.rpc.rpc4;

import iorl.rpc.IUserService;
import iorl.rpc.rpc01.User;

public class Client {
    public static void main(String[] args) {
        Stub stub = new Stub();
       // System.out.println("stub.class --> " + stub.getClass().getName());

        IUserService iUserService = stub.getStub();
        System.out.println("iUserService.class --->" + iUserService.getClass().getName());
        int id = 111;
        System.out.println("id = " + id);
        User byId = iUserService.findById(id);
        System.out.println(byId);
    }
}
