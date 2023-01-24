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
     public List<ModelAccounts> getStaff() throws SQLException {
        List<ModelAccounts> list = new ArrayList<>();
        sql = "SELECT * FROM staff JOIN Accounts ON Accounts.StaffID= staff.StaffID";
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
            ModelStaff staff = new ModelStaff(staffID,nama,alamat,noTelp,email,jabatan);
            acc.setStaff(staff);
            staff.setAccount(acc);
            list.add(acc);
        }
        rs.close();
        pst.close();
        return list;
     }
    public void insertAccount(ModelStaff data) throws SQLException{
       sql="INSERT INTO accounts (Username, Password, RoleId, StaffID) VALUES ('"+data.getAccount().getUsername()+"', '"+data.getAccount().getPassword()+"', '"+data.getAccount().getRoleID()+"', "+data.getStaffID()+")"; 
       pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
       pst.execute();
       rs = pst.getGeneratedKeys();
       rs.first();
       int userID = rs.getInt(1);
       data.getAccount().setUserID(userID);
       System.out.println("Keys : "+userID);
       rs.close();
       pst.close();
    }
    public void insertStaff(ModelStaff data) throws SQLException{
        sql="INSERT INTO staff (Nama, Alamat, NoTelp, Email, Jabatan) VALUES ('"+data.getNama()+"', '"+data.getAlamat()+"', "
                + "'"+data.getNoTelp()+"', '"+data.getEmail()+"', '"+data.getJabatan()+"')";
        pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.execute();
        rs = pst.getGeneratedKeys();
        rs.first();
        int staffID = rs.getInt(1);
        data.setStaffID(staffID);
        insertAccount(data);
        System.out.println("Keys : "+staffID);
        rs.close();
        pst.close();
    }
    public void updateStaff(ModelStaff data) throws SQLException{
        sql="UPDATE accounts, staff SET accounts.Username = '"+data.getAccount().getUsername()+"', "
                + "accounts.RoleId = "+data.getAccount().getRoleID()+", "
                + "staff.Nama = '"+data.getNama()+"', "
                + "staff.Alamat = '"+data.getAlamat()+"', "
                + "staff.NoTelp = '"+data.getNoTelp()+"', "
                + "staff.Email= '"+data.getEmail()+"', "
                + "staff.Jabatan = '"+data.getJabatan()+"' "
                + "WHERE accounts.StaffID = staff.StaffID AND staff.StaffID = "+data.getStaffID()+"";
        pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
        pst.execute();
            rs = pst.getGeneratedKeys();
            rs.first();
            rs.close();
            pst.close();
    }
    public void deleteStaff(int staffID) throws SQLException{
        sql="DELETE a, s FROM accounts a JOIN staff s ON a.StaffID= s.StaffID WHERE a.StaffID = "+staffID+"";
        pst = CC.prepareStatement(sql);
        pst.execute();
        pst.close();
    }
}
