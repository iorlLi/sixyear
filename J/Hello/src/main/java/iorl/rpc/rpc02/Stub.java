package iorl.rpc.rpc02;

import iorl.rpc.rpc01.User;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Stub {

    public User findUserById(int id) throws IOException {
        Socket socket = new Socket("127.0.0.1", 1234);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeInt(123);
        //发送出要查询的id
        socket.getOutputStream().write(baos.toByteArray());
        socket.getOutputStream().flush();
        //接收服务端返回的结果
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        int idtmp = dis.readInt();
        if (idtmp != id) System.out.println("error");
        String name = dis.readUTF();
        User user = new User(id, name);
        return user;
    }
}
