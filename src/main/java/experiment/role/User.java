package experiment.role;

import java.sql.SQLException;
import java.util.Enumeration;
import experiment.util.*;
 
public abstract class User {
	private String name;
	private String password;
	private String role;
	



	User(String name,String password,String role){
		this.name=name;
		this.password=password;
		this.role=role;				
	}
	
	public boolean changeSelfInfo(String password) throws SQLException{
		//写用户信息到存储
		if (DataProcessing.updateUser(name, password, role)){
			this.password=password;
			System.out.println("修改成功");
			return true;
		}else
			return false;
	}
	
	// public boolean downloadFile(String id) throws SQLException,IOException{
	// 	return DataProcessing.downloadFile(id);
	// }
	
	public  void  showFileList() throws  SQLException{
		Enumeration<Doc> e= DataProcessing.getAllDocs();
		Doc doc;
		while ( e.hasMoreElements() ){
			doc=e.nextElement();
			System.out.println("Id:"+doc.getID()+"\t Creator:" +doc.getCreator()+"\t Time:" +doc.getTimestamp()+"\t Filename:"+doc.getFilename());
			System.out.println("Description:"+doc.getDescription());
		}
	}
	

	public abstract void showMenu();
	
	public void exitSystem(){
		System.out.println("系统退出, 谢谢使用 ! ");
		System.exit(0);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

}
