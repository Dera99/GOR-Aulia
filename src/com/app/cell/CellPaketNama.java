package com.app.cell;

import com.app.main.Main;
import com.app.model.ModelPaket;
import com.app.service.ServicePaket;
import com.app.swing.table.TableCustom;
import com.app.swing.table.TableCustomCell;
import com.app.swing.table.TableRowData;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Time;
import javaswingdev.GoogleMaterialDesignIcon;
import javaswingdev.GoogleMaterialIcon;
import notification.Notification;

public class CellPaketNama extends TableCustomCell {
    public CellPaketNama() {
        initComponents();
    }
    boolean member = false;
    int id,harga,paketID;
    String nama;
    Time durasi;
    public void addEventSave(TableCustom table) {
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                table.stopCellEditing();
                Main m = new Main();
                Notification err= new Notification(m, Notification.Type.ERROR, Notification.Location.TOP_CENTER, "Paket Sewa Gagal Di Tambahkan !!");
                Notification succ= new Notification(m, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Paket Sewa Berhasil Di Tambahkan !!");
                Notification err1= new Notification(m, Notification.Type.ERROR, Notification.Location.TOP_CENTER, "Paket Sewa Gagal Di Update !!");
                Notification succ1= new Notification(m, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Paket Sewa Berhasil Di Update !!");
                Notification errNumber= new Notification(m, Notification.Type.ERROR, Notification.Location.TOP_CENTER, "Input Harga Tidak Sesuai !!");
            try{  
                int row = getRow();
                int col = getColumn();
                String base = (String) table.getValueAt(row,0);
                String replace = base.replace("R", "");
                if(!base.contains("R")){
                 replace = base.replace("M", "");
                }
                paketID = Integer.parseInt(replace);
                nama = table.getValueAt(row,1).toString();
                String price = table.getValueAt(row,2).toString();
                String result = price.replace("Rp ", "");
                harga = Integer.parseInt(result);
                String str = table.getValueAt(row,3).toString();
                String[] arrOfStr = str.split(":", 2);
                for (String a : arrOfStr)
                durasi = new Time(Integer.parseInt(arrOfStr[0]),Integer.parseInt(arrOfStr[1]),0);
                member = Boolean.parseBoolean(table.getValueAt(row,4).toString());
                System.out.println("Member = "+member);
                ModelPaket data = new ModelPaket(paketID,nama,harga,durasi,member);
                if (data.getPaketID() == 0) {
                    try {
                        //  Insert
                     new ServicePaket().insertPaket(data);
                     table.updateModelData(row, data);
                     succ.showNotification();
                    } catch (SQLException ex) {
                        System.err.println(ex);
                        err.showNotification();
                    }
                } else {
                    try {
                        //                        //  Update
                        new ServicePaket().updatePaket(data);
                        table.updateModelData(row, data);
                        succ1.showNotification();
                    } catch (SQLException ex) {
                        System.err.println(ex);
                        err1.showNotification();
                    }
                      
                }
            }catch (NumberFormatException ex) {
                        System.err.println(ex);
                        errNumber.showNotification();
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
        jLabel1.setText("Nama Paket");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 70, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void setData(Object o) {
        txt.setText(o.toString().trim());
    }

    @Override
    public Object getData() {
        String paketName = txt.getText().trim();        
        return paketName;
    }
    

  
    @Override
    public TableCustomCell createComponentCellEditor(TableCustom tc, TableRowData trd, Object o, int i, int i1) {
        CellPaketNama cell = new CellPaketNama();
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
