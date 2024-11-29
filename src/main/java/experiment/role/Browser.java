package experiment.role;


import java.util.Scanner;
import experiment.util.scannerutil;


// 定义Browser类，继承User类
public class Browser extends User{
    // 构造方法
    public Browser(String name,String password,String role){
        super(name, password, role);
    }


    //Browser的Menu
    public void showMenu(){
        Scanner scanner = scannerutil.getScanner();
        boolean flag = true;
        while (flag) {
            // 获取指令
            System.out.println("\n");
            System.out.println("******欢迎进入档案浏览员菜单******");
            System.out.println("1.下载文件");
            System.out.println("2.文件列表");
            System.out.println("3.修改密码");
            System.out.println("4.退出");
            System.out.println("*******************************");
            System.out.println("请输入一个整数：");
            int instructor = scanner.nextInt();
            scanner.nextLine();

            // 执行指令
            if(instructor==1){
                // System.out.println("请输入档案号：");
                // String ID = scanner.nextLine();
                // try {
                //     downloadFile(ID);
                // } catch (Exception e) {
                //     System.out.println(e.getMessage());
                // }
                
            }
            else if(instructor==2){
                try {
                    showFileList();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                
            }
            else if(instructor==3){
                System.out.println("请输入新的密码：");
                String password = scanner.nextLine();
                try {
                    changeSelfInfo(password);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                
            }else if(instructor==4){
                System.out.println("感谢使用！");
                flag = false;
            }else{
                System.out.println("错误的指令！");
            }
        }
    
         
    }


}
