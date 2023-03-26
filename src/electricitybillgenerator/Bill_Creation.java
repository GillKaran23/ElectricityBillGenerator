package electricitybillgenerator;

import java.sql.*;
import javax.swing.*;
import java.awt.*;

public class Bill_Creation extends javax.swing.JFrame {
    public Bill_Creation() {
        initComponents();
        
        setSize(550, 400);
        setTitle("Bill Creation");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Toolkit toolkit = getToolkit();
        Dimension s = toolkit.getScreenSize();
        setLocation(s.width/2 - getWidth()/2 , s.height/2 - getHeight()/2);
        
        bg.setSize(550,400);
        ImageIcon img = new ImageIcon("IMG/Background.png");
        Image im = img.getImage().getScaledInstance(bg.getWidth(),bg.getHeight(),Image.SCALE_SMOOTH);
        bg.setIcon(new ImageIcon(im));
        bg.setBounds(0,0,550,400);
        
        create_label.setBounds(190,20,200,50);
        create_label.setForeground(Color.WHITE);
        create_label.setFont(new Font("Elephant", Font.BOLD,18));
        
        units.setForeground(Color.WHITE);
        emailid.setForeground(Color.WHITE);
        bill.setForeground(Color.WHITE);
        user_bill.setForeground(Color.WHITE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        create_label = new javax.swing.JLabel();
        user_email = new javax.swing.JTextField();
        emailid = new javax.swing.JLabel();
        units = new javax.swing.JLabel();
        user_units = new javax.swing.JTextField();
        bill = new javax.swing.JLabel();
        user_bill = new javax.swing.JLabel();
        Calculate_Bill = new javax.swing.JButton();
        Back_Button = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        create_label.setText("Create Bill");
        getContentPane().add(create_label);
        create_label.setBounds(200, 30, 105, 16);
        getContentPane().add(user_email);
        user_email.setBounds(230, 110, 210, 22);

        emailid.setText("Email Id:");
        getContentPane().add(emailid);
        emailid.setBounds(60, 110, 90, 16);

        units.setText("Units:");
        getContentPane().add(units);
        units.setBounds(60, 170, 90, 16);
        getContentPane().add(user_units);
        user_units.setBounds(230, 170, 210, 22);

        bill.setText("Total Bill:");
        getContentPane().add(bill);
        bill.setBounds(60, 230, 110, 16);

        user_bill.setText("Rs. 0.0");
        getContentPane().add(user_bill);
        user_bill.setBounds(230, 230, 100, 16);

        Calculate_Bill.setText("Calculate");
        Calculate_Bill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Calculate_BillActionPerformed(evt);
            }
        });
        getContentPane().add(Calculate_Bill);
        Calculate_Bill.setBounds(190, 290, 120, 23);

        Back_Button.setText("Back");
        Back_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Back_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(Back_Button);
        Back_Button.setBounds(440, 10, 75, 23);
        getContentPane().add(bg);
        bg.setBounds(0, 0, 520, 340);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Calculate_BillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Calculate_BillActionPerformed
        try
        {
            String u_email = user_email.getText();
            String u_units = user_units.getText();
            String u_bill;
            
            if(!u_email.isEmpty() && !u_units.isEmpty())
            {
                ResultSet rs = DBLoader.executeSQL("select * from users where email='"+u_email+"'");
                if(rs.next())
                {
                    int unit = Integer.parseInt(u_units);
                    int bill = unit*6;
                    u_bill = Integer.toString(bill);
                    user_bill.setText(u_bill);
                    
                    rs.updateString("bill",u_bill);
                    rs.updateString("units",u_units);
                    rs.updateRow();
                    
                    JOptionPane.showMessageDialog(this, "Bill Calculated.");
                    user_email.setText(null);
                    user_units.setText(null);
                    user_bill.setText("Rs. 0.0");
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "There is no user with that mail.");
                }
            }
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_Calculate_BillActionPerformed

    private void Back_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Back_ButtonActionPerformed
        dispose();
        Admin_Screen obj = new Admin_Screen();
        obj.setVisible(true);
    }//GEN-LAST:event_Back_ButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bill_Creation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back_Button;
    private javax.swing.JButton Calculate_Bill;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel bill;
    private javax.swing.JLabel create_label;
    private javax.swing.JLabel emailid;
    private javax.swing.JLabel units;
    private javax.swing.JLabel user_bill;
    private javax.swing.JTextField user_email;
    private javax.swing.JTextField user_units;
    // End of variables declaration//GEN-END:variables
}
