/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payroll.validation;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Dell
 */
public class database {
 
    public static Connection connect(){
    
        Connection cntd=null;
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            cntd=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/itp", "root", "");
            
            
        
        
        }
        catch(Exception e){
            System.out.println(e);
        }
    
        
        
        
        
        
        return cntd;
    }
}
