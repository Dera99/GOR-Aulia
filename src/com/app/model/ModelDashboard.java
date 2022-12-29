package com.app.model;

import com.app.swing.table.TableRowData;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ModelDashboard extends TableRowData {
    public Date getRequest() {
        return request;
    }
    public void setRequest(Date request) {
        this.request = request;
    }
    public Date getExpired() {
        return expired;
    }
    public void setExpired(Date expired) {
        this.expired = expired;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getIdPesanan() {
        return idPesanan;
    }
    public void setIdPesanan(int idPesanan) {
        this.idPesanan = idPesanan;
    }
    public String getNoTelp() {
        return noTelp;
    }
    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
    public String getLapangan() {
        return Lapangan;
    }
    public void setLapangan(String Lapangan) {
        this.Lapangan = Lapangan;
    }

    public String getJamBooking() {
        //Date myDate=new Date(Time.getTime());
        DateFormat df=new SimpleDateFormat("H:mm");
        String req=df.format(getRequest());
        String exp=df.format(getExpired()); 
        return req +" - "+ exp;
    }

    public String getDurasi() {    
        return durasi;
    }
    
    public void setDurasi(String durasi) {
        this.durasi = durasi;
    }



    public ModelDashboard(int idPesanan,String nama, String noTelp, String Lapangan, Date request, Date expired, String durasi,String status) {
        this.idPesanan = idPesanan;
        this.nama=nama;
        this.noTelp = noTelp;
        this.Lapangan = Lapangan;
        this.request = request;
        this.expired = expired;
        this.durasi = durasi;
        this.status = status;
    }

    public ModelDashboard() {
    }
    
    private int idPesanan;
    private String nama;
    private String noTelp;
    private String Lapangan;
    private Date request;
    private Date expired;
    private String durasi;
    private String status;
    

    @Override
    public Object[] toTableRow() {
        DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
        return new Object[]{nama,noTelp,Lapangan,df.format(request),getJamBooking(),durasi,status};
    }
}
