
package com.app.configurations;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class DatabaseConnection {  
     private Connection CC;  
        config con = new config();
        Configuration co = new Configuration();
   
    public Connection connect(){
      String ip = con.GetProp(co.lbl_ip.getText());
      String db = con.GetProp(co.lbl_db.getText());
      String user = con.GetProp(co.lbl_user.getText());
      String pass = con.GetProp(co.lbl_pass.getText());
      
    try{
      if(CC==null){
        CC = DriverManager.getConnection("jdbc:mysql://"+ip+"/"+db+"", ""+user+"", ""+pass+"");
      }
    }
    catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);
        co.setVisible(true);
        
    }
        return CC;
    }
}
