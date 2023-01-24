package com.app.services;

import com.app.configurations.DatabaseConnection;
import com.app.main.Main;
import com.app.model.ModelCustomer;
import com.app.model.ModelTransaksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ServiceTransaksi {
    ResultSet rs = null;
    Connection CC = new DatabaseConnection().connect();;
    PreparedStatement pst = null;
    Statement stt;
    String sql; 
    Main M = new Main();
    public List<ModelTransaksi> getTransaksi() throws SQLException {
        List<ModelTransaksi> list = new ArrayList<>();
        SimpleDateFormat ex = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
        sql = "SELECT * FROM Transaksi JOIN Pesanan ON Pesanan.IdPesanan=Transaksi.IdPesanan JOIN customer ON Pesanan.IdCustomer = Customer.IdCustomer JOIN sewa ON Pesanan.IdSewa = sewa.IdSewa ORDER BY Tanggal";
        pst = CC.prepareStatement(sql);
        rs = pst.executeQuery();
        int count=1;
        while (rs.next()) {
            int trxID = rs.getInt(1);
            int pesananID = rs.getInt("pesanan.IdPesanan");
            int customerID = rs.getInt("pesanan.IdCustomer");
            long subTotal = rs.getLong("Subtotal");
            int DP = rs.getInt("DP");
            long grandTotal = rs.getLong("GrandTotal");
            Timestamp tanggal = rs.getTimestamp("Tanggal");
            String status = rs.getString("StatusTransaksi");
            String nama = rs.getString("customer.Nama");
            String noTelp = rs.getString("customer.NoTelp");
            String email = rs.getString("customer.Email");
            String type = rs.getString("customer.Keterangan");
            Timestamp tanggl = rs.getTimestamp("Customer.LastOrder");
            int isMember = rs.getInt("sewa.isMember");
            String paket = rs.getString("sewa.NamaSewa");
            ModelCustomer dataCustomer = new ModelCustomer(customerID,nama,noTelp,email,type);
            dataCustomer.setTanggal(tanggal);
            ModelTransaksi data = new ModelTransaksi(trxID,pesananID,paket,subTotal,DP,grandTotal,tanggal,status);
            String typeSewa = "Sewa Reguler";
            if(isMember==1){
                typeSewa = "Sewa Member";
            }
            data.setNameTransaksi(typeSewa);
            data.setCount(count++);
            data.setCustomerID(dataCustomer);
            //int tipeTrx = rs.getInt()
            list.add(data);
        }
        rs.close();
        pst.close();
        return list;
    }
    public void updateTrx(ModelTransaksi data) throws SQLException{
        sql="update Transaksi set StatusTransaksi = ? where IdTrx="+data.getTrxID()+" limit 1";
        pst = CC.prepareStatement(sql);
            pst.setString(1, "Selesai");
        pst.execute();
        pst.close();
    }
}
