package iorl.rpc.rpc3;

import iorl.rpc.IUserService;
import iorl.rpc.UserServiceImpl;
import iorl.rpc.rpc01.User;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static boolean running = true;

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8088);
        while (running) {
            Socket client = server.accept();
            process(client);
            client.close();
        }
        server.close();
    }

    public static void process(Socket socket) throws Exception {
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        int id = dis.readInt();
        IUserService service = new UserServiceImpl();
        User user = service.findById(id);
        dos.writeInt(user.getId());
        dos.writeUTF(user.getName());
        dos.flush();
    }
}
