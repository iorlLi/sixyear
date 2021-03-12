package iorl.rpc.rpc01;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 1234);
        //写入字节输出流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeInt(122);

        //写入socket
        socket.getOutputStream().write(baos.toByteArray());
        socket.getOutputStream().flush();

        //接收响应
        InputStream inputStream = socket.getInputStream();
        DataInputStream dis = new DataInputStream(inputStream);
        int id = dis.readInt();
        String name = dis.readUTF();
        User u = new User(id, name);
        System.out.println(u);

        //这两个关闭其他的也。。
        dos.close();
        socket.close();

    }
}
