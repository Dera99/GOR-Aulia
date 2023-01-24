package com.app.configurations;

import com.app.main.Login;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.GoogleMaterialDesignIcon;
import javaswingdev.GoogleMaterialIcon;

public class Configuration extends javax.swing.JFrame {

    SystemProperties pro = new SystemProperties();
    public Configuration() {
        initComponents();
        pro.loadFromFile();
        header1.initMoving(this);
        header1.initEvent(this, panelBackground1);
        ip.setText(String.valueOf(pro.getIP()));
        dbname.setText(String.valueOf(pro.getDbname()));
        user.setText(String.valueOf(pro.getDbuser()));
        pw.setText(String.valueOf(pro.getPwuser()));  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackground1 = new com.app.swing.PanelBackground();
        lbl_ip = new javax.swing.JLabel();
        ip = new javax.swing.JTextField();
        lbl_db = new javax.swing.JLabel();
        dbname = new javax.swing.JTextField();
        lbl_user = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        lbl_pass = new javax.swing.JLabel();
        pw = new javax.swing.JPasswordField();
        lbl_ip1 = new javax.swing.JLabel();
        header1 = new com.app.component.Header();
        button1 = new com.app.swing.Button();
        button2 = new com.app.swing.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Config");
        setUndecorated(true);

        panelBackground1.setBackground(new java.awt.Color(55, 55, 55));

        lbl_ip.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_ip.setForeground(new java.awt.Color(230, 230, 230));
        lbl_ip.setText("IP Server  :");

        lbl_db.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_db.setForeground(new java.awt.Color(230, 230, 230));
        lbl_db.setText("Database :");

        lbl_user.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_user.setForeground(new java.awt.Color(230, 230, 230));
        lbl_user.setText("Username :");

        lbl_pass.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_pass.setForeground(new java.awt.Color(230, 230, 230));
        lbl_pass.setText("Password :");

        pw.setText("jPasswordField2");

        lbl_ip1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbl_ip1.setForeground(new java.awt.Color(230, 230, 230));
        lbl_ip1.setText("Config Database");

        button1.setBackground(new java.awt.Color(51, 149, 225));
        button1.setForeground(new java.awt.Color(230, 230, 230));
        button1.setText("Save");
        button1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setBackground(new java.awt.Color(253, 83, 63));
        button2.setForeground(new java.awt.Color(230, 230, 230));
        button2.setText("Cancel");
        button2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBackground1Layout = new javax.swing.GroupLayout(panelBackground1);
        panelBackground1.setLayout(panelBackground1Layout);
        panelBackground1Layout.setHorizontalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground1Layout.createSequentialGroup()
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBackground1Layout.createSequentialGroup()
                        .addContainerGap(18, Short.MAX_VALUE)
                        .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelBackground1Layout.createSequentialGroup()
                                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_db)
                                    .addComponent(lbl_ip))
                                .addGap(23, 23, 23)
                                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dbname)
                                    .addComponent(ip, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelBackground1Layout.createSequentialGroup()
                                .addComponent(lbl_pass)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pw, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBackground1Layout.createSequentialGroup()
                                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_user)
                                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(user, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panelBackground1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_ip1)))
                .addContainerGap(40, Short.MAX_VALUE))
            .addComponent(header1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        panelBackground1Layout.setVerticalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackground1Layout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_ip1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_ip)
                    .addComponent(ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_db)
                    .addComponent(dbname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_user)
                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_pass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        GoogleMaterialIcon icon2 = new GoogleMaterialIcon();
        icon2.setIcon(GoogleMaterialDesignIcon.SAVE);
        icon2.setColor1(Color.white);
        icon2.setColor2(Color.white);
        button1.setIcon(icon2.toIcon());
        GoogleMaterialIcon icon1 = new GoogleMaterialIcon();
        icon1.setIcon(GoogleMaterialDesignIcon.CANCEL);
        icon1.setColor1(Color.white);
        icon1.setColor2(Color.white);
        button2.setIcon(icon1.toIcon());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_button2ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        try {
            pro.save("IP",ip.getText());
            pro.save("DB_Name",dbname.getText());
            pro.save("DB_User",user.getText());
            pro.save("DB_Password",pw.getText());
            this.dispose();
            Login obj = new Login();
            obj.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button1ActionPerformed
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Configuration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Configuration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.swing.Button button1;
    private com.app.swing.Button button2;
    public javax.swing.JTextField dbname;
    private com.app.component.Header header1;
    public javax.swing.JTextField ip;
    public javax.swing.JLabel lbl_db;
    public javax.swing.JLabel lbl_ip;
    public javax.swing.JLabel lbl_ip1;
    public javax.swing.JLabel lbl_pass;
    public javax.swing.JLabel lbl_user;
    private com.app.swing.PanelBackground panelBackground1;
    public javax.swing.JPasswordField pw;
    public javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
