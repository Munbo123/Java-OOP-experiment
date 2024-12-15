import java.io.*;
import java.net.*;
import java.net.Socket;
import java.util.Scanner;

public class FileServer {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("File Server is running on port " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (InputStream in = clientSocket.getInputStream();
             OutputStream out = clientSocket.getOutputStream();
             Scanner scanner = new Scanner(in);
             PrintWriter writer = new PrintWriter(out, true)) {

            writer.println("Welcome to File Server");
            String command;
            while (scanner.hasNextLine()) {
                command = scanner.nextLine();
                if (command.equalsIgnoreCase("exit")) {
                    writer.println("Goodbye!");
                    break;
                }
                handleCommand(command, writer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleCommand(String command, PrintWriter writer) {
        String[] parts = command.split(" ");
        String action = parts[0];

        switch (action.toLowerCase()) {
            case "list":
                File dir = new File(".");
                File[] files = dir.listFiles();
                if (files != null) {
                    for (File file : files) {
                        writer.println(file.getName());
                    }
                }
                break;

            case "download":
                if (parts.length < 2) {
                    writer.println("Usage: download <filename>");
                    return;
                }
                File fileToDownload = new File(parts[1]);
                if (fileToDownload.exists()) {
                    try (BufferedInputStream fileIn = new BufferedInputStream(new FileInputStream(fileToDownload));
                         OutputStream socketOut = clientSocket.getOutputStream()) {
                        byte[] buffer = new byte[4096];
                        int bytesRead;
                        while ((bytesRead = fileIn.read(buffer)) != -1) {
                            socketOut.write(buffer, 0, bytesRead);
                        }
                    } catch (IOException e) {
                        writer.println("Error sending file: " + e.getMessage());
                    }
                } else {
                    writer.println("File not found: " + parts[1]);
                }
                break;

            default:
                writer.println("Unknown command: " + command);
        }
    }
}
