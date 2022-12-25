package com.app.model;

import com.app.swing.table.TableRowData;

public class ModelStaff extends TableRowData{

    public ModelAccounts getAccount() {
        return account;
    }
    public void setAccount(ModelAccounts account) {
        this.account = account;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public int getStaffID() {
        return staffID;
    }
    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public String getNoTelp() {
        return noTelp;
    }
    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getJabatan() {
        return jabatan;
    }
    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }
    private int staffID;
    private String nama;
    private String alamat;
    private String noTelp;
    private String email;
    private String jabatan;
    private int count;
    private ModelAccounts account;
    public ModelStaff(){}
    public ModelStaff(int staffID,String nama, String alamat,String noTelp,String email,String jabatan){
        this.staffID=staffID;
        this.nama=nama;
        this.alamat=alamat;
        this.noTelp=noTelp;
        this.email=email;
        this.jabatan=jabatan;
    }

    @Override
    public Object[] toTableRow() {
        String level = "STAFF";
        if(account.getRoleID()==1){
            level="ADMIN";
        }
        return new Object[]{nama,email,jabatan,account,level};
    }
    @Override
    public String toString(){
        return nama;
    }
    
}
