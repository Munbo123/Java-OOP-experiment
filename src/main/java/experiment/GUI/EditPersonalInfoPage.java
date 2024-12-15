package experiment.GUI;

import experiment.Client.Client;
import experiment.role.*;

public class EditPersonalInfoPage extends javax.swing.JFrame {

    private Client client;
    public EditPersonalInfoPage(User user) {
        // 获取客户端实例
        client = Client.getInstance();
        // 窗口居中
        setLocationRelativeTo(null);
        // 初始化界面
        this.user = user;
        initComponents();
        // 初始化用户名和角色，并设置不可编辑
        username.setText(this.user.getName());
        role.setText(this.user.getRole());
        username.setEditable(false);
        role.setEditable(false);

    }
                   
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        modify_button = new javax.swing.JButton();
        back_button = new javax.swing.JButton();
        username = new javax.swing.JTextField();
        role = new javax.swing.JTextField();
        OriginalPassword = new javax.swing.JPasswordField();
        NewPassword = new javax.swing.JPasswordField();
        ConfirmNewPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("个人信息管理");

        jLabel1.setFont(new java.awt.Font("楷体", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("用户名");

        jLabel2.setFont(new java.awt.Font("楷体", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("确认新口令");

        jLabel3.setFont(new java.awt.Font("楷体", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("原口令");

        jLabel4.setFont(new java.awt.Font("楷体", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("新口令");

        jLabel5.setFont(new java.awt.Font("楷体", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("角色");

        modify_button.setFont(new java.awt.Font("黑体", 1, 14)); // NOI18N
        modify_button.setText("修改");
        modify_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modify_buttonActionPerformed(evt);
            }
        });

        back_button.setFont(new java.awt.Font("黑体", 1, 14)); // NOI18N
        back_button.setText("返回");
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            back_buttonActionPerformed(evt);
            }
        });

        OriginalPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            OriginalPasswordActionPerformed(evt);
            }
        });

        NewPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewPasswordActionPerformed(evt);
            }
        });

        ConfirmNewPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            ConfirmNewPasswordActionPerformed(evt);
            }
        });


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ConfirmNewPassword))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(OriginalPassword))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(NewPassword))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(role, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(modify_button, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OriginalPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConfirmNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modify_button)
                    .addComponent(back_button))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    // 修改按钮的事件处理
    private void modify_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // 弹出确认对话框
        int result = javax.swing.JOptionPane.showConfirmDialog(this, "确认修改？", "确认", javax.swing.JOptionPane.YES_NO_OPTION);
        if (result == javax.swing.JOptionPane.YES_OPTION) {
            // 获取输入的原口令、新口令和确认新口令
            String originalPassword = new String(OriginalPassword.getPassword());
            String newPassword = new String(NewPassword.getPassword());
            String confirmNewPassword = new String(ConfirmNewPassword.getPassword());
            // 判断原口令是否正确
            if (!originalPassword.equals(this.user.getPassword())) {
                javax.swing.JOptionPane.showMessageDialog(this, "原口令错误", "错误", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
            // 判断新口令和确认新口令是否一致
            if (!newPassword.equals(confirmNewPassword)) {
                javax.swing.JOptionPane.showMessageDialog(this, "新口令和确认新口令不一致", "错误", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
            // 修改本地存储的用户信息
            this.user.setPassword(newPassword);
            // 修改DataProcessing中的用户信息
            try {
                // DataProcessing.updateUser(user.getName(), newPassword, user.getRole());
                // 向服务器发送请求并获取响应
                client.writeAndReadMessage("updateUser " + user.getName() + " " + newPassword + " " + user.getRole());
            } catch (Exception e) {
                e.printStackTrace();
            }

            javax.swing.JOptionPane.showMessageDialog(this, "修改成功", "成功", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
    }  
    
    // 取消按钮的事件处理
    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        this.dispose();
    }

    // 原口令输入框的事件处理
    private void OriginalPasswordActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // 切换到新口令输入框
        NewPassword.requestFocus();
    }

    // 新口令输入框的事件处理
    private void NewPasswordActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // 切换到确认新口令输入框
        ConfirmNewPassword.requestFocus();
    }     
    
    // 确认新口令输入框的事件处理
    private void ConfirmNewPasswordActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // 点击修改按钮
        modify_buttonActionPerformed(evt);
    }


    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditPersonalInfoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditPersonalInfoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditPersonalInfoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditPersonalInfoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // new EditPersonalInfoPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify    
    private User user;                 
    private javax.swing.JPasswordField ConfirmNewPassword;
    private javax.swing.JPasswordField NewPassword;
    private javax.swing.JPasswordField OriginalPassword;
    private javax.swing.JButton back_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField role;
    private javax.swing.JButton modify_button;
    private javax.swing.JTextField username;
    // End of variables declaration                   
}
