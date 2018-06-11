package Inventory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
import java.sql.*;
import java.sql.DriverManager;
import javax.swing.*;
import java.sql.Connection;
   // import com.mysql.jdbc.driver;
public class connection {  
    
    public static Connection condb()throws SQLException{
        Connection conn=null;
      try{
          Class.forName("com.mysql.jdbc.Driver");
             conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/itp","root","");
            //JOptionPane.showMessageDialog(null, "connection ok");
            return conn;
          
      }
      catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
       return null;   
      }
    
    }    
}
