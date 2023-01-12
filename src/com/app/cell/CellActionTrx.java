package com.app.cell;

import com.app.form.Transaksi;
import com.app.main.Main;
import com.app.model.ModelTransaksi;
import com.app.services.ServiceTransaksi;
import com.app.swing.table.TableCustom;
import com.app.swing.table.TableCustomCell;
import com.app.swing.table.TableRowData;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.GoogleMaterialDesignIcon;
import javaswingdev.GoogleMaterialIcon;
import javax.swing.JOptionPane;
import notification.Notification;

public class CellActionTrx extends TableCustomCell {
    public CellActionTrx()  {
        initComponents();
    }
    public void addEventSave(TableCustom table) {
       cmdPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.stopCellEditing();
                Main m = new Main();
                int row = getRow();
                ModelTransaksi rows =  (ModelTransaksi) table.getModelData(row);   
                int trxID = rows.getTrxID();
                int pesananID = rows.getPesananID();
                String status = "Selesai";
                ModelTransaksi data = new ModelTransaksi(rows.getTrxID(),rows.getPesananID(),rows.getSubTotal(),rows.getDP(),rows.getGrandTotal(),null,status);
                Notification succ= new Notification(m, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Transaksi Berhasil di Update!!");
                Notification err= new Notification(m, Notification.Type.ERROR, Notification.Location.TOP_CENTER, "Transaksi Gagal di Update!!");
                int response = JOptionPane.showConfirmDialog(m, "Apakah Anda Yakin?", "Konfirmasi Pembayaran", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(response==JOptionPane.YES_OPTION){
                if (trxID != 0) {
                    try {
                        new ServiceTransaksi().updateTrx(data);
                        table.updateModelData(row, data);
                        table.setValueAt(status, row, 8);
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
      String status = ((ModelTransaksi) data).getStatus();
      if(status.equals("Pending")){
          cmdPayment.setVisible(true);
          cmdPayment.setEnabled(true);
      }else{
          cmdPayment.setVisible(false);
          cmdPayment.setEnabled(false);
      }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdPayment = new com.app.swing.Button();

        cmdPayment.setBackground(new Color(0,0,0,0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cmdPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdPayment, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        GoogleMaterialIcon googleIcon = new GoogleMaterialIcon();
        googleIcon.setIcon(GoogleMaterialDesignIcon.PAYMENTS);
        googleIcon.setColor1(new Color(50,200,126));
        googleIcon.setColor2(new Color(50,200,126));
        googleIcon.setSize(22);
        cmdPayment.setIcon(googleIcon.toIcon());
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
        CellActionTrx cell = new CellActionTrx();
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
        CellActionTrx cell = new CellActionTrx();
        cell.checkIcon(data);
        cell.addEventSave(table);
        return cell;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.swing.Button cmdPayment;
    // End of variables declaration//GEN-END:variables

     
}
