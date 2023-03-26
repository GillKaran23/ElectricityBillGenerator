package electricitybillgenerator;

import java.awt.*;
import javax.swing.*;

public class HomeScreen extends javax.swing.JFrame {
    public HomeScreen() {
        initComponents();
        
        setSize(500, 350);
        setTitle("Home Screen");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Toolkit toolkit = getToolkit();
        Dimension s = toolkit.getScreenSize();
        setLocation(s.width/2 - getWidth()/2 , s.height/2 - getHeight()/2);
        
        bg.setSize(500,350);
        ImageIcon img = new ImageIcon("IMG/Logo.png");
        Image im = img.getImage().getScaledInstance(bg.getWidth(),bg.getHeight(),Image.SCALE_SMOOTH);
        bg.setIcon(new ImageIcon(im));
        bg.setBounds(0,0,500,350);
        
        home_label.setBounds(180,30,300,50);
        home_label.setForeground(Color.WHITE);
        home_label.setFont(new Font("Elephant", Font.BOLD,18));
        
        Login_Screen_Button.setForeground(Color.WHITE);
        Login_Screen_Button.setFont(new Font("Jokerman", Font.BOLD,15));
        Login_Screen_Button.setBounds(430,0,100,50);
        password.setForeground(Color.WHITE);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        home_label = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        get_password = new javax.swing.JButton();
        Login_Screen_Button = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        home_label.setText("WELCOME");
        getContentPane().add(home_label);
        home_label.setBounds(210, 30, 101, 16);

        password.setText("Get your password from here:");
        getContentPane().add(password);
        password.setBounds(10, 280, 170, 16);

        get_password.setText("Get");
        get_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                get_passwordActionPerformed(evt);
            }
        });
        getContentPane().add(get_password);
        get_password.setBounds(180, 280, 70, 20);

        Login_Screen_Button.setText("Log In");
        Login_Screen_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Login_Screen_ButtonMouseClicked(evt);
            }
        });
        getContentPane().add(Login_Screen_Button);
        Login_Screen_Button.setBounds(440, 10, 60, 16);
        getContentPane().add(bg);
        bg.setBounds(0, 0, 510, 320);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void get_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_get_passwordActionPerformed
        dispose();
        Password_Screen obj = new Password_Screen();
        obj.setVisible(true);
    }//GEN-LAST:event_get_passwordActionPerformed

    private void Login_Screen_ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Login_Screen_ButtonMouseClicked
        dispose();
        User_Login obj = new User_Login();
        obj.setVisible(true);
    }//GEN-LAST:event_Login_Screen_ButtonMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Login_Screen_Button;
    private javax.swing.JLabel bg;
    private javax.swing.JButton get_password;
    private javax.swing.JLabel home_label;
    private javax.swing.JLabel password;
    // End of variables declaration//GEN-END:variables
}
