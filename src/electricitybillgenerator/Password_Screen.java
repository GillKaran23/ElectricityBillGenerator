package electricitybillgenerator;
import java.sql.*;
import javax.swing.*;
import java.awt.*;

public class Password_Screen extends javax.swing.JFrame {
    public Password_Screen() {
        initComponents();
        
        setSize(500, 350);
        setTitle("Password Screen");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Toolkit toolkit = getToolkit();
        Dimension s = toolkit.getScreenSize();
        setLocation(s.width/2 - getWidth()/2 , s.height/2 - getHeight()/2);
        
        bg.setSize(500,350);
        ImageIcon img = new ImageIcon("IMG/Background.png");
        Image im = img.getImage().getScaledInstance(bg.getWidth(),bg.getHeight(),Image.SCALE_SMOOTH);
        bg.setIcon(new ImageIcon(im));
        bg.setBounds(0,0,500,350);
        
        pass_label.setBounds(150,10,200,50);
        pass_label.setForeground(Color.WHITE);
        pass_label.setFont(new Font("Elephant", Font.BOLD,18));
        
        name.setForeground(Color.WHITE);
        emailid.setForeground(Color.WHITE);
        address.setForeground(Color.WHITE);
        fathername.setForeground(Color.WHITE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pass_label = new javax.swing.JLabel();
        user_name = new javax.swing.JTextField();
        Get_Password_Button = new javax.swing.JButton();
        user_father = new javax.swing.JTextField();
        user_emailid = new javax.swing.JTextField();
        user_address = new javax.swing.JTextField();
        name = new javax.swing.JLabel();
        fathername = new javax.swing.JLabel();
        emailid = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        pass_label.setText("Fill all the Details");
        getContentPane().add(pass_label);
        pass_label.setBounds(172, 22, 111, 16);
        getContentPane().add(user_name);
        user_name.setBounds(220, 80, 150, 22);

        Get_Password_Button.setText("Get");
        Get_Password_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Get_Password_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(Get_Password_Button);
        Get_Password_Button.setBounds(180, 260, 72, 23);
        getContentPane().add(user_father);
        user_father.setBounds(220, 120, 150, 22);
        getContentPane().add(user_emailid);
        user_emailid.setBounds(220, 160, 150, 22);
        getContentPane().add(user_address);
        user_address.setBounds(220, 200, 150, 22);

        name.setText("Name:");
        getContentPane().add(name);
        name.setBounds(50, 80, 80, 16);

        fathername.setText("Father Name:");
        getContentPane().add(fathername);
        fathername.setBounds(50, 120, 110, 16);

        emailid.setText("Email:");
        getContentPane().add(emailid);
        emailid.setBounds(50, 160, 100, 16);

        address.setText("Address:");
        getContentPane().add(address);
        address.setBounds(50, 200, 100, 16);
        getContentPane().add(bg);
        bg.setBounds(0, 0, 400, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Get_Password_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Get_Password_ButtonActionPerformed
        try
        {
           String n = user_name.getText();
           String fn = user_father.getText();
           String eid = user_emailid.getText();
           String addr = user_address.getText();
           
           if(!n.isEmpty() && !fn.isEmpty() && !eid.isEmpty() && !addr.isEmpty())
           {
               ResultSet rs = DBLoader.executeSQL("Select * from users where name='"+n+"' and fathername='"+fn+"' and email='"+eid+"' and address='"+addr+"'");
               if(rs.next())
               {
                   String pass = rs.getString("password");
                   String message = "Your Password is: "+pass;
                   JOptionPane.showMessageDialog(this,message);
                   HomeScreen obj = new HomeScreen();
                   obj.setVisible(true);
               }
               else
               {
                   JOptionPane.showMessageDialog(this, "Fill the details correctly.");
               }
           }
           else
           {
               JOptionPane.showMessageDialog(this,"Fill all the Fields.");
           }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_Get_Password_ButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Password_Screen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Get_Password_Button;
    private javax.swing.JLabel address;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel emailid;
    private javax.swing.JLabel fathername;
    private javax.swing.JLabel name;
    private javax.swing.JLabel pass_label;
    private javax.swing.JTextField user_address;
    private javax.swing.JTextField user_emailid;
    private javax.swing.JTextField user_father;
    private javax.swing.JTextField user_name;
    // End of variables declaration//GEN-END:variables
}
