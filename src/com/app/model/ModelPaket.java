package com.app.model;

import com.app.swing.table.TableRowData;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ModelPaket extends TableRowData {

    public int getPaketID() {
        return paketID;
    }
    public void setPaketID(int paketID) {
        this.paketID = paketID;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public int getHarga() {
        return harga;
    }
    public void setHarga(int harga) {
        this.harga = harga;
    }
    public Time getDurasi() {
        return durasi;
    }
    public void setDurasi(Time durasi) {
        this.durasi = durasi;
    }
    public boolean isMember() {
        return member;
    }
    public void setMember(boolean member) {
        this.member = member;
    }

 private int paketID;
 private String nama;
 private int harga;
 private Time durasi;
 private boolean member;
 public ModelPaket(int paketID,String nama, int harga, Time durasi, boolean member){
     this.paketID = paketID;
     this.nama=nama;
     this.harga = harga;
     this.durasi=durasi;
     this.member=member;
 }
 public ModelPaket(){}

    @Override
    public Object[] toTableRow() {
        DateFormat sdf = new SimpleDateFormat("h:mm"); 
        String kode = "R";
        String value = "Reguler";
        if(member==true){
            kode="M";
            value="Member";
        }
        
        return new Object[]{kode+paketID,nama,"Rp "+harga,sdf.format(durasi),value};
    }
}
