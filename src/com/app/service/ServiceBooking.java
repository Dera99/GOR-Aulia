package com.app.service;

import com.app.configurations.DatabaseConnection;
import com.app.main.Main;
import com.app.model.ModelBooking;
import com.app.model.ModelCustomer;
import com.app.model.ModelTransaksi;
import com.app.swing.Combobox;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import notification.Notification;
import org.joda.time.DateTime;
import org.joda.time.Interval;

public class ServiceBooking {
    public boolean isMember() {
        return member;
    }
    public void setMember(boolean member) {
        this.member = member;
    }
    public boolean isResultCheck() {
        return resultCheck;
    }
    public void setResultCheck(boolean resultCheck) {
        this.resultCheck = resultCheck;
    }
    public List<String> getLs() {
        return ls;
    }
    public void setLs(List<String> ls) {
        this.ls = ls;
    }
    String chek;
    ResultSet rs = null;
    Connection CC = new DatabaseConnection().connect();;
    PreparedStatement pst = null;
    Statement stt;
    String sql; 
    private boolean member;
    public ModelCustomer dataCustomer;
    public ModelBooking dataBooking;
    private boolean resultCheck;
    private List<String> ls = new ArrayList<String>(); 
    Main m = new Main();
    public List<ModelBooking> getBooking() throws SQLException, ParseException {
        List<ModelBooking> list = new ArrayList<>();
        SimpleDateFormat ex = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
        sql = "select * from pesanan JOIN customer ON customer.IdCustomer = pesanan.IdCustomer JOIN Lapangan ON Lapangan.IdLapangan = pesanan.IdLapangan JOIN sewa ON sewa.IdSewa = pesanan.IdSewa JOIN transaksi ON transaksi.IdPesanan = pesanan.IdPesanan WHERE pesanan.Status = 'Menunggu Antrian' ORDER By pesanan.Request_Date";
        pst = CC.prepareStatement(sql);
        rs = pst.executeQuery();
        while (rs.next()) {
            int bookingID = rs.getInt("IdPesanan");
            int CustomerID = rs.getInt("pesanan.IdCustomer");
            String nama = rs.getString("Nama");
            String noTelp = rs.getString("NoTelp");
            String Email = rs.getString("Email");
            String memberType = rs.getString("Customer.Keterangan");
            String paket = rs.getString("sewa.NamaSewa");
            String field = rs.getString("lapangan.NamaLapangan");
          
                  Date request = ex.parse(rs.getString("Request_Date"));
                  Date expired = ex.parse(rs.getString("Expired"));  
            String status = rs.getString("pesanan.Status");
            int trxID = rs.getInt("transaksi.IdTrx");
            int IdTipeTrx = rs.getInt("transaksi.IdTipeTrx");
            long subTotal = rs.getLong("transaksi.Subtotal");
            int DP = rs.getInt("transaksi.DP");
            long grandTotal = rs.getLong("transaksi.GrandTotal");
            Date tanggal = rs.getDate("transaksi.Tanggal");
            String StatusTrx = rs.getString("transaksi.StatusTransaksi");
            ModelCustomer data = new ModelCustomer(CustomerID,nama,noTelp,Email,memberType);
            ModelTransaksi trx = new ModelTransaksi(trxID,IdTipeTrx,bookingID,subTotal,DP,grandTotal,tanggal,StatusTrx);
            list.add(new ModelBooking(bookingID,data,paket,field,request,expired,status,trx));
        }
        rs.close();
        pst.close();
        return list;
    }
    public void isMember(int kode) throws SQLException{
        Notification err= new Notification(m, Notification.Type.ERROR, Notification.Location.TOP_CENTER, "Kode Member Tidak Ditemukan !");
        try{
            stt=CC.createStatement();
            rs = stt.executeQuery("SELECT * FROM Customer WHERE IdCustomer ="+kode+"");
            if(rs.next()){
                String status = rs.getString("Keterangan");
                if(status.equals("Member")){
                setMember(true);
                String nama = rs.getString("Nama");
                String NoTelp = rs.getString("NoTelp");
                String email = rs.getString("Email");
                dataCustomer = new ModelCustomer(kode,nama,NoTelp,email,status);
               }else if (status.equals("Non-Member")){
                setMember(false);
                String nama = rs.getString("Nama");
                String NoTelp = rs.getString("NoTelp");
                String email = rs.getString("Email");
                dataCustomer = new ModelCustomer(kode,nama,NoTelp,email,status);
               }           
            }else{
                setMember(false);
            }
        }catch(NumberFormatException e){
            System.err.println(e);
        }
    }
 
