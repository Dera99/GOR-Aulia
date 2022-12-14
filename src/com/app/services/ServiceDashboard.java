package com.app.services;

import com.app.chart.ModelChart;
import com.app.configurations.DatabaseConnection;
import com.app.model.ModelDashboard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;

public class ServiceDashboard {
    ResultSet rs = null;
    Connection CC = new DatabaseConnection().connect();;
    PreparedStatement pst = null;
    Statement stt;
    String sql; 
    public List<ModelDashboard> getBooking(String stat) throws SQLException {
        List<ModelDashboard> list = new ArrayList<>();
        if(stat.equals("play")){
        sql = "select * from pesanan JOIN transaksi ON pesanan.IdPesanan = transaksi.IdPesanan JOIN customer ON customer.IdCustomer = pesanan.IdCustomer JOIN Lapangan ON Lapangan.IdLapangan = pesanan.IdLapangan JOIN sewa ON sewa.IdSewa = pesanan.IdSewa WHERE Request_Date > CURDATE() AND Status='Ongoing' OR Status ='Menunggu Antrian'";
        }else{
        sql = "select * from pesanan JOIN customer ON customer.IdCustomer = pesanan.IdCustomer JOIN Lapangan ON Lapangan.IdLapangan = pesanan.IdLapangan JOIN sewa ON sewa.IdSewa = pesanan.IdSewa WHERE Request_Date > CURDATE() AND Status='"+stat+"'";
        }
        pst = CC.prepareStatement(sql);
        rs = pst.executeQuery();
        while (rs.next()) {
            int bookingID = rs.getInt("IdPesanan");
            String nama = rs.getString("Nama");
            String noTelp = rs.getString("NoTelp");
            String Lapangan = rs.getString("NamaLapangan");
            Timestamp request = rs.getTimestamp("Request_Date");
            Timestamp expired = rs.getTimestamp("Expired");
            Time durasi = rs.getTime("Durasi");
            String paket = rs.getString("NamaSewa");
            String status = rs.getString("pesanan.Status");
            list.add(new ModelDashboard(bookingID,nama,noTelp,Lapangan,request,expired,paket,status));
        }
        rs.close();
        pst.close();
        return list;
    }
    public List<ModelChart> getDataChart() throws SQLException {
        List<ModelChart> list = new ArrayList<>();
        String sql = "SELECT DATE_FORMAT(Tanggal,'%M') as M, SUM(IF(IdTipeTrx=1, Subtotal, 0)) as Subtotal1, SUM(IF(IdTipeTrx=2, Subtotal, 0)) as Subtotal2 FROM Transaksi WHERE StatusTransaksi='Selesai' GROUP BY DATE_FORMAT(Tanggal,'%Y-%M') ORDER BY Tanggal DESC LIMIT 6";
        pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        rs = pst.executeQuery();
        while (rs.next()) {
            String month = rs.getString(1);
            double total = rs.getDouble(2);
            double total2 = rs.getDouble(3);
            list.add(new ModelChart(month, new double[]{total,total2}));
        }
        rs.close();
        pst.close();
        return list;
    }
    public String getPasanan() throws SQLException{
        sql="SELECT COUNT(*) as JumlahPesanan FROM pesanan WHERE DATE(Request_Date) = CURDATE()";
        pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        rs = pst.executeQuery();
        int total=0;
        while (rs.next()) {
            total = rs.getInt(1);
        }
        rs.close();
        pst.close();
        return String.valueOf(total);
    }
    public String getIncome() throws SQLException{
        sql="SELECT SUM(CASE WHEN StatusTransaksi = 'Pending' THEN DP ELSE DP + GrandTotal END) as Total FROM transaksi WHERE DATE(Tanggal) = CURDATE()";
        pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        rs = pst.executeQuery();
        DecimalFormat kursIndonesia = new DecimalFormat("#,##0");
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        double total=0;
        while (rs.next()) {
            total = rs.getInt(1);
        }
        rs.close();
        pst.close();
        return kursIndonesia.format(total);
    }
    public String getActiveMember() throws SQLException{
        sql="SELECT COUNT(*) as JumlahMember FROM customer WHERE Keterangan = 'Member' AND DATE_FORMAT(LastOrder, '%Y-%m') = DATE_FORMAT(CURDATE(), '%Y-%m')";
        pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        rs = pst.executeQuery();
        int total=0;
        while (rs.next()) {
            total = rs.getInt(1);
        }
        rs.close();
        pst.close();
        return String.valueOf(total);
    }
    public void updatePlay(ModelDashboard data) throws SQLException{
        sql="update Pesanan set Status = ? where IdPesanan="+data.getIdPesanan()+" limit 1";
        pst = CC.prepareStatement(sql);
            pst.setString(1, data.getStatus());
        pst.execute();
        pst.close();
    }
    
}
