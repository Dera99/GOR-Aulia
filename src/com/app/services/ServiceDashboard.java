package com.app.services;

import com.app.chart.ModelChart;
import com.app.configurations.DatabaseConnection;
import com.app.model.ModelCustomer;
import com.app.model.ModelDashboard;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ServiceDashboard {
    ResultSet rs = null;
    Connection CC = new DatabaseConnection().connect();;
    PreparedStatement pst = null;
    Statement stt;
    String sql; 
//    public void insertStaff(ModePesanan data) throws SQLException, IOException {
//        sql = "insert into staff(FirstName, LastName, Gender, Age, Email, Tel, Profile) values (?,?,?,?,?,?,?)";
//        pst = CC.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
//        pst.setString(1, data.getName().getFirstName());
//        pst.setString(2, data.getName().getLastName());
//        pst.setString(3, data.getGender());
//        pst.setInt(4, data.getAge());
//        pst.setString(5, data.getEmail());
//        pst.setString(6, data.getPhoneNumber());
//        if (data.getName().getPath().equals("")) {
//            pst.setObject(7, null);
//        } else {
//            pst.setBlob(7, Files.newInputStream(new File(data.getName().getPath()).toPath()));
//        }
//        pst.execute();
//        rs = pst.getGeneratedKeys();
//        rs.first();
//        int staffID = rs.getInt(1);
//        data.setStaffID(staffID);
//        rs.close();
//        pst.close();
//    }

//    public void updateStaff(ModePesanan data) throws SQLException, IOException {
//        if (data.getName().getPath().equals("Image")) {
//            //  User no update image
//            sql = "update staff set Firstname=?, LastName=?, Gender=?, Age=?, Email=?, Tel=? where StaffID=? limit 1";
//            pst = CC.prepareStatement(sql);
//            pst.setString(1, data.getName().getFirstName());
//            pst.setString(2, data.getName().getLastName());
//            pst.setString(3, data.getGender());
//            pst.setInt(4, data.getAge());
//            pst.setString(5, data.getEmail());
//            pst.setString(6, data.getPhoneNumber());
//            pst.setInt(7, data.getStaffID());
//            pst.execute();
//            pst.close();
//        } else {
//            //  User update image
//            sql = "update staff set Firstname=?, LastName=?, Gender=?, Age=?, Email=?, Tel=?, Profile=? where StaffID=? limit 1";
//            pst = CC.prepareStatement(sql);
//            pst.setString(1, data.getName().getFirstName());
//            pst.setString(2, data.getName().getLastName());
//            pst.setString(3, data.getGender());
//            pst.setInt(4, data.getAge());
//            pst.setString(5, data.getEmail());
//            pst.setString(6, data.getPhoneNumber());
//            if (data.getName().getPath().equals("")) {
//                pst.setObject(7, null);
//            } else {
//                pst.setBlob(7, Files.newInputStream(new File(data.getName().getPath()).toPath()));
//            }
//            pst.setInt(8, data.getStaffID());
//            pst.execute();
//            pst.close();
//        }
//    }

    public List<ModelDashboard> getBooking() throws SQLException {
        List<ModelDashboard> list = new ArrayList<>();
        sql = "select * from pesanan JOIN customer ON customer.IdCustomer = pesanan.IdCustomer JOIN Lapangan ON Lapangan.IdLapangan = pesanan.IdLapangan JOIN sewa ON sewa.IdSewa = pesanan.IdSewa"
                + "";
        pst = CC.prepareStatement(sql);
        rs = pst.executeQuery();
        while (rs.next()) {
            int bookingID = rs.getInt("IdPesanan");
            String nama = rs.getString("Nama");
            String noTelp = rs.getString("NoTelp");
            String Lapangan = rs.getString("NamaLapangan");
            Time request = rs.getTime("Request_Date");
            Time expired = rs.getTime("Expired");
            Time durasi = rs.getTime("Durasi");
            String status = rs.getString("pesanan.Status");
            list.add(new ModelDashboard(nama,noTelp,Lapangan,request,expired,durasi,status));
        }
        rs.close();
        pst.close();
        return list;
    }

    public void deleteStaff(int staffID) throws SQLException {
        sql = "delete from staff where StaffID=? limit 1";
        pst = CC.prepareStatement(sql);
        pst.setInt(1, staffID);
        pst.execute();
        pst.close();
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
        sql="SELECT SUM(Subtotal) as Total FROM transaksi WHERE DATE(Tanggal) = CURDATE() AND StatusTransaksi='Selesai';";
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
}
