package Order;



import Account.Cash_Payment;
import DBconnection.DBconnect;
import Order.Report.rConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shalini
 */
public class newOrder extends javax.swing.JFrame {
    Connection connection = null;
    PreparedStatement pst = null;
    ResultSet rs =null;

    /**
     * Creates new form newOrder
     */
    public newOrder()  {
        initComponents();
        connection=DBconnect.connect();
        
    }
     public newOrder(String estId) throws SQLException{
        initComponents();
        connection=DBconnect.connect();
        showDetails( estId);
        jTextField14.setText(formatter.format( now ));//display the current system date
        predictid();
     }
    
    //gets the current system date and displays
    Date now = new Date(); 
    SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd" ); 
//    SimpleDateFormat formatter = new SimpleDateFormat( "dd-MM-yyyy" ); 

    public void predictid() throws SQLException{
        try{
        String oid="";
        Statement stmt = connection.createStatement();
        rs=stmt.executeQuery("SELECT max(Orderid) from ordercust ");
        
        while(rs.next()){
        oid=rs.getString("max(Orderid)");
        int newid = Integer.parseInt(oid);
        int nextid = newid+1;
        String nextid1 = Integer.toString(nextid);
        jTextField13.setText(nextid1);
    }

        }
        catch(Exception e)
           {
           }
    }
    
    public void showDetails(String estId){
    try{
        Statement stmt = connection.createStatement();
            rs=stmt.executeQuery("Select e.CID,c.Cname,e.EstimateID,e.Edate,e.Eamount from estimate as e, customer as c where e.CID =c.CID");
            
            String cusid="";
            String cusname="";
            String estid="";
            String estdate="";
            String estamount="";
            
            while(rs.next()){
                cusid=rs.getString("CID");
                jTextField8.setText(cusid);
                cusname=rs.getString("Cname");
                jTextField9.setText(cusname);
                estid=rs.getString("EstimateID");
                jTextField7.setText(estid);
                estdate=rs.getString("Edate");
                jTextField6.setText(estdate);
                estamount=rs.getString("Eamount");
                jTextField10.setText(estamount);
                
            }
    }
    catch(Exception e)
           {
           }
}
    
    public void refnum (String num){
        try{
            Statement stmt = connection.createStatement();
            rs=stmt.executeQuery("Select refNo from ordercust where refNo = '"+num+"'");
            if(rs.absolute(1)){
               JOptionPane.showMessageDialog(null, "Duplicate Reference No!!\nPlease e-enter!!"); 
               jTextField21.setText("");
            }
   
            
        }
        catch(Exception e){
            
        }
    }
    
