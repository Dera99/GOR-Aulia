package com.app.model;


import com.app.swing.table.TableRowData;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ModelBooking extends TableRowData {

    public ModelTransaksi getTransaksi() {
        return transaksi;
    }
    public void setTransaksi(ModelTransaksi transaksi) {
        this.transaksi = transaksi;
    }

    public ModelCustomer getCustomer() {
        return customer;
    }
    public void setCustomer(ModelCustomer customer) {
        this.customer = customer;
    }
    public String getField() {
        return field;
    }
    public void setField(String field) {
        this.field = field;
    }
    public Date getReqDate() {
        return reqDate;
    }
    public void setReqDate(Date reqDate) {
        this.reqDate = reqDate;
    }

    public String getPaket() {
        return paket;
    }
    public void setPaket(String paket) {
        this.paket = paket;
    }

    public Date getExpire() {
        return expire;
    }
    public void setExpire(Date expired) {
        this.expire = expired;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public ModelBooking(int id, ModelCustomer customer, String paket, String field, Date reqDate, Date expire,String status, ModelTransaksi transaksi){
        this.id=id;
        this.customer=customer;
        this.paket=paket;
        this.field=field;
        this.reqDate=reqDate;
        this.expire=expire;
        this.status=status;
        this.transaksi = transaksi;         
    }
    public ModelBooking(){
    }
    private ModelCustomer customer;
    private ModelTransaksi transaksi;
    private String field;
    private Date reqDate;
    private String paket;
    private Date expire;
    private String status;
    private int id;

    @Override
    public Object[] toTableRow() {
        SimpleDateFormat ex = new SimpleDateFormat("H:mm");
        SimpleDateFormat dates = new SimpleDateFormat("yyyy-MM-dd");  
        String kode = "R";
        if(paket.equals("Member")){
            kode = "M";
        }
       return new Object[]{kode+id,customer,paket,field,dates.format(reqDate),ex.format(reqDate)+" - "+ex.format(expire.getTime())+" WIB",status};
    }
    @Override
    public String toString() {
        return reqDate.toString();
    }
}