package com.app.form;

import com.app.cell.CellActionCustomer;
import com.app.cell.CellCustomerNama;
import com.app.cell.CellCustomerType;
import com.app.cell.CellTextEmail;
import com.app.cell.CellTextTelp;
import com.app.component.Form;
import com.app.model.ModelCustomer;
import com.app.services.ServiceCustomer;
import com.app.services.ServiceReport;
import com.app.swing.table.TableRowData;
import java.awt.Color;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.GoogleMaterialDesignIcon;
import javaswingdev.GoogleMaterialIcon;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Penyewa extends Form {
    public Penyewa() {
        initComponents();
        table1.addTableStyle(jScrollPane1);
        table1.setAnimateRowHeight(130);
        table2.addTableStyle(jScrollPane2);
        table2.setAnimateRowHeight(130);
        init();
    }
    int customerID;
    private void init(){
      table1.addTableCell(new CellCustomerNama(),2);
      table1.addTableCell(new CellTextTelp(),3);
      table1.addTableCell(new CellTextEmail(),4);
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
      table2.addTableCell(new CellTextTelp(),3);
      table2.addTableCell(new CellTextEmail(),4);
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
        serch1 = new com.app.swing.TextField();
        roundPanel2 = new com.app.swing.RoundPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new com.app.swing.table.Table();
        jLabel2 = new javax.swing.JLabel();
        btnPrint = new com.app.swing.Button();
        serch2 = new com.app.swing.TextField();
        btnAdd = new com.app.swing.Button();

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
            table1.getColumnModel().getColumn(0).setMinWidth(50);
            table1.getColumnModel().getColumn(0).setMaxWidth(50);
            table1.getColumnModel().getColumn(1).setPreferredWidth(10);
            table1.getColumnModel().getColumn(2).setPreferredWidth(100);
            table1.getColumnModel().getColumn(3).setPreferredWidth(100);
            table1.getColumnModel().getColumn(4).setPreferredWidth(100);
            table1.getColumnModel().getColumn(6).setPreferredWidth(20);
            table1.getColumnModel().getColumn(7).setPreferredWidth(10);
        }

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Customer Reguler");

        serch1.setBackground(new java.awt.Color(60, 60, 60));
        serch1.setForeground(new java.awt.Color(242, 242, 242));
        serch1.setLabelText("Search");
        serch1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                serch1KeyReleased(evt);
            }
        });

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(serch1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            table2.getColumnModel().getColumn(0).setMinWidth(50);
            table2.getColumnModel().getColumn(0).setMaxWidth(50);
            table2.getColumnModel().getColumn(1).setPreferredWidth(10);
            table2.getColumnModel().getColumn(2).setPreferredWidth(100);
            table2.getColumnModel().getColumn(3).setPreferredWidth(100);
            table2.getColumnModel().getColumn(4).setPreferredWidth(100);
            table2.getColumnModel().getColumn(6).setPreferredWidth(20);
            table2.getColumnModel().getColumn(7).setPreferredWidth(10);
        }

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Customer Member");

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

        serch2.setBackground(new java.awt.Color(60, 60, 60));
        serch2.setForeground(new java.awt.Color(242, 242, 242));
        serch2.setLabelText("Search");
        serch2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                serch2KeyReleased(evt);
            }
        });

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

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(serch2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(serch2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
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
        int row = table2.getSelectedRow();
        TableRowData rowData = table2.getModelData(row);
        String id = (String) table2.getValueAt(row,1);
        String result = id.replace("M", "");
        customerID = Integer.parseInt(result);
        System.out.println("ID : "+customerID);
    }//GEN-LAST:event_table2MouseReleased

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Date date = new Date();
        ModelCustomer data = new ModelCustomer(0,"","","","Member");
        data.setTanggal(date);
        table2.insertRowWithEdit(data, 0, true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void serch2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serch2KeyReleased
        table2.stopCellEditing();
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table2.getModel());
        String value = serch2.getText();
        sorter.setRowFilter(RowFilter.regexFilter(value));
        table2.setRowSorter(sorter);
        table2.autoRowHeight();
    }//GEN-LAST:event_serch2KeyReleased

    private void serch1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serch1KeyReleased
        // TODO add your handling code here:
        table1.stopCellEditing();
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table1.getModel());
        String value = serch1.getText();
        sorter.setRowFilter(RowFilter.regexFilter(value));
        table1.setRowSorter(sorter);
        table1.autoRowHeight();
    }//GEN-LAST:event_serch1KeyReleased

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        try {
            // TODO add your handling code here:
            ServiceReport sr = new ServiceReport();
            sr.getMemberCard(customerID);
        } catch (SQLException ex) {
            Logger.getLogger(Penyewa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnPrintActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.swing.Button btnAdd;
    private com.app.swing.Button btnPrint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.app.swing.RoundPanel roundPanel1;
    private com.app.swing.RoundPanel roundPanel2;
    private com.app.swing.TextField serch1;
    private com.app.swing.TextField serch2;
    private com.app.swing.table.Table table1;
    private com.app.swing.table.Table table2;
    // End of variables declaration//GEN-END:variables
}
