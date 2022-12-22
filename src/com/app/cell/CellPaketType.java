package com.app.cell;

import com.app.model.ModelPaket;
import com.app.swing.table.TableCustom;
import com.app.swing.table.TableCustomCell;
import com.app.swing.table.TableRowData;
import java.awt.Component;

public class CellPaketType extends TableCustomCell {
    public CellPaketType() {
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt = new javax.swing.JCheckBox();

        txt.setForeground(new java.awt.Color(230, 230, 230));
        txt.setText("Member");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(txt)
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox txt;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setData(Object data) {
        System.out.println("data "+data);
       if (data != null) {
            ModelPaket d = (ModelPaket) data;
            txt.setSelected(d.isMember());
        }
    }    
    @Override
    public Object getData() {
        return txt.isSelected();
    }

    @Override
    public TableCustomCell createComponentCellEditor(TableCustom table, TableRowData data, Object cellData, int row, int column) {
        CellPaketType cell = new CellPaketType();
        cell.setData(data);
        return cell;
    }
}
