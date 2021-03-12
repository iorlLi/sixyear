package iorl.rpc.rpc3;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        Stub stub = new Stub();
        System.out.println(stub.getStub().findById(123));
    }
}