    public void estinum (String estnum){
        try{
            Statement stmt = connection.createStatement();
            rs=stmt.executeQuery("Select EstId from ordercust where EstId = '"+estnum+"'");
            
            if(rs.absolute(1)){
               
               int q = JOptionPane.showConfirmDialog(null, "An Order Has Already Being Created For The Provided Estimation Number!\nDo You Want To Use The Same Estimation??"); 
               if(q == 1){
                   jTextField18.setText("");
                   JOptionPane.showMessageDialog(null, "Enter The Estimation Number!!"); 
               }
               if(q == 0){
                   JOptionPane.showMessageDialog(null, "Press The Search Button!!"); 
               }
               
               
            }
            
//            if(rs.absolute(1)){
//                checkestinum (estnum);
//            }
   
            
        }
        catch(Exception e){
            
        }
    }
    
//    public void checkestinum (String esti){
//        try{
//            Statement stmt = connection.createStatement();
//            rs=stmt.executeQuery("Select EstimateID from estimate where EstimateID = '"+esti+"'");
//            if(!rs.absolute(1)){
//                
//               JOptionPane.showMessageDialog(null, "Invalid Estimation Id Provided!!"); 
//               jTextField18.setText("");
//               
//            }
//   
//            
//        }
//        catch(Exception e){
//            
//        }
//    }
    
//    public void pdffile(File fname) throws SQLException{
////        selectedFile;
//        String f = fname.toString();
//        String s = "INSERT INTO ordercust ( file ) VALUES (?);";
//        PreparedStatement p = null;
//        try {
//            p = connection.prepareStatement(s);
//        } catch (SQLException ex) {
//            Logger.getLogger(newOrder.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        p.setString(1, f);
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel19 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel23 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator14 = new javax.swing.JSeparator();
        jButton17 = new javax.swing.JButton();
        jTextField18 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 18, 50));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton5.setBackground(new java.awt.Color(0, 100, 150));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/icons8-Back-50.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 60, 60));

        jButton16.setBackground(new java.awt.Color(0, 100, 150));
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/icons8-Home-50.png"))); // NOI18N
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, 60, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 81, 710));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("New Order");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(739, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 920, 80));

        jPanel2.setBackground(new java.awt.Color(32, 47, 90));

        jPanel10.setBackground(new java.awt.Color(106, 116, 145));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/icons8-Clear Symbol-50.png"))); // NOI18N
        jButton10.setText("Clear");
        jPanel10.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, -1, 50));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Customer Details");
        jPanel10.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel10.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 350, 10));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CUSTOMER ID :");
        jPanel10.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("CUSTOMER :");
        jPanel10.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jTextField8.setBackground(new java.awt.Color(106, 116, 145));
        jTextField8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(255, 255, 255));
        jTextField8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jPanel10.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 100, -1));

        jTextField9.setBackground(new java.awt.Color(106, 116, 145));
        jTextField9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(255, 255, 255));
        jTextField9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel10.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 210, -1));

        jPanel11.setBackground(new java.awt.Color(106, 116, 145));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/icons8-Clear Symbol-50.png"))); // NOI18N
        jButton11.setText("Clear");
        jPanel11.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, -1, 50));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Customer Details");
        jPanel11.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel11.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 350, 10));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("CUSTOMER ID :");
        jPanel11.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("CUSTOMER :");
        jPanel11.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jTextField11.setBackground(new java.awt.Color(106, 116, 145));
        jTextField11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        jPanel11.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 100, -1));

        jTextField12.setBackground(new java.awt.Color(106, 116, 145));
        jTextField12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel11.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 210, -1));

        jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, 370, 100));

        jPanel8.setBackground(new java.awt.Color(106, 116, 145));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/icons8-Clear Symbol-50.png"))); // NOI18N
        jButton8.setText("Clear");
        jPanel8.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, -1, 50));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Estimation Details");
        jPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel8.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 350, 10));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ESTIMATION DATE :");
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("ESTIMATION AMOUNT :");
        jPanel8.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jTextField6.setBackground(new java.awt.Color(106, 116, 145));
        jTextField6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));
        jTextField6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel8.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 120, -1));

        jTextField10.setBackground(new java.awt.Color(106, 116, 145));
        jTextField10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField10.setForeground(new java.awt.Color(255, 255, 255));
        jTextField10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel8.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 120, -1));

        jTextField7.setBackground(new java.awt.Color(106, 116, 145));
        jTextField7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(255, 255, 255));
        jTextField7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jPanel8.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 120, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("ESTIMATION ID :");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 20));

        jPanel12.setBackground(new java.awt.Color(106, 116, 145));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/icons8-Clear Symbol-50.png"))); // NOI18N
        jButton12.setText("Clear");
        jPanel12.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, -1, 50));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Order Details");
        jPanel12.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel12.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 350, 10));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("ORDER  ID :");
        jPanel12.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("DELIVERY REQUEST :");
        jPanel12.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 20));

        jTextField13.setEditable(false);
        jTextField13.setBackground(new java.awt.Color(106, 116, 145));
        jTextField13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField13.setForeground(new java.awt.Color(255, 255, 255));
        jTextField13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });
        jPanel12.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 100, -1));

        jTextField14.setEditable(false);
        jTextField14.setBackground(new java.awt.Color(106, 116, 145));
        jTextField14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField14.setForeground(new java.awt.Color(255, 255, 255));
        jTextField14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel12.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 100, -1));

        jPanel13.setBackground(new java.awt.Color(106, 116, 145));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/icons8-Clear Symbol-50.png"))); // NOI18N
        jButton13.setText("Clear");
        jPanel13.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, -1, 50));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Customer Details");
        jPanel13.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel13.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 350, 10));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("CUSTOMER ID :");
        jPanel13.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("CUSTOMER :");
        jPanel13.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jTextField15.setBackground(new java.awt.Color(106, 116, 145));
        jTextField15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });
        jPanel13.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 100, -1));

        jTextField16.setBackground(new java.awt.Color(106, 116, 145));
        jTextField16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel13.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 210, -1));

        jPanel12.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, 370, 100));

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Yes");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel12.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, -1, -1));

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setText("No");
        jPanel12.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("ORDER DATE :");
        jPanel12.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jPanel14.setBackground(new java.awt.Color(106, 116, 145));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/icons8-Clear Symbol-50.png"))); // NOI18N
        jButton14.setText("Clear");
        jPanel14.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, -1, 50));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("More Information");
        jPanel14.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel14.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 350, 10));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("DESIGN FILE :");
        jPanel14.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 90, -1));

        jPanel15.setBackground(new java.awt.Color(106, 116, 145));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/icons8-Clear Symbol-50.png"))); // NOI18N
        jButton15.setText("Clear");
        jPanel15.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, -1, 50));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Customer Details");
        jPanel15.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel15.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 350, 10));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("CUSTOMER ID :");
        jPanel15.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("CUSTOMER :");
        jPanel15.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jTextField19.setBackground(new java.awt.Color(106, 116, 145));
        jTextField19.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField19ActionPerformed(evt);
            }
        });
        jPanel15.add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 100, -1));

        jTextField20.setBackground(new java.awt.Color(106, 116, 145));
        jTextField20.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel15.add(jTextField20, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 210, -1));

        jPanel14.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, 370, 100));

        jTextArea2.setBackground(new java.awt.Color(106, 116, 145));
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextArea2.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jPanel14.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 270, 80));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("MEMO  :");
        jPanel14.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 60, -1));

        jTextField17.setBackground(new java.awt.Color(106, 116, 145));
        jTextField17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField17.setForeground(new java.awt.Color(255, 255, 255));
        jTextField17.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel14.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 270, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("REFERENCE NO :");
        jPanel14.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 90, -1));

        jTextField21.setBackground(new java.awt.Color(106, 116, 145));
        jTextField21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField21.setForeground(new java.awt.Color(255, 255, 255));
        jTextField21.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField21ActionPerformed(evt);
            }
        });
        jTextField21.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField21KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField21KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField21KeyTyped(evt);
            }
        });
        jPanel14.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 140, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 80, -1));

        jButton4.setBackground(new java.awt.Color(204, 180, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/icons8-Clear Symbol-50.png"))); // NOI18N
        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 180, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/icons8-Save-50.png"))); // NOI18N
        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton17.setBackground(new java.awt.Color(204, 180, 255));
        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/icons8-Search-50.png"))); // NOI18N
        jButton17.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jTextField18.setBackground(new java.awt.Color(106, 116, 145));
        jTextField18.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTextField18.setForeground(new java.awt.Color(255, 255, 255));
        jTextField18.setBorder(null);
        jTextField18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField18ActionPerformed(evt);
            }
        });
        jTextField18.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField18KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField18KeyTyped(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Enter Estimation Id");

        jButton6.setBackground(new java.awt.Color(204, 180, 255));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/icons8-Process-26.png"))); // NOI18N
        jButton6.setText("Pay");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField18)
                                        .addComponent(jSeparator14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel35))
                                .addGap(18, 18, 18)
                                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(29, Short.MAX_VALUE)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 920, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void jTextField19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField19ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
           String eid="";
          
               
           
           try{
               
               
               eid= jTextField18.getText(); 
               
               
               Statement stmt = connection.createStatement();    
               rs=stmt.executeQuery("Select e.EstimateID ,e.Edate,e.Eamount,e.CID,c.Cname from estimate as e,customer as c where e.EstimateId = '"+eid+"' and e.CID=c.CID");
               
               
            String edate="";
            String eamount="";
            String cid="";
            String cus="";
    
            while(rs.next()){
                eid=rs.getString("EstimateID");
                jTextField7.setText(eid);
                edate=rs.getString("Edate");
                jTextField6.setText(edate);
                eamount=rs.getString("Eamount");
                jTextField10.setText(eamount);
                cid=rs.getString("CID");
                jTextField8.setText(cid);
                cus=rs.getString("Cname");
                jTextField9.setText(cus);
            }
            jTextField14.setText(formatter.format( now ));//display the current system date
            predictid();
           }
           catch(Exception e)
           {
           }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        customerProfile cp = null;
        cp = new  customerProfile();
        cp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        mainMenu mm = new  mainMenu();
        mm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
                    String cid     = jTextField8.getText();
                    String eid     = jTextField7.getText();
                    String memo    = jTextArea2.getText();
                    String date    = jTextField14.getText();
                    String process = "Undertaken";
                    String delivery = null ;
                    String filePath = jTextField17.getText();
                    String ref     = jTextField21.getText();
                    //String e      = jTextField18.getText();
