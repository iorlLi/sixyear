package iorl.rpc.rpc6;

import iorl.rpc.IUserService;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.net.Socket;
import java.time.LocalDateTime;

public class Stub {
    public IUserService getStub(Class clazz) {
        InvocationHandler invocationHandler = (proxy, method, args) -> {
            System.out.println(LocalDateTime.now() + "2 执行代理类的方法:" + method.getName());
            Socket socket = new Socket("127.0.0.1", 8088);

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            String className = clazz.getSimpleName();
            String methodName = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            oos.writeUTF(className);
            oos.writeUTF(methodName);
            oos.writeObject(parameterTypes);
            oos.writeObject(args);
            System.out.println("代理方法里的形参" + args);
            oos.flush();


            //接收服务端返回的结果
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Object o = ois.readObject();

            oos.close();
            socket.close();

            return o;
        };

        Object proxyInstance = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, invocationHandler);
        System.out.println(LocalDateTime.now() + "1 产生代理对象");
        return (IUserService) proxyInstance;
    }

}