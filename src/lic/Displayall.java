/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lic;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.*;
/**
 *
 * @author sweta verma
 */
class mytable extends javax.swing.table.AbstractTableModel
{
ResultSet rs;
ResultSetMetaData rsmd;
mytable(ResultSet rs1)
{
    try
    {
    rs=rs1;
    rsmd=rs1.getMetaData();
    }
    catch(Exception e)
    {
        
    }
}
public String getColumnName(int n)
{
    try
    {
        return rsmd.getColumnName(n+1);
        
    }
    catch(Exception e)
    {
        return null;
    }
}

    @Override
    public int getRowCount() {
        try
        {
            rs.last();
            return rs.getRow();
            
        }
        catch(Exception e)
        {
            return 0;
        }
        
    }

    @Override
    public int getColumnCount() {
    try
    {
        return rsmd.getColumnCount();
        
    }
    catch(Exception e)
    {
        return 0;
    }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    try{
        rs.absolute(rowIndex+1);
        return rs.getObject(columnIndex+1);
        
    } 
    catch(Exception e)
    {
        return null;
    }
    }

}
public class Displayall extends javax.swing.JInternalFrame {

    /**
     * Creates new form Displayall
     */
    Connection c;
    Statement st;
    
    public Displayall() {
        initComponents();
        java.awt.Container cp1=getContentPane();
        cp1.setBackground(Color.PINK);
          try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection c=DriverManager.getConnection("jdbc:odbc:company");
            Statement st=c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery("Select * from create");
             mytable m1=new mytable(rs);
            Table1.setModel(m1);
             
        }
                catch(Exception e)
                {
                System.out.println(e);   
                }
    
    }
          
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setForeground(new java.awt.Color(255, 153, 153));
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        Table1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(Table1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 190, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
