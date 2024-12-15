package experiment.Client;

import java.io.*;
import java.net.Socket;

public class Client {
    private Socket socket;
    private ObjectOutputStream oout;
    private ObjectInputStream oin;
    private static Client instance = null;

    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 12345;

    private Client() {
        try {
            socket = new Socket(SERVER_IP,SERVER_PORT); // 连接到服务端
            oout = new ObjectOutputStream(socket.getOutputStream());
            oin = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object writeAndReadMessage(String message) throws IOException, ClassNotFoundException {
        oout.writeObject(message);
        oout.flush();
        return (Object) oin.readObject();
    }

    public void sendExit() throws IOException {
        oout.writeObject("exit");
        oout.flush();

        oout.close();
        oin.close();
        socket.close();
    }

    public static synchronized Client getInstance() {
        if(instance == null) {
            instance = new Client();
        }
        return instance;
    }

    public void close() {
        try {
            if (socket != null) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
