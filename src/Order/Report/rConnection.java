/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order.Report;

import DBconnection.DBconnect;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Shalini
 */
public class rConnection {
    Connection connection = null;
    PreparedStatement pst = null;
    ResultSet rs =null;
    
    
    public rConnection() {
       
        connection = DBconnect.connect();
    }
    
public void toPDF(String filename)
{

try 
{

JasperReport jr= null;
InputStream path = this.getClass().getResourceAsStream(filename);
JasperPrint jp=null;
jr = JasperCompileManager.compileReport(path);
HashMap parameters = new HashMap();
jp=JasperFillManager.fillReport(jr, parameters, connection);
JasperViewer.viewReport(jp,false);




}

catch(JRException e)
{
 Logger.getLogger(rConnection.class.getName()).log(Level.SEVERE,null,e);

}


}


public void toPDF(String filename, HashMap Parameter)
{

try 
{

JasperReport jr= null;
InputStream path = this.getClass().getResourceAsStream(filename);
JasperPrint jp=null;
jr = JasperCompileManager.compileReport(path);
//HashMap parameters = new HashMap();
jp=JasperFillManager.fillReport(jr, Parameter, connection);
JasperViewer.viewReport(jp,false);




}

catch(JRException e)
{
 Logger.getLogger(rConnection.class.getName()).log(Level.SEVERE,null,e);

}


}



}
