
package com.app.service;

import javax.swing.Icon;

public class UserSession {



    private static String userLogin;
    private static int UserId;
    private static int RoleId;
    private static Icon icon;
    
    public static void setUserLogin(String userLogin) {
        UserSession.userLogin = userLogin;
    }
    public static void setUserId(int UserId) {
        UserSession.UserId = UserId;
    }
    public static void setRoleId(int RoleId) {
        UserSession.RoleId = RoleId;
    }
    public static void setIcon(Icon aIcon) {
        icon = aIcon;
    }
    public static String getUserLogin() {
        return userLogin;
    }
    public static int GetUserId(){
        return UserId;
    }
    public static int getRoleId() {
        return RoleId;
    }
    public static Icon getIcon() {
        return icon;
    }
 
   
}