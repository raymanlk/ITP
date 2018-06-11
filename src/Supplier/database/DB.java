package Supplier.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Krishan
 */
public class DB {
    
   
       public static Connection getConnection() throws SQLException
      {
        Connection con = null;
        
           try {
               Class.forName("com.mysql.jdbc.Driver");
           
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itp","root","");
                 return con ;
            }
        catch(ClassNotFoundException | SQLException e)
        { //System.out.println(e);
        JOptionPane.showMessageDialog(null,"my sql database server not started","Error",JOptionPane.ERROR_MESSAGE); 
        }
           return null;
      }
        
      
         public static void main(String[] args) {
       

    
    
}

}
