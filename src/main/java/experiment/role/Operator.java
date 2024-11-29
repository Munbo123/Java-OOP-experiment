package experiment.role;

import java.util.Scanner;


import experiment.util.scannerutil;

// Operator类
public class Operator extends Browser{

    // 构造方法
    public Operator(String name,String password,String role){
        super(name, password, role);
    }


    //Operator的Menu
    public void showMenu(){
        Scanner scanner = scannerutil.getScanner();
        boolean flag = true;
        while (flag) {
            // 获取指令
            System.out.println("\n");
            System.out.println("******欢迎进入档案录入员菜单******");
            System.out.println("1.上传文件");
            System.out.println("2.下载文件");
            System.out.println("3.文件列表");
            System.out.println("4.修改密码");
            System.out.println("5.退出");
            System.out.println("*******************************");
            System.out.println("请输入一个整数：");
            int instructor = scanner.nextInt();
            scanner.nextLine();

            // 执行指令
            switch (instructor) {
                case 1:{
                    // uploadFile();
                    break;
                }
                case 2:{
                    // System.out.println("请输入档案号：");
                    // String ID = scanner.nextLine();
                    // try {
                    //     downloadFile(ID);
                    // } catch (Exception e) {
                    //     System.out.println(e.getMessage());
                    // }
                    
                    break;
                }
                case 3:{
                    try {
                        showFileList();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    
                    break;
                }
                case 4:{
                    System.out.println("请输入新的密码：");
                    String password = scanner.nextLine();
                    try {
                        changeSelfInfo(password);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    
                    break;
                }
                case 5:{
                    System.out.println("感谢使用！");                
                    break;
                }
                default:
                    break;
            }
        }
    }

    
    //Operator的uploadFile
    // public boolean uploadFile(){
    //     try {
    //         DataProcessing.uploadFile(getName());
    //     } catch (Exception e) {
    //         System.out.println("上传文件出错");
    //     }
        

    //     return true;
    // }
};
