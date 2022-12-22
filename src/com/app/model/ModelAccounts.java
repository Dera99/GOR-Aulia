package com.app.model;

import javax.swing.Icon;

public class ModelAccounts{
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
    public Icon getProfile() {
        return profile;
    }
    public void setProfile(Icon profile) {
        this.profile = profile;
    }
    private int userID;
    private String username;
    private String password;
    private int roleID;
    private Icon profile;
    public ModelAccounts(){}
    public ModelAccounts(int userID,String username, String password, int roleID, Icon profile){
        this.userID = userID;
        this.username=username;
        this.password=password;
        this.roleID=roleID;
        this.profile=profile;
    }
}
