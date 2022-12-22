package com.app.cell;

import com.app.swing.table.TableCustom;
import com.app.swing.table.TableCustomCell;
import com.app.swing.table.TableRowData;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.SpinnerNumberModel;

public class CellPaketDurasi extends TableCustomCell {

    public CellPaketDurasi() {
        initComponents();
        SpinnerNumberModel model = (SpinnerNumberModel) jam.getModel();
        model.setMinimum(0);
        model.setMaximum(100);
        model.setValue(0);


        SpinnerNumberModel model1 = (SpinnerNumberModel) jam1.getModel();
        model1.setMinimum(0);
        model1.setMaximum(100);
        model1.setValue(0);
        jam.setModel(model);
        jam1.setModel(model1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jam = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jam1 = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setForeground(new java.awt.Color(230, 230, 230));
        jLabel1.setText("Durasi (Jam)");

        jam.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jam.setName(""); // NOI18N

        jLabel3.setForeground(new java.awt.Color(230, 230, 230));
        jLabel3.setText("j        :");

        jam1.setName(""); // NOI18N

        jLabel2.setForeground(new java.awt.Color(230, 230, 230));
        jLabel2.setText("m");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jam1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jam1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void setData(Object o) {
        String str = o.toString();
        String[] arrOfStr = str.split(":", 2);
        for (String a : arrOfStr)
            jam.setValue(Integer.valueOf(arrOfStr[0]));
            jam1.setValue(Integer.valueOf(arrOfStr[1]));
    }

    @Override
    public Object getData() { 
        Object a;
        int hour = (int) jam.getValue();
        int minute = (int) jam1.getValue();
        DateFormat sdf = new SimpleDateFormat("h:mm");
        Time value = new Time(hour,minute,0);
        a = sdf.format(value);
        return a;
    }

    @Override
    public TableCustomCell createComponentCellEditor(TableCustom tc, TableRowData trd, Object o, int i, int i1) {
        CellPaketDurasi cell = new CellPaketDurasi();
        cell.setData(o);
        return cell;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSpinner jam;
    private javax.swing.JSpinner jam1;
    // End of variables declaration//GEN-END:variables
}
