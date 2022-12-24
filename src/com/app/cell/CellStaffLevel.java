package com.app.cell;

import com.app.model.ModelAccounts;
import com.app.model.ModelStaff;
import com.app.swing.table.TableCustom;
import com.app.swing.table.TableCustomCell;
import com.app.swing.table.TableRowData;

public class CellStaffLevel extends TableCustomCell {

    public CellStaffLevel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        cbLevel = new javax.swing.JComboBox<>();

        jLabel2.setForeground(new java.awt.Color(230, 230, 230));
        jLabel2.setText("Level");

        cbLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "STAFF", "ADMIN" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(cbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void setData(Object o) {
        cbLevel.setSelectedItem(o);
    }

    @Override
    public Object getData() {      
        return cbLevel.getSelectedItem();
    }

    @Override
    public TableCustomCell createComponentCellEditor(TableCustom tc, TableRowData trd, Object o, int i, int i1) {
        CellStaffLevel cell = new CellStaffLevel();
        cell.setData(o);
        return cell;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbLevel;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
