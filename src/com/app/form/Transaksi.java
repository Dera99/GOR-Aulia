package com.app.form;

import com.app.cell.CellActionTrx;
import com.app.component.Form;
import com.app.model.ModelTransaksi;
import com.app.services.ServiceTransaksi;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Transaksi extends Form {

    public Transaksi() {
        initComponents();
        table1.addTableStyle(jScrollPane1);
        initTable();
    }
    public void initTable(){
        table1.addTableCell(new CellActionTrx(),9);
        new Thread(new Runnable() {
            @Override
            public void run() {
                table1.removeAllRows();
                try {
                    table1.removeAllRows();
                    for (ModelTransaksi trx: new ServiceTransaksi().getTransaksi()) {
                        table1.addRow(trx, false); 
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
        jLabel1 = new javax.swing.JLabel();
        serch = new com.app.swing.TextField();

        roundPanel1.setBackground(new java.awt.Color(60, 60, 60));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Kode Pesanan", "Customer ID", "Tipe Transaksi", "Sub Total", "DP", "Total Bayar", "Tanggal", "Status Transaksi", "Action"
            }
        ));
        jScrollPane1.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(0).setMinWidth(30);
            table1.getColumnModel().getColumn(0).setPreferredWidth(30);
            table1.getColumnModel().getColumn(0).setMaxWidth(30);
            table1.getColumnModel().getColumn(1).setPreferredWidth(50);
            table1.getColumnModel().getColumn(4).setPreferredWidth(30);
            table1.getColumnModel().getColumn(5).setPreferredWidth(30);
            table1.getColumnModel().getColumn(6).setPreferredWidth(30);
            table1.getColumnModel().getColumn(7).setPreferredWidth(30);
            table1.getColumnModel().getColumn(9).setPreferredWidth(10);
        }

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Daftar Transaksi");

        serch.setBackground(new java.awt.Color(60, 60, 60));
        serch.setForeground(new java.awt.Color(242, 242, 242));
        serch.setLabelText("Search");
        serch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                serchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 843, Short.MAX_VALUE)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(serch, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(serch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void serchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serchKeyReleased
        // TODO add your handling code here:
        table1.stopCellEditing();
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table1.getModel());
        String value = serch.getText();
        String result = value.substring(0, 1).toUpperCase() + value.substring(1);
        sorter.setRowFilter(RowFilter.regexFilter(result));
        table1.setRowSorter(sorter);
        table1.autoRowHeight();
    }//GEN-LAST:event_serchKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.app.swing.RoundPanel roundPanel1;
    private com.app.swing.TextField serch;
    private com.app.swing.table.Table table1;
    // End of variables declaration//GEN-END:variables
}
