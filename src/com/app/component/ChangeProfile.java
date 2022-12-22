
package com.app.component;

import com.app.main.Main;
import com.app.model.ModelAccounts;
import com.app.service.ServiceSettings;
import com.app.service.UserSession;
import com.app.swing.SwitchButton;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.GoogleMaterialDesignIcon;
import javaswingdev.GoogleMaterialIcon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;
import net.miginfocom.swing.MigLayout;
import notification.Notification;
import org.jdesktop.animation.timing.TimingTargetAdapter;


public class ChangeProfile extends javax.swing.JPanel {
    private MigLayout layout;
    private String pathImage;
    ServiceSettings ss = new ServiceSettings();
    ModelAccounts data = new ModelAccounts();
    public ChangeProfile() {
        initComponents();
        image.setImage(UserSession.getIcon());
        layout = new MigLayout("fill, wrap 1,  inset 3","[fill]","[0][0!]");
        setLayout(layout);
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

        popup = new javax.swing.JPopupMenu();
        deleteImage = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        lbBack = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        switchButton1 = new com.app.swing.SwitchButton();
        panel = new javax.swing.JPanel();
        btnSave = new com.app.swing.Button();
        image = new com.app.swing.ImageAvatar();
        btnClear = new com.app.swing.Button();

        deleteImage.setText("Delete Image");
        deleteImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteImageActionPerformed(evt);
            }
        });
        popup.add(deleteImage);

        setOpaque(false);

        jPanel1.setOpaque(false);

        lbBack.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        lbBack.setForeground(new java.awt.Color(230, 230, 230));
        lbBack.setText("Profile");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(128, 128, 128));
        jLabel2.setText("Upload gambar profile dashboard");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 340, Short.MAX_VALUE)
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

        image.setGradientColor1(new java.awt.Color(51, 149, 225));
        image.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                imageMousePressed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(253, 83, 63));
        btnClear.setForeground(new java.awt.Color(240, 240, 240));
        btnClear.setText("Clear");
        btnClear.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        GoogleMaterialIcon icon4 = new GoogleMaterialIcon();
        icon4.setIcon(GoogleMaterialDesignIcon.DELETE);
        icon4.setColor1(Color.white);
        icon4.setColor2(Color.white);
        btnClear.setIcon(icon4.toIcon());

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
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

    private void imageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageMouseClicked
        // TODO add your handling code here:
         if (SwingUtilities.isLeftMouseButton(evt) && evt.getClickCount() == 2) {
            JFileChooser ch = new JFileChooser();
            ch.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    String name = file.getName().toLowerCase();
                    return file.isDirectory() || name.endsWith(".png") || name.endsWith(".jpg");
                }

                @Override
                public String getDescription() {
                    return "Image File";
                }
            });
            int opt = ch.showOpenDialog(this);
            if (opt == JFileChooser.APPROVE_OPTION) {
                pathImage = ch.getSelectedFile().getAbsolutePath();
                image.setImage(new ImageIcon(pathImage));
            }
        }
    }//GEN-LAST:event_imageMouseClicked

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
         //TODO add your handling code here:
        pathImage = "";
        image.setImage(null);
    }//GEN-LAST:event_btnClearActionPerformed

    private void imageMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageMousePressed
        // TODO add your handling code here:
        if (SwingUtilities.isRightMouseButton(evt)) {
            popup.show(image, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_imageMousePressed

    private void deleteImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteImageActionPerformed
        pathImage = "";
        image.setImage(null);
    }//GEN-LAST:event_deleteImageActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Main m = new Main();
        Notification succ= new Notification(m, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Berhasil Disimpan, Silahkan Login Kembali !!");
        try {
            int userID = UserSession.GetUserId();
            System.out.println("user id "+userID);
            System.out.println("path image "+pathImage);
            succ.showNotification();
            ss.updateProfile(pathImage, userID);        
        } catch (SQLException ex) {
            //Logger.getLogger(ChangeProfile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //System.err.println("E" );
        }
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.swing.Button btnClear;
    private com.app.swing.Button btnSave;
    private javax.swing.JMenuItem deleteImage;
    private com.app.swing.ImageAvatar image;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbBack;
    private javax.swing.JPanel panel;
    private javax.swing.JPopupMenu popup;
    private com.app.swing.SwitchButton switchButton1;
    // End of variables declaration//GEN-END:variables
}
