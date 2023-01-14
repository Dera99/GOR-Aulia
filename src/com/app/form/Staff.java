
package com.app.form;

import com.app.cell.CellActionStaff;
import com.app.cell.CellStaffJabatan;
import com.app.cell.CellStaffLevel;
import com.app.cell.CellStaffNama;
import com.app.cell.CellStaffUsername;
import com.app.cell.CellTextEmail;
import com.app.cell.CellTextTelp;
import com.app.component.Form;
import com.app.model.ModelAccounts;
import com.app.model.ModelStaff;
import com.app.services.ServiceStaff;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.GoogleMaterialDesignIcon;
import javaswingdev.GoogleMaterialIcon;

public class Staff extends Form{

    public Staff() {
        initComponents();
        table1.addTableStyle(jScrollPane1);
        table1.setAnimateRowHeight(250);
        initTable();
    }
    private void initTable(){
        table1.addTableCell(new CellStaffNama(), 0);
        table1.addTableCell(new CellTextEmail(), 1);
        table1.addTableCell(new CellStaffJabatan(), 2);
        table1.addTableCell(new CellStaffUsername(), 3);
        table1.addTableCell(new CellStaffLevel(), 4);
        table1.addTableCell(new CellActionStaff(), 5);
         new Thread(new Runnable() {
            @Override
            public void run() {
                table1.removeAllRows();
                try {
                    table1.removeAllRows();
                    for (ModelAccounts data : new ServiceStaff().getStaff()) {
                        table1.addRow(data, false); 
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
                    System.err.println(ex);
                }
                
            }   
        }).start();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.app.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.app.swing.table.Table();
        btnAdd = new com.app.swing.Button();

        roundPanel1.setBackground(new java.awt.Color(60, 60, 60));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "Email", "Jabatan", "Username", "Level Account", "Action"
            }
        ));
        jScrollPane1.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(0).setPreferredWidth(200);
            table1.getColumnModel().getColumn(1).setPreferredWidth(100);
            table1.getColumnModel().getColumn(2).setPreferredWidth(90);
            table1.getColumnModel().getColumn(3).setPreferredWidth(100);
            table1.getColumnModel().getColumn(4).setPreferredWidth(100);
            table1.getColumnModel().getColumn(5).setPreferredWidth(10);
        }

        btnAdd.setBackground(new java.awt.Color(51, 149, 225));
        btnAdd.setForeground(new java.awt.Color(240, 240, 240));
        btnAdd.setText("Add");
        btnAdd.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        GoogleMaterialIcon icon1 = new GoogleMaterialIcon();
        icon1.setIcon(GoogleMaterialDesignIcon.ADD_CIRCLE_OUTLINE);
        icon1.setColor1(Color.white);
        icon1.setColor2(Color.white);
        btnAdd.setIcon(icon1.toIcon());

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1032, Short.MAX_VALUE)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        ModelAccounts acc = new ModelAccounts(0,"","",0);
        ModelStaff data = new ModelStaff(0,"","","","","");
        acc.setStaff(data);
        data.setAccount(acc);
        table1.insertRowWithEdit(acc, 0, true);
    }//GEN-LAST:event_btnAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.swing.Button btnAdd;
    private javax.swing.JScrollPane jScrollPane1;
    private com.app.swing.RoundPanel roundPanel1;
    private com.app.swing.table.Table table1;
    // End of variables declaration//GEN-END:variables
}
