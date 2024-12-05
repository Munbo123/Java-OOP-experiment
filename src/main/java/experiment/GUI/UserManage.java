package experiment.GUI;

import experiment.util.DataProcessing;
import experiment.role.*;
import java.util.Enumeration;


/**
 * 用户管理界面
 * 1. 新增用户
 * 2. 修改用户
 * 3. 删除用户
 */
public class UserManage extends javax.swing.JFrame {

    public UserManage() {
        // 窗口居中
        setLocationRelativeTo(null);
        // 初始化界面
        initComponents();
        setChangeUserTableData();
        setDeleteUserTableData();
        // 选择一下修改用户信息的username框，让密码和角色框显示第一个用户的信息
        username2.setSelectedIndex(0);
    }

    // 切换到特定tab的函数
    public void switchTab(int index) {
        TabbedPane1.setSelectedIndex(index);
    }

    // 从DataProcessing中获取数据并显示在修改用户tab中的combox中
    public void setChangeUserTableData() {
        java.util.ArrayList<String> data = new java.util.ArrayList<>();
        try {
            Enumeration<User> e = DataProcessing.getAllUser();
            while (e.hasMoreElements()) {
                data.add(e.nextElement().getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        username2.setModel(new javax.swing.DefaultComboBoxModel<String>(data.toArray(new String[0])));
    }


    // 从DataProcessing中获取数据并显示在删除用户tab中的表格中
    public void setDeleteUserTableData() {
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) UserTable.getModel();
        model.setRowCount(0);
        try {
            Enumeration<User> e = DataProcessing.getAllUser();
            while (e.hasMoreElements()) {
                User user = e.nextElement();
                model.addRow(new Object[]{user.getName(), user.getPassword(), user.getRole()});
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 初始化界面          
    private void initComponents() {

        TabbedPane1 = new javax.swing.JTabbedPane();
        NewUserTable = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        AddUserButton = new javax.swing.JButton();
        CancelButton1 = new javax.swing.JButton();
        username1 = new javax.swing.JTextField();
        password1 = new javax.swing.JPasswordField();
        role1 = new javax.swing.JComboBox<>();
        ChangeUserTable = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ChangeUserButton = new javax.swing.JButton();
        CancelButton2 = new javax.swing.JButton();
        username2 = new javax.swing.JComboBox<>();
        role2 = new javax.swing.JComboBox<>();
        password2 = new javax.swing.JPasswordField();
        DeleteUserTable = new javax.swing.JPanel();
        UserScrollPane = new javax.swing.JScrollPane();
        UserTable = new javax.swing.JTable();
        DeleteUserButton = new javax.swing.JButton();
        CancelButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("用户界面管理");

        TabbedPane1.setFont(new java.awt.Font("楷体", 1, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("黑体", 1, 14)); // NOI18N
        jLabel1.setText("用户名");

        jLabel2.setFont(new java.awt.Font("黑体", 1, 14)); // NOI18N
        jLabel2.setText("角色");

        jLabel3.setFont(new java.awt.Font("黑体", 1, 14)); // NOI18N
        jLabel3.setText("口令");

        AddUserButton.setText("增加");
        AddUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddUserButtonActionPerformed(evt);
            }
        });

        CancelButton1.setText("取消");
        CancelButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButton1ActionPerformed(evt);
            }
        });

        username1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username1ActionPerformed(evt);
            }
        });

        password1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password1ActionPerformed(evt);
            }
        });

        role1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "browser", "administrator", "operator", " " }));
        role1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                role1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NewUserTableLayout = new javax.swing.GroupLayout(NewUserTable);
        NewUserTable.setLayout(NewUserTableLayout);
        NewUserTableLayout.setHorizontalGroup(
            NewUserTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewUserTableLayout.createSequentialGroup()
                .addGroup(NewUserTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NewUserTableLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(NewUserTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(NewUserTableLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(password1))
                            .addGroup(NewUserTableLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(role1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(NewUserTableLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(username1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(NewUserTableLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(AddUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CancelButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        NewUserTableLayout.setVerticalGroup(
            NewUserTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewUserTableLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(NewUserTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(NewUserTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(NewUserTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(role1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(NewUserTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddUserButton)
                    .addComponent(CancelButton1))
                .addGap(25, 25, 25))
        );

        TabbedPane1.addTab("新增用户", NewUserTable);

        jLabel4.setFont(new java.awt.Font("黑体", 1, 14)); // NOI18N
        jLabel4.setText("用户名");

        jLabel5.setFont(new java.awt.Font("黑体", 1, 14)); // NOI18N
        jLabel5.setText("口令");

        jLabel6.setFont(new java.awt.Font("黑体", 1, 14)); // NOI18N
        jLabel6.setText("角色");

        ChangeUserButton.setText("修改");
        ChangeUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangeUserButtonActionPerformed(evt);
            }
        });

        CancelButton2.setText("取消");
        CancelButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButton2ActionPerformed(evt);
            }
        });

        username2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "jack", "kate", "rose" }));
        username2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username2ActionPerformed(evt);
            }
        });

        role2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "browser", "administrator", "operator", " " }));
        role2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                role2ActionPerformed(evt);
            }
        });

        password2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ChangeUserTableLayout = new javax.swing.GroupLayout(ChangeUserTable);
        ChangeUserTable.setLayout(ChangeUserTableLayout);
        ChangeUserTableLayout.setHorizontalGroup(
            ChangeUserTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChangeUserTableLayout.createSequentialGroup()
                .addGroup(ChangeUserTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ChangeUserTableLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(ChangeUserTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(ChangeUserTableLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(password2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ChangeUserTableLayout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(role2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ChangeUserTableLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(username2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(ChangeUserTableLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(ChangeUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CancelButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        ChangeUserTableLayout.setVerticalGroup(
            ChangeUserTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChangeUserTableLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(ChangeUserTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(ChangeUserTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(ChangeUserTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(role2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(ChangeUserTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ChangeUserButton)
                    .addComponent(CancelButton2))
                .addGap(25, 25, 25))
        );

        TabbedPane1.addTab("修改用户", ChangeUserTable);

        UserTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "用户名", "口令", "角色"
            }
        ));
        UserScrollPane.setViewportView(UserTable);

        DeleteUserButton.setText("删除");
        DeleteUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteUserButtonActionPerformed(evt);
            }
        });

        CancelButton3.setText("取消");
        CancelButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DeleteUserTableLayout = new javax.swing.GroupLayout(DeleteUserTable);
        DeleteUserTable.setLayout(DeleteUserTableLayout);
        DeleteUserTableLayout.setHorizontalGroup(
            DeleteUserTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UserScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(DeleteUserTableLayout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(DeleteUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CancelButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );
        DeleteUserTableLayout.setVerticalGroup(
            DeleteUserTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteUserTableLayout.createSequentialGroup()
                .addComponent(UserScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(DeleteUserTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeleteUserButton)
                    .addComponent(CancelButton3))
                .addGap(32, 32, 32))
        );

        TabbedPane1.addTab("删除用户", DeleteUserTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>                        

    private void role1ActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // 暂时不需要
        return;
    }                                     

    private void username1ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // 光标移动到密码框
        password1.requestFocus();
    }                                         

    private void password1ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // 光标移动到角色框
        role1.requestFocus();
    }                                         

    private void AddUserButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // 获取新增用户信息
        String username = username1.getText();
        char[] passwordArray = password1.getPassword();
        String password = new String(passwordArray);
        String role = role1.getSelectedItem().toString();
        // 新增用户
        try {
            // 弹出确认新增用户提示框
            int result = javax.swing.JOptionPane.showConfirmDialog(this, "确认新增用户？", "确认", javax.swing.JOptionPane.YES_NO_OPTION);
            if (result == javax.swing.JOptionPane.YES_OPTION) {
                DataProcessing.insertUser(username, password, role);
                javax.swing.JOptionPane.showMessageDialog(this, "新增用户成功！");
            }else {
                return;
            } 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        // 更新修改用户tab中的combox
        setChangeUserTableData();
        // 更新删除用户tab中的表格
        setDeleteUserTableData();
    }                                             

    private void CancelButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // 关闭界面
        this.dispose();
    }                                             

    private void ChangeUserButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // 获取修改后的用户信息
        String username = username2.getSelectedItem().toString();
        char[] passwordArray = password2.getPassword();
        String password = new String(passwordArray);
        String role = role2.getSelectedItem().toString();
        // 更新用户信息
        try {
            // 弹出确认更新用户信息提示框
            int result = javax.swing.JOptionPane.showConfirmDialog(this, "确认更新用户信息？", "确认", javax.swing.JOptionPane.YES_NO_OPTION);
            if (result == javax.swing.JOptionPane.YES_OPTION) {
                DataProcessing.updateUser(username, password, role);
                javax.swing.JOptionPane.showMessageDialog(this, "更新用户信息成功！");
            }else {
                return;
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 更新删除用户tab中的表格
        setDeleteUserTableData();
    }                                                

    private void CancelButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // 关闭界面
        this.dispose();
    }                                             

    private void role2ActionPerformed(java.awt.event.ActionEvent evt) {          
        // 暂时不需要                            
        return;
    }                                     

    private void password2ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // 跳转到角色框
        role2.requestFocus();
    }                                         

    private void DeleteUserButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // 删除用户
        int row = UserTable.getSelectedRow();
        if (row == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "请选择要删除的用户！");
            return;
        }
        String username = UserTable.getValueAt(row, 0).toString();
        try {
            // 弹出确认删除用户提示框
            int result = javax.swing.JOptionPane.showConfirmDialog(this, "确认删除用户？", "确认", javax.swing.JOptionPane.YES_NO_OPTION);
            if (result == javax.swing.JOptionPane.YES_OPTION) {
                DataProcessing.deleteUser(username);
                javax.swing.JOptionPane.showMessageDialog(this, "删除用户成功！");
            }else {
                return;
            } 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        // 更新修改用户tab中的combox
        setChangeUserTableData();
        // 更新删除用户tab中的表格
        setDeleteUserTableData();
    }                                                

    private void CancelButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // 关闭界面
        this.dispose();
    }                                             

    private void username2ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // 更新密码和角色
        try {
            User user = DataProcessing.searchUser(username2.getSelectedItem().toString());
            // System.out.println(user.getName()+" "+user.getPassword()+" "+user.getRole());
            password2.setText(user.getPassword());
            role2.setSelectedItem(user.getRole());
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            java.util.logging.Logger.getLogger(UserManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserManage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton AddUserButton;
    private javax.swing.JButton CancelButton1;
    private javax.swing.JButton CancelButton2;
    private javax.swing.JButton CancelButton3;
    private javax.swing.JButton ChangeUserButton;
    private javax.swing.JPanel ChangeUserTable;
    private javax.swing.JButton DeleteUserButton;
    private javax.swing.JPanel DeleteUserTable;
    private javax.swing.JPanel NewUserTable;
    private javax.swing.JTabbedPane TabbedPane1;
    private javax.swing.JScrollPane UserScrollPane;
    private javax.swing.JTable UserTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField password1;
    private javax.swing.JPasswordField password2;
    private javax.swing.JComboBox<String> role1;
    private javax.swing.JComboBox<String> role2;
    private javax.swing.JTextField username1;
    private javax.swing.JComboBox<String> username2;
    // End of variables declaration                   
}
