package experiment.GUI;

import experiment.util.DataProcessing;
import experiment.role.*;
import experiment.util.Doc;


public class FileManage extends javax.swing.JFrame {

    public FileManage(User user) {
        // 设置界面居中
        setLocationRelativeTo(null);
        // 初始化界面
        this.user = user;
        initComponents();
        updateTable();
    }
                
    private void initComponents() {

        TabbedPane1 = new javax.swing.JTabbedPane();
        download = new javax.swing.JPanel();
        download_button = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        back_button = new javax.swing.JButton();
        upload = new javax.swing.JPanel();
        upload_button = new javax.swing.JButton();
        cancel_button = new javax.swing.JButton();
        open_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        filename = new javax.swing.JTextField();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("文件管理界面");

        TabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TabbedPane1.setFont(new java.awt.Font("楷体", 1, 18)); // NOI18N
        TabbedPane1.setName(""); // NOI18N

        download_button.setFont(new java.awt.Font("微软雅黑", 1, 12)); // NOI18N
        download_button.setText("下载");
        download_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                download_buttonActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Table1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "档案号", "创建者", "时间", "文件名", "描述"
            }
        ));
        Table1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Table1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane2.setViewportView(Table1);

        back_button.setFont(new java.awt.Font("微软雅黑", 1, 12)); // NOI18N
        back_button.setText("返回");
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout downloadLayout = new javax.swing.GroupLayout(download);
        download.setLayout(downloadLayout);
        downloadLayout.setHorizontalGroup(
            downloadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(downloadLayout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(download_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(back_button)
                .addContainerGap(153, Short.MAX_VALUE))
            .addGroup(downloadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        downloadLayout.setVerticalGroup(
            downloadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, downloadLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(downloadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(download_button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        TabbedPane1.addTab("文件下载", download);

        upload_button.setFont(new java.awt.Font("黑体", 1, 14)); // NOI18N
        upload_button.setText("上传");
        upload_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upload_buttonActionPerformed(evt);
            }
        });

        cancel_button.setFont(new java.awt.Font("黑体", 1, 14)); // NOI18N
        cancel_button.setText("取消");
        cancel_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_buttonActionPerformed(evt);
            }
        });

        open_button.setFont(new java.awt.Font("黑体", 1, 14)); // NOI18N
        open_button.setText("打开");
        open_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                open_buttonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 16)); // NOI18N
        jLabel1.setText("档案号");

        jLabel2.setFont(new java.awt.Font("微软雅黑", 0, 16)); // NOI18N
        jLabel2.setText("档案描述");

        jLabel3.setFont(new java.awt.Font("微软雅黑", 0, 16)); // NOI18N
        jLabel3.setText("档案文件名");

        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        filename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filenameActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
 

        javax.swing.GroupLayout uploadLayout = new javax.swing.GroupLayout(upload);
        upload.setLayout(uploadLayout);
        uploadLayout.setHorizontalGroup(
            uploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(uploadLayout.createSequentialGroup()
                .addGroup(uploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(uploadLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(uploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, uploadLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(uploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(filename))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(open_button))
                    .addGroup(uploadLayout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(upload_button)
                        .addGap(5, 5, 5)
                        .addComponent(cancel_button)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        uploadLayout.setVerticalGroup(
            uploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, uploadLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(uploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id))
                .addGap(18, 18, 18)
                .addGroup(uploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(uploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filename)
                    .addComponent(open_button))
                .addGap(18, 18, 18)
                .addGroup(uploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(upload_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancel_button))
                .addGap(41, 41, 41))
        );

        TabbedPane1.addTab("文件上传", upload);

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

    // 更新table的函数，从dataproccessing中获取数据
    private void updateTable() {
        try {
            java.util.Enumeration<Doc> docs = DataProcessing.getAllDocs();
            int i = 0;
            while (docs.hasMoreElements()) {
                Doc doc = docs.nextElement();
                Table1.setValueAt(doc.getID(), i, 0);
                Table1.setValueAt(doc.getCreator(), i, 1);
                Table1.setValueAt(doc.getTimestamp(), i, 2);
                Table1.setValueAt(doc.getFilename(), i, 3);
                Table1.setValueAt(doc.getDescription(), i, 4);
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 根据传入的数值，切换到对应的tab
    public void switchTab(int index) {
        TabbedPane1.setSelectedIndex(index);
    }

    // 定义setUploadButtonNotEnabled函数，用于设置上传table为不可用
    public void setUploadButtonNotEnabled() {
        TabbedPane1.setEnabledAt(1, false);
    }

    private void download_buttonActionPerformed(java.awt.event.ActionEvent evt) {                            
        int selectedRow = Table1.getSelectedRow();
        if (selectedRow != -1) {
            String id = Table1.getValueAt(selectedRow, 0).toString();
            try {
                // 弹出确认对话框
                int result = javax.swing.JOptionPane.showConfirmDialog(this, "确认下载文件？", "提示", javax.swing.JOptionPane.YES_NO_OPTION);
                if (result == javax.swing.JOptionPane.YES_OPTION) {
                    // 弹出保存文件位置的框，获取保存的文件夹和保存的文件名（文件名需要用户输入）
                    String defaultFilename = Table1.getValueAt(selectedRow, 3).toString();
                    String defaultPath = "C:\\Users\\19722\\Desktop\\Coding\\GithubProjects\\MyProjects\\JavaExperiment\\untitled\\src\\main\\java\\experiment\\files\\downloadfiles"; // 指定默认路径
                    javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser(defaultPath);
                    fileChooser.setSelectedFile(new java.io.File(defaultFilename));
                    fileChooser.setFileSelectionMode(javax.swing.JFileChooser.FILES_ONLY);
                    int returnVal = fileChooser.showSaveDialog(this);
                    if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
                        java.io.File file = fileChooser.getSelectedFile();
                        String downloadpath = file.getParent();
                        String filename = file.getName();

                    DataProcessing.downloadFile(id, downloadpath, filename);
                    }
                    // 弹出下载成功提示框
                    javax.swing.JOptionPane.showMessageDialog(this, "下载成功！", "提示", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                e.printStackTrace();
                javax.swing.JOptionPane.showMessageDialog(this, "出现错误", "提示", javax.swing.JOptionPane.WARNING_MESSAGE);
            }
        } else {
            // 弹出提示框
            javax.swing.JOptionPane.showMessageDialog(this, "请选择一个文件进行下载", "提示", javax.swing.JOptionPane.WARNING_MESSAGE);
        }
    }                                               

    private void upload_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        String fileId = id.getText();
        String description = jTextArea1.getText();
        String filePath = filename.getText();
        // 检查docs中是否已经存在该文件的id
        try {
            if (DataProcessing.searchDoc(fileId) != null) {
                javax.swing.JOptionPane.showMessageDialog(this, "档案号已存在，请重新输入！", "提示", javax.swing.JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }


        try {
            if (DataProcessing.uploadFile(filePath, fileId, description,this.user.getName())) {
                // 上传成功后，更新table
                updateTable();
                // 弹出消息框：文件上传成功！
                javax.swing.JOptionPane.showMessageDialog(this, "文件上传成功！", "提示", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } else {
                // 弹出消息框：文件上传失败！
                javax.swing.JOptionPane.showMessageDialog(this, "文件上传失败！请检查是否已经存在同名文件", "提示", javax.swing.JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }                                             

    private void cancel_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        dispose();
    }                                             

    private void idActionPerformed(java.awt.event.ActionEvent evt) {                                   
        // 将光标切换到描述文本框
        jTextArea1.requestFocus();
    }                                  

    private void filenameActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // 即当做用户点击了upload_button
        upload_buttonActionPerformed(evt);
    }
    

    private void open_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // 打开文件选择对话框，选择文件后，把文件的路径填入filename文本框
        // 设置初始显示路径为指定的路径
        String defaultPath = "C:\\Users\\19722\\Desktop\\Coding\\GithubProjects\\MyProjects\\JavaExperiment\\untitled\\src\\main\\java\\experiment\\files";
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser(defaultPath);
        fileChooser.setFileSelectionMode(javax.swing.JFileChooser.FILES_ONLY);
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File file = fileChooser.getSelectedFile();
            filename.setText(file.getAbsolutePath());
        }
    }                                           

    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        dispose();
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
            java.util.logging.Logger.getLogger(FileManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FileManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FileManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FileManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                User temp_user = new Browser("rose","123","browser");
                new FileManage(temp_user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify   
    private User user;                  
    private javax.swing.JTabbedPane TabbedPane1;
    private javax.swing.JTable Table1;
    private javax.swing.JButton back_button;
    private javax.swing.JButton cancel_button;
    private javax.swing.JPanel download;
    private javax.swing.JButton download_button;
    private javax.swing.JTextField filename;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton open_button;
    private javax.swing.JPanel upload;
    private javax.swing.JButton upload_button;
    // End of variables declaration                   
}
