package com.app.form;

import com.app.cell.CellActionLapangan;
import com.app.cell.CellActionPaket;
import com.app.cell.CellJenisSewa;
import com.app.cell.CellPaketDurasi;
import com.app.cell.CellPaketHarga;
import com.app.cell.CellPaketNama;
import com.app.cell.CellPaketType;
import com.app.component.Form;
import com.app.main.Main;
import com.app.model.ModelLapangan;
import com.app.model.ModelPaket;
import com.app.services.ServicePaket;
import com.app.services.UserSession;
import java.awt.Color;
import java.sql.SQLException;
import java.sql.Time;
import javaswingdev.GoogleMaterialDesignIcon;
import javaswingdev.GoogleMaterialIcon;

public class PaketSewa extends Form {

    public PaketSewa() {
        initComponents();
        table1.addTableStyle(jScrollPane1);
        table2.addTableStyle(jScrollPane2);
        int roleID = UserSession.getRoleId();
        if(roleID==0){
            btnAdd.setVisible(false);
            btnAdd1.setVisible(false);
        }else{
            btnAdd.setVisible(true);
            btnAdd1.setVisible(true);
        }
        initTable();
    }
    Main m = new Main();
    private void initTable(){
        table1.addTableCell(new CellPaketNama(),1);
        table1.addTableCell(new CellPaketHarga(),2);
        table1.addTableCell(new CellPaketDurasi(),3);
        table1.addTableCell(new CellPaketType(),4);
        table1.addTableCell(new CellActionPaket(),5);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    table1.removeAllRows();
                    for (ModelPaket paket: new ServicePaket().getPaket()) {
                        table1.addRow(paket, false);
                    }
                } catch (SQLException e) {
                    System.err.println(e);
                } 
                
            }   
        }).start();
        table2.addTableCell(new CellJenisSewa(),1);
        table2.addTableCell(new CellActionLapangan(),2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    table2.removeAllRows();
                    for (ModelLapangan field: new ServicePaket().getField()) {
                        table2.addRow(field, false);
                    }
                } catch (SQLException e) {
                    System.err.println(e);
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
        btnAdd = new com.app.swing.Button();
        roundPanel2 = new com.app.swing.RoundPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new com.app.swing.table.Table();
        jLabel2 = new javax.swing.JLabel();
        btnAdd1 = new com.app.swing.Button();

        roundPanel1.setBackground(new java.awt.Color(60, 60, 60));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Paket ID", "Nama Paket", "Harga", "Durasi (Jam)", "Paket Type", "Action"
            }
        ));
        jScrollPane1.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(0).setPreferredWidth(10);
            table1.getColumnModel().getColumn(5).setMinWidth(80);
            table1.getColumnModel().getColumn(5).setPreferredWidth(80);
            table1.getColumnModel().getColumn(5).setMaxWidth(80);
        }

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Daftar Paket");

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addContainerGap())
        );

        roundPanel2.setBackground(new java.awt.Color(60, 60, 60));

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Jenis Sewa", "Action"
            }
        ));
        jScrollPane2.setViewportView(table2);
        if (table2.getColumnModel().getColumnCount() > 0) {
            table2.getColumnModel().getColumn(2).setMinWidth(80);
            table2.getColumnModel().getColumn(2).setPreferredWidth(80);
            table2.getColumnModel().getColumn(2).setMaxWidth(80);
        }

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Jenis Sewa");

        btnAdd1.setBackground(new java.awt.Color(51, 149, 225));
        btnAdd1.setForeground(new java.awt.Color(240, 240, 240));
        btnAdd1.setText("Add");
        btnAdd1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd1ActionPerformed(evt);
            }
        });
        GoogleMaterialIcon icon2 = new GoogleMaterialIcon();
        icon2.setIcon(GoogleMaterialDesignIcon.ADD_CIRCLE_OUTLINE);
        icon2.setColor1(Color.white);
        icon2.setColor2(Color.white);
        btnAdd1.setIcon(icon2.toIcon());

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
       Time base = new Time(1,0,0);
       table1.insertRowWithEdit(new ModelPaket(0,"",0,base,false), 0, true); 
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        // TODO add your handling code here:
        table2.insertRowWithEdit(new ModelLapangan(0,""), 0, true); 
    }//GEN-LAST:event_btnAdd1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.swing.Button btnAdd;
    private com.app.swing.Button btnAdd1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.app.swing.RoundPanel roundPanel1;
    private com.app.swing.RoundPanel roundPanel2;
    private com.app.swing.table.Table table1;
    private com.app.swing.table.Table table2;
    // End of variables declaration//GEN-END:variables
}
