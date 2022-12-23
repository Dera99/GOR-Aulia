package com.app.cell;

import com.app.model.ModelCustomer;
import com.app.swing.table.TableCustom;
import com.app.swing.table.TableCustomCell;
import com.app.swing.table.TableRowData;

public class CellCustomerType extends TableCustomCell {
    public CellCustomerType() {
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
        
       if (data != null) {
            ModelCustomer d = (ModelCustomer) data;
            boolean result=false;
            if(d.getKet().equals("Member")){
                result=true;
            }
            txt.setSelected(result);
        }
    }    
    @Override
    public Object getData() {
        String result;
        if(txt.isSelected()==true){
            result="Member";
        }else{
            result = "Reguler";
        }
        return result;
    }

    @Override
    public TableCustomCell createComponentCellEditor(TableCustom table, TableRowData data, Object cellData, int row, int column) {
        CellCustomerType cell = new CellCustomerType();
        cell.setData(data);
        return cell;
    }
}
