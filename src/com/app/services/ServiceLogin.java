package com.app.services;

import com.app.configurations.DatabaseConnection;
import com.app.main.Main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import notification.Notification;

public class ServiceLogin {
    ResultSet rs = null;
    Connection CC = new DatabaseConnection().connect();;
    PreparedStatement pst = null;
    Statement stt;
    String sql;
    public ServiceLogin(String table) throws SQLException{
        sql="SELECT * FROM "+table+"";
        pst = CC.prepareStatement(sql);
        rs=pst.executeQuery();
    }
    public ServiceLogin(String Username, String Password,JFrame frame) throws SQLException{
        Main b = new Main();
        Notification err= new Notification(frame, Notification.Type.ERROR, Notification.Location.TOP_CENTER, "Username atau Password anda salah !");
        Notification err1= new Notification(frame, Notification.Type.ERROR, Notification.Location.TOP_CENTER, "Ada Kesalahan !");
        Notification err2= new Notification(frame, Notification.Type.ERROR, Notification.Location.TOP_CENTER, "Username Tidak Ada");
        Notification noti= new Notification(b, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Login Berhasil !");
       try {
        sql="SELECT * FROM accounts JOIN staff ON accounts.StaffID = staff.StaffID WHERE Username = '"+Username+"' AND Password = '"+Password+"'";    
        pst = CC.prepareStatement(sql);
        rs = pst.executeQuery(); 
        if(rs.next()){
                String user = rs.getString("Username");
                String pass = rs.getString("Password");
                String name = rs.getString("Nama");
                int UserId = rs.getInt("UserId");
                int RoleId = rs.getInt("RoleId");
                Icon profile=null;
                if (rs.getObject("Profile") != null) {
                    profile = new ImageIcon(rs.getBytes("Profile"));
                }
                if (Password.equals(pass) && Username.equals(user)){
                    UserSession.setUserId(UserId);
                    UserSession.setUserLogin(name);
                    UserSession.setRoleId(RoleId);
                    UserSession.setIcon(profile);
                    Main a = new Main();
                    a.setVisible(true);
                    frame.dispose();
                    noti.showNotification();
                }else{
                err.showNotification();
                }
            }else{
                err1.showNotification();
            } 
        }catch (Exception e){
            err1.showNotification();
            e.printStackTrace();
        }        
      
    }
}
