package iorl.rpc.rpc4;

import iorl.rpc.IUserService;
import iorl.rpc.UserServiceImpl;
import iorl.rpc.rpc01.User;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static boolean running = true;

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8088);
        System.out.println("服务开始===>>>");
        while (running) {
            Socket client = server.accept();
            System.out.println("接收链接===>>>" + client.getLocalAddress().getHostAddress());
            process(client);
            client.close();
            System.out.println("完成===>>>" );
        }
        server.close();
    }

    public static void process(Socket socket) throws Exception {
        InputStream inputStream = socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(inputStream);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        //读取数据
        String methodName = ois.readUTF();
        Class[] parameters = (Class[]) ois.readObject();
        Object[] args = (Object[]) ois.readObject();
        System.out.println("执行方法 " + methodName);

        IUserService iUserService = new UserServiceImpl();
        //获取重写方法
        Method method = iUserService.getClass().getMethod(methodName, parameters);
        User user = (User) method.invoke(iUserService, args);
        dos.writeInt(user.getId());
        dos.writeUTF(user.getName());
        dos.flush();
    }
}
