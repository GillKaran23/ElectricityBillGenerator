package electricitybillgenerator;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.table.*;

public class Users_Queries extends javax.swing.JFrame {
    
    ArrayList<queries> a1;
    mytablemodel tm;
    
    
    public Users_Queries() {
        
        a1 = new ArrayList<>();
        tm = new mytablemodel();
        
        initComponents();
        
        Queries_Table.setModel(tm);
        
        setSize(550, 400);
        setTitle("Users Queries");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Toolkit toolkit = getToolkit();
        Dimension s = toolkit.getScreenSize();
        setLocation(s.width/2 - getWidth()/2 , s.height/2 - getHeight()/2);
        
        bg.setSize(550,400);
        ImageIcon img = new ImageIcon("IMG/Background.png");
        Image im = img.getImage().getScaledInstance(bg.getWidth(),bg.getHeight(),Image.SCALE_SMOOTH);
        bg.setIcon(new ImageIcon(im));
        bg.setBounds(0,0,550,400);
        
        query_label.setBounds(200,0,200,50);
        query_label.setForeground(Color.WHITE);
        query_label.setFont(new Font("Elephant", Font.BOLD,18));
        
        emailid.setForeground(Color.WHITE);
        answer.setForeground(Color.WHITE);
        
        setVisible(true);
        result();
        
    }
    
    void result()
    {
        try
        {
            String n;
            String emid;
            String q;
            
            ResultSet rs = DBLoader.executeSQL("Select * from queries");
            while(rs.next())
            {
                n = rs.getString("name");
                emid = rs.getString("emailid");
                q = rs.getString("query");
                a1.add(new queries(n,emid,q));
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
            return 3;
        }
        @Override
        public String getColumnName(int j)
        {
            String[] c = {"Name", "Email Id", "Query"};
            return c[j];
        }
        @Override
        public Object getValueAt(int i, int j)
        {
            queries obj = a1.get(i);
            if(j==0)
                return obj.user_name;
            else if(j==1)
                return obj.user_email;
            else
                return obj.user_query;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        query_label = new javax.swing.JLabel();
        Queries_Pane = new javax.swing.JScrollPane();
        Queries_Table = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        Answer = new javax.swing.JTextArea();
        answer = new javax.swing.JLabel();
        emailid = new javax.swing.JLabel();
        user_email_id = new javax.swing.JTextField();
        query_answer_button = new javax.swing.JButton();
        Back_Button = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        query_label.setText("Queries");
        getContentPane().add(query_label);
        query_label.setBounds(270, 10, 80, 16);

        Queries_Table.setModel(new javax.swing.table.DefaultTableModel(
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
        Queries_Pane.setViewportView(Queries_Table);

        getContentPane().add(Queries_Pane);
        Queries_Pane.setBounds(60, 40, 440, 170);

        Answer.setColumns(20);
        Answer.setRows(5);
        jScrollPane1.setViewportView(Answer);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(70, 270, 240, 90);

        answer.setText("Answer:");
        getContentPane().add(answer);
        answer.setBounds(70, 250, 90, 16);

        emailid.setText("Email Id:");
        getContentPane().add(emailid);
        emailid.setBounds(70, 220, 110, 16);
        getContentPane().add(user_email_id);
        user_email_id.setBounds(140, 220, 170, 22);

        query_answer_button.setText("Answer");
        query_answer_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                query_answer_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(query_answer_button);
        query_answer_button.setBounds(320, 270, 100, 90);

        Back_Button.setText("Back");
        Back_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Back_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(Back_Button);
        Back_Button.setBounds(0, 0, 70, 20);
        getContentPane().add(bg);
        bg.setBounds(0, 0, 560, 420);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void query_answer_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_query_answer_buttonActionPerformed
        try
        {
            String eid = user_email_id.getText();
            String ans = Answer.getText();
            
            if(!eid.isEmpty() && !ans.isEmpty())
            {
                ResultSet rs = DBLoader.executeSQL("select * from queries where emailid='"+eid+"'");
                ResultSet rs1 = DBLoader.executeSQL("select * from queries_answers where emailid='"+eid+"'");
                
                if(rs.next())
                {
                    String n = rs.getString("name");
                    String qu = rs.getString("query");
                    rs.deleteRow();
                    
                    rs1.moveToInsertRow();
                    rs1.updateString("name", n);
                    rs1.updateString("emailid", eid);
                    rs1.updateString("query", qu);
                    rs1.updateString("answer", ans);
                    rs1.insertRow();
                    
                    JOptionPane.showMessageDialog(this,"Query answered.");
                    user_email_id.setText(null);
                    Answer.setText(null);
                }
                else{
                    JOptionPane.showMessageDialog(this,"This user don't have any Query.");
                    
                    user_email_id.setText(null);
                    Answer.setText(null);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Fill the all details first.");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_query_answer_buttonActionPerformed

    private void Back_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Back_ButtonActionPerformed
        dispose();
        Admin_Screen obj = new Admin_Screen();
        obj.setVisible(true);
    }//GEN-LAST:event_Back_ButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Users_Queries().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Answer;
    private javax.swing.JButton Back_Button;
    private javax.swing.JScrollPane Queries_Pane;
    private javax.swing.JTable Queries_Table;
    private javax.swing.JLabel answer;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel emailid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton query_answer_button;
    private javax.swing.JLabel query_label;
    private javax.swing.JTextField user_email_id;
    // End of variables declaration//GEN-END:variables
}
