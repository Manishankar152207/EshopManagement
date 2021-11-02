/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eshop;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author acer
 */
public class PriceList extends javax.swing.JFrame {
    Connection con;
    Statement st;
    PreparedStatement pst;
    ResultSet rec;
    String a1;
    

    /**
     * Creates new form PriceList
     */
    public PriceList() {
        initComponents();
        fetch();
    }
    public void getData(){
        a1=jTextField1.getText();
    }
     public void connect()
    {
        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con=DriverManager.getConnection("jdbc:odbc:JAISWALDSN");
        }
        catch(Exception ex){
        System.out.println(ex);
        }
    }
    public void showData()
     {
     try
        {
        connect();
        st=con.createStatement();
        String str=jTextField1.getText();
        if(str.equals("")){
            DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
                while(model.getRowCount()>0){
                    for(int i=0;i<model.getRowCount();i++){
                        model.removeRow(i);
                    }
                }
            fetch();
        }
        else{
            rec=st.executeQuery("select * from additem where itemname='"+str+"'");
        if(rec.next())
            {
                DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
                while(model.getRowCount()>0){
                    for(int i=0;i<model.getRowCount();i++){
                        model.removeRow(i);
                    }
                }
                fetch1();
                jLabel2.setText("");
            }
        }
        }
       catch(Exception ex)
        {
        System.out.println(ex);
        }
     }
    public ArrayList<User> userList(){
        ArrayList<User> userList =new ArrayList<>();
        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con=DriverManager.getConnection("jdbc:odbc:JAISWALDSN");
            st=con.createStatement();
            rec=st.executeQuery("select * from additem");
            while(rec.next()){
                User user=new User(rec.getInt("itemcode"),rec.getString("itemname"),rec.getString("comname"),rec.getString("model"),rec.getInt("tax"),rec.getInt("approxprice"));
                userList.add(user);
                
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        return userList;
    }
   
    public ArrayList<User> userList1(){
        ArrayList<User> userList1 =new ArrayList<>();
        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con=DriverManager.getConnection("jdbc:odbc:JAISWALDSN");
            st=con.createStatement();
            String str=jTextField1.getText();
            rec=st.executeQuery("select * from additem where itemname='"+str+"'");
            while(rec.next()){
                User user=new User(rec.getInt("itemcode"),rec.getString("itemname"),rec.getString("comname"),rec.getString("model"),rec.getInt("tax"),rec.getInt("approxprice"));
                userList1.add(user);
                
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        return userList1;
    }
    public void fetch(){
        ArrayList<User> list = userList();
        DefaultTableModel model1=(DefaultTableModel) jTable1.getModel();
        Object[] row=new Object[6];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getitemcode();
            row[1]=list.get(i).getname();
            row[2]=list.get(i).getcompany();
            row[3]=list.get(i).getmodel();
            row[4]=list.get(i).gettax();
            row[5]=list.get(i).getprice();
            model1.addRow(row);           
        }

}
    public void fetch1(){
        ArrayList<User> list = userList1();
        DefaultTableModel model1=(DefaultTableModel) jTable1.getModel();
        Object[] row=new Object[6];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getitemcode();
            row[1]=list.get(i).getname();
            row[2]=list.get(i).getcompany();
            row[3]=list.get(i).getmodel();
            row[4]=list.get(i).gettax();
            row[5]=list.get(i).getprice();
            model1.addRow(row);           
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("    PRICE LIST");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Code", "Item Name", "Company", "Model", "Tax", "Price"
            }
        ));
        jTable1.setEditingColumn(6);
        jTable1.setEditingRow(0);
        jScrollPane1.setViewportView(jTable1);

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel3.setText("   SearchBar/Filter");

        jButton1.setText("CLOSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(381, 381, 381))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextField1))
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(257, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
    DefaultTableModel model1=(DefaultTableModel) jTable1.getModel();
    String search=jTextField1.getText().toUpperCase();
    TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model1);
    jTable1.setRowSorter(tr);
    tr.setRowFilter(RowFilter.regexFilter(search));
    //showData();    // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     dispose();   // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PriceList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PriceList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PriceList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PriceList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PriceList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
