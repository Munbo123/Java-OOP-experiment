package experiment.Server;

import java.io.*;
import java.net.*;
import java.sql.Timestamp;
import java.util.Vector;


import experiment.util.Doc;
import experiment.role.*;;

public class Server {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("File Server is running on port " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (Exception e) {
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
        try {
            // 获取输入和输出流
            InputStream in = clientSocket.getInputStream();
            OutputStream out = clientSocket.getOutputStream();

            // 使用对象流来读取指令和发送响应
            ObjectInputStream oin = new ObjectInputStream(in);
            ObjectOutputStream oout = new ObjectOutputStream(out);

            String command;
            while (true) {
                // 从客户端接收 String 指令

            command = (String) oin.readObject();
            if (command.equalsIgnoreCase("exit")) {
                // 客户端发送 "exit" 时退出循环
                System.out.println("Client requested to exit");
                oout.close(); // 关闭输出流
                oin.close();  // 关闭输入流
                clientSocket.close();  // 关闭客户端连接
                break;
            }

            // 打印接收到的指令
            System.out.println("Received command: " + command);

            // 处理命令并发送响应
            handleCommand(command, oout);
        
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }

    
    private void handleCommand(String command, ObjectOutputStream oout) {
        String[] parts = command.split(" ");
        String action = parts[0];

        try{
            switch (action) {
                // public static boolean downloadFile(String id, String downloadpath, String filename)
                case "downloadFile":
                    if (parts.length < 4) {
                        oout.writeObject("false 参数错误，Usage: downloadFile <id> <downloadpath> <filename>");
                        return;
                    }
                    String id = parts[1];
                    String downloadpath = parts[2];
                    String filename = parts[3];
                    try {
                        DataProcessing.downloadFile(id, downloadpath, filename);
                        oout.writeObject("true");
                    } catch (Exception e) {
                        oout.writeObject("false error:" + e.getMessage());
                    }
                    break;
                    
                // public static boolean uploadFile(String path, String ID, String description, String creator) throws SQLException, IOException
                case "uploadFile":
                    if (parts.length < 5) {
                        oout.writeObject("false 参数错误，Usage: uploadFile <path> <ID> <description> <creator>");
                        return;
                    }
                    String path = parts[1];
                    String ID = parts[2];
                    String description = parts[3];
                    String creator = parts[4];
                    try {
                        DataProcessing.uploadFile(path, ID, description, creator);
                        oout.writeObject("true");
                    } catch (Exception e) {
                        oout.writeObject("false Error: " + e.getMessage());
                    }
                    break;
                
                // public static Doc searchDoc(String ID) throws SQLException 
                case "searchDoc":
                    if (parts.length < 2) {
                        oout.writeObject("false 参数错误，Usage: searchDoc <ID>");
                        return;
                    }
                    String searchID = parts[1];
                    try {
                        Doc doc = DataProcessing.searchDoc(searchID);
                        oout.writeObject(doc);
                    } catch (Exception e) {
                        oout.writeObject("false Error: " + e.getMessage());
                    }
                    break;
                
                // public static Enumeration<Doc> getAllDocs() throws SQLException 
                case "getAllDocs":
                    try {
                        Vector<Doc> v1 = DataProcessing.getAllDocs();
                        oout.writeObject(v1);
                    } catch (Exception e) {
                        oout.writeObject("false Error: " + e.getMessage());
                    }
                    break;
                
                // public static boolean insertDoc(String ID, String creator, Timestamp timestamp, String description, String filename) throws SQLException
                case "insertDoc":
                    if (parts.length < 6) {
                        oout.writeObject("false 参数错误，Usage: insertDoc <ID> <creator> <timestamp> <description> <filename>");
                        return;
                    }
                    String insertID = parts[1];
                    String creatorID = parts[2];
                    Timestamp timestamp = Timestamp.valueOf(parts[3]);
                    String insertDescription = parts[4];
                    String insertFilename = parts[5];
                    try {
                        DataProcessing.insertDoc(insertID, creatorID, timestamp, insertDescription, insertFilename);
                        oout.writeObject("true");
                    } catch (Exception e) {
                        oout.writeObject("false Error:" + e.getMessage());
                    }
                    break;
                
                // public static User searchUser(String name) throws SQLException
                case "searchUser":
                    if (parts.length < 2) {
                        oout.writeObject("false 参数错误，Usage: searchUser <name>");
                        return;
                    }
                    String searchName = parts[1];
                    try {
                        User user = DataProcessing.searchUser(searchName);
                        oout.writeObject(user);
                    } catch (Exception e) {
                        oout.writeObject("false Error: " + e.getMessage());
                    }
                    break;

                // public static User search(String name, String password) throws SQLException 
                case "search":
                    if (parts.length < 3) {
                        oout.writeObject("false 参数错误，Usage: search <name> <password>");
                        return;
                    }
                    String searchName2 = parts[1];
                    String searchPassword = parts[2];
                    try {
                        User user = DataProcessing.search(searchName2, searchPassword);
                        oout.writeObject(user);
                    } catch (Exception e) {
                        oout.writeObject("false Error: " + e.getMessage());
                    }
                    break;


                // public static Enumeration<User> getAllUser() throws SQLException 
                case "getAllUser":
                    try {
                        Vector<User> v1 = DataProcessing.getAllUser();
                        oout.writeObject(v1);
                    } catch (Exception e) {
                        oout.writeObject("false Error: " + e.getMessage());
                    }
                    break;
                
                // public static boolean updateUser(String name, String password, String role) throws SQLException
                case "updateUser":
                    if (parts.length < 4) {
                        oout.writeObject("false参数错误，Usage: updateUser <name> <password> <role>");
                        return;
                    }
                    String updateName = parts[1];
                    String updatePassword = parts[2];
                    String updateRole = parts[3];
                    try {
                        DataProcessing.updateUser(updateName, updatePassword, updateRole);
                        oout.writeObject("true");
                    } catch (Exception e) {
                        oout.writeObject("false Error: " + e.getMessage());
                    }
                    break;
                
                // public static boolean insertUser(String name, String password, String role) throws SQLException
                case "insertUser":
                    if (parts.length < 4) {
                        oout.writeObject("false 参数错误，Usage: insertUser <name> <password> <role>");
                        return;
                    }
                    String insertName = parts[1];
                    String insertPassword = parts[2];
                    String insertRole = parts[3];
                    try {
                        DataProcessing.insertUser(insertName, insertPassword, insertRole);
                        oout.writeObject("true");
                    } catch (Exception e) {
                        oout.writeObject("false Error: " + e.getMessage());
                    }
                    break;
                

                // public static boolean deleteUser(String name) throws SQLException
                case "deleteUser":
                    if (parts.length < 2) {
                        oout.writeObject("false 参数错误，Usage: deleteUser <name>");
                        return;
                    }
                    String deleteName = parts[1];
                    try {
                        DataProcessing.deleteUser(deleteName);
                        oout.writeObject("true");
                    } catch (Exception e) {
                        oout.writeObject("false Error: " + e.getMessage());
                    }
                    break;
                
                default:
                    oout.writeObject("false Unknown command: " + command);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
