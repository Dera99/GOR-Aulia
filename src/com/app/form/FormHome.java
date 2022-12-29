package com.app.form;

import com.app.cell.CellActionJadwal;
import com.app.chart.ModelChart;
import com.app.services.ServiceDashboard;
import java.awt.Color;
import java.sql.SQLException;
import java.util.List;
import com.app.component.Form;
import com.app.model.ModelCard;
import com.app.model.ModelDashboard;
import javaswingdev.GoogleMaterialDesignIcon;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class FormHome extends Form {

    public FormHome() {
        initComponents();
        //table1.setAnimateRowHeight(150);
        init();
        initDataTable();
    }

    private void init() {
        ServiceDashboard sd = new ServiceDashboard();
        table1.addTableStyle(jScrollPane1);
        table2.addTableStyle(jScrollPane2);
       try {
        chart.addLegend("Reguler", new Color(12, 84, 175), new Color(0, 108, 247));
        chart.addLegend("Member", new Color(5, 125, 0), new Color(95, 209, 69));
        // card
        card1.setData(new ModelCard(null, null, null, sd.getPasanan(), "Pesanan Hari Ini"));
        card2.setData(new ModelCard(GoogleMaterialDesignIcon.PAYMENTS, null, null, "Rp "+sd.getIncome(), "Income Hari Ini"));
        card3.setData(new ModelCard(GoogleMaterialDesignIcon.GROUP, null, null, sd.getActiveMember(), "Member Aktif Bulan Ini"));
     
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
        table1.addTableCell(new CellActionJadwal(), 7);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (ModelDashboard booking: new ServiceDashboard().getBooking("play")) {
                        table1.addRow(booking, false);
                    }
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (ModelDashboard booking: new ServiceDashboard().getBooking("selesai")) {
                        table2.addRow(booking, false);
                    }
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        }).start();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.app.swing.table.Table();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new com.app.swing.table.Table();
        jLabel2 = new javax.swing.JLabel();
        serch1 = new com.app.swing.TextField();

        roundPanel1.setBackground(new java.awt.Color(60, 60, 60));

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        card2.setDescription("Income Hari Ini");
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

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Penyewa", "No Telp", "Lapangan", "Tanggal", "Jam Mulai", "Paket", "Status", "Action"
            }
        ));
        jScrollPane1.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(7).setPreferredWidth(5);
        }

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Penyewa", "No Telp", "Lapangan", "Tanggal", "Jam Mulai", "Paket", "Status"
            }
        ));
        jScrollPane2.setViewportView(table2);

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Pesanan Selesai");

        serch1.setBackground(new java.awt.Color(60, 60, 60));
        serch1.setForeground(new java.awt.Color(242, 242, 242));
        serch1.setLabelText("Search");
        serch1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                serch1KeyReleased(evt);
            }
        });

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
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(serch1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(card1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(card2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(card3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(serch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void serch1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serch1KeyReleased
        // TODO add your handling code here:
        table2.stopCellEditing();
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table2.getModel());
        String value = serch1.getText();
        sorter.setRowFilter(RowFilter.regexFilter(value));
        table2.setRowSorter(sorter);
        table2.autoRowHeight();
    }//GEN-LAST:event_serch1KeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.swing.Card card1;
    private com.app.swing.Card card2;
    private com.app.swing.Card card3;
    private com.app.chart.CurveChart chart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.app.swing.RoundPanel roundPanel1;
    private com.app.swing.RoundPanel roundPanel2;
    private com.app.swing.TextField serch1;
    private com.app.swing.table.Table table1;
    private com.app.swing.table.Table table2;
    // End of variables declaration//GEN-END:variables
}
