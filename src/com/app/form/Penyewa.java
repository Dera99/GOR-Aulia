package com.app.form;

import com.app.cell.CellActionCustomer;
import com.app.cell.CellCustomerEmail;
import com.app.cell.CellCustomerNama;
import com.app.cell.CellCustomerTelp;
import com.app.cell.CellCustomerType;
import com.app.component.Form;
import com.app.model.ModelCustomer;
import com.app.services.ServiceCustomer;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.GoogleMaterialDesignIcon;
import javaswingdev.GoogleMaterialIcon;

public class Penyewa extends Form {
    public Penyewa() {
        initComponents();
        table1.addTableStyle(jScrollPane1);
        table2.addTableStyle(jScrollPane2);
        init();
    }
    private void init(){
      table1.addTableCell(new CellCustomerNama(),2);
      table1.addTableCell(new CellCustomerTelp(),3);
      table1.addTableCell(new CellCustomerEmail(),4);
      table1.addTableCell(new CellCustomerType(),5);
      table1.addTableCell(new CellActionCustomer(),7);
        new Thread(new Runnable() {
            @Override
            public void run() {
                table1.removeAllRows();
                try {
                    table1.removeAllRows();
                    for (ModelCustomer data: new ServiceCustomer().getCustomer("Reguler")) {
                        table1.addRow(data, false); 
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
                    System.err.println(ex);
                }
                
            }   
        }).start();
      table2.addTableCell(new CellCustomerNama(),2);
      table2.addTableCell(new CellCustomerTelp(),3);
      table2.addTableCell(new CellCustomerEmail(),4);
      table2.addTableCell(new CellCustomerType(),5);
      table2.addTableCell(new CellActionCustomer(),7);
        new Thread(new Runnable() {
            @Override
            public void run() {
                table2.removeAllRows();
                try {
                    table2.removeAllRows();
                    for (ModelCustomer data: new ServiceCustomer().getCustomer("Member")) {
                        table2.addRow(data, false); 
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
        roundPanel2 = new com.app.swing.RoundPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new com.app.swing.table.Table();
        jLabel2 = new javax.swing.JLabel();
        btnPrint = new com.app.swing.Button();
        serch = new com.app.swing.TextField();

        roundPanel1.setBackground(new java.awt.Color(60, 60, 60));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Customer ID", "Nama", "No Telp", "Email", "Tipe Customer", "Terakhir Aktif", "Action"
            }
        ));
        jScrollPane1.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(0).setPreferredWidth(10);
            table1.getColumnModel().getColumn(7).setPreferredWidth(10);
        }

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Penyewa Reguler");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addContainerGap())
        );

        roundPanel2.setBackground(new java.awt.Color(60, 60, 60));

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Customer ID", "Nama", "No Telp", "Email", "Tipe Customer", "Terakhir Aktif", "Action"
            }
        ));
        table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                table2MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(table2);
        if (table2.getColumnModel().getColumnCount() > 0) {
            table2.getColumnModel().getColumn(0).setPreferredWidth(10);
            table2.getColumnModel().getColumn(7).setPreferredWidth(10);
        }

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Penyewa Member");

        btnPrint.setBackground(new java.awt.Color(51, 149, 225));
        btnPrint.setForeground(new java.awt.Color(240, 240, 240));
        btnPrint.setText("Cetak");
        btnPrint.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnPrint.setPreferredSize(new java.awt.Dimension(43, 27));
        ;
        GoogleMaterialIcon icn = new GoogleMaterialIcon();
        icn.setIcon(GoogleMaterialDesignIcon.PRINT);
        icn.setColor1(Color.white);
        icn.setColor2(Color.white);
        btnPrint.setIcon(icn.toIcon());

        serch.setBackground(new java.awt.Color(60, 60, 60));
        serch.setForeground(new java.awt.Color(242, 242, 242));
        serch.setLabelText("Search");

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(serch, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(serch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnPrint.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void table2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseReleased
        // TODO add your handling code here:
        btnPrint.setVisible(true);
    }//GEN-LAST:event_table2MouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.swing.Button btnPrint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.app.swing.RoundPanel roundPanel1;
    private com.app.swing.RoundPanel roundPanel2;
    private com.app.swing.TextField serch;
    private com.app.swing.table.Table table1;
    private com.app.swing.table.Table table2;
    // End of variables declaration//GEN-END:variables
}