    public boolean checkRequest(ModelBooking data) throws ParseException{
        boolean result = true;
        try{
            setResultCheck(true);
            Date requestStart = data.getReqDate();
            Date expiredEnd = data.getExpire();
            DateTime requested = new DateTime(requestStart);
            DateTime expire = new DateTime(expiredEnd);
            Interval durasi = new Interval(requested,expire);
            DateTime current = new DateTime();
            //Set current time biar bisa di setting dynamic
                if(durasi.isBeforeNow()){
                    setResultCheck(false);
                }  
            if(data.getField().equals("Lapangan 1 & 2")){
            SimpleDateFormat ex = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                sql = "SELECT * FROM pesanan JOIN lapangan on lapangan.IdLapangan = pesanan.IdLapangan JOIN customer on customer.IdCustomer = pesanan.IdCustomer";
                pst = CC.prepareStatement(sql);
                rs = pst.executeQuery();
                while(rs.next()){
                      Date request = ex.parse(rs.getString("Request_Date"));
                      Date expired = ex.parse(rs.getString("Expired"));  
                      DateTime bookedStart = new DateTime(request);
                      DateTime bookedEnd = new DateTime(expired);
                      Interval interval = new Interval(bookedStart, bookedEnd);
                          if(durasi.contains(bookedStart) || interval.contains(requested)){
                            setResultCheck(false);
                            result = false;
                          }
                }   
                System.out.println("getMinut "+current.getMinuteOfHour());
                System.out.println(ex.format(data.getReqDate()));
                System.out.println(ex.format(data.getExpire()));
                System.out.println("Request available = "+isResultCheck());
                rs.close();
                pst.close();
            }else {
            SimpleDateFormat ex = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                sql = "SELECT * FROM pesanan JOIN lapangan on lapangan.IdLapangan = pesanan.IdLapangan JOIN customer on customer.IdCustomer = pesanan.IdCustomer WHERE pesanan.IdLapangan = (select IdLapangan from lapangan WHERE NamaLapangan='"+data.getField()+"')";
                pst = CC.prepareStatement(sql);
                rs = pst.executeQuery();
                while(rs.next()){
                      Date request = ex.parse(rs.getString("Request_Date"));
                      Date expired = ex.parse(rs.getString("Expired"));  
                      DateTime bookedStart = new DateTime(request);
                      DateTime bookedEnd = new DateTime(expired);
                      Interval interval = new Interval(bookedStart, bookedEnd);
                          if(durasi.contains(bookedStart) || interval.contains(requested)){
                            setResultCheck(false);
                            result = false;
                          }
                }   
                System.out.println("getMinut "+current.getMinuteOfHour());
                System.out.println(ex.format(data.getReqDate()));
                System.out.println(ex.format(data.getExpire()));
                System.out.println("Request available = "+isResultCheck());
                rs.close();
                pst.close();
            }
        }catch(SQLException ex){
             Logger.getLogger(ServiceBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public void insertData(ModelBooking data){
        SimpleDateFormat ex = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
        int jenis = 1;
        if(data.getPaket().equals("Member")){
            jenis=2;
        }
        if(isMember()==false){
        try{
            insertCustomer(data);
            updateOrder(data);
            try{
                sql = "insert into pesanan (IdSewa, IdLapangan,IdTipeTrx,IdCustomer,Request_Date,Expired,Status) values ((select IdSewa from sewa where NamaSewa='"+data.getPaket()+"'),(SELECT IdLapangan from lapangan WHERE NamaLapangan='"+data.getField()+"'),"+jenis+",(SELECT IdCustomer from customer WHERE Nama ='"+data.getCustomer().getNama()+"' AND Email='"+data.getCustomer().getEmail()+"' AND NoTelp = '"+data.getCustomer().getNoTelp()+"' AND Keterangan = 'Non-Member'),'"+ex.format(data.getReqDate())+"','"+ex.format(data.getExpire())+"','Menunggu Antrian');";
                pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                pst.execute();
                rs = pst.getGeneratedKeys();
                rs.first();
                int IdBooking = rs.getInt(1);
                data.setId(IdBooking);
                System.out.println("Keys : "+IdBooking);
                //refresh(data);
                rs.close();
                pst.close();
            }catch (SQLException e){
                System.err.println(e);
            }
        }catch (SQLException ex1){
                Logger.getLogger(ServiceBooking.class.getName()).log(Level.SEVERE, null,ex1);
        }
        }else{
        try{    
            sql = "insert into pesanan (IdSewa, IdLapangan,IdTipeTrx,IdCustomer,Request_Date,Expired,Status) values ((select IdSewa from sewa where NamaSewa='"+data.getPaket()+"'),(SELECT IdLapangan from lapangan WHERE NamaLapangan='"+data.getField()+"'),"+jenis+",(SELECT IdCustomer from customer WHERE Nama ='"+data.getCustomer().getNama()+"' AND Email='"+data.getCustomer().getEmail()+"' AND NoTelp = '"+data.getCustomer().getNoTelp()+"' AND Keterangan = 'Member'),'"+ex.format(data.getReqDate())+"','"+ex.format(data.getExpire())+"','Menunggu Antrian');";
            pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
            pst.execute();
            rs = pst.getGeneratedKeys();
            rs.first();
            int IdBooking = rs.getInt(1);
            data.setId(IdBooking);
            System.out.println("Keys : "+IdBooking);    
            //refresh(data);  
            updateOrder(data);
        rs.close();
        pst.close();
        }catch (SQLException a){
            System.err.println(a);
        }
        
    }
    }
    public void insertCustomer(ModelBooking data){
        try {
            String sql = "INSERT INTO customer (Nama, NoTelp, Email, Keterangan) SELECT * FROM (SELECT '"+data.getCustomer().getNama()+"', '"+data.getCustomer().getNoTelp()+"', '"+data.getCustomer().getEmail()+"', 'Non-Member') AS tmp "
                    + "WHERE NOT EXISTS ( SELECT Nama,NoTelp,Email,Keterangan FROM customer WHERE "
                    + "Nama = '"+data.getCustomer().getNama()+"' AND NoTelp = '"+data.getCustomer().getNoTelp()+"' AND Email='"+data.getCustomer().getEmail()+"' AND Keterangan='Non-Member'  LIMIT 1 )";
            pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.execute();
            rs = pst.getGeneratedKeys();
            rs.first();
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteBooked(int IdPesanan) throws SQLException {
        sql = "delete pesanan,transaksi from pesanan JOIN transaksi ON pesanan.IdPesanan = transaksi.IdPesanan where pesanan.IdPesanan=?";
        pst = CC.prepareStatement(sql);
        pst.setInt(1, IdPesanan);
        pst.execute();
        pst.close();
    }
    public void updateBooked(ModelBooking data) {
        try{
        SimpleDateFormat ex = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
        int jenis = 1;
        if(data.getPaket().equals("Member")){
            jenis=2;
        }
        String sql = "update pesanan set IdSewa=(select IdSewa from sewa where NamaSewa='"+data.getPaket()+"'),\n" +
"		 IdLapangan=(SELECT IdLapangan from lapangan WHERE NamaLapangan='"+data.getField()+"'),\n" +
"                IdTipeTrx="+jenis+",Request_Date='"+ex.format(data.getReqDate())+"',Expired='"+ex.format(data.getExpire())+"' where IdPesanan="+data.getId()+" limit 1";
        pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
        pst.execute();
            rs = pst.getGeneratedKeys();
            rs.first();
            rs.close();
            pst.close();
            updateTrx(data);
        }catch (SQLException ex) {
            Logger.getLogger(ServiceBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateOrder(ModelBooking data) throws SQLException{
        String status = data.getCustomer().getKet();
        System.out.println("Status Order e "+status);
        System.out.println("Nama "+data.getCustomer().getNama());
        System.out.println("No Telp "+data.getCustomer().getNoTelp());
        System.out.println("Email "+data.getCustomer().getEmail());
        Date date = new Date();
        SimpleDateFormat ex = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
        sql="update Customer set LastOrder = '"+ex.format(date)+"' WHERE Nama='"+data.getCustomer().getNama()+"' AND NoTelp='"+data.getCustomer().getNoTelp()+"' AND Email='"+data.getCustomer().getEmail()+"' AND Keterangan='"+status+"'";
        pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
        pst.execute();
            rs = pst.getGeneratedKeys();
            rs.first();
            rs.close();
            pst.close();

    }
    public void updateTrx(ModelBooking data) {
        try{
        SimpleDateFormat ex = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
        sql = "update transaksi SET IdTipeTrx = "+data.getTransaksi().getTipeTrx()+", "
                + "IdPesanan="+data.getId()+", Subtotal="+data.getTransaksi().getSubTotal()+","
                + "DP="+data.getTransaksi().getDP()+",GrandTotal="+data.getTransaksi().getGrandTotal()+","
                + "StatusTransaksi='"+data.getTransaksi().getStatus()+"' WHERE IdTrx="+data.getTransaksi().getTrxID()+" LIMIT 1";
        pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
            pst.execute();
            rs = pst.getGeneratedKeys();
            rs.first();
            rs.close();
            pst.close();
        }catch (SQLException ex) {
            Logger.getLogger(ServiceBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getPaket(Combobox paket){
       paket.removeAllItems();
       List<String> la = new ArrayList<String>(); 
        try{
            sql = "SELECT * FROM sewa where isMember=0";
            pst = CC.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                String result = rs.getString("NamaSewa");
                la.add(result);
            }
            paket.setModel(new DefaultComboBoxModel<String>(la.toArray(new String[0])));
            int jumlah = rs.getRow();
            pst.close();
            rs.close();
        }catch(SQLException ex){
           Logger.getLogger(ServiceBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getPaketMember(Combobox paket){
       paket.removeAllItems();
       List<String> la = new ArrayList<String>(); 
        try{
            sql = "SELECT * FROM sewa";
            pst = CC.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                String result = rs.getString("NamaSewa");
                la.add(result);
            }
            paket.setModel(new DefaultComboBoxModel<String>(la.toArray(new String[0])));
            int jumlah = rs.getRow();
            pst.close();
            rs.close();
        }catch(SQLException ex){
           Logger.getLogger(ServiceBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getField(Combobox field){
       field.removeAllItems();
       List<String> la = new ArrayList<String>(); 
        try{
            sql = "SELECT * FROM lapangan";
            pst = CC.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                String result = rs.getString("NamaLapangan");
                la.add(result);
            }
            int jumlah = rs.getRow();
            field.setModel(new DefaultComboBoxModel<String>(la.toArray(new String[0])));
            field.setSelectedIndex(-1);
            pst.close();
            rs.close();
        }catch(SQLException ex){
           Logger.getLogger(ServiceBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int getPrice(String lapangan, String Jam){
        int price = 0;
            try{
            sql = "SELECT * FROM sewa WHERE NamaSewa = '"+Jam+"'";
            pst = CC.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                int result = rs.getInt("Harga");
                price=result;
                if(lapangan.equals("Lapangan 1 & 2")){
                   price = result*2;
                }
            }
            pst.close();
            rs.close(); 
         }catch(SQLException ex){
           Logger.getLogger(ServiceBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
        return price;
    }
    public void addTransaksi(ModelTransaksi data){
        try{ 
            sql= "INSERT INTO transaksi (IdTipeTrx, IdPesanan, Subtotal, DP, GrandTotal,StatusTransaksi) values (?,?,?,?,?,?)";
            pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, data.getTipeTrx());
            pst.setInt(2, data.getPesananID());
            pst.setLong(3, data.getSubTotal());
            pst.setLong(4, data.getDP());
            pst.setLong(5, data.getGrandTotal());
            pst.setString(6, data.getStatus());
            pst.execute();       
            rs = pst.getGeneratedKeys();
            rs.first();
            int transaksiID = rs.getInt(1);
            data.setTrxID(transaksiID);
            System.out.println("Keys : "+transaksiID);
              System.out.println("");
              System.out.println("Sub total = "+data.getSubTotal());
              System.out.println("diskon total = "+data.getDP());
              System.out.println("grand total = "+data.getGrandTotal());
            rs.close();
            pst.close();   
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    public int checkPaket(String paket) throws SQLException{
    int isMember=0;  
    try{ 
       sql="SELECT * FROM sewa WHERE NamaSewa='"+paket+"'";
       pst = CC.prepareStatement(sql);
       rs = pst.executeQuery();
       while(rs.next()){
            isMember = rs.getInt("isMember");
       }
       pst.close();
       rs.close();  
      }catch(SQLException e){
         System.err.println(e);
      }
      return isMember;
    }
    public Time getDurasi(String paket) throws SQLException{
       sql="SELECT * FROM sewa WHERE NamaSewa='"+paket+"'";
       Time time = new Time(0,0,0);
       pst = CC.prepareStatement(sql);
       rs = pst.executeQuery();
       while(rs.next()){
            time = rs.getTime("Durasi");
       }
       DateFormat sdf = new SimpleDateFormat("h:mm");
       System.out.println("TIME = "+sdf.format(time));
       pst.close();
       rs.close();  
       return time;
    }
}
