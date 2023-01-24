package com.app.services;
import com.app.configurations.DatabaseConnection;
import com.app.main.Main;
import com.app.model.ModelLapangan;
import com.app.model.ModelPaket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
public class ServicePaket {
    ResultSet rs = null;
    Connection CC = new DatabaseConnection().connect();;
    PreparedStatement pst = null;
    Statement stt;
    String sql; 
    Main M = new Main();
    public List<ModelPaket> getPaket() throws SQLException {
        List<ModelPaket> list = new ArrayList<>();
        SimpleDateFormat ex = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
        sql = "SELECT * FROM sewa";
        pst = CC.prepareStatement(sql);
        rs = pst.executeQuery();
        boolean member = false;
        while (rs.next()) {
            int paketID = rs.getInt(1);
            String nama = rs.getString(2);
            int harga = rs.getInt(3);
            Time durasi = rs.getTime(4);
            int isMember = rs.getInt(5);
            if(isMember==1){
                member=true;
            }     
            list.add(new ModelPaket(paketID,nama,harga,durasi,member));
        }
        rs.close();
        pst.close();
        return list;
    }
    public void insertPaket(ModelPaket data) throws SQLException{
         sql = "INSERT INTO sewa (NamaSewa,Harga,Durasi,isMember) values (?,?,?,?)";
            pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, data.getNama());
            pst.setLong(2, data.getHarga());
            pst.setTime(3, data.getDurasi());
            int value=0;
            if(data.isMember()==true){
                value=1;
            }
            pst.setInt(4, value);
        pst.execute();
        rs = pst.getGeneratedKeys();
        rs.first();
        int idPaket = rs.getInt(1);
        data.setPaketID(idPaket);
        System.out.println("Keys : "+idPaket);
        rs.close();
        pst.close();
    }
    public void updatePaket(ModelPaket data) throws SQLException{
        sql="update sewa set NamaSewa = ?,Harga = ?,Durasi= ?, isMember=? where IdSewa=? limit 1";
        pst = CC.prepareStatement(sql);
            pst.setString(1, data.getNama());
            pst.setLong(2, data.getHarga());
            pst.setTime(3, data.getDurasi());
            int value;
            if(data.isMember()==true){
                value=1;
            }else{
                value=0;
            }
            pst.setInt(4, value);
            pst.setInt(5, data.getPaketID());
         pst.execute();
         pst.close();
    }
    public void deletePaket(int paketID) throws SQLException{
        sql = "delete from sewa where IdSewa=? limit 1";
        pst = CC.prepareStatement(sql);
        pst.setInt(1, paketID);
        pst.execute();
        pst.close();
    }
    public List<ModelLapangan> getField() throws SQLException {
        List<ModelLapangan> list = new ArrayList<>();
        SimpleDateFormat ex = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
        sql = "SELECT * FROM lapangan ORDER BY IdLapangan";
        pst = CC.prepareStatement(sql);
        rs = pst.executeQuery();
        int count=1;
        while (rs.next()) {
            int lapanganID = rs.getInt(1);
            String nama = rs.getString(2);
            list.add(new ModelLapangan(count++,lapanganID,nama));
        }
        rs.close();
        pst.close();
        return list;
    }
    public void insertLapangan(ModelLapangan data) throws SQLException{
         sql = "INSERT INTO lapangan (NamaLapangan) values (?)";
            pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, data.getNama());
        pst.execute();
        rs = pst.getGeneratedKeys();
        rs.first();
        int idLapangan = rs.getInt(1);
        data.setLapanganID(idLapangan);
        System.out.println("Keys : "+idLapangan);
        rs.close();
        pst.close();
    }
    public void updateLapangan(ModelLapangan data) throws SQLException{
        sql="update lapangan set NamaLapangan=? where IdLapangan=? limit 1";
        pst = CC.prepareStatement(sql);
            pst.setString(1, data.getNama());
            pst.setInt(2, data.getLapanganID());
         pst.execute();
         pst.close();
    }
    public void deleteLapangan(int lapanganID) throws SQLException{
        sql = "delete from lapangan where IdLapangan=? limit 1";
        pst = CC.prepareStatement(sql);
        pst.setInt(1, lapanganID);
        pst.execute();
        pst.close();
    }
}
