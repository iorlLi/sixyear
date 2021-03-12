package iorl.rpc.rpc4;

import iorl.rpc.IUserService;
import iorl.rpc.rpc01.User;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class Stub {
    public IUserService getStub() {
        InvocationHandler invocationHandler = (proxy, method, args) -> {
            System.out.println("执行代理类的方法:" + method.getName());
            Socket socket = new Socket("127.0.0.1", 8088);

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            String methodName = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            oos.writeUTF(methodName);
            oos.writeObject(parameterTypes);
            oos.writeObject(args);
            System.out.println("代理方法里的形参" + args);
            oos.flush();
            //接收服务端返回的结果
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            int id = dis.readInt();
            String name = dis.readUTF();
            Object user = new User(id, name);
            oos.close();
            socket.close();

            return user;
        };

        Object proxyInstance = Proxy.newProxyInstance(IUserService.class.getClassLoader(), new Class[]{IUserService.class}, invocationHandler);
        return (IUserService) proxyInstance;
    }

}