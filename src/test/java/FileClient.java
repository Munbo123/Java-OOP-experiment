import java.io.PrintWriter;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.IOException;

import java.net.Socket;
import java.util.Scanner;

public class FileClient {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
             InputStream in = socket.getInputStream();
             OutputStream out = socket.getOutputStream();
             Scanner scanner = new Scanner(System.in);
             Scanner serverScanner = new Scanner(in);
             PrintWriter writer = new PrintWriter(out, true)) {

            System.out.println("Connected to File Server");
            new Thread(() -> {
                while (serverScanner.hasNextLine()) {
                    System.out.println("Server: " + serverScanner.nextLine());
                }
            }).start();

            while (true) {
                System.out.print("Enter command: ");
                String command = scanner.nextLine();
                writer.println(command);
                if (command.equalsIgnoreCase("exit")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
