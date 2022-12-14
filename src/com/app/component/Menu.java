package com.app.component;

import com.app.event.MenuEvent;
import com.app.services.ServiceSettings;
import com.app.services.UserSession;
import com.app.swing.MenuButton;
import com.app.swing.Split;
import com.app.swing.scroll.ScrollBarCustom;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javaswingdev.GoogleMaterialDesignIcon;
import static javaswingdev.GoogleMaterialDesignIcon.DASHBOARD;
import javaswingdev.GoogleMaterialIcon;
import javaswingdev.GradientType;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import com.app.theme.ColorGradient;
import javaswingdev.FontAwesome;
        
public class Menu extends javax.swing.JPanel { 


    private MenuButton selectedMenu;
    private MenuButton unSelectedMenu;
    private Animator animator;
    private MenuEvent event;
    private GoogleMaterialDesignIcon icon;
    private FontAwesome icn;
    int roleID = UserSession.getRoleId();
    String userLogin = UserSession.getUserLogin();
    String security = "Staff";
    public Menu() {
        initComponents();
        setOpaque(false);
        Image.setImage(UserSession.getIcon());
        scroll.setViewportBorder(null);
        scroll.setBorder(null);
        scroll.getViewport().setOpaque(false);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        panelMenu.setLayout(new MigLayout("wrap, fillx, inset 0", "[fill]"));
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                selectedMenu.setAnimate(fraction);
                if (unSelectedMenu != null) {
                    unSelectedMenu.setAnimate(1f - fraction);
                }
            }
        };
        animator = new Animator(300, target);
        animator.setAcceleration(.5f);
        animator.setDeceleration(.5f);
        animator.setResolution(0);
        if(roleID==1){
            security="Admin";
        }
        lblSecurity.setText(security);
        lblUser.setText(userLogin);
        
    }

    public void initMenu(MenuEvent event) {
        this.event = event;
        if(roleID==0){
        addMenu(DASHBOARD, "Dashboard", 0);
        split("Penyewaan");
        addMenu(GoogleMaterialDesignIcon.EVENT, "Pemesanan", 1);
        addMenu(GoogleMaterialDesignIcon.PAYMENT, "Transaksi", 2); 
        addMenu(GoogleMaterialDesignIcon.FORMAT_LIST_BULLETED, "Paket Sewa", 3); 
        addMenu(GoogleMaterialDesignIcon.GROUP, "Customer", 4); 
        split("Staff");
        addMenu(GoogleMaterialDesignIcon.ACCOUNT_BOX, "Data Staff", 5);
        split("Laporan");
        addMenu(GoogleMaterialDesignIcon.PERSON, "Customer Reguler", 6);
        addMenu(GoogleMaterialDesignIcon.GROUPS, "Customer Member", 7);
        addMenu("4", "Transaksi", 8);
        addMenu("7", "Pemesanan", 9);
        split("Account");
        addMenu(GoogleMaterialDesignIcon.ADMIN_PANEL, "Panel Admin", 10);    
        addMenu(GoogleMaterialDesignIcon.LOGOUT, "Logout", 11);
        }else{
          addMenu(DASHBOARD, "Dashboard", 0);
          split("Penyewaan");
          addMenu(GoogleMaterialDesignIcon.EVENT, "Pemesanan", 1);
          addMenu(GoogleMaterialDesignIcon.PAYMENT, "Transaksi", 2); 
          addMenu(GoogleMaterialDesignIcon.FORMAT_LIST_BULLETED, "Paket Sewa", 3); 
          addMenu(GoogleMaterialDesignIcon.GROUP, "Customer", 4);  
          split("Account");
          addMenu(GoogleMaterialDesignIcon.MANAGE_ACCOUNTS, "Pengaturan", 10);    
          addMenu(GoogleMaterialDesignIcon.LOGOUT, "Logout", 11);
        }
    }
  

    private void addMenu(GoogleMaterialDesignIcon icon, String text, int index) {
        this.icon=icon;
        MenuButton menu = new MenuButton(index);
        setFont(menu.getFont().deriveFont(Font.PLAIN, 14));
        //menu.setIcon(new ImageIcon(getClass().getResource("/com/app/icon/" + icon + ".png")));
        menu.setIcon(new GoogleMaterialIcon(icon,GradientType.HORIZONTAL, ColorGradient.MAIN_COLOR_1, ColorGradient.MAIN_COLOR_2, 19).toIcon());
        menu.setText("  " + text);
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    if (menu != selectedMenu) {
                        unSelectedMenu = selectedMenu;
                        selectedMenu = menu;
                        animator.start();
                        event.menuSelected(index);
                    }
                }
            }
        });
        panelMenu.add(menu);
    }
    private void addMenu(String icon, String text, int index) {
        MenuButton menu = new MenuButton(index);
        setFont(menu.getFont().deriveFont(Font.PLAIN, 14));
        menu.setIcon(new ImageIcon(getClass().getResource("/com/app/icon/" + icon + ".png")));
        //menu.setIcon(new GoogleMaterialIcon(icon,GradientType.HORIZONTAL, ColorGradient.MAIN_COLOR_1, ColorGradient.MAIN_COLOR_2, 19).toIcon());
        menu.setText("  " + text);
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    if (menu != selectedMenu) {
                        unSelectedMenu = selectedMenu;
                        selectedMenu = menu;
                        animator.start();
                        event.menuSelected(index);
                    }
                }
            }
        });
        panelMenu.add(menu);
    }

    private void split(String name) {
        panelMenu.add(new Split(name), "h 30");
    }

    private void space() {
        panelMenu.add(new JLabel(), "push");
    }

    public void setSelected(int index) {
        for (Component com : panelMenu.getComponents()) {
            MenuButton menu = (MenuButton) com;
            if (menu.getIndex() == index) {
               
                if (menu != selectedMenu) {
                    unSelectedMenu = selectedMenu;
                    selectedMenu = menu;
                    animator.start();
                    event.menuSelected(index);
                }
                break;
            }
        }
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        panelMenu = new javax.swing.JPanel();
        Image = new com.app.swing.ImageAvatar();
        lblUser = new javax.swing.JLabel();
        lblSecurity = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(243, 243, 243));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Dashboard");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));

        panelMenu.setOpaque(false);

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 204, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );

        scroll.setViewportView(panelMenu);

        Image.setGradientColor1(new java.awt.Color(51, 149, 225));

        lblUser.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lblUser.setForeground(new java.awt.Color(154, 154, 154));
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUser.setText("Admin");

        lblSecurity.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lblSecurity.setForeground(new java.awt.Color(154, 154, 154));
        lblSecurity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSecurity.setText("Admin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
            .addComponent(Image, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblSecurity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Image, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSecurity, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public com.app.swing.ImageAvatar Image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblSecurity;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
