package Supplier;


import java.awt.Color;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
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
public class SupplierValidation {
    
    public static boolean SupplierIDvalidation(String c)
            
            
    {
        
        if(c.isEmpty())
       {
                  JOptionPane.showMessageDialog(null, "Suppliler is Empty");
                  return false;
       }
        boolean b=true ;
        for(int i=0;i<c.length();i++)
        {
        if( !Character.isDigit(c.charAt(i))  )
            {
           
              
               JOptionPane.showMessageDialog(null, "SupplierID format invalid it's should be Digits only ");
               b=false;
               return b;
             }
        }
        return b;
    }    
    
    
    
    
    public static boolean itemCodevalidation(String c)
            
            
    {
        
        if(c.isEmpty())
       {
                  JOptionPane.showMessageDialog(null, "Item Code is Empty");
                  return false;
       }
        boolean b=true ;
        for(int i=0;i<c.length();i++)
        {
        if( !Character.isDigit(c.charAt(i))  )
            {
           
              
               JOptionPane.showMessageDialog(null, "Item Code format invalid it's should be Digits only ");
               b=false;
               return b;
             }
        }
        return b;
    }    
    
    
    public static boolean Namevalidation(String name)
    {
        if(!name.isEmpty())
        {
            boolean b=true ;
             for(int i=0;i<name.length();i++)
             {
                 if( !Character.isAlphabetic(name.charAt(i)) && !Character.isDigit(name.charAt(i)) &&  name.charAt(i)!=' ' &&  name.charAt(i)!='(' &&  name.charAt(i)!=')'  || name.length()>100  )
                  {
           
              
                       JOptionPane.showMessageDialog(null, "Supplier Name format invalid  ");
                       b=false;
                       return b;
                  }
        }
            return b;
        }
         JOptionPane.showMessageDialog(null, "Name is Empty");
          return false;
    }       


    
    
    
    public static boolean Addressvalidation(String add)
    {
        boolean b=true ;
       if( add.length()<100 && !add.isEmpty())
       {for(int i=0;i<add.length();i++)
        {
        if( !Character.isAlphabetic(add.charAt(i))&& !Character.isDigit(add.charAt(i))&& add.charAt(i)!='/' && add.charAt(i)!='-' && add.charAt(i)!='.' && add.charAt(i)!='#' && add.charAt(i)!=',' && add.charAt(i)!=' '  )
            {
           
              
               JOptionPane.showMessageDialog(null, "ADDRESS format invalid it's should be Letters and (/  -  #  , .) only ");
               b=false;
               return b;
             }
        }


          return b;
       
       }
       else if(add.isEmpty())
       {
                  JOptionPane.showMessageDialog(null, "ADDRESS is Empty");
                  return false;
       }
       
       JOptionPane.showMessageDialog(null, "ADDRESS format invalid it's MAXIMUM SIZE should be 100 Characters only ");

       return false;
    }    
    
    
    
    
    
    
    
    
     public static boolean Phonevalidation(String c)
    {
        if(c.isEmpty())
            
        {
           JOptionPane.showMessageDialog(null, "Phone Number is Empty ");
            return false ;
        }
    if(c.length()==10) 
    {
       if(c.charAt(0) !='0' ) 
        {   
            
            JOptionPane.showMessageDialog(null, "Phone Number format invalid it's should be 0XX1234567 ");
        
            return false;
            
        }
        
        boolean b=true ;
        for(int i=1;i<c.length();i++)
        {
        if( !Character.isDigit(c.charAt(i))   )
            {
               b=false;
              
              JOptionPane.showMessageDialog(null, "Phone Number format invalid it's should be 0XX1234567 ");
               
               return b;
             }
        }
        return b;
        
    }
    
    JOptionPane.showMessageDialog(null, "Phone Number format invalid it's should be 0XX1234567 ");

    return false;
    
    }       
     
     
     
    /* public static boolean EmailValidation(String email)
     {
         
         
         
          if (!(Pattern.matches("^[\\\\w-\\\\+]+(\\\\.[\\\\w]+)*@[\\\\w-]+(\\\\.[\\\\w]+)*(\\\\.[a-z]{2,})$&quot", email   ))) 
          {
            JOptionPane.showMessageDialog(null, "Please enter a valid email", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "The email is valid", "Good!", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        
     
     }*/
     
     
     public static boolean  isDoublePrice(String str) {
        try {
            Double.parseDouble(str);

            return true;
        } catch (NumberFormatException e) {
          JOptionPane.showMessageDialog(null, "The unitprice is invalid", "Error", JOptionPane.INFORMATION_MESSAGE);

            return false;
        }
    }
    
    


public static boolean Quantityvalidation(String c)
    {
        
        if(c.isEmpty())
       {
                  JOptionPane.showMessageDialog(null, "Quantity is Empty");
                  return false;
       }
        boolean b=true ;
        for(int i=0;i<c.length();i++)
        {
        if( !Character.isDigit(c.charAt(i))  )
            {
           
              
               JOptionPane.showMessageDialog(null, "Quantity format invalid it's should be Digits only ");
               b=false;
               return b;
             }
        }
        return b;
    }    
  




public static boolean EmailValidation(String email) {
     boolean b;
    if(email.isEmpty())
       {
                  JOptionPane.showMessageDialog(null, "Email is Empty");
                  return false;
       }
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
          b= m.matches();
          if(b)
          {
               return true;
              
          }
              
           JOptionPane.showMessageDialog(null, "Email format invalid  ");
           return false; 
    }






 public static boolean InternetConnection ()
    {
        Socket sock = new Socket();
        InetSocketAddress addr = new InetSocketAddress("www.google.com",80); 

        try
        {
            sock.connect(addr,3000);
            //JOptionPane.showMessageDialog(null,"You are connected!");
            
            return true;
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null,"Please check your Internet Connection!","Error",JOptionPane.ERROR_MESSAGE);

            return false;
        }
        finally
        {
            
            
            try {
                sock.close();
            } catch (IOException ex) {
                      
                    JOptionPane.showMessageDialog(null,"Please check your Internet Connection!", "Error", JOptionPane.ERROR_MESSAGE);

                     return false;            }
            
            
        }
    }

}

    