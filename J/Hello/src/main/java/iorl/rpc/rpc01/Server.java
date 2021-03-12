package iorl.rpc.rpc01;

import iorl.rpc.IUserService;
import iorl.rpc.UserServiceImpl;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234);
        while (true){
            System.out.println("server 接收请求===>>>>>>>>>>>>>>>>>");
            Socket accept = serverSocket.accept();
            System.out.println("选手" + accept.getInetAddress().getHostAddress());
            System.out.println("选手" + accept.getInetAddress().getHostName());
            process(accept);
            accept.close();
            System.out.println("server 响应完成<<<<<<<<<<<<<======");
        }
    }

    private static void process(Socket accept) throws Exception{
        InputStream in = accept.getInputStream();
        OutputStream out = accept.getOutputStream();
        DataInputStream dis = new DataInputStream(in);
        DataOutputStream dos = new DataOutputStream(out);

        int id = dis.readInt();
        IUserService iUserService = new UserServiceImpl();
        User user = iUserService.findById(id);
        dos.writeInt(id);
        dos.writeUTF(user.getName());
        dos.flush();

    }

}
