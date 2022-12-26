package com.app.form;

import com.app.chart.ModelChart;
import com.app.services.ServiceDashboard;
import java.awt.Color;
import java.sql.SQLException;
import java.util.List;
import com.app.component.Form;
import com.app.model.ModelCard;
import javaswingdev.GoogleMaterialDesignIcon;

public class FormHome extends Form {

    public FormHome() {
        initComponents();
        setOpaque(false);
        //table1.addTableStyle(jScrollPane1);
        //table1.setAnimateRowHeight(150);
        init();
        //initDataTable();
    }

    private void init() {
        chart.addLegend("Customer Reguler", new Color(12, 84, 175), new Color(0, 108, 247));
        chart.addLegend("Customer Member", new Color(5, 125, 0), new Color(95, 209, 69));
        // card
        card1.setData(new ModelCard(null, null, null, "50", "Pesanan Hari Ini"));
        card2.setData(new ModelCard(GoogleMaterialDesignIcon.ATTACH_MONEY, null, null, "Rp 50.000", "Pemasukan Hari Ini"));
        card3.setData(new ModelCard(GoogleMaterialDesignIcon.GROUP, null, null, "50", "Member Aktif Hari Ini"));
        try {
            List<ModelChart> datas = new ServiceDashboard().getDataChart();
            for (int i = datas.size() - 1; i >= 0; i--) {
                chart.addData(datas.get(i));
            }
            chart.start();
        } catch (SQLException e) {
            System.err.println(e);
        }
        

    }

    private void initDataTable() {
//        table1.addTableCell(new CellName(), 0);
//        table1.addTableCell(new CellGender(), 1);
//        table1.addTableCell(new CellAge(), 2);
//        table1.addTableCell(new CellAddress(), 3);
//        table1.addTableCell(new CellTel(), 4);
//        table1.addTableCell(new CellAction(), 5);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    for (ModelJadwal booking: new ServiceJadwal().getBooking()) {
//                        table1.addRow(booking, false);
//                    }
//                } catch (SQLException e) {
//                    System.err.println(e);
//                }
//            }
//        }).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.app.swing.RoundPanel();
        chart = new com.app.chart.CurveChart();
        roundPanel2 = new com.app.swing.RoundPanel();
        card1 = new com.app.swing.Card();
        card2 = new com.app.swing.Card();
        card3 = new com.app.swing.Card();
        jLabel1 = new javax.swing.JLabel();

        roundPanel1.setBackground(new java.awt.Color(60, 60, 60));

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
        );

        roundPanel2.setBackground(new java.awt.Color(60, 60, 60));

        card1.setBackground(new java.awt.Color(55, 55, 55));
        card1.setForeground(new java.awt.Color(255, 255, 255));
        card1.setColor1(new java.awt.Color(95, 211, 226));
        card1.setColor2(new java.awt.Color(54, 149, 255));
        card1.setDescription("Pesanan Hari Ini");
        card1.setIcon(javaswingdev.GoogleMaterialDesignIcon.BOOK);

        card2.setBackground(new java.awt.Color(55, 55, 55));
        card2.setForeground(new java.awt.Color(255, 255, 255));
        card2.setColor1(new java.awt.Color(95, 211, 226));
        card2.setColor2(new java.awt.Color(26, 166, 170));
        card2.setDescription("Pemasukan Hari Ini");
        card2.setDoubleBuffered(false);
        card2.setIcon(javaswingdev.GoogleMaterialDesignIcon.ATTACH_MONEY);

        card3.setBackground(new java.awt.Color(55, 55, 55));
        card3.setForeground(new java.awt.Color(255, 255, 255));
        card3.setColor1(new java.awt.Color(95, 243, 140));
        card3.setColor2(new java.awt.Color(3, 157, 27));
        card3.setDescription("Total Pesanan Hari Ini");
        card3.setIcon(javaswingdev.GoogleMaterialDesignIcon.BACKUP);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Jadwal Hari Ini");

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(card1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addGap(80, 80, 80)
                .addComponent(card2, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addGap(80, 80, 80)
                .addComponent(card3, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addGap(25, 25, 25))
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(card1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(card2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(card3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(244, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAddNewActionPerformed
        //table1.insertRowWithEdit(new ModePesanan(0, new ModelCustomer("", "", null, ""), "Male", 0, "", ""), 0, true);
    }//GEN-LAST:event_cmdAddNewActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.swing.Card card1;
    private com.app.swing.Card card2;
    private com.app.swing.Card card3;
    private com.app.chart.CurveChart chart;
    private javax.swing.JLabel jLabel1;
    private com.app.swing.RoundPanel roundPanel1;
    private com.app.swing.RoundPanel roundPanel2;
    // End of variables declaration//GEN-END:variables
}
