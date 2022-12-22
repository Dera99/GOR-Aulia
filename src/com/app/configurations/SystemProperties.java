
package com.app.config;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SystemProperties{

    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public boolean isDarkMode() {
        return darkMode;
    }
    public void setDarkmode(boolean darkMode) {
        this.darkMode = darkMode;
    } 
    public String getBackgroundImage() {
        return backgroundImage;
    }
    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }
    public SystemProperties(){
        
    }
    
    private Color color;
    private boolean darkMode;
    private String backgroundImage;
   
    public void loadFromFile(){
        try{
            Properties pro = new Properties();
            FileInputStream in = new FileInputStream(new File("src/configSystem.app"));
            pro.load(in);
            String themeColor = pro.getProperty("theme_color");
            color = new Color(Integer.valueOf(themeColor));
            darkMode = Boolean.valueOf(pro.getProperty("dark_mode"));
            backgroundImage = pro.getProperty("background_image");
            in.close();
        }catch(IOException e){
            System.err.println(e);
        }
    }
    public void save(String name, String values){
        try{
            Properties pro = new Properties();
            File file = new File("src/configSystem.app");
            InputStream in = new FileInputStream(file);
            pro.load(in);
            pro.setProperty(name    ,values);
            pro.store(new FileOutputStream(file), null);
            in.close();
        }catch(IOException e){
            System.err.println(e);
        }
    }

  
    
    
}
