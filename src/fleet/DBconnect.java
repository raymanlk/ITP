/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fleet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Pavilion
 */
public class DBconnect {
    public static Connection connect() throws SQLException
    {
        Connection con=null;
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itp","root","");
            System.out.println("Sucess");
        }
        catch (ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }
        return con;
    } 
}
