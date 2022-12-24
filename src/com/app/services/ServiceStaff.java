package com.app.services;

import com.app.configurations.DatabaseConnection;
import com.app.model.ModelAccounts;
import com.app.model.ModelStaff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServiceStaff {
    ResultSet rs = null;
    Connection CC = new DatabaseConnection().connect();;
    PreparedStatement pst = null;
    Statement stt;
    String sql; 
     public List<ModelStaff> getStaff() throws SQLException {
        List<ModelStaff> list = new ArrayList<>();
        sql = "SELECT * FROM staff JOIN Accounts ON Accounts.UserId= staff.UserId";
        pst = CC.prepareStatement(sql);
        rs = pst.executeQuery();
        int count=1;
        while (rs.next()) {
            int staffID = rs.getInt("StaffID");
            String nama = rs.getString("Nama");
            String alamat = rs.getString("Alamat");
            String noTelp = rs.getString("NoTelp");
            String email = rs.getString("Email");
            String jabatan = rs.getString("Jabatan");
            int userID = rs.getInt("UserId");
            String username = rs.getString("Username");
            String password = rs.getString("Password");
            int roleID = rs.getInt("RoleId");
            ModelAccounts acc = new ModelAccounts(userID,username,password,roleID);
            ModelStaff staff = new ModelStaff(staffID,acc,nama,alamat,noTelp,email,jabatan);
            acc.setStaff(staff);
            list.add(staff);
        }
        rs.close();
        pst.close();
        return list;
     }
}
