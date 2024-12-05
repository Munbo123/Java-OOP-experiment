package experiment.GUI;

import experiment.role.*;


public class MainPage extends javax.swing.JFrame {

    public MainPage(User user) {
        // 设置界面居中
        setLocationRelativeTo(null);
        // 初始化界面
        this.user = user;
        initComponents();
        setMenuItemsEnabled(user.getRole());
    }

                      
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        Menu1 = new javax.swing.JMenu();
        MenuItem1_1 = new javax.swing.JMenuItem();
        MenuItem1_2 = new javax.swing.JMenuItem();
        MenuItem1_3 = new javax.swing.JMenuItem();
        Menu2 = new javax.swing.JMenu();
        MenuItem2_1 = new javax.swing.JMenuItem();
        MenuItem2_2 = new javax.swing.JMenuItem();
        Menu3 = new javax.swing.JMenu();
        MenuItem3_1 = new javax.swing.JMenuItem();
        Menu4 = new javax.swing.JMenu();
        MenuItem4_1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenuBar1.setName("menu"); // NOI18N

        Menu1.setText("用户管理");

        MenuItem1_1.setText("修改用户");
        MenuItem1_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem1_1ActionPerformed(evt);
            }
        });
        Menu1.add(MenuItem1_1);


        MenuItem1_2.setText("删除用户");
        MenuItem1_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem1_2ActionPerformed(evt);
            }
        });
        Menu1.add(MenuItem1_2);

        MenuItem1_3.setText("新增用户");
        MenuItem1_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem1_3ActionPerformed(evt);
            }
        });
        Menu1.add(MenuItem1_3);

        jMenuBar1.add(Menu1);

        Menu2.setText("档案管理");
        Menu2.setName("menu2"); // NOI18N

        MenuItem2_1.setText("档案上传");
        MenuItem2_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem2_1ActionPerformed(evt);
            }
        });
        Menu2.add(MenuItem2_1);

        MenuItem2_2.setText("档案下载");
        MenuItem2_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem2_2ActionPerformed(evt);
            }
        });
        Menu2.add(MenuItem2_2);

        jMenuBar1.add(Menu2);

        Menu3.setText("个人信息管理");
        Menu3.setName("menu3"); // NOI18N

        MenuItem3_1.setText("信息修改");
        MenuItem3_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem3_1ActionPerformed(evt);
            }
        });
        Menu3.add(MenuItem3_1);

        jMenuBar1.add(Menu3);

        Menu4.setText("退出");
        Menu4.setName("menu4"); // NOI18N

        MenuItem4_1.setText("退出登录");
        MenuItem4_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem4_1ActionPerformed(evt);
            }
        });

        Menu4.add(MenuItem4_1);

        jMenuBar1.add(Menu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 335, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    public void setMenuItemsEnabled(String role) {
        if (role.equals("administrator")) {
            Menu1.setEnabled(true);
            Menu2.setEnabled(true);
            Menu3.setEnabled(true);
        } else if (role.equals("operator")) {
            Menu1.setEnabled(false);
            Menu2.setEnabled(true);
            Menu3.setEnabled(true);
        } else if (role.equals("browser")){
            Menu1.setEnabled(false);
            Menu2.setEnabled(true);
            Menu3.setEnabled(true);
            MenuItem2_1.setEnabled(false);
        } else {
            Menu1.setEnabled(false);
            Menu2.setEnabled(false);
            Menu3.setEnabled(false);
        }
    }

    private void menuItem1_1ActionPerformed(java.awt.event.ActionEvent evt) {
        // 打开用户管理界面的GUI，并切换到修改用户tab
        UserManage userManagement = new UserManage();
        userManagement.setVisible(true);
        userManagement.switchTab(1);
    }

    private void menuItem1_2ActionPerformed(java.awt.event.ActionEvent evt) {
        // 打开用户管理界面的GUI，并切换到删除用户tab
        UserManage userManagement = new UserManage();
        userManagement.setVisible(true);
        userManagement.switchTab(2);
    }

    private void menuItem1_3ActionPerformed(java.awt.event.ActionEvent evt) {
        // 打开用户管理界面的GUI，并切换到新增用户tab
        UserManage userManagement = new UserManage();
        userManagement.setVisible(true);
        userManagement.switchTab(0);
    }

    private void menuItem2_1ActionPerformed(java.awt.event.ActionEvent evt) {
        // 打开文件管理界面的GUI,并切换到上传文件tab
        FileManage fileManagement = new FileManage(this.user);
        fileManagement.setVisible(true);
        fileManagement.switchTab(1);
    }

    private void menuItem2_2ActionPerformed(java.awt.event.ActionEvent evt) {
        // 打开文件管理界面的GUI,并切换到下载文件tab
        FileManage fileManagement = new FileManage(this.user);
        fileManagement.setVisible(true);
        fileManagement.switchTab(0);
        // 如果用户的role是broswer，则禁用上传文件功能
        System.out.println(this.user.getRole());
        if (this.user.getRole().equals("browser")) {
            fileManagement.setUploadButtonNotEnabled();
        }
    }

    private void menuItem3_1ActionPerformed(java.awt.event.ActionEvent evt) {
        // 打开用户信息编辑界面
        EditPersonalInfoPage editUserInfo = new EditPersonalInfoPage(this.user);
        editUserInfo.setVisible(true);
    }
    
    private void menuItem4_1ActionPerformed(java.awt.event.ActionEvent evt) {
        // 退出登录
        this.dispose();
        login login = new login();
        login.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                User temp_user = new Administrator("jack","123","administrator");
                new MainPage(temp_user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify       
    private User user;              
    private javax.swing.JMenu Menu1;
    private javax.swing.JMenu Menu2;
    private javax.swing.JMenu Menu3;
    private javax.swing.JMenu Menu4;
    private javax.swing.JMenuItem MenuItem1_1;
    private javax.swing.JMenuItem MenuItem1_2;
    private javax.swing.JMenuItem MenuItem1_3;
    private javax.swing.JMenuItem MenuItem2_1;
    private javax.swing.JMenuItem MenuItem2_2;
    private javax.swing.JMenuItem MenuItem3_1;
    private javax.swing.JMenuItem MenuItem4_1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration                   
}
