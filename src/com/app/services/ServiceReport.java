package com.app.services;

import com.app.chart.ModelChart;
import com.app.configurations.DatabaseConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ServiceReport {
    ResultSet rs = null;
    Connection CC = new DatabaseConnection().connect();;
    PreparedStatement pst = null;
    Statement stt;
    String sql;
    public void getMemberCard(int id) throws SQLException {
         try{
            HashMap param = new HashMap();
            param.put("id",id);
            InputStream file = new FileInputStream(new File("src/com/app/reports/CardMember.jrxml"));
            JasperDesign jd = JRXmlLoader.load(file);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr,param,CC);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void getKodePesanan(int id,String typePesanan, String typeCustomer) throws SQLException {
         try{
            HashMap param = new HashMap();
            param.put("id",id);
            param.put("typePesanan",typePesanan);
            param.put("typeCustomer",typeCustomer);
            InputStream file = new FileInputStream(new File("src/com/app/reports/KodePesanan.jrxml"));
            JasperDesign jd = JRXmlLoader.load(file);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr,param,CC);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