//                    JFileChooser chooser = new JFileChooser();
//                    chooser.showOpenDialog(null);
//                    File f = chooser.getSelectedFile();
//                    String fileName = f.getAbsolutePath().toString();

//                    String input = "INSERT INTO imagesrc ( image_src ) VALUES (?);";
//                    PreparedStatement p = con.prepareStatement(input);
//                    p.setString(1, fileName);

//                    File selectedFile = fileChooser.getSelectedFile().getAbsoluteFile();
//                    jTextField17.setText(fileChooser.getSelectedFile().getAbsolutePath());

                    
                    if(jCheckBox1.isSelected()){
                    jCheckBox2.setEnabled(false);
                    delivery=String.valueOf(jCheckBox1.getText());
                    }
                    
                    if(jCheckBox2.isSelected()){
                    jCheckBox1.setEnabled(false);
                    delivery=String.valueOf(jCheckBox2.getText());
                    }
                    
                   if("".equals(eid)) {
                       JOptionPane.showMessageDialog(null, "All Fields Are Empty!!");
                   } 
                   else if(delivery == null){
                        JOptionPane.showMessageDialog(null, "Delivery Request Field is Empty!!");
                   }
                   
                   
                   else if("".equals(ref)){
                       JOptionPane.showMessageDialog(null, "Reference No Is Not Added!!");
                   }
                   
                   else if("".equals(filePath)){
                       JOptionPane.showMessageDialog(null, "Design Template Not Added!!");
                   }
                   
