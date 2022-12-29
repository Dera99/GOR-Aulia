package com.app.model;

import com.app.swing.table.TableRowData;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ModelTransaksi extends TableRowData{

    public ModelCustomer getCustomerID() {
        return customerID;
    }
    public void setCustomerID(ModelCustomer customerID) {
        this.customerID = customerID;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public String getNameTransaksi() {
        return nameTransaksi;
    }
    public void setNameTransaksi(String nameTransaksi) {
        this.nameTransaksi = nameTransaksi;
    }
    public Date getTanggal() {
        return tanggal;
    }
    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
    public int getTrxID() {
        return trxID;
    }
    public void setTrxID(int trxID) {
        this.trxID = trxID;
    }
    public int getTipeTrx() {
        return tipeTrx;
    }
    public void setTipeTrx(int tipeTrx) {
        this.tipeTrx = tipeTrx;
    }
    public int getPesananID() {
        return pesananID;
    }
    public void setPesananID(int pesananID) {
        this.pesananID = pesananID;
    }
    public long getSubTotal() {
        return subTotal;
    }
    public void setSubTotal(long subTotal) {
        this.subTotal = subTotal;
    }
    public int getDP() {
        return DP;
    }
    public void setDP(int DP) {
        this.DP = DP;
    }
    public long getGrandTotal() {
        return grandTotal;
    }
    public void setGrandTotal(long grandTotal) {
        this.grandTotal = grandTotal;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    private int trxID;
    private int tipeTrx;
    private int pesananID;
    private long subTotal;
    private int DP;
    private long grandTotal;
    private String status;
    private Date tanggal;
    private int count;
    private String nameTransaksi;
    private ModelCustomer customerID;
    public ModelTransaksi(int trxID,int tipeTrx, int pesananID, long subTotal, int DP, long grandTotal,Date tanggal, String status){
        this.trxID = trxID;
        this.tipeTrx = tipeTrx;
        this.pesananID = pesananID;
        this.subTotal = subTotal;
        this.DP = DP;
        this.grandTotal = grandTotal;
        this.tanggal=tanggal;
        this.status = status;
    }
    public ModelTransaksi(){
    }

    @Override
    public Object[] toTableRow() {
        DateFormat sdf = new SimpleDateFormat("dd/MM/yy H:mm");
        String kode = "R";
        String type = "R";
        if(tipeTrx==2){
            kode="M";
        }
        if(customerID.getKet().equals("Member")){
            type="M";
        }
        return new Object[]{getCount(),kode+pesananID,type+customerID.getCustomerID(),getNameTransaksi(),"Rp "+subTotal,"Rp "+DP,"Rp "+grandTotal,sdf.format(tanggal)+" WIB",status};
    }
}
