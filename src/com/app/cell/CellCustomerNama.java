package com.app.cell;

import com.app.main.Main;
import com.app.model.ModelCustomer;
import com.app.services.ServiceCustomer;
import com.app.swing.table.TableCustom;
import com.app.swing.table.TableCustomCell;
import com.app.swing.table.TableRowData;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javaswingdev.GoogleMaterialDesignIcon;
import javaswingdev.GoogleMaterialIcon;
import notification.Notification;

public class CellCustomerNama extends TableCustomCell {
    public CellCustomerNama() {
        initComponents();
    }
    public void addEventSave(TableCustom table) {
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                table.stopCellEditing();
                Main m = new Main();
                Notification err= new Notification(m, Notification.Type.ERROR, Notification.Location.TOP_CENTER, "Data Customer Gagal Di Tambahkan !!");
                Notification succ= new Notification(m, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Data Customer Berhasil Di Tambahkan !!");
                Notification err1= new Notification(m, Notification.Type.ERROR, Notification.Location.TOP_CENTER, "Data Customer Gagal Di Update !!");
                Notification succ1= new Notification(m, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Data Customer Berhasil Di Update !!");
            try{  
                int row = getRow();
                int col = getColumn();
                String base = (String) table.getValueAt(row,1);
                String replace = base.replace("R", "");
                if(!base.contains("R")){
                 replace = base.replace("M", "");
                }
                int customerID = Integer.parseInt(replace);
                String nama = table.getValueAt(row,2).toString();
                String noTelp = table.getValueAt(row,3).toString();
                String email = table.getValueAt(row,4).toString();
                String member = (String) table.getValueAt(row, 5);
                System.out.println("is Member ? "+member);
                ModelCustomer data = new ModelCustomer(customerID,nama,noTelp,email,member);
                DateFormat sdf = new SimpleDateFormat("dd/MM/yy H:mm");
                String tanggal = (String) table.getValueAt(row, 6);
                data.setTanggal(sdf.parse(tanggal));
                if (data.getCustomerID()== 0) {
                   try{
                     new ServiceCustomer().insertCustomer(data);
                     table.updateModelData(row, data);
                     succ.showNotification();
                    } catch (SQLException e) {
                        e.printStackTrace();
                        err.showNotification();
                    }
                }else{
                    try {
                      //  Update
                     new ServiceCustomer().updateCustomer(data);
                     table.updateModelData(row, data);
                     succ1.showNotification();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        err1.showNotification();
                    }
                } 
            }catch (Exception ex) {
                ex.printStackTrace();
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
        jLabel1.setText("Nama");

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
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
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
        CellCustomerNama cell = new CellCustomerNama();
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
