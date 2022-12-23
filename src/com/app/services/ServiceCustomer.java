
package com.app.services;

import com.app.configurations.DatabaseConnection;
import com.app.model.ModelCustomer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ServiceCustomer  {
    ResultSet rs = null;
    Connection CC = new DatabaseConnection().connect();;
    PreparedStatement pst = null;
    Statement stt;
    String sql; 
    public List<ModelCustomer> getCustomer(String customerType) throws SQLException {
        List<ModelCustomer> list = new ArrayList<>();
        sql = "SELECT * FROM customer WHERE Keterangan='"+customerType+"'";
        pst = CC.prepareStatement(sql);
        rs = pst.executeQuery();
        int count=1;
        while (rs.next()) {
            int customerID = rs.getInt(1);
            String nama = rs.getString(2);
            String noTelp = rs.getString(3);
            String email = rs.getString(4);
            String type = rs.getString(5);
            ModelCustomer data = new ModelCustomer(customerID,nama,noTelp,email,type);
            Timestamp tanggal = rs.getTimestamp("LastOrder");
            data.setCount(count++);
            data.setTanggal(tanggal);
            list.add(data);
        }
        rs.close();
        pst.close();
        return list;
    }
    public void updateCustomer(ModelCustomer data) throws SQLException{
        sql="UPDATE Customer Set Nama=?, NoTelp=?, Email=?, Keterangan=? WHERE IdCustomer=?";
        pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, data.getNama());
            pst.setString(2, data.getNoTelp());
            pst.setString(3, data.getEmail());
            pst.setString(4, data.getKet());
            pst.setInt(5, data.getCustomerID());
        pst.execute();
        rs = pst.getGeneratedKeys();
        rs.first();
        rs.close();
        pst.close();
    }
    public void deleteCustomer(int id) throws SQLException{
         sql = "delete from Customer where IdCustomer=? limit 1";
        pst = CC.prepareStatement(sql);
        pst.setInt(1, id);
        pst.execute();
        pst.close();
    }
    public void insertCustomer(ModelCustomer data) throws SQLException{
            sql = "INSERT INTO customer (Nama, NoTelp, Email, Keterangan) SELECT * FROM (SELECT '"+data.getNama()+"', '"+data.getNoTelp()+"', '"+data.getEmail()+"', 'Member') AS tmp "
                    + "WHERE NOT EXISTS ( SELECT Nama,NoTelp,Email,Keterangan FROM customer WHERE "
                    + "Nama = '"+data.getNama()+"' AND NoTelp = '"+data.getNoTelp()+"' AND Email='"+data.getEmail()+"' AND Keterangan='Member'  LIMIT 1 )";
            pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.execute();
            rs = pst.getGeneratedKeys();
            rs.first();
            rs.close();
            pst.close();
    }
}
