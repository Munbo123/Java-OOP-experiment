package experiment.util;

import java.util.*;
import java.io.*;
import java.sql.*;
import experiment.role.*;

public class DataProcessing {

    private static String uploadpath = "C:\\Users\\19722\\Desktop\\Coding\\GithubProjects\\MyProjects\\JavaExperiment\\untitled\\src\\main\\java\\experiment\\files\\uploadfiles";
    private static String driverName = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/mydatabase?useUnicode=true&characterEncoding=UTF-8";
    private static String user = "root";
    private static String password = "nf3039755985";

    // 创建数据库连接函数
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(driverName);
        return DriverManager.getConnection(url, user, password);
    }

// 创建一个函数，用来显示目前数据库中所有的表和表里的数据
	public static void showAll() {
		try (Connection connection = getConnection()) {
			// 显示 user_info 表的数据
			System.out.println("Table: user_info");
			ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM user_info");
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int columnCount = resultSetMetaData.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				System.out.print(resultSetMetaData.getColumnName(i) + "\t");
			}
			System.out.println();
			while (resultSet.next()) {
				for (int i = 1; i <= columnCount; i++) {
					System.out.print(resultSet.getString(i) + "\t");
				}
				System.out.println();
			}
			resultSet.close();

			// 显示 docs_info 表的数据
			System.out.println("Table: docs_info");
			resultSet = connection.createStatement().executeQuery("SELECT * FROM docs_info");
			resultSetMetaData = resultSet.getMetaData();
			columnCount = resultSetMetaData.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				System.out.print(resultSetMetaData.getColumnName(i) + "\t");
			}
			System.out.println();
			while (resultSet.next()) {
				for (int i = 1; i <= columnCount; i++) {
					System.out.print(resultSet.getString(i) + "\t");
				}
				System.out.println();
			}
			resultSet.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

    // 其他函数
    public static boolean downloadFile(String id, String downloadpath, String filename) throws SQLException, IOException {
        byte[] buffer = new byte[1024];
        Doc doc = searchDoc(id);

        if (doc == null) {
            return false;
        }

        File tempFile = new File(uploadpath + "\\" + doc.getFilename());

        BufferedInputStream infile = new BufferedInputStream(new FileInputStream(tempFile));
        BufferedOutputStream targetfile = new BufferedOutputStream(new FileOutputStream(downloadpath + "\\" + filename));

        while (true) {
            int byteRead = infile.read(buffer);
            if (byteRead == -1) {
                break;
            }
            targetfile.write(buffer, 0, byteRead);
        }
        infile.close();
        targetfile.close();

        return true;
    }

    public static boolean uploadFile(String path, String ID, String description, String creator) throws SQLException, IOException {
        File file = new File(path);
        String fileName = file.getName();
        String directory = file.getParent();

        if (searchDoc(ID) != null) {
            return false;
        }

        File UploadDirectory = new File(uploadpath);
        File[] tempList = UploadDirectory.listFiles();
        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                if (tempList[i].getName().equals(file.getName())) {
                    return false;
                }
            }
        }

        byte[] buffer = new byte[1024];
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Doc doc = new Doc(ID, creator, timestamp, description, fileName);
        insertDoc(ID, creator, timestamp, description, fileName);

        File tempFile = new File(directory + "\\" + doc.getFilename());
        BufferedInputStream infile = new BufferedInputStream(new FileInputStream(tempFile));
        BufferedOutputStream targetfile = new BufferedOutputStream(new FileOutputStream(uploadpath + "\\" + fileName));

        while (true) {
            int byteRead = infile.read(buffer);
            if (byteRead == -1) {
                break;
            }
            targetfile.write(buffer, 0, byteRead);
        }
        infile.close();
        targetfile.close();

        return true;
    }

    public static Doc searchDoc(String ID) throws SQLException {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM docs_info WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, ID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String creator = resultSet.getString("uploader");
                Timestamp timestamp = resultSet.getTimestamp("upload_time");
                String description = resultSet.getString("description");
                String filename = resultSet.getString("filename");
                return new Doc(ID, creator, timestamp, description, filename);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Enumeration<Doc> getAllDocs() throws SQLException {
        Vector<Doc> docs = new Vector<>();
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM docs_info";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String id = resultSet.getString("ID");
                String creator = resultSet.getString("uploader");
                Timestamp timestamp = resultSet.getTimestamp("upload_time");
                String description = resultSet.getString("description");
                String filename = resultSet.getString("filename");
                docs.add(new Doc(id, creator, timestamp, description, filename));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return docs.elements();
    }

    public static boolean insertDoc(String ID, String creator, Timestamp timestamp, String description, String filename) throws SQLException {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO docs_info (ID, uploader, upload_time, description, filename) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, ID);
            preparedStatement.setString(2, creator);
            preparedStatement.setTimestamp(3, timestamp);
            preparedStatement.setString(4, description);
            preparedStatement.setString(5, filename);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static User searchUser(String name) throws SQLException {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM user_info WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                if (role.equalsIgnoreCase("administrator"))
                    return new Administrator(name, password, role);
                else if (role.equalsIgnoreCase("operator"))
                    return new Operator(name, password, role);
                else
                    return new Browser(name, password, role);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static User search(String name, String password) throws SQLException {
        User user = searchUser(name);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public static Enumeration<User> getAllUser() throws SQLException {
        Vector<User> users = new Vector<>();
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM user_info";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String name = resultSet.getString("username");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                if (role.equalsIgnoreCase("administrator"))
                    users.add(new Administrator(name, password, role));
                else if (role.equalsIgnoreCase("operator"))
                    users.add(new Operator(name, password, role));
                else
                    users.add(new Browser(name, password, role));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users.elements();
    }

    public static boolean updateUser(String name, String password, String role) throws SQLException {
        try (Connection connection = getConnection()) {
            String query = "UPDATE user_info SET password = ?, role = ? WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, role);
            preparedStatement.setString(3, name);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean insertUser(String name, String password, String role) throws SQLException {
        if (searchUser(name) != null) {
            return false;
        }
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO user_info (username, password, role) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, role);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteUser(String name) throws SQLException {
        try (Connection connection = getConnection()) {
            String query = "DELETE FROM user_info WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        // 链接数据库，并显示所有表和表中的数据
		showAll();
    }
}