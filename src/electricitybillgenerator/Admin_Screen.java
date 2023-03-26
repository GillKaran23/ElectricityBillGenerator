package electricitybillgenerator;

import javax.swing.*;
import java.awt.*;

public class Admin_Screen extends javax.swing.JFrame {

    public Admin_Screen() {
        initComponents();
        
        setSize(500, 350);
        setTitle("Admin Screen");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Toolkit toolkit = getToolkit();
        Dimension s = toolkit.getScreenSize();
        setLocation(s.width/2 - getWidth()/2 , s.height/2 - getHeight()/2);
        
        admin_label.setBounds(160,0,200,50);
        admin_label.setForeground(Color.WHITE);
        admin_label.setFont(new Font("Elephant", Font.BOLD,18));
        
        
        Create_User_Button.setBounds(50,50,100,100);
        Users_data.setBounds(180,50,100,100);
        Create_Bill.setBounds(310,50,100,100);
        Users_Queries_Button.setBounds(120,170,100,100);
        Update_User.setBounds(250,170,100,100);
        
        bg.setSize(500,350);
        ImageIcon img = new ImageIcon("IMG/Background.png");
        Image im = img.getImage().getScaledInstance(bg.getWidth(),bg.getHeight(),Image.SCALE_SMOOTH);
        bg.setIcon(new ImageIcon(im));
        bg.setBounds(0,0,500,350);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        admin_label = new javax.swing.JLabel();
        Create_User_Button = new javax.swing.JButton();
        Users_data = new javax.swing.JButton();
        Create_Bill = new javax.swing.JButton();
        Users_Queries_Button = new javax.swing.JButton();
        Update_User = new javax.swing.JButton();
        bg = new javax.swing.JLabel();
        Admin_Bar = new javax.swing.JMenuBar();
        homeScreen_Button = new javax.swing.JMenu();
        Login_Button = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        admin_label.setText("Welcome Admin");
        getContentPane().add(admin_label);
        admin_label.setBounds(190, 10, 120, 16);

        Create_User_Button.setText("Add");
        Create_User_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Create_User_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(Create_User_Button);
        Create_User_Button.setBounds(40, 60, 110, 80);

        Users_data.setText("Users");
        Users_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Users_dataActionPerformed(evt);
            }
        });
        getContentPane().add(Users_data);
        Users_data.setBounds(170, 60, 110, 80);

        Create_Bill.setText("Create Bills");
        Create_Bill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Create_BillActionPerformed(evt);
            }
        });
        getContentPane().add(Create_Bill);
        Create_Bill.setBounds(300, 60, 110, 80);

        Users_Queries_Button.setText("Queries");
        Users_Queries_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Users_Queries_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(Users_Queries_Button);
        Users_Queries_Button.setBounds(100, 160, 110, 80);

        Update_User.setText("Update");
        Update_User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update_UserActionPerformed(evt);
            }
        });
        getContentPane().add(Update_User);
        Update_User.setBounds(230, 160, 120, 80);
        getContentPane().add(bg);
        bg.setBounds(0, 0, 470, 330);

        homeScreen_Button.setText("Home");
        homeScreen_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeScreen_ButtonMouseClicked(evt);
            }
        });
        Admin_Bar.add(homeScreen_Button);

        Login_Button.setText("LogIn");
        Login_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Login_ButtonMouseClicked(evt);
            }
        });
        Admin_Bar.add(Login_Button);

        setJMenuBar(Admin_Bar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeScreen_ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeScreen_ButtonMouseClicked
        dispose();
        HomeScreen obj = new HomeScreen();
        obj.setVisible(true);
    }//GEN-LAST:event_homeScreen_ButtonMouseClicked

    private void Login_ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Login_ButtonMouseClicked
        dispose();
        Admins_Login obj = new Admins_Login();
        obj.setVisible(true);
    }//GEN-LAST:event_Login_ButtonMouseClicked

    private void Create_User_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Create_User_ButtonActionPerformed
        dispose();
        AddUser obj = new AddUser();       
        obj.setVisible(true);
    }//GEN-LAST:event_Create_User_ButtonActionPerformed

    private void Users_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Users_dataActionPerformed
        dispose();
        Users_Data obj = new Users_Data();
        obj.setVisible(true);
    }//GEN-LAST:event_Users_dataActionPerformed

    private void Create_BillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Create_BillActionPerformed
        dispose();
        Bill_Creation obj = new Bill_Creation();
        obj.setVisible(true);
    }//GEN-LAST:event_Create_BillActionPerformed

    private void Users_Queries_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Users_Queries_ButtonActionPerformed
        dispose();
        Users_Queries obj = new Users_Queries();
        obj.setVisible(true);
    }//GEN-LAST:event_Users_Queries_ButtonActionPerformed

    private void Update_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update_UserActionPerformed
        dispose();
        Update_User obj = new Update_User();
        obj.setVisible(true);
    }//GEN-LAST:event_Update_UserActionPerformed


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Screen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar Admin_Bar;
    private javax.swing.JButton Create_Bill;
    private javax.swing.JButton Create_User_Button;
    private javax.swing.JMenu Login_Button;
    private javax.swing.JButton Update_User;
    private javax.swing.JButton Users_Queries_Button;
    private javax.swing.JButton Users_data;
    private javax.swing.JLabel admin_label;
    private javax.swing.JLabel bg;
    private javax.swing.JMenu homeScreen_Button;
    // End of variables declaration//GEN-END:variables
}
