
package com.app.configurations;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class DatabaseConnection {  
     private Connection CC;  
     Configuration co = new Configuration();
     SystemProperties pro = new SystemProperties();
    public Connection connect(){
  
      String ip = String.valueOf(pro.getIP());
      String db = String.valueOf(pro.getDbname());
      String user = String.valueOf(pro.getDbuser());
      String pass = String.valueOf(pro.getPwuser());
      
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
