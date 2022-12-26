package com.app.model;

import com.app.swing.table.TableRowData;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ModelDashboard extends TableRowData {
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
        String req=df.format(request);
        String exp=df.format(expired); 
        return req +" - "+ exp;
    }

    public String getDurasi() {
        DateFormat df=new SimpleDateFormat("H:mm");
        String dur = df.format(durasi);
        
        return dur + " Jam";
    }

    /**
     * @param durasi the durasi to set
     */
    public void setDurasi(Time durasi) {
        this.durasi = durasi;
    }



    public ModelDashboard(String nama, String noTelp, String Lapangan, Time request, Time expired, Time durasi,String status) {
        this.nama=nama;
        this.noTelp = noTelp;
        this.Lapangan = Lapangan;
        this.request = request;
        this.expired = expired;
        this.durasi = durasi;
        this.status = status;
    }
//    public ModePesanan(int idPesanan,String nama, String noTelp, String Lapangan, Date request, Date expired, String durasi,String status) {
//        this.idPesanan = idPesanan;
//        this.noTelp = noTelp;
//        this.Lapangan = Lapangan;
//        this.request = request;
//        this.expired = expired;
//        this.durasi = durasi;
//        this.status = status;
//    }

    public ModelDashboard() {
    }
    
    private int idPesanan;
    private String nama;
    private String noTelp;
    private String Lapangan;
    private Time request;
    private Time expired;
    private Time durasi;
    private String status;
    

    @Override
    public Object[] toTableRow() {
        return new Object[]{nama,noTelp,Lapangan,getJamBooking(),getDurasi(),status};
    }
}
