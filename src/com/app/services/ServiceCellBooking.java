package com.app.services;

import com.app.configurations.Conn;
import com.app.configurations.DatabaseConnection;
import com.app.model.ModelCell;
import com.app.swing.Combobox;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

public class ServiceCellBooking {
    public List<String> getPaket(ModelCell paket){
       paket.getComboBox().removeAllItems();
       List<String> ls = new ArrayList<String>(); 
        try{
            String sql = "SELECT * FROM sewa";
            PreparedStatement pst = Conn.getInstance().connect().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                String result = rs.getString("NamaSewa");
                ls.add(result);
            }
            paket.setResult(ls);
            paket.getComboBox().removeAllItems();
            paket.getComboBox().setModel(new DefaultComboBoxModel<String>(ls.toArray(new String[0])));
            paket.getComboBox().setSelectedIndex(0);
            int jumlah = rs.getRow();
            pst.close();
            rs.close();
        }catch(SQLException ex){
           Logger.getLogger(ServiceBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }
    public List<String> getLapangan(ModelCell paket){
       paket.getComboBox().removeAllItems();
       List<String> la = new ArrayList<String>(); 
        try{
            String sql = "SELECT * FROM Lapangan";
            PreparedStatement pst = Conn.getInstance().connect().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                String result = rs.getString("NamaLapangan");
                la.add(result);
            }
            paket.setResult(la);
            int jumlah = rs.getRow();
            pst.close();
            rs.close();
        }catch(SQLException ex){
           Logger.getLogger(ServiceBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
        return la;
    }
}
