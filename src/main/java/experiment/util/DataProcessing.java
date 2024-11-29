package experiment.util;

import java.util.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import experiment.role.*;



public  class DataProcessing {

	private static String uploadpath="C:\\Users\\19722\\Desktop\\Coding\\GithubProjects\\MyProjects\\JavaExperiment\\untitled\\src\\main\\java\\experiment\\files\\uploadfiles";


	static Hashtable<String, User> users;
	static Hashtable<String, Doc> docs;


	static {
		// 初始化用户和文件，目前暂时用哈希表储存
		users = new Hashtable<String, User>();
		users.put("jack", new Operator("jack","123","operator"));
		users.put("rose", new Browser("rose","123","browser"));
		users.put("kate", new Administrator("kate","123","administrator"));
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis()); 
		docs = new Hashtable<String,Doc>();
		// 读取uploadpath中所有的文件，默认创建者为jack，id从0001开始递增
		File directory = new File(uploadpath);
		File[] tempList = directory.listFiles();
		int id = 1;
		for (int i = 0; i < tempList.length; i++) {
			if (tempList[i].isFile()) {
				Doc doc = new Doc(String.format("%04d", id), "jack", timestamp, tempList[i].getName(), tempList[i].getName());
				docs.put(String.format("%04d", id), doc);
				id++;
			}
		}

	}
	

	public static boolean downloadFile(String id,String downloadpath,String filename) throws SQLException,IOException{
		//boolean result=false;
		byte [] buffer = new  byte [1024];
		Doc doc=DataProcessing.searchDoc(id);

		if (doc==null) {
			return false ;
		}

		File tempFile = new File(uploadpath+"\\"+doc.getFilename());


		BufferedInputStream infile = new BufferedInputStream(new FileInputStream(tempFile));
		BufferedOutputStream targetfile = new  BufferedOutputStream(new  FileOutputStream(downloadpath+"\\"+filename));

		while (true){
			int  byteRead=infile.read(buffer);
			if  (byteRead==-1) {
			break ;
			}
			targetfile.write(buffer,0,byteRead);
		}
		infile.close();
		targetfile.close();

		return  true ;
	}


	public static boolean uploadFile(String path,String ID,String description,String creator) throws SQLException,IOException{
		// 实例化文件对象
		File file = new File(path);		
		// 获取文件名部分
		String fileName = file.getName();
		// 获取文件路径部分
		String directory = file.getParent();

		// 检查docs中是否已经存在该文件的id
		if (docs.containsKey(ID)) {
			return false;
		}
		// 检查uploadpath中是否存在同名文件
		File UploadDirectory = new File(uploadpath);
		File[] tempList = UploadDirectory.listFiles();
		for (int i = 0; i < tempList.length; i++) {
			if (tempList[i].isFile()) {
				System.out.println(tempList[i].getName());
				if (tempList[i].getName().equals(file.getName())) {
					return false;
				}
			}
		}

		//boolean result=false;
		byte [] buffer = new  byte [1024];

		// 获取文件创建时间
		Timestamp timestamp = new Timestamp(System.currentTimeMillis()); 

		// 创建doc对象
		Doc doc= new Doc(ID, creator,timestamp,description,fileName);
		docs.put(ID,doc);	

		File tempFile = new File(directory+"\\"+doc.getFilename());
		String filename = tempFile.getName();

		BufferedInputStream infile = new BufferedInputStream(new FileInputStream(tempFile));
		BufferedOutputStream targetfile = new  BufferedOutputStream(new  FileOutputStream(uploadpath+"\\"+filename));

		while (true){
			int  byteRead=infile.read(buffer);
			if  (byteRead==-1) {
			break ;
			}
			targetfile.write(buffer,0,byteRead);
		}
		infile.close();
		targetfile.close();
		// 更新docs中的数据
		docs.put(ID,doc);
		return  true ;
	}



	public static Doc searchDoc(String ID) throws SQLException {
		if (docs.containsKey(ID)) {
			Doc temp =docs.get(ID);
			return temp;
		}
		return null;
	}
	

	public static Enumeration<Doc> getAllDocs() throws SQLException{		
		Enumeration<Doc> e  = docs.elements();
		return e;
	} 
	

	public static boolean insertDoc(String ID, String creator, Timestamp timestamp, String description, String filename) throws SQLException{
		Doc doc;		
		if (docs.containsKey(ID))
			return false;
		else{
			doc = new Doc(ID,creator,timestamp,description,filename);
			docs.put(ID, doc);
			return true;
		}
	} 
	

	public static User searchUser(String name) throws SQLException{
		// if ( !connectToDB ) 
		// 	throw new SQLException( "Not Connected to Database" );
		// double ranValue=Math.random();
		// if (ranValue>0.5)
		// 	throw new SQLException( "Error in excecuting Query" );
		
		if (users.containsKey(name)) {
			return users.get(name);			
		}
		return null;
	}
	

	public static User search(String name, String password) throws SQLException {
		// if ( !connectToDB ) 
	    //     throw new SQLException( "Not Connected to Database" );
		// double ranValue=Math.random();
		// if (ranValue>0.5)
		// 	throw new SQLException( "Error in excecuting Query" );
		
		if (users.containsKey(name)) {
			User temp =users.get(name);
			if ((temp.getPassword()).equals(password))
				return temp;
		}
		return null;
	}
	

	public static Enumeration<User> getAllUser() throws SQLException{
		// if ( !connectToDB ) 
	    //     throw new SQLException( "Not Connected to Database" );
		
		// double ranValue=Math.random();
		// if (ranValue>0.5)
		// 	throw new SQLException( "Error in excecuting Query" );
		
		Enumeration<User> e  = users.elements();
		return e;
	}
	
	
	public static boolean updateUser(String name, String password, String role) throws SQLException{
		User user;
		if (users.containsKey(name)) {
			if (role.equalsIgnoreCase("administrator"))
				user = new Administrator(name,password, role);
			else if (role.equalsIgnoreCase("operator"))
				user = new Operator(name,password, role);
			else
				user = new Browser(name,password, role);
			users.put(name, user);
			return true;
		}else
			return false;
	}
	

	public static boolean insertUser(String name, String password, String role) throws SQLException{
		// if ( !connectToDB ) 
	    //     throw new SQLException( "Not Connected to Database" );
		
		// double ranValue=Math.random();
		// if (ranValue>0.5)
		// 	throw new SQLException( "Error in excecuting Insert" );

		User user;

		if (users.containsKey(name))
			return false;
		else{
			if (role.equalsIgnoreCase("administrator"))
				user = new Administrator(name,password, role);
			else if (role.equalsIgnoreCase("operator"))
				user = new Operator(name,password, role);
			else
				user = new Browser(name,password, role);
			users.put(name, user);
			return true;
		}
	}
	

	public static boolean deleteUser(String name) throws SQLException{
		// if ( !connectToDB ) 
	    //     throw new SQLException( "Not Connected to Database" );
		
		// double ranValue=Math.random();
		// if (ranValue>0.5)
		// 	throw new SQLException( "Error in excecuting Delete" );
		
		if (users.containsKey(name)){
			users.remove(name);
			return true;
		}else
			return false;
		
	}	
         
	


	
	public static void main(String[] args) {		

	}
	
}
