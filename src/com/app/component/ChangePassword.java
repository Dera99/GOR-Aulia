
package com.app.component;

import com.app.main.Main;
import com.app.model.ModelAccounts;
import com.app.services.ServiceSettings;
import com.app.services.UserSession;
import com.app.swing.SwitchButton;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.GoogleMaterialDesignIcon;
import javaswingdev.GoogleMaterialIcon;
import net.miginfocom.swing.MigLayout;
import notification.Notification;
import org.jdesktop.animation.timing.TimingTargetAdapter;


public class ChangePassword extends javax.swing.JPanel {
    private MigLayout layout;
    public ChangePassword() {
        initComponents();
        layout = new MigLayout("fill, wrap 1,  inset 3","[fill]","[0][0!]");
        setLayout(layout);
        txtLama.setBackground(new Color(0,0,0,0));
        txtBaru.setBackground(new Color(0,0,0,0)); 
        switchButton1.getAnimator().addTarget(new TimingTargetAdapter(){
           @Override
           public void timingEvent(float fraction){
               double size;
               if(switchButton1.isSelected()){
                   size = (1f - fraction)*110;
               }else{
                   size = fraction * 110;
               }
               layout.setRowConstraints("[]0[" +size+ "!]");
               revalidate();
           }
           @Override
           public void end(){
               if(!switchButton1.isSelected()){
               }
           }
        });
    }
    public SwitchButton getSwitch(){
        return switchButton1;
    }
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbBack = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        switchButton1 = new com.app.swing.SwitchButton();
        panel = new javax.swing.JPanel();
        btnSave = new com.app.swing.Button();
        txtLama = new com.app.swing.PasswordField();
        txtBaru = new com.app.swing.PasswordField();

        setOpaque(false);

        jPanel1.setOpaque(false);

        lbBack.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        lbBack.setForeground(new java.awt.Color(230, 230, 230));
        lbBack.setText("Reset Password");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(128, 128, 128));
        jLabel2.setText("Input password lama dan password baru");

        jPanel2.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(switchButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(switchButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lbBack))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 301, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lbBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel.setOpaque(false);

        btnSave.setBackground(new java.awt.Color(51, 149, 225));
        btnSave.setForeground(new java.awt.Color(240, 240, 240));
        btnSave.setText("Save");
        btnSave.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        GoogleMaterialIcon icon2 = new GoogleMaterialIcon();
        icon2.setIcon(GoogleMaterialDesignIcon.SAVE);
        icon2.setColor1(Color.white);
        icon2.setColor2(Color.white);
        btnSave.setIcon(icon2.toIcon());
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        txtLama.setForeground(new java.awt.Color(230, 230, 230));
        txtLama.setLabelText("Password Lama");

        txtBaru.setForeground(new java.awt.Color(230, 230, 230));
        txtBaru.setLabelText("Password Baru");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLama, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBaru, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtLama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBaru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
       Main m = new Main();
       Notification err= new Notification(m, Notification.Type.ERROR, Notification.Location.TOP_CENTER, "Password Lama Tidak Sesuai !!");
       Notification succ= new Notification(m, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Password Berhasil di Update !!");
        try {
            // TODO add your handling code here:
            ServiceSettings ss = new ServiceSettings();
            int userID = UserSession.GetUserId();
            int roleID = UserSession.getRoleId();
            String userLogin = UserSession.getUserLogin();
            ModelAccounts data = new ModelAccounts(userID,userLogin,txtLama.getText(),roleID);
            if(ss.checkPassword(data)==true){
                ModelAccounts data2 = new ModelAccounts(userID,userLogin,txtBaru.getText(),roleID);
                ss.updatePassword(data2);
                succ.showNotification();
            }else{
                err.showNotification();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.swing.Button btnSave;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbBack;
    private javax.swing.JPanel panel;
    private com.app.swing.SwitchButton switchButton1;
    private com.app.swing.PasswordField txtBaru;
    private com.app.swing.PasswordField txtLama;
    // End of variables declaration//GEN-END:variables
}
