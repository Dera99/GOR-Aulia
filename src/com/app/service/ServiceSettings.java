package com.app.service;

import com.app.configurations.DatabaseConnection;
import com.app.main.Main;
import com.app.model.ModelAccounts;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ServiceSettings {
    ResultSet rs = null;
    Connection CC = new DatabaseConnection().connect();;
    PreparedStatement pst = null;
    Statement stt;
    String sql; 
    Main M = new Main();
    public void updateProfile(String path, int id) throws SQLException, IOException{
        Icon profile = null;
        sql="UPDATE accounts SET Profile=? WHERE UserId ="+id+"";
        pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         if (path.equals("")) {
            pst.setObject(1, null);
        } else {
            File img = new File(path);
            Path images = img.toPath();
            pst.setBlob(1, Files.newInputStream(images));
            profile= new ImageIcon(path);
            UserSession.setIcon(profile);
        }
        pst.execute();
        rs.close();
        pst.close();
    }
    public void updatePassword(ModelAccounts data) throws SQLException{
        sql="UPDATE accounts SET Password=? WHERE UserId ="+data.getUserID()+"";
        pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, data.getPassword());
        pst.execute();
        rs.close();
        pst.close();
    }
    public boolean checkPassword(ModelAccounts data) throws SQLException{
        boolean result=false;
        sql="SELECT * FROM Accounts WHERE UserId="+data.getUserID()+"";
        pst = CC.prepareStatement(sql);
        rs = pst.executeQuery();
        if(rs.next()){
            String old = rs.getString("Password");
            if(data.getPassword().equals(old)){
                result=true;
            }
        }
        rs.close();
        pst.close();
        return result;
    }
}
