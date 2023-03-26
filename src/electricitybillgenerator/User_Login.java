package electricitybillgenerator;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class User_Login extends javax.swing.JFrame {
    public User_Login() {
        initComponents();
        
        setSize(500, 350);
        setTitle("User Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Toolkit toolkit = getToolkit();
        Dimension s = toolkit.getScreenSize();
        setLocation(s.width/2 - getWidth()/2 , s.height/2 - getHeight()/2);
        
        bg.setSize(500,350);
        ImageIcon img = new ImageIcon("IMG/Background.png");
        Image im = img.getImage().getScaledInstance(bg.getWidth(),bg.getHeight(),Image.SCALE_SMOOTH);
        bg.setIcon(new ImageIcon(im));
        bg.setBounds(0,0,500,350);
        
        user_label.setBounds(200,0,200,50);
        user_label.setForeground(Color.WHITE);
        user_label.setFont(new Font("Elephant", Font.BOLD,18));
        
        emailid.setForeground(Color.WHITE);
        password.setForeground(Color.WHITE);
        AdminLogin.setForeground(Color.WHITE);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        user_label = new javax.swing.JLabel();
        emailid = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        user_email = new javax.swing.JTextField();
        User_Login_Button = new javax.swing.JButton();
        AdminLogin = new javax.swing.JLabel();
        user_password = new javax.swing.JPasswordField();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        user_label.setText("Login");
        getContentPane().add(user_label);
        user_label.setBounds(190, 20, 95, 16);

        emailid.setText("Email:");
        getContentPane().add(emailid);
        emailid.setBounds(50, 90, 90, 16);

        password.setText("Password:");
        getContentPane().add(password);
        password.setBounds(50, 140, 90, 16);
        getContentPane().add(user_email);
        user_email.setBounds(260, 80, 160, 22);

        User_Login_Button.setText("Login");
        User_Login_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Login_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(User_Login_Button);
        User_Login_Button.setBounds(190, 220, 100, 23);

        AdminLogin.setText(".");
        AdminLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AdminLoginMouseClicked(evt);
            }
        });
        getContentPane().add(AdminLogin);
        AdminLogin.setBounds(10, 10, 37, 16);
        getContentPane().add(user_password);
        user_password.setBounds(260, 130, 160, 22);
        getContentPane().add(bg);
        bg.setBounds(0, 0, 450, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void User_Login_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_User_Login_ButtonActionPerformed
        try
        {
            String u_email =  user_email.getText();
            String u_password = user_password.getText();
            
            if(!u_email.isEmpty() && !u_password.isEmpty())
            {
                ResultSet rs = DBLoader.executeSQL("select * from users where email='"+u_email+"' and password='"+u_password+"'");
                if(rs.next())
                {
                    JOptionPane.showMessageDialog(this, "Login Successfull.");
                    Global.useremail = u_email;
                    
                    dispose();
                    UserScreen obj = new UserScreen();
                    obj.setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Login Failed.");
                }
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_User_Login_ButtonActionPerformed

    private void AdminLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminLoginMouseClicked
        dispose();
        Admins_Login obj = new Admins_Login();
        obj.setVisible(true);
    }//GEN-LAST:event_AdminLoginMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AdminLogin;
    private javax.swing.JButton User_Login_Button;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel emailid;
    private javax.swing.JLabel password;
    private javax.swing.JTextField user_email;
    private javax.swing.JLabel user_label;
    private javax.swing.JPasswordField user_password;
    // End of variables declaration//GEN-END:variables
}
