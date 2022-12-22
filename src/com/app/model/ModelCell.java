package com.app.model;

import com.app.swing.Combobox;
import java.util.List;

public class ModelCell {

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
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

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    public boolean isResultCek() {
        return resultCek;
    }
    public void setResultCek(boolean resultCek) {
        this.resultCek = resultCek;
    }
    public String getMemberType() {
        return memberType;
    }
    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }
    public List<String> getResult() {
        return result;
    }
    public void setResult(List<String> result) {
        this.result = result;
    }
    public Combobox getComboBox() {
        return comboBox;
    }
    public void setComboBox(Combobox comboBox) {
        this.comboBox = comboBox;
    }
    private Combobox comboBox;
    private List<String> result;
    private String memberType;
    private boolean resultCek;
    public ModelCell(Combobox comboBox){
        this.comboBox=comboBox;
    }
    public ModelCell(String memberType,Combobox comboBox){
        this.memberType=memberType;
        this.comboBox=comboBox;
    }
    public ModelCell(boolean resultCek,Combobox comboBox){
        this.resultCek=resultCek;
        this.comboBox=comboBox;
    }
    
    private int kode;
    private String nama;
    private String noTelp;
    private String email;
    public ModelCell(int kode,String nama, String noTelp, String email){
        this.kode=kode;
        this.nama=nama;
        this.noTelp=noTelp;
        this.email=email;
    }
    public ModelCell(){}
}
