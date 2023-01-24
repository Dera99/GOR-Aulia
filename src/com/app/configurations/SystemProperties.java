
package com.app.configurations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SystemProperties{

    public static String getIP() {
        return ip;
    }
    public void setIP(String ip) {
        this.ip = ip;
    }
    public static String getDbname() {
        return dbname;
    }
    public void setDbname(String dbname) {
        this.dbname = dbname;
    }
    public static String getDbuser() {
        return dbuser;
    }
    public void setDbuser(String dbuser) {
        this.dbuser = dbuser;
    }
    public static String getPwuser() {
        return pwuser;
    }
    public void setPwuser(String pwuser) {
        this.pwuser = pwuser;
    } 
    public int getDP() {
        return DP;
    }
    public void setDP(int DP) {
        this.DP = DP;
    }
    public int getMinute() {
        return minute;
    }  
    public void setMinute(int minute) {
        this.minute = minute;
    }
    
    public SystemProperties(){}
    
    private int DP;
    private int minute;
    private static String ip;
    private static String dbname;
    private static String dbuser;
    private static String pwuser;
    
    public void loadFromFile(){
        try{
            Properties pro = new Properties();
            FileInputStream in = new FileInputStream(new File("src/configProperties.app"));
            pro.load(in);
            setIP(pro.getProperty("IP"));
            setDbname(pro.getProperty("DB_Name"));
            setDbuser(pro.getProperty("DB_User"));
            setPwuser(pro.getProperty("DB_Password"));
            setDP(Integer.parseInt(pro.getProperty("atur_DP")));
            setMinute(Integer.parseInt(pro.getProperty("toleransi")));
            in.close();
        }catch(IOException e){
            System.err.println(e);
        }
    }
    public void save(String name, String values){
        try{
            Properties pro = new Properties();
            File file = new File("src/configProperties.app");
            if(!file.exists()){
                file.mkdirs();
            }
            InputStream in = new FileInputStream(file);
            pro.load(in);
            pro.setProperty(name,values);
            pro.store(new FileOutputStream(file), null);
            in.close();
        }catch(IOException e){
            System.err.println(e);
        }
    }   
}
