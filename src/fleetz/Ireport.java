/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fleetz;


import static Supplier.database.DB.getConnection;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Krishan
 */
public class Ireport {
    
    
    
    
     
    public static void MyReport(String r,HashMap parameter) throws SQLException, JRException{
     
    Connection connection = getConnection(); 
    
    
    
    JasperPrint jp = JasperFillManager.fillReport(r, parameter, connection);
           JRViewer jv = new JRViewer(jp);
          
               JFrame jf = new JFrame();
            jf.getContentPane().add(jv);
            jf.validate();
            jf.setVisible(true);
            jf.setSize(new Dimension(1200,1000));
            jf.setLocation(50,100);
            
    }
    
    
}
