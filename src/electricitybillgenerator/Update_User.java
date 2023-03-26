package electricitybillgenerator;

import java.sql.*;
import java.awt.*;
import javax.swing.*;

public class Update_User extends javax.swing.JFrame {
    public Update_User() {
        initComponents();
        
        setSize(500, 350);
        setTitle("Update User");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Toolkit toolkit = getToolkit();
        Dimension s = toolkit.getScreenSize();
        setLocation(s.width/2 - getWidth()/2 , s.height/2 - getHeight()/2);
        
        bg.setSize(500,350);
        ImageIcon img = new ImageIcon("IMG/Background.png");
        Image im = img.getImage().getScaledInstance(bg.getWidth(),bg.getHeight(),Image.SCALE_SMOOTH);
        bg.setIcon(new ImageIcon(im));
        bg.setBounds(0,0,500,350);
        
        update_label.setBounds(160,0,200,50);
        update_label.setForeground(Color.WHITE);
        update_label.setFont(new Font("Elephant", Font.BOLD,18));
        
        name.setForeground(Color.WHITE);
        emailid.setForeground(Color.WHITE);
        address.setForeground(Color.WHITE);
        fathername.setForeground(Color.WHITE);
        seperator.setForeground(Color.WHITE);
        user_id.setForeground(Color.WHITE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        update_label = new javax.swing.JLabel();
        user_id = new javax.swing.JLabel();
        user_email_id = new javax.swing.JTextField();
        seperator = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        emailid = new javax.swing.JLabel();
        fathername = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        user_name = new javax.swing.JTextField();
        user_fathername = new javax.swing.JTextField();
        user_emailid = new javax.swing.JTextField();
        user_address = new javax.swing.JTextField();
        update_name = new javax.swing.JButton();
        update_fathername = new javax.swing.JButton();
        Update_emailid = new javax.swing.JButton();
        update_address = new javax.swing.JButton();
        Update_All = new javax.swing.JButton();
        Back_Button = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        update_label.setText("Update User");
        getContentPane().add(update_label);
        update_label.setBounds(200, 10, 87, 16);

        user_id.setText("Emailid of user you want to Update :");
        getContentPane().add(user_id);
        user_id.setBounds(20, 60, 210, 16);
        getContentPane().add(user_email_id);
        user_email_id.setBounds(270, 60, 200, 22);

        seperator.setText("----------------------------------------------------------------------------------------------------------------------------------");
        getContentPane().add(seperator);
        seperator.setBounds(0, 90, 630, 16);

        name.setText("Name:");
        getContentPane().add(name);
        name.setBounds(20, 130, 70, 16);

        emailid.setText("Email Id:");
        getContentPane().add(emailid);
        emailid.setBounds(20, 190, 100, 16);

        fathername.setText("Father Name:");
        getContentPane().add(fathername);
        fathername.setBounds(20, 160, 100, 16);

        address.setText("Address:");
        getContentPane().add(address);
        address.setBounds(20, 220, 100, 16);
        getContentPane().add(user_name);
        user_name.setBounds(180, 130, 190, 20);
        getContentPane().add(user_fathername);
        user_fathername.setBounds(180, 160, 190, 22);
        getContentPane().add(user_emailid);
        user_emailid.setBounds(180, 190, 190, 22);
        getContentPane().add(user_address);
        user_address.setBounds(180, 220, 190, 22);

        update_name.setText("Update");
        update_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_nameActionPerformed(evt);
            }
        });
        getContentPane().add(update_name);
        update_name.setBounds(382, 130, 90, 23);

        update_fathername.setText("Update");
        update_fathername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_fathernameActionPerformed(evt);
            }
        });
        getContentPane().add(update_fathername);
        update_fathername.setBounds(382, 160, 90, 23);

        Update_emailid.setText("Update");
        Update_emailid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update_emailidActionPerformed(evt);
            }
        });
        getContentPane().add(Update_emailid);
        Update_emailid.setBounds(382, 190, 90, 23);

        update_address.setText("Update");
        update_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_addressActionPerformed(evt);
            }
        });
        getContentPane().add(update_address);
        update_address.setBounds(382, 220, 90, 23);

        Update_All.setText("Update All");
        Update_All.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update_AllActionPerformed(evt);
            }
        });
        getContentPane().add(Update_All);
        Update_All.setBounds(170, 280, 130, 23);

        Back_Button.setText("Back");
        Back_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Back_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(Back_Button);
        Back_Button.setBounds(400, 10, 70, 20);
        getContentPane().add(bg);
        bg.setBounds(0, 0, 480, 340);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void update_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_nameActionPerformed
        try
        {
            String email_id = user_email_id.getText();
            String n = user_name.getText();
            
            if(!email_id.isEmpty() && !n.isEmpty())
            {
                ResultSet rs = DBLoader.executeSQL("select * from users where email='"+email_id+"'");
                if(rs.next())
                {
                    rs.updateString("name", n);
                    rs.updateRow();
                    
                    JOptionPane.showMessageDialog(this, "Name is Updated");
                    
                    user_email_id.setText(null);
                    user_name.setText(null);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "User not Exist.");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Fill all fields.");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_update_nameActionPerformed

    private void update_fathernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_fathernameActionPerformed
        try
        {
            String email_id = user_email_id.getText();
            String fn = user_fathername.getText();
            
            if(!email_id.isEmpty() && !fn.isEmpty())
            {
                ResultSet rs = DBLoader.executeSQL("select * from users where email='"+email_id+"'");
                if(rs.next())
                {
                    rs.updateString("fathername", fn);
                    rs.updateRow();
                    
                    JOptionPane.showMessageDialog(this, "Father Name is Updated");
                    
                    user_email_id.setText(null);
                    user_fathername.setText(null);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "User not Exist.");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Fill all fields.");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_update_fathernameActionPerformed

    private void Update_emailidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update_emailidActionPerformed
        try
        {
            String email_id = user_email_id.getText();
            String eid = user_emailid.getText();
            
            if(!email_id.isEmpty() && !eid.isEmpty())
            {
                ResultSet rs = DBLoader.executeSQL("select * from users where email='"+email_id+"'");
                if(rs.next())
                {
                    rs.updateString("email", eid);
                    rs.updateRow();
                    
                    JOptionPane.showMessageDialog(this, "Email Id is Updated");
                    
                    user_email_id.setText(null);
                    user_emailid.setText(null);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "User not Exist.");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Fill all fields.");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_Update_emailidActionPerformed

    private void update_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_addressActionPerformed
        try
        {
            String email_id = user_email_id.getText();
            String addr = user_address.getText();
            
            if(!email_id.isEmpty() && !addr.isEmpty())
            {
                ResultSet rs = DBLoader.executeSQL("select * from users where email='"+email_id+"'");
                if(rs.next())
                {
                    rs.updateString("address", addr);
                    rs.updateRow();
                    
                    JOptionPane.showMessageDialog(this, "Address is Updated");
                    
                    user_email_id.setText(null);
                    user_address.setText(null);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "User not Exist.");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Fill all fields.");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_update_addressActionPerformed

    private void Update_AllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update_AllActionPerformed
        try
        {
            String email_id = user_email_id.getText();
            String n = user_name.getText();
            String fn = user_fathername.getText();
            String eid = user_emailid.getText();
            String addr = user_address.getText();
            
            if(!email_id.isEmpty() && !eid.isEmpty() && !n.isEmpty() && !fn.isEmpty() && !addr.isEmpty())
            {
                ResultSet rs = DBLoader.executeSQL("select * from users where email='"+email_id+"'");
                if(rs.next())
                {
                    rs.updateString("name", n);
                    rs.updateString("fathername", fn);
                    rs.updateString("email", eid);
                    rs.updateString("address", addr);
                    rs.updateRow();
                    
                    JOptionPane.showMessageDialog(this, "User is Updated");
                    
                    user_email_id.setText(null);
                    user_emailid.setText(null);
                    user_fathername.setText(null);
                    user_address.setText(null);
                    user_name.setText(null);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "User not Exist.");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Fill all fields.");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_Update_AllActionPerformed

    private void Back_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Back_ButtonActionPerformed
        dispose();
        Admin_Screen obj = new Admin_Screen();
        obj.setVisible(true);
    }//GEN-LAST:event_Back_ButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Update_User().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back_Button;
    private javax.swing.JButton Update_All;
    private javax.swing.JButton Update_emailid;
    private javax.swing.JLabel address;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel emailid;
    private javax.swing.JLabel fathername;
    private javax.swing.JLabel name;
    private javax.swing.JLabel seperator;
    private javax.swing.JButton update_address;
    private javax.swing.JButton update_fathername;
    private javax.swing.JLabel update_label;
    private javax.swing.JButton update_name;
    private javax.swing.JTextField user_address;
    private javax.swing.JTextField user_email_id;
    private javax.swing.JTextField user_emailid;
    private javax.swing.JTextField user_fathername;
    private javax.swing.JLabel user_id;
    private javax.swing.JTextField user_name;
    // End of variables declaration//GEN-END:variables
}
