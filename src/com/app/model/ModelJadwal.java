package com.app.model;

import com.app.swing.table.TableRowData;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ModelJadwal extends TableRowData {

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the idPesanan
     */
    public int getIdPesanan() {
        return idPesanan;
    }

    /**
     * @param idPesanan the idPesanan to set
     */
    public void setIdPesanan(int idPesanan) {
        this.idPesanan = idPesanan;
    }

    /**
     * @return the noTelp
     */
    public String getNoTelp() {
        return noTelp;
    }

    /**
     * @param noTelp the noTelp to set
     */
    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    /**
     * @return the Lapangan
     */
    public String getLapangan() {
        return Lapangan;
    }

    /**
     * @param Lapangan the Lapangan to set
     */
    public void setLapangan(String Lapangan) {
        this.Lapangan = Lapangan;
    }

    /**
     * @return the jamBooking
     */
    public String getJamBooking() {
        //Date myDate=new Date(Time.getTime());
        DateFormat df=new SimpleDateFormat("H:mm");
        String req=df.format(request);
        String exp=df.format(expired); 
        return req +" - "+ exp;
    }

    /**
     * @param jamBooking the jamBooking to set
     */
//    public void setJamBooking(String request, String expired) {
//        this.request = request;
//        this.expired = expired;
//    }

    /**
     * @return the durasi
     */
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



    public ModelJadwal(String nama, String noTelp, String Lapangan, Time request, Time expired, Time durasi,String status) {
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

    public ModelJadwal() {
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
