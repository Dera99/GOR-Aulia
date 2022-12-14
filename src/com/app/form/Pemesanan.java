package com.app.form;
import com.app.cell.CellActionBooking;
import com.app.component.Form;
import com.app.configurations.config;
import com.app.main.Main;
import com.app.model.ModelBooking;
import com.app.model.ModelCustomer;
import com.app.model.ModelTransaksi;
import com.app.services.ServiceBooking;
import com.app.swing.table.TableRowData;
import java.awt.Color;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.GoogleMaterialDesignIcon;
import javaswingdev.GoogleMaterialIcon;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import notification.Notification;
import org.apache.commons.lang3.time.DateUtils;

public class Pemesanan extends Form{

    public int getPesananID() {
        return pesananID;
    }
    public void setPesananID(int pesananID) {
        this.pesananID = pesananID;
    }
    public int getKode() {
        return kode;
    }
    public void setKode(int kode) {
        this.kode = kode;
    }
    public boolean isResult() {
        return result;
    }
    public void setResult(boolean result) {
        this.result = result;
    }
    ServiceBooking sb = new ServiceBooking();
    Main m = new Main();
    private int kode;
    private boolean result;
    public int id,trxID;
    private int pesananID;
    config con = new config();
    public Pemesanan() {
        initComponents();
        table1.addTableStyle(jScrollPane1);
        table1.setAnimateRowHeight(47);
        initTable();
        cbPaket.removeAllItems();
        sb.getPaket(cbPaket);
        cbPaket.setSelectedIndex(-1);
        cbPaket.removeItem("Member");
        sb.getField(cbLapangan);
    }
    
