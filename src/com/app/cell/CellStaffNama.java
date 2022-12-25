package com.app.cell;

import com.app.main.Main;
import com.app.model.ModelAccounts;
import com.app.model.ModelCustomer;
import com.app.model.ModelStaff;
import com.app.services.ServiceCustomer;
import com.app.services.ServiceStaff;
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

public class CellStaffNama extends TableCustomCell {
    public CellStaffNama() {
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
                ModelStaff akun = (ModelStaff) table.getValueAt(row, 0);
                int userID = akun.getAccount().getUserID();
                System.out.println("USER ID "+userID);
                String nama = txtNama.getText();
                String alamat = txtAlamat.getText();
                String noTelp = txtTelp.getText();
                String email = (String) table.getValueAt(row, 1);
                String jabatan = (String) table.getValueAt(row, 2);
                String username = (String) table.getValueAt(row, 3);
                String level = (String) table.getValueAt(row, 4);
                int lvl = 0;
                if(level.equals("ADMIN")){
                    lvl=1;
                }
                ModelAccounts acc = new ModelAccounts(userID,username,"",lvl);
                ModelStaff data = new ModelStaff(staffID,nama,alamat,noTelp,email,jabatan);
                data.setAccount(acc);
                acc.setStaff(data);
                if (acc.getUserID()==0 && data.getStaffID()==0) {
                   try{
                     acc.setPassword(username);
                     new ServiceStaff().insertStaff(data);
                     table.updateModelData(row, data);
                     succ.showNotification();
                    } catch (SQLException e) {
                        e.printStackTrace();
                        err.showNotification();
                    }
                }else{
                    try {
                      //  Update
                     new ServiceStaff().updateStaff(data);
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

        btnUpdate = new com.app.swing.Button();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTelp = new javax.swing.JTextField();

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

        jLabel2.setForeground(new java.awt.Color(230, 230, 230));
        jLabel2.setText("Alamat       ");

        txtAlamat.setColumns(20);
        txtAlamat.setRows(5);
        jScrollPane1.setViewportView(txtAlamat);

        jLabel3.setForeground(new java.awt.Color(230, 230, 230));
        jLabel3.setText("Nama   ");

        jLabel4.setForeground(new java.awt.Color(230, 230, 230));
        jLabel4.setText("No Telp");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(txtTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

    int staffID=0,userID=0,roleID=0;
    String email,jabatan;
    @Override
    public void setData(Object o) { 
        System.out.println("Model "+o);
        if (o != null) {
            ModelStaff data = (ModelStaff)o;
            staffID = data.getStaffID();
            email=data.getEmail();
            jabatan=data.getJabatan();
            txtNama.setText(data.getNama());
            txtAlamat.setText(data.getAlamat());        
            txtTelp.setText(data.getNoTelp());
        }
        
    }

    @Override
    public Object getData() {
        String nama = txtNama.getText();
        String alamat = txtAlamat.getText();
        String telp = txtTelp.getText();
        ModelStaff data = new ModelStaff(staffID,nama,alamat,telp,email,jabatan);
        ModelAccounts acc = new ModelAccounts(userID,"","",0);
        data.setAccount(acc);
        return data;
    }
    

  
    @Override
    public TableCustomCell createComponentCellEditor(TableCustom tc, TableRowData trd, Object o, int i, int i1) {
        CellStaffNama cell = new CellStaffNama();
        cell.setData(o);
        cell.addEventSave(tc);
        return cell;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.swing.Button btnUpdate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtTelp;
    // End of variables declaration//GEN-END:variables
}
