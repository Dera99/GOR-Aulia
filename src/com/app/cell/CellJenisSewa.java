package com.app.cell;

import com.app.main.Main;
import com.app.model.ModelLapangan;
import com.app.services.ServicePaket;
import com.app.swing.table.TableCustom;
import com.app.swing.table.TableCustomCell;
import com.app.swing.table.TableRowData;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javaswingdev.GoogleMaterialDesignIcon;
import javaswingdev.GoogleMaterialIcon;
import notification.Notification;

public class CellJenisSewa extends TableCustomCell {
    
     public CellJenisSewa() {
        initComponents();
        
    }
    public void addEventSave(TableCustom table) {
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                table.stopCellEditing();
                Main m = new Main();
                ServicePaket sp = new ServicePaket();
                Notification err= new Notification(m, Notification.Type.ERROR, Notification.Location.TOP_CENTER, "Jenis Sewa Gagal Di Tambahkan !!");
                Notification succ= new Notification(m, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Jenis Sewa Berhasil Di Tambahkan !!");
                Notification err1= new Notification(m, Notification.Type.ERROR, Notification.Location.TOP_CENTER, "Jenis Sewa Gagal Di Update !!");
                Notification succ1= new Notification(m, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Jenis Sewa Berhasil Di Update !!");
                int row = getRow();
                ModelLapangan lapangan = (ModelLapangan) table.getModelData(row);
                int id = lapangan.getLapanganID();
                String name = (String) table.getValueAt(row,1);
                ModelLapangan data = new ModelLapangan(id,name);
              
                if (data.getLapanganID() == 0) {
                    //  Insert
                    try {
                        new ServicePaket().insertLapangan(data);
                        table.updateModelData(row, data);
                        succ.showNotification();
                    } catch (SQLException ex) {
                        System.err.println(ex);
                        err.showNotification();
                    }
                        
                } else {
                    //  Update
                    try {
                        new ServicePaket().updateLapangan(data);
                        table.updateModelData(row, data);
                        succ1.showNotification();
                    } catch (SQLException ex) {
                        System.err.println(ex);
                        err1.showNotification();
                    }     
                }
               
            
       }});
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt = new javax.swing.JTextField();
        btnUpdate = new com.app.swing.Button();

        jLabel1.setForeground(new java.awt.Color(230, 230, 230));
        jLabel1.setText("Jenis Sewa");

        btnUpdate.setBackground(new java.awt.Color(50, 200, 126));
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.setAutoscrolls(true);
        btnUpdate.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        GoogleMaterialIcon icon3 = new GoogleMaterialIcon();
        icon3.setIcon(GoogleMaterialDesignIcon.UPDATE);
        icon3.setColor1(Color.white);
        icon3.setColor2(Color.white);
        btnUpdate.setIcon(icon3.toIcon());
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed

    @Override
    public void setData(Object o) {
        txt.setText(o.toString());
    }

    @Override
    public Object getData() {      
        return txt.getText().trim();
    }

    @Override
    public TableCustomCell createComponentCellEditor(TableCustom tc, TableRowData trd, Object o, int i, int i1) {
        CellJenisSewa cell = new CellJenisSewa();
        cell.setData(o);
        cell.addEventSave(tc);
        return cell;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.swing.Button btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txt;
    // End of variables declaration//GEN-END:variables
}
