/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maintan;

/**
 *
 * @author Dinith Gamage
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class validate {
    
        public static boolean Namevalidation(String name)
    {   
        if(!name.isEmpty())
        {
            boolean value=true ;
             for(int i=0;i<name.length();i++)
             {
                 if( !Character.isAlphabetic(name.charAt(i)) && name.charAt(i)!=' ' || name.length()>25  )
                  {
           
              
                       JOptionPane.showMessageDialog(null, "Name format invalid it's should be Letters only ");
                       value=false;
                       return value;
                  }
        }
            return value;
        }
         JOptionPane.showMessageDialog(null, "Name is Empty");
          return false;
    } 
        
     
         
         public static boolean numbervalidation(String c)
    {
        boolean b=true ;
    if(c.isEmpty()) 
    {
                  
            JOptionPane.showMessageDialog(null, "field empty ! ");

            return false;
            
        }
        
    else{
        for(int i=0;i<c.length();i++)
        {
        if( !Character.isDigit(c.charAt(i))   )
            {
               b=false;
              
              JOptionPane.showMessageDialog(null, "Please enter number ! ");
               
               return b;
             }
        }
    }
        return b;
        
    }
    
       
         public static boolean isThisDateValid(String dateToValidate){

		if(dateToValidate == null){
                     JOptionPane.showMessageDialog(null, "DATE format invalid it's should be yyyy-MM-dd");

			return false;
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);

		try {

			//if not valid, it will throw ParseException
			Date date = sdf.parse(dateToValidate);
			

		} catch (ParseException e) {

		   JOptionPane.showMessageDialog(null, "DATE format invalid it's should be yyyy-MM-dd");

			return false;
		}

		return true;
	}
    
                  public static boolean Pricevalidation(String c1)
    {
    if(c1.isEmpty()) 
    {
                  
            JOptionPane.showMessageDialog(null, "price field empty ! ");

            return false;
            
        }
        
        boolean b=true ;
        for(int i=0;i<c1.length();i++)
        {
        if( !Character.isDigit(c1.charAt(i))   )
            {
               b=false;
              
              JOptionPane.showMessageDialog(null, "Please enter cost ! ");
               
               return b;
             }
        }
        return b;
        
    }
                          public static boolean snvalidation(String itemcode)
    {
    if(itemcode.isEmpty()) 
    {
          
            
            JOptionPane.showMessageDialog(null, "Item Code is empty ! ");

            return false;
            
        }
    return true;
    }
}
