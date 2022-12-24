package com.app.model;

import com.app.swing.table.TableRowData;
import javax.swing.Icon;

public class ModelAccounts{
    public ModelStaff getStaff() {
        return staff;
    }
    public void setStaff(ModelStaff staff) {
        this.staff = staff;
    }
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getRoleID() {
        return roleID;
    }
    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }
    private int userID;
    private String username;
    private String password;
    private int roleID;
    private ModelStaff staff;
    public ModelAccounts(){}
//    public ModelAccounts(int userID,String username, String password, int roleID, ModelStaff staff){
//        this.userID = userID;
//        this.username=username;
//        this.password=password;
//        this.roleID=roleID;
//        this.staff=staff;
//    }
    public ModelAccounts(int userID,String username, String password, int roleID){
        this.userID = userID;
        this.username=username;
        this.password=password;
        this.roleID=roleID;
    }
    @Override
    public String toString() {
        return username;
    }
}
