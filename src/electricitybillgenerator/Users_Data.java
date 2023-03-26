package electricitybillgenerator;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.table.*;

public class Users_Data extends javax.swing.JFrame {

    ArrayList<Users> a1;
    mytablemodel tm;
    
    public Users_Data() {
        
        a1 = new ArrayList<>();
        tm = new mytablemodel();
        
        initComponents();
        
        users_data.setModel(tm);
        
        setSize(550, 400);
        setTitle("Users");
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
        
        emailid.setForeground(Color.WHITE);
        
        setVisible(true);
        result();
    }
    
    void result()
    {
        try
        {
            String n;
            String fn;
            String emid;
            String addr;
            String u;
            String b;
            
            ResultSet rs = DBLoader.executeSQL("Select * from users");
            while(rs.next())
            {
                n = rs.getString("name");
                fn = rs.getString("fathername");
                emid = rs.getString("email");
                addr = rs.getString("address");
                u = rs.getString("units");
                b = rs.getString("bill");
                a1.add(new Users(n,fn,emid,addr,u,b));
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
    }
    class mytablemodel extends AbstractTableModel
    {
        @Override 
        public int getRowCount()
        {
            return a1.size();
        }
        @Override
        public int getColumnCount()
        {
            return 6;
        }
        @Override
        public String getColumnName(int j)
        {
            String[] c = {"Name", "Father Name", "Email Id", "Address", "Units", "Bill"};
            return c[j];
        }
        @Override
        public Object getValueAt(int i, int j)
        {
            Users obj = a1.get(i);
            if(j==0)
                return obj.user_name;
            else if(j==1)
                return obj.father_name;
            else if(j==2)
                return obj.user_email;
            else if(j==3)
                return obj.user_address;
            else if(j==4)
                return obj.user_unit;
            else
                return obj.user_bill;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Table_ScrollPane = new javax.swing.JScrollPane();
        users_data = new javax.swing.JTable();
        user_label = new javax.swing.JLabel();
        Back_Button = new javax.swing.JButton();
        User_emailid = new javax.swing.JTextField();
        emailid = new javax.swing.JLabel();
        Delete_Button = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        users_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table_ScrollPane.setViewportView(users_data);

        getContentPane().add(Table_ScrollPane);
        Table_ScrollPane.setBounds(20, 60, 490, 191);

        user_label.setText("Users");
        getContentPane().add(user_label);
        user_label.setBounds(240, 20, 80, 16);

        Back_Button.setText("Back");
        Back_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Back_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(Back_Button);
        Back_Button.setBounds(450, 10, 72, 23);
        getContentPane().add(User_emailid);
        User_emailid.setBounds(20, 310, 210, 22);

        emailid.setText("Email Id:");
        getContentPane().add(emailid);
        emailid.setBounds(20, 290, 70, 16);

        Delete_Button.setText("Delete");
        Delete_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(Delete_Button);
        Delete_Button.setBounds(250, 310, 75, 23);
        getContentPane().add(bg);
        bg.setBounds(0, 0, 530, 370);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Delete_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_ButtonActionPerformed
        try
        {
            String u_email_id = User_emailid.getText();
            
            if(!u_email_id.isEmpty())
            {
                ResultSet rs = DBLoader.executeSQL("select * from users where email='"+u_email_id+"'");
                if(rs.next())
                {
                    rs.deleteRow();
                    JOptionPane.showMessageDialog(this, "User Deleted");
                    User_emailid.setText(null);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "User Not Present");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Fill Email First");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_Delete_ButtonActionPerformed

    private void Back_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Back_ButtonActionPerformed
        dispose();
        Admin_Screen obj = new Admin_Screen();
        obj.setVisible(true);
    }//GEN-LAST:event_Back_ButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Users_Data().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back_Button;
    private javax.swing.JButton Delete_Button;
    private javax.swing.JScrollPane Table_ScrollPane;
    private javax.swing.JTextField User_emailid;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel emailid;
    private javax.swing.JLabel user_label;
    private javax.swing.JTable users_data;
    // End of variables declaration//GEN-END:variables
}
