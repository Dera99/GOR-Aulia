
package com.app.form;

import com.app.cell.CellActionStaff;
import com.app.cell.CellStaffJabatan;
import com.app.cell.CellStaffLevel;
import com.app.cell.CellStaffNama;
import com.app.cell.CellTextEmail;
import com.app.cell.CellTextTelp;
import com.app.component.Form;
import com.app.model.ModelAccounts;
import com.app.model.ModelStaff;
import com.app.services.ServiceStaff;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Staff extends Form{

    public Staff() {
        initComponents();
        table1.addTableStyle(jScrollPane1);
        table1.setAnimateRowHeight(250);
        initTable();
    }
    private void initTable(){
        table1.addTableCell(new CellStaffNama(), 0);
        table1.addTableCell(new CellTextTelp(), 1);
        table1.addTableCell(new CellTextEmail(), 2);
        table1.addTableCell(new CellStaffJabatan(), 3);
        table1.addTableCell(new CellStaffLevel(), 4);
        table1.addTableCell(new CellActionStaff(), 5);
         new Thread(new Runnable() {
            @Override
            public void run() {
                table1.removeAllRows();
                try {
                    table1.removeAllRows();
                    for (ModelStaff data : new ServiceStaff().getStaff()) {
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

        roundPanel1.setBackground(new java.awt.Color(60, 60, 60));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "No Telp", "Email", "Jabatan", "Level Account", "Action"
            }
        ));
        jScrollPane1.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(0).setPreferredWidth(200);
            table1.getColumnModel().getColumn(5).setPreferredWidth(10);
        }

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private com.app.swing.RoundPanel roundPanel1;
    private com.app.swing.table.Table table1;
    // End of variables declaration//GEN-END:variables
}
