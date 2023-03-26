package electricitybillgenerator;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class AddUser extends javax.swing.JFrame {
    public AddUser() {
        initComponents();
        
        setSize(550, 400);
        setTitle("Create User");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Toolkit toolkit = getToolkit();
        Dimension s = toolkit.getScreenSize();
        setLocation(s.width/2 - getWidth()/2 , s.height/2 - getHeight()/2);
        
        bg.setSize(550,400);
        ImageIcon img = new ImageIcon("IMG/Background.png");
        Image im = img.getImage().getScaledInstance(bg.getWidth(),bg.getHeight(),Image.SCALE_SMOOTH);
        bg.setIcon(new ImageIcon(im));
        bg.setBounds(0,0,550,400);
        
        user_label.setBounds(200,0,200,50);
        user_label.setForeground(Color.WHITE);
        user_label.setFont(new Font("Elephant", Font.BOLD,18));
        
        name.setForeground(Color.WHITE);
        emailid.setForeground(Color.WHITE);
        address.setForeground(Color.WHITE);
        fathername.setForeground(Color.WHITE);
        password.setForeground(Color.WHITE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        user_label = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        fathername = new javax.swing.JLabel();
        emailid = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        create_user = new javax.swing.JButton();
        user_name = new javax.swing.JTextField();
        user_father_name = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        user_address = new javax.swing.JTextArea();
        user_email_id = new javax.swing.JTextField();
        Back_Button = new javax.swing.JButton();
        user_password = new javax.swing.JPasswordField();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        user_label.setText("Add User");
        getContentPane().add(user_label);
        user_label.setBounds(210, 20, 81, 16);

        name.setText("Name:");
        getContentPane().add(name);
        name.setBounds(30, 60, 150, 16);

        fathername.setText("Father's Name:");
        getContentPane().add(fathername);
        fathername.setBounds(30, 120, 150, 16);

        emailid.setText("Email Id:");
        getContentPane().add(emailid);
        emailid.setBounds(280, 60, 140, 16);

        address.setText("Address:");
        getContentPane().add(address);
        address.setBounds(30, 180, 80, 16);

        password.setText("Password:");
        getContentPane().add(password);
        password.setBounds(280, 120, 80, 20);

        create_user.setText("CREATE");
        create_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_userActionPerformed(evt);
            }
        });
        getContentPane().add(create_user);
        create_user.setBounds(180, 310, 130, 23);
        getContentPane().add(user_name);
        user_name.setBounds(30, 80, 180, 22);
        getContentPane().add(user_father_name);
        user_father_name.setBounds(30, 140, 180, 22);

        user_address.setColumns(20);
        user_address.setRows(5);
        jScrollPane1.setViewportView(user_address);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 200, 234, 86);
        getContentPane().add(user_email_id);
        user_email_id.setBounds(280, 80, 180, 22);

        Back_Button.setText("Back");
        Back_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Back_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(Back_Button);
        Back_Button.setBounds(440, 10, 72, 23);
        getContentPane().add(user_password);
        user_password.setBounds(280, 140, 180, 22);
        getContentPane().add(bg);
        bg.setBounds(0, 0, 530, 370);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void create_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_userActionPerformed
        try
        {
            String u_name = user_name.getText();
            String u_f_name = user_father_name.getText();
            String u_email = user_email_id.getText();
            String u_address = user_address.getText();
            String u_password = user_password.getText();
            
            if(!u_name.isEmpty() && !u_f_name.isEmpty() && !u_email.isEmpty() && !u_address.isEmpty() && !u_password.isEmpty() && (u_password.length()>=6))
            {
                ResultSet rs = DBLoader.executeSQL("select * from users where email='"+u_email+"'");
                if(rs.next())
                {
                    JOptionPane.showMessageDialog(this, "Already a user.");
                }
                else
                {
                  rs.moveToInsertRow();
                  rs.updateString("name", u_name);
                  rs.updateString("fathername", u_f_name);
                  rs.updateString("email", u_email);
                  rs.updateString("address", u_address);
                  rs.updateString("password", u_password);
                  rs.insertRow();
                  JOptionPane.showMessageDialog(this, "User ADDED");
                  dispose();
                  Admin_Screen obj = new Admin_Screen();       
                  obj.setVisible(true);
                }
            }
            else if(u_password.length()<6){
                JOptionPane.showMessageDialog(this, "Password length is smaller than 6.");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Fill all the fields.");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_create_userActionPerformed

    private void Back_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Back_ButtonActionPerformed
        dispose();
        Admin_Screen obj = new Admin_Screen();
        obj.setVisible(true);
    }//GEN-LAST:event_Back_ButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back_Button;
    private javax.swing.JLabel address;
    private javax.swing.JLabel bg;
    private javax.swing.JButton create_user;
    private javax.swing.JLabel emailid;
    private javax.swing.JLabel fathername;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel name;
    private javax.swing.JLabel password;
    private javax.swing.JTextArea user_address;
    private javax.swing.JTextField user_email_id;
    private javax.swing.JTextField user_father_name;
    private javax.swing.JLabel user_label;
    private javax.swing.JTextField user_name;
    private javax.swing.JPasswordField user_password;
    // End of variables declaration//GEN-END:variables
}
