/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBconnection;
/**
 *
 * @author Shalini
 */
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBconnect {
    
    public static Connection connect(){
        
       Connection con = null;
       
       
       try{
           
           Class.forName("com.mysql.jdbc.Driver");
           con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/itp","root","");
                   
          }
       
       catch(Exception e){
           
           System.out.println(e);
       }
       return con;
    }

    public static java.sql.Connection getConn() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
