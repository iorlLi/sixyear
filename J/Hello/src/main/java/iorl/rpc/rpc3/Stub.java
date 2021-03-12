package iorl.rpc.rpc3;

import iorl.rpc.IUserService;
import iorl.rpc.rpc01.User;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class Stub {
    public static IUserService getStub(){
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("执行代理类的方法:" + method.getName());
                Socket socket = new Socket("127.0.0.1",8088);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                DataOutputStream dos = new DataOutputStream(baos);
                dos.writeInt(123); // 注意这里是写死的，缺少灵活性
                //发送出要查询的id
                socket.getOutputStream().write(baos.toByteArray());
                socket.getOutputStream().flush();
                //接收服务端返回的结果
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                int id = dis.readInt();
                String name = dis.readUTF();
                Object user = new User(id,name);

                return user;
            }
        };

        Object o = Proxy.newProxyInstance(IUserService.class.getClassLoader(), new Class[]{IUserService.class}, h);
       // System.out.println(o.getClass().getName());
       // System.out.println(o.getClass().getInterfaces()[0]);
        return (IUserService) o;
    }
}
