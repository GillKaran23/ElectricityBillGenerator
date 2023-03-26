package electricitybillgenerator;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class UserScreen extends javax.swing.JFrame {

    public UserScreen() {
        initComponents();
        
        setSize(500, 400);
        setTitle("User Profile");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Toolkit toolkit = getToolkit();
        Dimension s = toolkit.getScreenSize();
        setLocation(s.width/2 - getWidth()/2 , s.height/2 - getHeight()/2);
        Query_Section.setVisible(false);
        Answer.setVisible(false);
        Change_Password_Pane.setVisible(false);
        
        bg.setSize(500,400);
        ImageIcon img = new ImageIcon("IMG/Background.png");
        Image im = img.getImage().getScaledInstance(bg.getWidth(),bg.getHeight(),Image.SCALE_SMOOTH);
        bg.setIcon(new ImageIcon(im));
        bg.setBounds(0,0,500,400);
        
        user_name.setForeground(Color.WHITE);
        user_father_name.setForeground(Color.WHITE);
        user_address.setForeground(Color.WHITE);
        user_units.setForeground(Color.WHITE);
        user_bill.setForeground(Color.WHITE);
        user_label.setForeground(Color.WHITE);
        user_label.setFont(new Font("Elephant", Font.BOLD,18));
        user_label.setBounds(160,0,200,50);
        chg_pass.setForeground(Color.WHITE);
        pre.setForeground(Color.WHITE);
        new_p.setForeground(Color.WHITE);
        query_label.setForeground(Color.WHITE);
        write_query.setForeground(Color.WHITE);
        query_answer.setForeground(Color.WHITE);
        
        Query_Section.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
        Change_Password_Pane.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
                
                
        try
        {
            ResultSet rs1 = DBLoader.executeSQL("select * from queries_answers where emailid ='"+Global.useremail+"'");
            if(rs1.next())
            {
                msg.setVisible(true);
                msg.setForeground(Color.red);
            }
            else
            {
                msg.setVisible(false);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        try
        {
           ResultSet rs = DBLoader.executeSQL("select * from users where email='"+Global.useremail+"'");
           if(rs.next())
           {
               String name = rs.getString("name");
               String u_name = "Name:   "+name;
               user_name.setText(u_name);
               
               String fathername = rs.getString("fathername");
               String u_f_name = "Father Name:   "+fathername;
               user_father_name.setText(u_f_name);
               
               String address_u = rs.getString("address");
               String u_address = "Address:   "+address_u;
               user_address.setText(u_address);
               
               String units_u = rs.getString("units");
               String u_units = "Units:   "+units_u;
               user_units.setText(u_units);
               
               String bill_u = rs.getString("bill");
               String u_bill = "Bill:   "+bill_u;
               user_bill.setText(u_bill);
           }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        try
        {
            ResultSet rs = DBLoader.executeSQL("select * from queries_answers where emailid='"+Global.useremail+"'");
            if(rs.next())
            {
                String ans = rs.getString("answer");
                rs.deleteRow();
                Answer.setVisible(true);
                Answer.setText(ans);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        user_label = new javax.swing.JLabel();
        user_name = new javax.swing.JLabel();
        user_father_name = new javax.swing.JLabel();
        user_address = new javax.swing.JLabel();
        user_units = new javax.swing.JLabel();
        user_bill = new javax.swing.JLabel();
        Query_Section = new javax.swing.JPanel();
        query_label = new javax.swing.JLabel();
        write_query = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Query_Text_Area = new javax.swing.JTextArea();
        Send_Query_Button = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Answer = new javax.swing.JTextPane();
        query_answer = new javax.swing.JLabel();
        msg = new javax.swing.JLabel();
        Change_Password_Pane = new javax.swing.JPanel();
        pre = new javax.swing.JLabel();
        new_p = new javax.swing.JLabel();
        chg_pass = new javax.swing.JLabel();
        Change_Password = new javax.swing.JButton();
        user_password = new javax.swing.JPasswordField();
        new_password = new javax.swing.JPasswordField();
        bg = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        update_Password = new javax.swing.JMenu();
        User_Query = new javax.swing.JMenu();
        Back = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        user_label.setText("User Screen");
        getContentPane().add(user_label);
        user_label.setBounds(180, 10, 92, 16);

        user_name.setText("Name:");
        getContentPane().add(user_name);
        user_name.setBounds(20, 40, 180, 16);

        user_father_name.setText("Father Name:");
        getContentPane().add(user_father_name);
        user_father_name.setBounds(20, 70, 190, 16);

        user_address.setText("Address:");
        getContentPane().add(user_address);
        user_address.setBounds(20, 100, 210, 16);

        user_units.setText("Units:");
        getContentPane().add(user_units);
        user_units.setBounds(20, 130, 140, 16);

        user_bill.setText("Bill:");
        getContentPane().add(user_bill);
        user_bill.setBounds(20, 160, 150, 16);

        Query_Section.setLayout(null);

        query_label.setText("Query");
        Query_Section.add(query_label);
        query_label.setBounds(80, 0, 60, 16);

        write_query.setText("Write Your Query Here:");
        Query_Section.add(write_query);
        write_query.setBounds(10, 30, 200, 16);

        Query_Text_Area.setColumns(20);
        Query_Text_Area.setRows(5);
        jScrollPane1.setViewportView(Query_Text_Area);

        Query_Section.add(jScrollPane1);
        jScrollPane1.setBounds(10, 50, 200, 90);

        Send_Query_Button.setText("Send Query");
        Send_Query_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Send_Query_ButtonActionPerformed(evt);
            }
        });
        Query_Section.add(Send_Query_Button);
        Send_Query_Button.setBounds(10, 150, 200, 23);

        jScrollPane2.setViewportView(Answer);

        Query_Section.add(jScrollPane2);
        jScrollPane2.setBounds(10, 210, 200, 80);

        query_answer.setText("Check your answer:");
        Query_Section.add(query_answer);
        query_answer.setBounds(10, 190, 120, 16);

        getContentPane().add(Query_Section);
        Query_Section.setBounds(260, 0, 220, 310);

        msg.setText("Check Query Answer");
        getContentPane().add(msg);
        msg.setBounds(20, 190, 130, 16);

        Change_Password_Pane.setLayout(null);

        pre.setText("Previous:");
        Change_Password_Pane.add(pre);
        pre.setBounds(10, 30, 70, 16);

        new_p.setText("New:");
        Change_Password_Pane.add(new_p);
        new_p.setBounds(10, 60, 60, 16);

        chg_pass.setText("Change Your Password");
        Change_Password_Pane.add(chg_pass);
        chg_pass.setBounds(40, 10, 150, 16);

        Change_Password.setText("Change");
        Change_Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Change_PasswordActionPerformed(evt);
            }
        });
        Change_Password_Pane.add(Change_Password);
        Change_Password.setBounds(60, 90, 90, 20);
        Change_Password_Pane.add(user_password);
        user_password.setBounds(80, 30, 130, 22);
        Change_Password_Pane.add(new_password);
        new_password.setBounds(80, 60, 130, 22);

        getContentPane().add(Change_Password_Pane);
        Change_Password_Pane.setBounds(20, 210, 220, 120);
        getContentPane().add(bg);
        bg.setBounds(0, 0, 490, 360);

        update_Password.setText("Password");
        update_Password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                update_PasswordMouseClicked(evt);
            }
        });
        jMenuBar1.add(update_Password);

        User_Query.setText("Query");
        User_Query.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                User_QueryMouseClicked(evt);
            }
        });
        jMenuBar1.add(User_Query);

        Back.setText("Back");
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
        });
        jMenuBar1.add(Back);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Send_Query_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Send_Query_ButtonActionPerformed
        try
        {
            String query = Query_Text_Area.getText();
            if(!query.isEmpty())
            {
                ResultSet rs = DBLoader.executeSQL("select * from users where email='"+Global.useremail+"'");
                ResultSet rs1 = DBLoader.executeSQL("select * from queries where emailid='"+Global.useremail+"'");
                if(rs.next())
                {
                    String u_name = rs.getString("name");
                    
                    rs1.moveToInsertRow();
                    rs1.updateString("name",u_name);
                    rs1.updateString("emailid", Global.useremail);
                    rs1.updateString("query", query);
                    rs1.insertRow();
                    
                    JOptionPane.showMessageDialog(this, "Query Submit.");
                    
                    Query_Text_Area.setText(null);
                    Query_Section.setVisible(false);
                    
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Write Query First.");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_Send_Query_ButtonActionPerformed

    private void User_QueryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_User_QueryMouseClicked
        Query_Section.setVisible(true);
    }//GEN-LAST:event_User_QueryMouseClicked

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        dispose();
        HomeScreen obj = new HomeScreen();
        obj.setVisible(true);
    }//GEN-LAST:event_BackMouseClicked

    private void update_PasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update_PasswordMouseClicked
        Change_Password_Pane.setVisible(true);
    }//GEN-LAST:event_update_PasswordMouseClicked

    private void Change_PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Change_PasswordActionPerformed
        try
        {
            String previous = user_password.getText();
            String newpass = new_password.getText();
            if(!previous.isEmpty() && !newpass.isEmpty())
            {
                ResultSet rs = DBLoader.executeSQL("select * from users where email='"+Global.useremail+"'");
                if(rs.next())
                {
                    String pass = rs.getString("password");
                    if(pass.equals(previous) && (newpass.length()>=6))
                    {
                        rs.updateString("password", newpass);
                        rs.updateRow();
                        JOptionPane.showMessageDialog(this,"Password Changed");
                        user_password.setText(null);
                        new_password.setText(null);
                        
                        Change_Password_Pane.setVisible(false);
                    }
                    else if(newpass.length()<6){
                        JOptionPane.showMessageDialog(this,"Password length is smaller than 6 words.");
                    }
                    else if(newpass.equals(pass)){
                        JOptionPane.showMessageDialog(this,"Create different password.");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this,"Your Previous password not matched.");
                    }
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Fill all the fields.");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_Change_PasswordActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane Answer;
    private javax.swing.JMenu Back;
    private javax.swing.JButton Change_Password;
    private javax.swing.JPanel Change_Password_Pane;
    private javax.swing.JPanel Query_Section;
    private javax.swing.JTextArea Query_Text_Area;
    private javax.swing.JButton Send_Query_Button;
    private javax.swing.JMenu User_Query;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel chg_pass;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel msg;
    private javax.swing.JLabel new_p;
    private javax.swing.JPasswordField new_password;
    private javax.swing.JLabel pre;
    private javax.swing.JLabel query_answer;
    private javax.swing.JLabel query_label;
    private javax.swing.JMenu update_Password;
    private javax.swing.JLabel user_address;
    private javax.swing.JLabel user_bill;
    private javax.swing.JLabel user_father_name;
    private javax.swing.JLabel user_label;
    private javax.swing.JLabel user_name;
    private javax.swing.JPasswordField user_password;
    private javax.swing.JLabel user_units;
    private javax.swing.JLabel write_query;
    // End of variables declaration//GEN-END:variables
}
