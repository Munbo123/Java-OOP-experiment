package experiment.role;

import java.util.Scanner;
import java.util.Vector;

import experiment.Server.DataProcessing;
import experiment.util.scannerutil;

// Administrator类
public class Administrator extends Operator{
    
    // Administrator类的构造方法
    public Administrator(String name,String password,String role){
        super(name, password, role);
    }


    //Administrator的Menu
    public void showMenu(){
        Scanner scanner = scannerutil.getScanner();
        boolean flag = true;
        while (flag) {
            // 获取指令
            System.out.println("\n");
            System.out.println("******欢迎进入管理员菜单******");
            System.out.println("1.修改用户");
            System.out.println("2.删除用户");
            System.out.println("3.新增用户");
            System.out.println("4.列出用户");
            System.out.println("5.下载文件");
            System.out.println("6.文件列表");
            System.out.println("7.修改（本人）密码");
            System.out.println("8.退出");
            System.out.println("*******************************");
            System.out.println("请输入一个整数：");
            int instructor = scanner.nextInt();
            scanner.nextLine();

            // 执行指令
            switch (instructor) {
                case 1:{
                    // 修改用户
                    System.out.println("请输入用户名：");
                    String username = scanner.nextLine();
                    System.out.println("请输入密码：");
                    String password = scanner.nextLine();
                    System.out.println("请输入角色：");
                    String role = scanner.nextLine();
                    try {
                        if(DataProcessing.updateUser(username, password, role)){
                            System.out.println("修改成功");
                        }else{
                            System.out.println("修改失败");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }
                case 2:{
                    // 删除用户
                    System.out.println("请输入用户名：");
                    String username = scanner.nextLine();
                    try {
                        if(DataProcessing.deleteUser(username)){
                            System.out.println("删除成功");
                        }else{
                            System.out.println("删除失败");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }
                case 3:{
                    // 新增用户
                    System.out.println("请输入用户名：");
                    String username = scanner.nextLine();
                    System.out.println("请输入密码：");
                    String password = scanner.nextLine();
                    System.out.println("请输入角色：");
                    String role = scanner.nextLine();
                    try {
                        if(DataProcessing.insertUser(username, password, role)){
                            System.out.println("增加成功");
                        }else{
                            System.out.println("增加失败");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }
                case 4:{
                    // 列出用户
                    try {
                        Vector<User> e1 = DataProcessing.getAllUser();
                        for (User user : e1) {
                            System.out.println(user);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }
                case 5:{
                    // 下载文件
                    // System.out.println("请输入档案号：");
                    // String ID = scanner.nextLine();
                    // try {
                    //     downloadFile(ID);
                    // } catch (Exception e) {
                    //     System.out.println(e.getMessage());
                    // }
                    
                    break;
                }
                case 6:{
                    // 列出文件
                    try {
                        showFileList();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    
                    break;
                }
                case 7:{
                    // 修改（本人）密码
                    System.out.println("请输入新的密码：");
                    String password = scanner.nextLine();
                    try {
                        changeSelfInfo(password);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    
                    break;
                }
                case 8:{
                    // 退出系统
                    System.out.println("感谢使用！"); 
                    flag = false;               
                    break;
                }
                default:
                    break;
            }
        }
    }

}
