package com.app.cell;

import com.app.form.Pemesanan;
import com.app.main.Main;
import com.app.model.ModelBooking;
import com.app.model.ModelCell;
import com.app.services.ServiceBooking;
import com.app.services.ServiceCellBooking;
import com.app.swing.table.TableCustom;
import com.app.swing.table.TableCustomCell;
import com.app.swing.table.TableRowData;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JOptionPane;

public class CellActionBooking extends TableCustomCell {
    public CellActionBooking()  {
        initComponents();
    }
    private void addEvent(TableCustom table, TableRowData data, int row) {
        cmdDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int response = JOptionPane.showConfirmDialog(Main.getJFram(), "Apakah Anda Yakin?", "Konfirmasi Hapus Data", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(response==JOptionPane.YES_OPTION){
                    int bookedID = ((ModelBooking) data).getId();
                    System.out.println("booked ID" +bookedID);
                    if (bookedID != 0) {
                        try {
                            new ServiceBooking().deleteBooked(bookedID);
                            table.deleteRowAt(getRow(), true);
                        } catch (SQLException e) {
                            System.err.println(e);
                        }
                    } else {
                        table.deleteRowAt(getRow(), true);
                    }
                }else if(response==JOptionPane.NO_OPTION){
                        System.err.println("Failed");
                }
            }
        });
    }
  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdDelete = new com.app.swing.Button();

        cmdDelete.setBackground(new Color(0,0,0,0));
        cmdDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/icon/delete.png"))); // NOI18N
        cmdDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(cmdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdDeleteActionPerformed

    @Override
    public void setData(Object o) {
    }

    @Override
    public Object getData() {
        return null;
    }

    @Override
    public Component createComponentCellRender(TableCustom table, TableRowData data, int row, int column) {
        CellActionBooking cell = new CellActionBooking();
        cell.addEvent(table, data, row);
        return cell;
    }

    @Override
    public Component createComponentCellRenderOnEditor(TableCustom table, TableRowData data, int row, int column) {
        return null;
    }

    @Override
    public TableCustomCell createComponentCellEditor(TableCustom table, TableRowData data, Object o, int row, int column) {
        CellActionBooking cell = new CellActionBooking();
        cell.addEvent(table, data, row);
        return cell;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.swing.Button cmdDelete;
    // End of variables declaration//GEN-END:variables
}
