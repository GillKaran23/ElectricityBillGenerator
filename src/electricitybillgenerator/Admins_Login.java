package electricitybillgenerator;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Admins_Login extends javax.swing.JFrame {
    public Admins_Login() {
        initComponents();
        
        setSize(500, 350);
        setTitle("Admin Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Toolkit toolkit = getToolkit();
        Dimension s = toolkit.getScreenSize();
        setLocation(s.width/2 - getWidth()/2 , s.height/2 - getHeight()/2);
        
        admin_label.setBounds(160,0,200,50);
        admin_label.setForeground(Color.WHITE);
        admin_label.setFont(new Font("Elephant", Font.BOLD,18));
        
        bg.setSize(500,350);
        ImageIcon img = new ImageIcon("IMG/Background.png");
        Image im = img.getImage().getScaledInstance(bg.getWidth(),bg.getHeight(),Image.SCALE_SMOOTH);
        bg.setIcon(new ImageIcon(im));
        bg.setBounds(0,0,500,350);
        
        name.setForeground(Color.WHITE);
        emailid.setForeground(Color.WHITE);
        password.setForeground(Color.WHITE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        admin_name = new javax.swing.JTextField();
        admin_email_id = new javax.swing.JTextField();
        admin_password = new javax.swing.JPasswordField();
        name = new javax.swing.JLabel();
        emailid = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        Admin_Login_button = new javax.swing.JButton();
        admin_label = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(admin_name);
        admin_name.setBounds(260, 90, 160, 22);
        getContentPane().add(admin_email_id);
        admin_email_id.setBounds(260, 140, 160, 22);
        getContentPane().add(admin_password);
        admin_password.setBounds(260, 190, 160, 22);

        name.setText("Name:");
        getContentPane().add(name);
        name.setBounds(60, 90, 80, 16);

        emailid.setText("Email id:");
        getContentPane().add(emailid);
        emailid.setBounds(60, 140, 70, 16);

        password.setText("Password:");
        getContentPane().add(password);
        password.setBounds(60, 190, 80, 16);

        Admin_Login_button.setText("LogIn");
        Admin_Login_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Admin_Login_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(Admin_Login_button);
        Admin_Login_button.setBounds(180, 260, 110, 23);

        admin_label.setText("Admin LogIn");
        getContentPane().add(admin_label);
        admin_label.setBounds(190, 30, 80, 16);
        getContentPane().add(bg);
        bg.setBounds(0, 0, 470, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Admin_Login_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Admin_Login_buttonActionPerformed
        try{
            String ad_name = admin_name.getText();
            String ad_email = admin_email_id.getText();
            String ad_password = admin_password.getText();
            
            if(!ad_name.isEmpty() && !ad_email.isEmpty() && !ad_password.isEmpty())
            {
                ResultSet rs = DBLoader.executeSQL("select * from admins where name='"+ad_name+"' and email_id='"+ad_email+"' and password='"+ad_password+"'");
                if(rs.next())
                {
                    JOptionPane.showMessageDialog(this,"Login Successfull.");
                    
                    dispose();
                    Admin_Screen obj = new Admin_Screen();
                    obj.setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Login Failed.");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Fill all the fields.");
            }
                
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_Admin_Login_buttonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admins_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Admin_Login_button;
    private javax.swing.JTextField admin_email_id;
    private javax.swing.JLabel admin_label;
    private javax.swing.JTextField admin_name;
    private javax.swing.JPasswordField admin_password;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel emailid;
    private javax.swing.JLabel name;
    private javax.swing.JLabel password;
    // End of variables declaration//GEN-END:variables
}
