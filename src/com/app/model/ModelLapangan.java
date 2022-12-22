package com.app.model;

import com.app.swing.table.TableRowData;

public class ModelLapangan extends TableRowData{
    public int getLapanganID() {
        return lapanganID;
    }
    public void setLapanganID(int lapanganID) {
        this.lapanganID = lapanganID;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }

    public ModelLapangan(){}
    private int lapanganID;
    int count;
    private String nama;
    public ModelLapangan(int lapanganID, String nama){
        this.lapanganID = lapanganID;
        this.nama=nama;
    }
     public ModelLapangan(int count,int lapanganID, String nama){
        this.lapanganID = lapanganID;
        this.nama=nama;
        this.count=count;
    }
    @Override
    public Object[] toTableRow() {
        return new Object[]{count,nama};
    }
    
}
