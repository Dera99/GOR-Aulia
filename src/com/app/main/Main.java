package com.app.main;

import com.app.configurations.DatabaseConnection;
import com.app.event.MenuEvent;
import com.app.form.FormHome;
import com.app.form.Forms;
import com.app.form.PaketSewa;
import com.app.form.Pemesanan;
import com.app.form.Penyewa;
import com.app.form.Settings;
import com.app.form.Transaksi;
import com.app.services.UserSession;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends javax.swing.JFrame {
Connection CC = new DatabaseConnection().connect();
    public Main() {
        initComponents();
        init();
    }
   private void init(){
        header.initMoving(this);
        header.initEvent(this, panelBackground);
//        ServiceSettings ss = new ServiceSettings();
//        int UserID = UserSession.GetUserId();
//        menu.Image.setImage(ss.getProfile(UserID));
            MenuEvent event = new MenuEvent() {
            @Override
            public void menuSelected(int index) {
                System.out.println("Index : "+index);
                if (index == 0) {
                    mainBody.displayForm(new FormHome(),"Dashboard");
                }else if (index==1){
                    mainBody.displayForm(new Pemesanan(),"Pemesanan");
                }else if (index==2){
                    mainBody.displayForm(new Transaksi(),"Transaksi");
                }else if (index==3){
                    mainBody.displayForm(new PaketSewa(),"Paket Sewa");
                }else if (index==4){
                    mainBody.displayForm(new Penyewa(),"Penyewa");
                }else if (index==5){
                    mainBody.displayForm(new Settings(),"Settings");
                }
                else if(index == 6){
                    try {
                        UserSession.setUserId(0);
                        UserSession.setUserLogin("");
                        UserSession.setRoleId(0);
                        Login a = new Login();
                        a.setVisible(true);
                        dispose();
                    } catch (SQLException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else {
                    mainBody.displayForm(new Forms(index + ""));
                }
            }           
        }; 
        menu.initMenu(event);
        menu.setSelected(0);
        mainBody.displayForm(new FormHome(),"Dashboard");  
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackground = new com.app.swing.PanelBackground();
        header = new com.app.component.Header();
        menu = new com.app.component.Menu();
        mainBody = new com.app.component.MainBody();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBackground.setBackground(new java.awt.Color(55, 55, 55));

        header.setBackground(new java.awt.Color(60, 60, 60));

        javax.swing.GroupLayout panelBackgroundLayout = new javax.swing.GroupLayout(panelBackground);
        panelBackground.setLayout(panelBackgroundLayout);
        panelBackgroundLayout.setHorizontalGroup(
            panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackgroundLayout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainBody, javax.swing.GroupLayout.DEFAULT_SIZE, 1079, Short.MAX_VALUE))
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelBackgroundLayout.setVerticalGroup(
            panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackgroundLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainBody, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
                    .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                   Connection CC = new DatabaseConnection().connect();
                } catch (Exception e) {
                    System.err.println(e);
                }
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.component.Header header;
    private com.app.component.MainBody mainBody;
    private com.app.component.Menu menu;
    private com.app.swing.PanelBackground panelBackground;
    // End of variables declaration//GEN-END:variables
}