    private void initTable(){        
        table1.addTableCell(new CellActionBooking(), 7);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    table1.removeAllRows();
                    for (ModelBooking booking: new ServiceBooking().getBooking()) {
                        table1.addRow(booking, false);
                    }
                } catch (SQLException e) {
                    System.err.println(e);
                } catch (ParseException ex) {   
                    Logger.getLogger(Pemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }   
        }).start();
    }
    private void clear(){
        table1.clearSelection();
        btnPrint.setVisible(false);
        id=0;
        setPesananID(0);
        txtNama.setText("");
        txtMember.setText("");
        txtEmail.setText("");
        txtnoHp.setText("");
        cbPaket.setSelectedIndex(0);
        cbLapangan.setSelectedIndex(0);
        cbTimeReq.setSelectedIndex(0);
        lblPaket.setText("Null");
        lblHarga.setText("-");
        lblDP.setText("-");
        lblSisa.setText("-");
        txtNama.setEditable(true);
        txtEmail.setEditable(true);
        txtnoHp.setEditable(true);
        txtMember.setEditable(true);
        cbLapangan.setSelectedIndex(-1);
    }
    private boolean checkTime(ModelBooking data) throws ParseException, SQLException{
         
        boolean result=false;
        int duration,minute;
        String field = data.getField();
        String paket = data.getPaket();
        Date reqTime = data.getReqDate();   
        try {  
            if(sb.checkPaket(paket)==1){
                int i;
                for (i=0;i<=3;i++){
                   duration = reqTime.getHours()+sb.getDurasi(paket).getHours();
                   minute = reqTime.getMinutes()+sb.getDurasi(paket).getMinutes();
                    Date expired,request;
                    if(duration==24){
                        duration = 23;
                        request = DateUtils.addWeeks(reqTime,i);
                        expired = DateUtils.setHours(data.getReqDate(),23);
                        expired = DateUtils.setMinutes(expired,minute);
                    }else{
                        request = DateUtils.addWeeks(reqTime, i);
                        expired = DateUtils.setHours(data.getReqDate(),duration);
                        expired = DateUtils.setMinutes(expired,minute);
                    }
                    ModelCustomer cust = new ModelCustomer(0,"","","","");
                    ModelTransaksi trx = new ModelTransaksi(0,0,0,0,con.getDP(),0,null,"");
                    ModelBooking check = new ModelBooking(0,cust,paket,field,data.getReqDate(),expired,"",trx);
                     sb.checkRequest(check); 
                    }                      
                     if(sb.isResultCheck()==true){
                        result=true;
                    }
                    System.out.println("Result di pemesanan = "+isResult());
            }else {  
                duration = reqTime.getHours()+sb.getDurasi(paket).getHours();
                minute = reqTime.getMinutes()+sb.getDurasi(paket).getMinutes();
                Date expired;
                if(duration == 24){
                    expired = DateUtils.setHours(data.getReqDate(),23);
                    expired = DateUtils.setMinutes(data.getReqDate(),minute);
                }else{
                    expired = DateUtils.setHours(data.getReqDate(),duration);
                    expired = DateUtils.setMinutes(expired,minute);
                }       
                ModelCustomer cust = new ModelCustomer(0,"","","","");
                ModelTransaksi trx = new ModelTransaksi(0,0,0,0,con.getDP(),0,null,"");
                ModelBooking check = new ModelBooking(0,cust,paket,field,data.getReqDate(),expired,"",trx);
                //System.out.println("Midnight pemesanna");
                sb.checkRequest(check);
                    if(sb.isResultCheck()==true){
                        result=true;
                    }
            } 
                
        } catch (ParseException e) {
            Logger.getLogger(Pemesanan.class.getName()).log(Level.SEVERE, null, e);
        } 
        return result;
    }
    private void addPesanan(ModelBooking data) throws ParseException, SQLException{
       Notification err1= new Notification(m, Notification.Type.ERROR, Notification.Location.TOP_CENTER, "Jadwal Tidak Tersedia Silahkan Pilih Jadwal Lain !!");
       Notification err2= new Notification(m, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Silahkan Clear Pesanan Terlebih Dahulu !!");
       Notification succ= new Notification(m, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Pesanan Berhasil Dibuat !!");
       int duration,minute;
       int customerID = data.getCustomer().getCustomerID();
       String nama = data.getCustomer().getNama();
       String email = data.getCustomer().getEmail();
       String noTelp = data.getCustomer().getNoTelp();
       String memberType = data.getCustomer().getKet();
            String type;
               if(sb.isMember()==true){
                   type="Member";
               }else{
                   type="Reguler";
               } 
       ModelCustomer customer = new ModelCustomer(customerID,nama,noTelp,email,type);
        String field = data.getField();
        String paket = data.getPaket();
        Date reqTime = data.getReqDate();
        long subTotal = data.getTransaksi().getSubTotal();
        long grandTotal = data.getTransaksi().getGrandTotal();
        ModelTransaksi cek = new ModelTransaksi(0,0,0,0,con.getDP(),0,null,"");
        ModelBooking check = new ModelBooking(0,customer,paket,field,reqTime,null,"",cek);
        if(pesananID==0){
        if(checkTime(check)==true){
            setResult(true);  
            if(sb.checkPaket(paket)==1 && sb.isMember()==true){
                int i;
                for (i=0;i<=3;i++){
                   duration = reqTime.getHours()+sb.getDurasi(paket).getHours();
                   minute = reqTime.getMinutes()+sb.getDurasi(paket).getMinutes();
                   Date expired,request;
                    if(duration==24){
                        duration = 23;
                        request = DateUtils.addWeeks(reqTime,i);
                        expired = DateUtils.addWeeks(data.getReqDate(),i);
                        expired = DateUtils.setHours(expired,23);
                        expired = DateUtils.setMinutes(expired,minute);
                    }else{
                        request = DateUtils.addWeeks(reqTime, i);
                        expired = DateUtils.addWeeks(data.getReqDate(), i);
                        expired = DateUtils.setHours(expired,duration);
                        expired = DateUtils.setMinutes(expired, minute);
                    }
                    ModelBooking insert = new ModelBooking(0,customer,paket,field,request,expired,"",new ModelTransaksi(0,2,pesananID,subTotal,0,grandTotal,null,"Selesai"));
                    sb.insertData(insert); 
                    pesananID = insert.getId();
                    ModelTransaksi trx = new ModelTransaksi(0,2,pesananID,subTotal,0,grandTotal,null,"Selesai");
                    sb.addTransaksi(trx);
                }  
                    succ.showNotification();
                    
            }else {
                duration = reqTime.getHours()+sb.getDurasi(paket).getHours();
                minute = reqTime.getMinutes()+sb.getDurasi(paket).getMinutes();
                Date expired;
                if(duration == 24){
                    expired = DateUtils.setHours(data.getReqDate(),23);
                    expired = DateUtils.setMinutes(expired,59);
                }else{
                    expired = DateUtils.setHours(data.getReqDate(),duration);
                    expired = DateUtils.setMinutes(expired,minute);
                } 
               ModelBooking insert = new ModelBooking(0,customer,paket,field,data.getReqDate(),expired,"", new ModelTransaksi(0,1,pesananID,subTotal,data.getTransaksi().getDP(),grandTotal,null,"Pending"));
               sb.insertData(insert);
               pesananID = insert.getId();
               ModelTransaksi trx = new ModelTransaksi(0,1,pesananID,subTotal,con.getDP(),grandTotal,null,"Pending");
               sb.addTransaksi(trx);
               
               succ.showNotification();
            } 
       }else{
           err1.showNotification();
           setResult(false);
       }
    }else{
        err2.showNotification();
        }
   }
    private void updatePesanan(ModelBooking data) throws ParseException, SQLException{
       Notification err1= new Notification(m, Notification.Type.ERROR, Notification.Location.TOP_CENTER, "Jadwal Tidak Tersedia Silahkan Pilih Jadwal Lain !!");
       Notification err2= new Notification(m, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Silahkan Pilih Daftar Pesanan Terlebih Dahulu !!");
       Notification succ= new Notification(m, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Pesanan Berhasil Dibuat !!");
       int duration,minute;
       int customerID = data.getCustomer().getCustomerID();
       String nama = data.getCustomer().getNama();
       String email = data.getCustomer().getEmail();
       String noTelp = data.getCustomer().getNoTelp();
       String memberType = data.getCustomer().getKet();
       ModelCustomer customer = new ModelCustomer(customerID,nama,noTelp,email,memberType);
        String field = data.getField();
        String paket = data.getPaket();
        Date reqTime = data.getReqDate(); 
        long subTotal = data.getTransaksi().getSubTotal();
        long grandTotal = data.getTransaksi().getGrandTotal();
        ModelTransaksi cek = new ModelTransaksi(0,0,0,0,con.getDP(),0,null,"");
        ModelBooking check = new ModelBooking(getPesananID(),customer,paket,field,reqTime,null,"",cek);
        if(getPesananID()!=0){
        if(checkTime(check)==true){
            setResult(true);
            if(sb.checkPaket(paket)==1 && sb.isMember()==true){
                int i;
                duration = reqTime.getHours()+sb.getDurasi(paket).getHours();
                minute = reqTime.getMinutes()+sb.getDurasi(paket).getMinutes();
                Date expired,request;
                for (i=0;i<=3;i++){
                      if(duration==24){
                        duration = 23;
                        request = DateUtils.addWeeks(reqTime,i);
                        expired = DateUtils.addWeeks(data.getReqDate(),i);
                        expired = DateUtils.setHours(expired,23);
                        expired = DateUtils.setMinutes(expired,minute);
                    }else{
                        request = DateUtils.addWeeks(reqTime, i);
                        expired = DateUtils.addWeeks(data.getReqDate(), i);
                        expired = DateUtils.setHours(expired,duration);
                        expired = DateUtils.setMinutes(expired,minute);
                    }
                    ModelTransaksi trx = new ModelTransaksi(trxID,2, pesananID,subTotal,0,grandTotal,null,"Selesai");
                    ModelBooking add = new ModelBooking(pesananID,customer,paket,field,request,expired,"Member",trx);
                    sb.updateBooked(add);  
                    sb.updateOrder(add);
                }
                        succ.showNotification();
            }else {
                duration = reqTime.getHours()+sb.getDurasi(paket).getHours();
                minute = reqTime.getMinutes()+sb.getDurasi(paket).getMinutes(); 
                Date expired;
                if(duration == 24){
                    expired = DateUtils.setHours(data.getReqDate(),23);
                    expired = DateUtils.setMinutes(expired,minute);
                }else{
                    expired = DateUtils.setHours(data.getReqDate(),duration);
                    expired = DateUtils.setMinutes(expired,minute);
                }
                ModelTransaksi trx = new ModelTransaksi(trxID,1, getPesananID(),subTotal,con.getDP(),grandTotal,null,"Pending");
                ModelBooking insert = new ModelBooking(getPesananID(),customer,paket,field,data.getReqDate(),expired,"",trx);
                System.out.println("ID Pesanan "+pesananID);
                sb.updateBooked(insert);
                sb.updateOrder(insert);
                succ.showNotification();
            } 
       }else{
           err1.showNotification();
       }
    }else{
        setResult(true);
        err2.showNotification();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser = new com.app.swing.datechooser.DateChooser();
        roundPanel1 = new com.app.swing.RoundPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.app.swing.table.Table();
        btnPrint = new com.app.swing.Button();
        serch = new com.app.swing.TextField();
        roundPanel2 = new com.app.swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        btnAdd = new com.app.swing.Button();
        roundPanel3 = new com.app.swing.RoundPanel();
        txtMember = new com.app.swing.TextField();
        btnSearch = new com.app.swing.Button();
        txtNama = new com.app.swing.TextField();
        txtEmail = new com.app.swing.TextField();
        txtnoHp = new com.app.swing.TextField();
        jLabel3 = new javax.swing.JLabel();
        roundPanel4 = new com.app.swing.RoundPanel();
        txtDate = new com.app.swing.TextField();
        cbLapangan = new com.app.swing.Combobox();
        jLabel4 = new javax.swing.JLabel();
        cbPaket = new com.app.swing.Combobox();
        cbTimeReq = new com.app.swing.Combobox();
        btnCheck = new com.app.swing.Button();
        btnClear = new com.app.swing.Button();
        roundPanel5 = new com.app.swing.RoundPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblHarga = new javax.swing.JLabel();
        line1 = new com.app.swing.Line();
        jLabel8 = new javax.swing.JLabel();
        lblDP = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblPaket = new javax.swing.JLabel();
        lblSisa = new javax.swing.JLabel();
        btnUpdate = new com.app.swing.Button();

        dateChooser.setForeground(new java.awt.Color(51, 149, 225));
        dateChooser.setTextRefernce(txtDate);

        roundPanel1.setBackground(new java.awt.Color(60, 60, 60));
        roundPanel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Daftar Pesanan");

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Pesanan", "Penyewa", "Paket Sewa", "Lapangan", "Tanggal Pesan", "Jam Mulai", "Status", "Action"
            }
        ));
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                table1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(1).setPreferredWidth(250);
            table1.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        btnPrint.setBackground(new java.awt.Color(51, 149, 225));
        btnPrint.setForeground(new java.awt.Color(240, 240, 240));
        btnPrint.setText("Cetak");
        btnPrint.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnPrint.setPreferredSize(new java.awt.Dimension(43, 27));
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        ;
        GoogleMaterialIcon icn = new GoogleMaterialIcon();
        icn.setIcon(GoogleMaterialDesignIcon.PRINT);
        icn.setColor1(Color.white);
        icn.setColor2(Color.white);
        btnPrint.setIcon(icn.toIcon());

        serch.setBackground(new java.awt.Color(60, 60, 60));
        serch.setForeground(new java.awt.Color(242, 242, 242));
        serch.setLabelText("Search");
        serch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                serchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(serch, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(serch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnPrint.setVisible(false);

        roundPanel2.setBackground(new java.awt.Color(60, 60, 60));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Buat Pesanan");

        btnAdd.setBackground(new java.awt.Color(51, 149, 225));
        btnAdd.setForeground(new java.awt.Color(240, 240, 240));
        btnAdd.setText("Add");
        btnAdd.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        GoogleMaterialIcon icon2 = new GoogleMaterialIcon();
        icon2.setIcon(GoogleMaterialDesignIcon.ADD_CIRCLE_OUTLINE);
        icon2.setColor1(Color.white);
        icon2.setColor2(Color.white);
        btnAdd.setIcon(icon2.toIcon());

        roundPanel3.setBackground(new java.awt.Color(55, 55, 55));

        txtMember.setBackground(new java.awt.Color(55, 55, 55));
        txtMember.setForeground(new java.awt.Color(240, 240, 240));
        txtMember.setLabelText("Kode Member");

        btnSearch.setBackground(new java.awt.Color(50, 200, 126));
        btnSearch.setForeground(new java.awt.Color(240, 240, 240));
        btnSearch.setText("Cari");
        btnSearch.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtNama.setBackground(new java.awt.Color(55, 55, 55));
        txtNama.setForeground(new java.awt.Color(240, 240, 240));
        txtNama.setLabelText("Nama");

        txtEmail.setBackground(new java.awt.Color(55, 55, 55));
        txtEmail.setForeground(new java.awt.Color(240, 240, 240));
        txtEmail.setLabelText("Email");

        txtnoHp.setBackground(new java.awt.Color(55, 55, 55));
        txtnoHp.setForeground(new java.awt.Color(240, 240, 240));
        txtnoHp.setLabelText("No Handphone");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Data Customer");

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(roundPanel3Layout.createSequentialGroup()
                                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMember, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                    .addComponent(txtnoHp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 26, Short.MAX_VALUE))))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnoHp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        GoogleMaterialIcon icon = new GoogleMaterialIcon();
        icon.setIcon(GoogleMaterialDesignIcon.SEARCH);
        icon.setColor1(Color.white);
        icon.setColor2(Color.white);
        btnSearch.setIcon(icon.toIcon());

        roundPanel4.setBackground(new java.awt.Color(55, 55, 55));

        txtDate.setBackground(new java.awt.Color(55, 55, 55));
        txtDate.setForeground(new java.awt.Color(240, 240, 240));
        txtDate.setLabelText("Tanggal Pesanan");

        cbLapangan.setForeground(new java.awt.Color(240, 240, 240));
        cbLapangan.setLabeText("Lapangan :");
        cbLapangan.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Detail Pesanan");

        cbPaket.setForeground(new java.awt.Color(240, 240, 240));
        cbPaket.setLabeText("Paket Sewa :");
        cbPaket.setOpaque(false);

        cbTimeReq.setForeground(new java.awt.Color(240, 240, 240));
        cbTimeReq.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00" }));
        cbTimeReq.setSelectedIndex(-1);
        cbTimeReq.setLabeText("Jam Mulai :");
        cbTimeReq.setOpaque(false);

        btnCheck.setBackground(new java.awt.Color(50, 200, 126));
        btnCheck.setForeground(new java.awt.Color(240, 240, 240));
        btnCheck.setText("Check");
        btnCheck.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnCheck.setPreferredSize(new java.awt.Dimension(43, 27));
        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel4Layout = new javax.swing.GroupLayout(roundPanel4);
        roundPanel4.setLayout(roundPanel4Layout);
        roundPanel4Layout.setHorizontalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbLapangan, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbPaket, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTimeReq, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );
        roundPanel4Layout.setVerticalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPaket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbLapangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTimeReq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        GoogleMaterialIcon check = new GoogleMaterialIcon();
        check.setIcon(GoogleMaterialDesignIcon.SEARCH);
        check.setColor1(Color.white);
        check.setColor2(Color.white);
        btnCheck.setIcon(check.toIcon());

        btnClear.setBackground(new java.awt.Color(253, 83, 63));
        btnClear.setForeground(new java.awt.Color(240, 240, 240));
        btnClear.setText("Clear");
        btnClear.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        GoogleMaterialIcon icon4 = new GoogleMaterialIcon();
        icon4.setIcon(GoogleMaterialDesignIcon.DELETE);
        icon4.setColor1(Color.white);
        icon4.setColor2(Color.white);
        btnClear.setIcon(icon4.toIcon());

        roundPanel5.setBackground(new java.awt.Color(55, 55, 55));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Detail Harga");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Harga           =");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("Total DP       =");

        lblHarga.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        lblHarga.setForeground(new java.awt.Color(240, 240, 240));
        lblHarga.setText("-");

        javax.swing.GroupLayout line1Layout = new javax.swing.GroupLayout(line1);
        line1.setLayout(line1Layout);
        line1Layout.setHorizontalGroup(
            line1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 184, Short.MAX_VALUE)
        );
        line1Layout.setVerticalGroup(
            line1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(240, 240, 240));
        jLabel8.setText("Sisa Bayar    =");

        lblDP.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        lblDP.setForeground(new java.awt.Color(240, 240, 240));
        lblDP.setText("-");

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(240, 240, 240));
        jLabel9.setText("Paket            :");

        lblPaket.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        lblPaket.setForeground(new java.awt.Color(240, 240, 240));
        lblPaket.setText("Null");

        lblSisa.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        lblSisa.setForeground(new java.awt.Color(240, 240, 240));
        lblSisa.setText("-");

        javax.swing.GroupLayout roundPanel5Layout = new javax.swing.GroupLayout(roundPanel5);
        roundPanel5.setLayout(roundPanel5Layout);
        roundPanel5Layout.setHorizontalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel5Layout.createSequentialGroup()
                .addGap(0, 129, Short.MAX_VALUE)
                .addComponent(line1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(lblHarga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(roundPanel5Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(lblDP))
                    .addGroup(roundPanel5Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSisa)
                            .addComponent(lblPaket))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel5Layout.setVerticalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblPaket))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(roundPanel5Layout.createSequentialGroup()
                        .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(lblHarga))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addComponent(lblDP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblSisa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnUpdate.setBackground(new java.awt.Color(50, 200, 126));
        btnUpdate.setForeground(new java.awt.Color(240, 240, 240));
        btnUpdate.setText("Update");
        btnUpdate.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnUpdate.setPreferredSize(new java.awt.Dimension(43, 27));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(roundPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(roundPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        GoogleMaterialIcon icon3 = new GoogleMaterialIcon();
        icon3.setIcon(GoogleMaterialDesignIcon.UPDATE);
        icon3.setColor1(Color.white);
        icon3.setColor2(Color.white);
        btnUpdate.setIcon(icon3.toIcon());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
     Notification err= new Notification(m, Notification.Type.ERROR, Notification.Location.TOP_CENTER, "Kode Member Salah !!");
     Notification succ= new Notification(m, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Kode Member Berhasil Ditemukan !");
     try {
            sb.isMember(Integer.parseInt(txtMember.getText()));
            if(sb.isMember()==true){
                succ.showNotification();
                txtNama.setText(sb.dataCustomer.getNama());
                txtnoHp.setText(sb.dataCustomer.getNoTelp());
                txtEmail.setText(sb.dataCustomer.getEmail());
                cbPaket.removeAllItems();
                sb.getPaketMember(cbPaket);
                cbPaket.setSelectedIndex(-1);
            }else{
                err.showNotification();
                cbPaket.removeAllItems();
                sb.getPaket(cbPaket);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        Notification err4= new Notification(m, Notification.Type.ERROR, Notification.Location.TOP_CENTER, "Pesanan Tidak Sesuai Jam Oprasional !!");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat tf=new SimpleDateFormat("H:mm");       
        Notification err= new Notification(m, Notification.Type.ERROR, Notification.Location.TOP_CENTER, "Jadwal Tidak Tersedia !");
        Notification succ= new Notification(m, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Jadwal Tersedia !");       
        try {
            Date date = sdf.parse(txtDate.getText());
            String field = cbLapangan.getSelectedItem().toString();
            String paket = (String) cbPaket.getSelectedItem();
            String startTime = paket.replaceAll("[^0-9]", ""); 
            String request = cbTimeReq.getSelectedItem().toString();      
            Date reqTime = tf.parse(request);
            Date dateRequest = DateUtils.setHours(date,reqTime.getHours());
            ModelCustomer cust = new ModelCustomer(0,"","","","");
            ModelTransaksi cek = new ModelTransaksi(0,0,0,0,con.getDP(),0,null,"Pending");
            ModelBooking data = new ModelBooking(0,cust,paket,field,dateRequest,null,"",cek);
            if(checkTime(data)==true){
                succ.showNotification();
                lblPaket.setText(paket);
                int harga = sb.getPrice(field, paket);
                int DP = con.getDP();
                if(sb.checkPaket(paket)==1){
                    DP = 0;
                }
                int sisa = harga-DP;
                lblHarga.setText("Rp "+String.valueOf(harga)+" ,-");
                lblDP.setText("Rp "+String.valueOf(DP)+" ,-");
                lblSisa.setText("Rp "+String.valueOf(sisa)+" ,-");
            }else{
                err.showNotification();
            }
        } catch (ParseException ex) {
            Logger.getLogger(Pemesanan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Pemesanan.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IllegalArgumentException e){
            err4.showNotification();
        }
    }//GEN-LAST:event_btnCheckActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Notification err4= new Notification(m, Notification.Type.ERROR, Notification.Location.TOP_CENTER, "Silahkan Check Pesanan !!");
        Notification err= new Notification(m, Notification.Type.ERROR, Notification.Location.TOP_CENTER, "Pesanan Tidak Boleh Kosong !!");
        Notification err3= new Notification(m, Notification.Type.ERROR, Notification.Location.TOP_CENTER, "Pesanan Gagal Ditambahkan !!");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat tf=new SimpleDateFormat("H:mm"); 
        try {
            String nama = txtNama.getText();
            String noTelp = txtnoHp.getText();
            String email = txtEmail.getText();
            String member = txtMember.getText();
            System.out.println("Kode Member = "+getKode());
            int id = 0;
            ModelCustomer customer = new ModelCustomer(id,nama,noTelp,email,"");
                Date date = sdf.parse(txtDate.getText());
                String field = cbLapangan.getSelectedItem().toString();
                String paket = (String) cbPaket.getSelectedItem();
                String startTime = paket.replaceAll("[^0-9]", ""); 
                String request = cbTimeReq.getSelectedItem().toString();      
                Date reqTime = tf.parse(request);
                Date dateRequest = DateUtils.setHours(date,reqTime.getHours());
                int tipe = 1;
                int dp = con.getDP();
                if(sb.checkPaket(paket)==1){
                    tipe=2;
                    dp = 0;
                }
                long subTotal = Long.parseLong(lblHarga.getText().replaceAll("[^0-9]", ""));
                long grandTotal = Long.parseLong(lblSisa.getText().replaceAll("[^0-9]", ""));
                ModelTransaksi trx = new ModelTransaksi(0,tipe, getPesananID(),subTotal,dp,grandTotal,null,"Pending");
                ModelBooking data = new ModelBooking(0,customer,paket,field,dateRequest,null,"",trx);
            addPesanan(data);
            initTable(); 
            clear();
        } catch (ParseException e) {
            Logger.getLogger(Pemesanan.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            System.err.println(ex);
             Logger.getLogger(Pemesanan.class.getName()).log(Level.SEVERE, null, ex);
            err3.showNotification();
        }catch (IllegalArgumentException e){
            err4.showNotification();
            System.err.println(e);
        }catch (NullPointerException ex){
            err.showNotification();
            System.err.println(ex);
        } 
    }//GEN-LAST:event_btnAddActionPerformed

    private void table1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseReleased
        try {
            // TODO add your handling code here
            btnPrint.setVisible(true);
            int row = table1.getSelectedRow();
            TableRowData rowData = table1.getModelData(row);
            ModelCustomer name = (ModelCustomer) table1.getValueAt(row, 1);
            String paket = (String) table1.getValueAt(row,2);
            String field = (String) table1.getValueAt(row,3);
            String date = (String) table1.getValueAt(row, 4);
            String data = (String) table1.getValueAt(row, 5);
            id = name.getCustomerID();
            trxID = ((ModelBooking)rowData).getTransaksi().getTrxID();
            System.out.println("trxID = "+trxID);
            String b  = table1.getValueAt(row,0).toString();
            String pesanan = b.replace("R","");
            if(!b.contains("R")){
                pesanan=b.replace("M","");
            }
            System.out.println("pesanan "+pesanan);
            setPesananID((Integer.parseInt(pesanan)));
            String a;
            if(data.equals("8:00") || data.equals("9:00")){
                a = data.substring(0,4);
            }else{
                a = data.substring(0,5);
            }
            String Time = a.replace(" ", "");
            
            txtNama.setText(name.getNama());
            txtEmail.setText(name.getEmail());
            txtnoHp.setText(name.getNoTelp());
            txtNama.setEditable(false);
            txtEmail.setEditable(false);
            txtnoHp.setEditable(false);
            if(sb.checkPaket(paket)==1){
                txtMember.setText(String.valueOf(name.getCustomerID()));
                cbPaket.removeAllItems();
                sb.getPaketMember(cbPaket);
                cbPaket.setSelectedIndex(-1);
                cbPaket.setEnabled(false);
                txtDate.setEditable(false);
                cbLapangan.setEnabled(false);
                cbTimeReq.setEnabled(false);
                btnUpdate.setEnabled(false);
            }else{
                cbPaket.removeAllItems();
                sb.getPaket(cbPaket);
                txtMember.setText("");
                cbPaket.setSelectedIndex(-1);
                cbPaket.setEnabled(true);
                txtDate.setEditable(true);
                cbLapangan.setEnabled(true);
                cbTimeReq.setEnabled(true);
                btnUpdate.setEnabled(true);
            }
            txtMember.setEditable(false);
            txtDate.setText(date);
            cbLapangan.setSelectedItem(field);
            cbTimeReq.setSelectedItem(Time);
            cbPaket.setSelectedItem(paket);
            lblPaket.setText(paket);
            int harga = sb.getPrice(field, paket);
            int DP = con.getDP();
            if(sb.checkPaket(paket)==1){
                DP = 0;
            }
            int sisa = harga-DP;
            lblHarga.setText("Rp "+String.valueOf(harga)+" ,-");
            lblDP.setText("Rp "+String.valueOf(DP)+" ,-");
            lblSisa.setText("Rp "+String.valueOf(sisa)+" ,-");
        } catch (SQLException ex) {
            System.err.println(ex);
        }
  
    }//GEN-LAST:event_table1MouseReleased

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        table1.clearSelection();
        btnPrint.setVisible(false);
        id=0;
        setPesananID(0);
        txtNama.setText("");
        txtMember.setText("");
        txtEmail.setText("");
        txtnoHp.setText("");
        sb.getPaket(cbPaket);
        cbPaket.setSelectedIndex(0);
        cbLapangan.setSelectedIndex(0);
        cbTimeReq.setSelectedIndex(0);
        lblPaket.setText("Null");
        lblHarga.setText("-");
        lblDP.setText("-");
        lblSisa.setText("-");
        txtNama.setEditable(true);
        txtEmail.setEditable(true);
        txtnoHp.setEditable(true);
        txtMember.setEditable(true);
        btnUpdate.setEnabled(true);
           cbPaket.setEnabled(true);
           txtDate.setEditable(true);
           cbLapangan.setEnabled(true);
           cbTimeReq.setEnabled(true);
           btnUpdate.setEnabled(true);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        Notification err= new Notification(m, Notification.Type.ERROR, Notification.Location.TOP_CENTER, "Pesanan Tidak Boleh Kosong !!");
        Notification err2= new Notification(m, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Silahkan Pilih Daftar Pesanan Terlebih Dahulu !!");
        if(getPesananID()==0){
            err2.showNotification();
        }else{
        Notification err4= new Notification(m, Notification.Type.ERROR, Notification.Location.TOP_CENTER, "Pesanan Tidak Sesuai Jam Oprasional !!");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat tf=new SimpleDateFormat("H:mm"); 
        try {
            String nama = txtNama.getText();
            String noTelp = txtnoHp.getText();
            String email = txtEmail.getText();
            String member = txtMember.getText();
            System.out.println("Kode Member = "+getKode());
            System.out.println("pesanan ID = "+getPesananID());
            ModelCustomer customer = new ModelCustomer(getKode(),nama,noTelp,email,"");
                Date date = sdf.parse(txtDate.getText());
                String field = cbLapangan.getSelectedItem().toString();
                String paket = (String) cbPaket.getSelectedItem();
                String startTime = paket.replaceAll("[^0-9]", ""); 
                String request = cbTimeReq.getSelectedItem().toString();      
                Date reqTime = tf.parse(request);
                Date dateRequest = DateUtils.setHours(date,reqTime.getHours());
                int tipe = 1;
                int dp = con.getDP();
                if(sb.checkPaket(paket)==1){
                    tipe=2;
                    dp = 0;
                }
                
                long subTotal = Long.parseLong(lblHarga.getText().replaceAll("[^0-9]", ""));
                long grandTotal = Long.parseLong(lblSisa.getText().replaceAll("[^0-9]", ""));
                ModelTransaksi trx = new ModelTransaksi(0,tipe,getKode(),subTotal,dp,grandTotal,null,"Pending");
                ModelBooking data = new ModelBooking(getPesananID(),customer,paket,field,dateRequest,null,"",trx);
            updatePesanan(data);
            initTable(); 
            clear();
        } catch (ParseException e) {
            Logger.getLogger(Pemesanan.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            Logger.getLogger(Pemesanan.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IllegalArgumentException e){
            err4.showNotification();
            System.err.println(e);
        }catch (NullPointerException ex){
            err.showNotification();
        }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void serchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serchKeyReleased
        // TODO add your handling code here:
        table1.stopCellEditing();
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table1.getModel());
        String value = serch.getText();
        String result = value.substring(0, 1).toUpperCase() + value.substring(1);
        sorter.setRowFilter(RowFilter.regexFilter(result));
        table1.setRowSorter(sorter);
        table1.autoRowHeight();
    }//GEN-LAST:event_serchKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.swing.Button btnAdd;
    private com.app.swing.Button btnCheck;
    private com.app.swing.Button btnClear;
    private com.app.swing.Button btnPrint;
    private com.app.swing.Button btnSearch;
    private com.app.swing.Button btnUpdate;
    private com.app.swing.Combobox cbLapangan;
    private com.app.swing.Combobox cbPaket;
    private com.app.swing.Combobox cbTimeReq;
    private com.app.swing.datechooser.DateChooser dateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDP;
    private javax.swing.JLabel lblHarga;
    private javax.swing.JLabel lblPaket;
    private javax.swing.JLabel lblSisa;
    private com.app.swing.Line line1;
    private com.app.swing.RoundPanel roundPanel1;
    private com.app.swing.RoundPanel roundPanel2;
    private com.app.swing.RoundPanel roundPanel3;
    private com.app.swing.RoundPanel roundPanel4;
    private com.app.swing.RoundPanel roundPanel5;
    private com.app.swing.TextField serch;
    private com.app.swing.table.Table table1;
    private com.app.swing.TextField txtDate;
    private com.app.swing.TextField txtEmail;
    private com.app.swing.TextField txtMember;
    public com.app.swing.TextField txtNama;
    private com.app.swing.TextField txtnoHp;
    // End of variables declaration//GEN-END:variables
}
