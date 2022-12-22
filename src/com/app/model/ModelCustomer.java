package com.app.model;

import com.app.swing.table.TableRowData;

public class ModelCustomer{

    /**
     * @return the Ket
     */
    public String getKet() {
        return Ket;
    }

    /**
     * @param Ket the Ket to set
     */
    public void setKet(String Ket) {
        this.Ket = Ket;
    }

    /**
     * @return the CustomerID
     */
    public int getCustomerID() {
        return CustomerID;
    }

    /**
     * @param CustomerID the CustomerID to set
     */
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

//    public ModelCustomer(String nama) {
//      this.nama = nama;
//    }
//    public ModelCustomer(String nama, String Ket) {
//      this.nama = nama;
//      this.Ket=Ket;
//    }
//    public ModelCustomer(String nama, String noTelp, String Email) {
//      this.nama = nama;
//      this.noTelp = noTelp;
//      this.Email = Email;
//    }
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
    
    @Override
    public String toString() {
        return getNama();
    }
  
}
