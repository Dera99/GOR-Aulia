
package com.app.component;

import com.app.swing.SwitchButton;
import java.awt.Color;
import javaswingdev.GoogleMaterialDesignIcon;
import javaswingdev.GoogleMaterialIcon;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.TimingTargetAdapter;


public class ReportCustomer extends javax.swing.JPanel {
    private MigLayout layout;
    public ReportCustomer() {
        initComponents();
        layout = new MigLayout("fill, wrap 1,  inset 3","[fill]","[0][0!]");
        setLayout(layout);
        switchButton1.getAnimator().addTarget(new TimingTargetAdapter(){
           @Override
           public void timingEvent(float fraction){
               double size;
               if(switchButton1.isSelected()){
                   size = (1f - fraction)*130;
               }else{
                   size = fraction * 130;
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

        dateChooser1 = new com.app.swing.datechooser.DateChooser();
        dateChooser2 = new com.app.swing.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        lbBack = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        switchButton1 = new com.app.swing.SwitchButton();
        panel = new javax.swing.JPanel();
        combobox1 = new com.app.swing.Combobox();
        txtDari = new com.app.swing.TextField();
        txtSampai = new com.app.swing.TextField();
        btnPrint = new com.app.swing.Button();

        dateChooser1.setForeground(new java.awt.Color(51, 149, 225));
        dateChooser1.setTextRefernce(txtDari);

        dateChooser2.setForeground(new java.awt.Color(51, 149, 225));
        dateChooser2.setTextRefernce(txtSampai);

        setOpaque(false);

        jPanel1.setOpaque(false);

        lbBack.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        lbBack.setForeground(new java.awt.Color(230, 230, 230));
        lbBack.setText("Report Customer");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(128, 128, 128));
        jLabel2.setText("Cetak laporan data customer");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        combobox1.setBackground(new java.awt.Color(60, 60, 60));
        combobox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Reguler", "Member" }));
        combobox1.setSelectedIndex(-1);
        combobox1.setLabeText("Tipe Customer");

        txtDari.setBackground(new java.awt.Color(60, 60, 60));
        txtDari.setForeground(new java.awt.Color(230, 230, 230));
        txtDari.setLabelText("Dari :");

        txtSampai.setBackground(new java.awt.Color(60, 60, 60));
        txtSampai.setForeground(new java.awt.Color(230, 230, 230));
        txtSampai.setLabelText("Sampai :");
        txtSampai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSampaiActionPerformed(evt);
            }
        });

        btnPrint.setBackground(new java.awt.Color(51, 149, 225));
        btnPrint.setForeground(new java.awt.Color(240, 240, 240));
        btnPrint.setText("Cetak");
        btnPrint.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnPrint.setPreferredSize(new java.awt.Dimension(43, 27));
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        ;
        GoogleMaterialIcon icn = new GoogleMaterialIcon();
        icn.setIcon(GoogleMaterialDesignIcon.PRINT);
        icn.setColor1(Color.white);
        icn.setColor2(Color.white);
        btnPrint.setIcon(icn.toIcon());

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combobox1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(txtDari, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(txtSampai, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(162, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(combobox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSampai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(188, Short.MAX_VALUE))
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
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed

    }//GEN-LAST:event_btnPrintActionPerformed

    private void txtSampaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSampaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSampaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.swing.Button btnPrint;
    private com.app.swing.Combobox combobox1;
    private com.app.swing.datechooser.DateChooser dateChooser1;
    private com.app.swing.datechooser.DateChooser dateChooser2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbBack;
    private javax.swing.JPanel panel;
    private com.app.swing.SwitchButton switchButton1;
    private com.app.swing.TextField txtDari;
    private com.app.swing.TextField txtSampai;
    // End of variables declaration//GEN-END:variables
}
