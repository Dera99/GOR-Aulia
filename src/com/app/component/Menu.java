package com.app.component;

import com.app.event.MenuEvent;
import com.app.service.ServiceSettings;
import com.app.service.UserSession;
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
    }

    public void initMenu(MenuEvent event) {
        this.event = event;
        addMenu(DASHBOARD, "Dashboard", 0);
        split("Penyewaan");
        addMenu(GoogleMaterialDesignIcon.EVENT, "Pemesanan", 1);
        addMenu(GoogleMaterialDesignIcon.PAYMENT, "Transaksi", 2); 
        addMenu(GoogleMaterialDesignIcon.FORMAT_LIST_BULLETED, "Paket Sewa", 3); 
        addMenu(GoogleMaterialDesignIcon.GROUP, "Penyewa", 4); 
        addMenu(GoogleMaterialDesignIcon.SETTINGS, "Settings", 5);     
//        split("Report");
//        addMenu("4", "Report Income", 3);
//        addMenu("5", "Report Expense", 4);
//        addMenu("6", "Report Staff", 5);
//        addMenu("7", "Accounting", 6);
        space();
        addMenu(GoogleMaterialDesignIcon.LOGOUT, "Logout", 6);
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

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(243, 243, 243));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/icon/logo.png"))); // NOI18N
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
            .addGap(0, 352, Short.MAX_VALUE)
        );

        scroll.setViewportView(panelMenu);

        Image.setGradientColor1(new java.awt.Color(51, 149, 225));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scroll)
            .addComponent(Image, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Image, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(scroll))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public com.app.swing.ImageAvatar Image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
