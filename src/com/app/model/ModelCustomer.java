package com.app.model;

import com.app.swing.table.TableRowData;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ModelCustomer extends TableRowData{
    public Date getTanggal() {
        return tanggal;
    }
    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    public String getKet() {
        return Ket;
    }
    public void setKet(String Ket) {
        this.Ket = Ket;
    }
    public int getCustomerID() {
        return CustomerID;
    }
    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getNoTelp() {
        return noTelp;
    }
    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }

    public ModelCustomer(int CustomerID, String nama, String noTelp, String Email,String Ket) {
      this.CustomerID = CustomerID;
      this.nama = nama;
      this.noTelp = noTelp;
      this.Email = Email;
      this.Ket=Ket;
    }

    public ModelCustomer() {
    }
    private String nama;
    private String noTelp;
    private String Email;
    private String Ket;
    private int CustomerID;
    private int count;
    private Date tanggal;
    
    @Override
    public String toString() {
        return getNama();
    }

    @Override
    public Object[] toTableRow() {
        DateFormat sdf = new SimpleDateFormat("dd/MM/yy H:mm");
        String type = "R";
        if(Ket.equals("Member")){
            type="M";
        }
        return new Object[]{count,type+CustomerID,nama,noTelp,Email,Ket,sdf.format(tanggal)};
    }
  
}