//                   else if(!"".equals(ref)){
//                       refnum(ref);
//                   }
                   
                   
                   
                   
                   else {
                   
                    int x = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Make And Save the Order?");
                    if(x==0){
                 
                    try{
               
                        String p = "insert into ordercust(Cid,EstId,memo,OrderDate,OrderStatus,deliveryReq,refNo,file) values('"+cid+"','"+eid+"','"+memo+"','"+date+"','"+process+"','"+delivery+"','"+ref+"', '"+filePath+"')";
                        
                        pst = connection.prepareStatement(p);
                        pst.execute();
                                                
                    
                    }   catch (SQLException ex) {
                            Logger.getLogger(newOrder.class.getName()).log(Level.SEVERE, null, ex);
                        }
//                    catch (Exception e){
//                    }
                    
                    int q = JOptionPane.showConfirmDialog(null, "Your Order Has Been Created! \nA Detailed Document Can Be Printed!!");
                    if(q == 0){
                        String orderID = jTextField13.getText();
                  
                        HashMap param = new HashMap();
                        rConnection cr = new rConnection();

                        param.put("CusOid",orderID );

                        cr.toPDF("PrintOrderForCus.jrxml",param); 
                  
                    
            }}}
            
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
                    String cid     = jTextField8.getText();
                    String date =jTextField14.getText() ;
                Cash_Payment P =new Cash_Payment(cid,date);
                    P.setVisible(true);
                    this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setFileSelectionMode( JFileChooser.FILES_ONLY );
    fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("PDF Documents (*.pdf)", "pdf"));
    int returnValue = fileChooser.showOpenDialog(null);
    if (returnValue == JFileChooser.APPROVE_OPTION) 
    {
    File selectedFile = fileChooser.getSelectedFile().getAbsoluteFile();
    jTextField17.setText(fileChooser.getSelectedFile().getAbsolutePath());
    }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField21KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField21KeyReleased
        // TODO add your handling code here:
       String r = jTextField21.getText();
       if(!"".equals(r)){
                       refnum(r);
                   }
    }//GEN-LAST:event_jTextField21KeyReleased

    private void jTextField21KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField21KeyTyped
        // TODO add your handling code here:
         
    }//GEN-LAST:event_jTextField21KeyTyped

    private void jTextField21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField21ActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jTextField21ActionPerformed

    private void jTextField21KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField21KeyPressed
        // TODO add your handling code here:
         
    }//GEN-LAST:event_jTextField21KeyPressed

    private void jTextField18KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField18KeyReleased
        // TODO add your handling code here:
          String e = jTextField18.getText(); 
          
          estinum (e);
          //checkestinum (e);
    }//GEN-LAST:event_jTextField18KeyReleased

    private void jTextField18KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField18KeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField18KeyTyped

    private void jTextField18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField18ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField18ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
                    jTextField8.setText("");
                    jTextField7.setText("");
                    jTextArea2.setText("");
                    jTextField14.setText("");
                    //String process = "Undertaken";
                    //String delivery = null ;
                    jTextField17.setText("");
                    jTextField21.setText("");
                    jTextField18.setText("");
                    jTextField6.setText("");
                    jTextField9.setText("");
                    jTextField10.setText("");
                    jTextField13.setText("");
                    jTextField14.setText("");
                    
                    jCheckBox1.setSelected(false);
                    jCheckBox2.setSelected(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

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
            java.util.logging.Logger.getLogger(newOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new newOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables

   
}
