package com.app.cell;

import com.app.form.Transaksi;
import com.app.main.Main;
import com.app.model.ModelDashboard;
import com.app.model.ModelTransaksi;
import com.app.services.ServiceDashboard;
import com.app.services.ServiceTransaksi;
import com.app.swing.table.TableCustom;
import com.app.swing.table.TableCustomCell;
import com.app.swing.table.TableRowData;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.GoogleMaterialDesignIcon;
import javaswingdev.GoogleMaterialIcon;
import javax.swing.JOptionPane;
import notification.Notification;

public class CellActionJadwal extends TableCustomCell {
    public CellActionJadwal()  {
        initComponents();
    }
    public void addEventSave(TableCustom table) {
       cmdPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.stopCellEditing();
                Main m = new Main();
                int row = getRow();
                ModelDashboard rows =  (ModelDashboard) table.getModelData(row);   
                int pesananID = rows.getIdPesanan();
                String nama = (String) table.getValueAt(row, 0);
                String noTelp = (String) table.getValueAt(row, 1);
                String field = (String) table.getValueAt(row, 2);
                String jamBooking = (String) table.getValueAt(row, 4);
                String[] parts = jamBooking.split(" - ");
                String waktuMulai = parts[0];
                String waktuSelesai = parts[1];
                // set Time Mulai
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(waktuMulai.split(":")[0]));
                calendar.set(Calendar.MINUTE, Integer.parseInt(waktuMulai.split(":")[1]));
                calendar.set(Calendar.SECOND, 0);
                Time jamMulai = new Time(calendar.getTimeInMillis());
                // set Time Selesai
                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(Calendar.HOUR_OF_DAY, Integer.parseInt(waktuSelesai.split(":")[0]));
                calendar1.set(Calendar.MINUTE, Integer.parseInt(waktuSelesai.split(":")[1]));
                calendar1.set(Calendar.SECOND, 0);
                Time jamSelesai = new Time(calendar1.getTimeInMillis());
                // set Model
                String paket = (String) table.getValueAt(row, 5);
                String status = "Ongoing";
                ModelDashboard data = new ModelDashboard(pesananID,nama,noTelp,field,jamMulai,jamSelesai,paket,status);
                //Notif
                Notification succ= new Notification(m, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Pesanan Berhasil di Mulai !!");
                Notification err= new Notification(m, Notification.Type.ERROR, Notification.Location.TOP_CENTER, "Pesanan Gagal di Mulai !!");
                //response
                int response = JOptionPane.showConfirmDialog(m, "Apakah Anda Yakin?", "Konfirmasi Pembayaran", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(response==JOptionPane.YES_OPTION){
                if (pesananID != 0) {
                    try {
                        new ServiceDashboard().updatePlay(data);
                        table.updateModelData(row, data);
                        table.setValueAt("Ongoing", row, 6);
                        succ.showNotification();
                    } catch (SQLException ex) {
                        System.err.println(ex);
                        err.showNotification();   
                    }
                 }
                }else if(response==JOptionPane.NO_OPTION){
                        System.err.println("Failed");
                }
            }
        });
       cmdStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.stopCellEditing();
                Main m = new Main();
                int row = getRow();
                ModelDashboard rows =  (ModelDashboard) table.getModelData(row);   
                int pesananID = rows.getIdPesanan();
                String nama = (String) table.getValueAt(row, 0);
                String noTelp = (String) table.getValueAt(row, 1);
                String field = (String) table.getValueAt(row, 2);
                String jamBooking = (String) table.getValueAt(row, 4);
                String[] parts = jamBooking.split(" - ");
                String waktuMulai = parts[0];
                String waktuSelesai = parts[1];
                // set Time Mulai
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(waktuMulai.split(":")[0]));
                calendar.set(Calendar.MINUTE, Integer.parseInt(waktuMulai.split(":")[1]));
                calendar.set(Calendar.SECOND, 0);
                Time jamMulai = new Time(calendar.getTimeInMillis());
                // set Time Selesai
                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(Calendar.HOUR_OF_DAY, Integer.parseInt(waktuSelesai.split(":")[0]));
                calendar1.set(Calendar.MINUTE, Integer.parseInt(waktuSelesai.split(":")[1]));
                calendar1.set(Calendar.SECOND, 0);
                Time jamSelesai = new Time(calendar1.getTimeInMillis());
                // set Model
                String paket = (String) table.getValueAt(row, 5);
                String status = "Selesai";
                ModelDashboard data = new ModelDashboard(pesananID,nama,noTelp,field,jamMulai,jamSelesai,paket,status);
                //Notif
                Notification succ= new Notification(m, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Pesanan Selesai !!");
                Notification err= new Notification(m, Notification.Type.ERROR, Notification.Location.TOP_CENTER, "Pesanan Gagal di Update!!");
                //response
                int response = JOptionPane.showConfirmDialog(m, "Apakah Anda Yakin?", "Konfirmasi Pembayaran", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(response==JOptionPane.YES_OPTION){
                if (pesananID != 0) {
                    try {
                        new ServiceDashboard().updatePlay(data);
                        table.updateModelData(row, data);
                        table.setValueAt("Selesai", row, 6);
                        succ.showNotification();
                    } catch (SQLException ex) {
                        System.err.println(ex);
                        err.showNotification();   
                    }
                 }
                }else if(response==JOptionPane.NO_OPTION){
                        System.err.println("Failed");
                }
            }
        });
    }
    private void checkIcon(TableRowData data) {
      String status = ((ModelDashboard) data).getStatus();
      if(status.equals("Menunggu Antrian")){
          cmdPlay.setVisible(true);
          cmdPlay.setEnabled(true);
          cmdStop.setVisible(false);
          cmdStop.setEnabled(false);
      }else if(status.equals("Ongoing")){
          cmdStop.setVisible(true);
          cmdStop.setEnabled(true);
          cmdPlay.setVisible(false);
          cmdPlay.setEnabled(false);
      }else{
          cmdStop.setVisible(false);
          cmdStop.setEnabled(false);
          cmdPlay.setVisible(false);
          cmdPlay.setEnabled(false);
      }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdPlay = new com.app.swing.Button();
        cmdStop = new com.app.swing.Button();

        cmdPlay.setBackground(new Color(0,0,0,0));

        cmdStop.setBackground(new Color(0,0,0,0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cmdPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdStop, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdStop, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(cmdPlay, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
        );

        GoogleMaterialIcon googleIcon = new GoogleMaterialIcon();
        googleIcon.setIcon(GoogleMaterialDesignIcon.PLAY_CIRCLE_FILLED);
        googleIcon.setColor1(new Color(50,200,126));
        googleIcon.setColor2(new Color(50,200,126));
        googleIcon.setSize(25);
        cmdPlay.setIcon(googleIcon.toIcon());
        GoogleMaterialIcon googleIcon1 = new GoogleMaterialIcon();
        googleIcon1.setIcon(GoogleMaterialDesignIcon.STOP_CIRCLE);
        googleIcon1.setColor1(new Color(253,83,63));
        googleIcon1.setColor2(new Color(253,83,63));
        googleIcon1.setSize(25);
        cmdStop.setIcon(googleIcon1.toIcon());
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void setData(Object o) {
    }

    @Override
    public Object getData() {
        return null;
    }

    @Override
    public Component createComponentCellRender(TableCustom table, TableRowData data, int row, int column) {
        CellActionJadwal cell = new CellActionJadwal();
        cell.checkIcon(data);
        cell.addEventSave(table);
        return cell;
    }

    @Override
    public Component createComponentCellRenderOnEditor(TableCustom table, TableRowData data, int row, int column) {
        return null;
    }

    @Override
    public TableCustomCell createComponentCellEditor(TableCustom table, TableRowData data, Object o, int row, int column) {
        CellActionJadwal cell = new CellActionJadwal();
        cell.checkIcon(data);
        cell.addEventSave(table);
        return cell;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.swing.Button cmdPlay;
    private com.app.swing.Button cmdStop;
    // End of variables declaration//GEN-END:variables

     
}
