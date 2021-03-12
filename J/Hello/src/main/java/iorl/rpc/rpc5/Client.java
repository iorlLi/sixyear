package iorl.rpc.rpc5;

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
        User byId = (User) iUserService.findById(id);
        System.out.println("byId" + byId);

        User byId2 = (User) iUserService.findById2(333);
        System.out.println("byId2" + byId2);

        int andAdd = (int)iUserService.getAndAdd(99);
        System.out.println(andAdd);
    }
}
