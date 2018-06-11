/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fleetz;

import javax.swing.JOptionPane;

/**
 *
 * @author Pavilion
 */
public class dValidation {
    public static boolean VIDValidation(String vid){

        if(!vid.isEmpty()){
            boolean value=true;
            for(int i=0;i<vid.length();i++){
                if( !Character.isDigit(vid.charAt(i))){
                    JOptionPane.showMessageDialog(null, "Vehicle ID format invalid, should be numbers only ");
                    value=false;
                    return value;
                }
            }
            return value;
        }
        JOptionPane.showMessageDialog(null, "Vehicle ID is Empty");
        return false;
        
    }
    
    public static boolean DIDValidation(String did){

        if(!did.isEmpty()){
            boolean value=true;
            for(int i=0;i<did.length();i++){
                if( !Character.isDigit(did.charAt(i))){
                    JOptionPane.showMessageDialog(null, "Delivery ID format invalid, should be numbers only ");
                    value=false;
                    return value;
                }
            }
            return value;
        }
        JOptionPane.showMessageDialog(null, "Delivery ID is Empty");
        return false;
        
    }
    
    public static boolean CIDValidation(String cid){
        if(cid.equals("Choose")){
            JOptionPane.showMessageDialog(null, "Please choose a CID");
            return false;
        }
        boolean value=true;
            for(int i=0;i<cid.length();i++){
                if( !Character.isDigit(cid.charAt(i))){
                    JOptionPane.showMessageDialog(null, "CID format invalid, should be numbers only ");
                    value=false;
                    return value;
                }
            }
        return value;
    }
    
    
    public static boolean DateValidation(String date){

        if(!date.isEmpty()){
            boolean value=true;
            return value;
        }
        JOptionPane.showMessageDialog(null, "Date is Empty");
        return false;        
    }
    
    public static boolean StatusValidation(String status){
        if(!status.equals("Choose")){
            boolean value=true;
            return value;
        }
        JOptionPane.showMessageDialog(null, "Please choose a status");
        return false;        
    }
    
    public static boolean AddressValidation(String add){

        if(!add.isEmpty()){
            boolean value=true;
            return value;
        }
        JOptionPane.showMessageDialog(null, "Address is Empty");
        return false;        
    }
    
    public static boolean NameValidation(String name){

        if(!name.isEmpty()){
            boolean value=true ;
            for(int i=0;i<name.length();i++)
             {
                 if( !Character.isAlphabetic(name.charAt(i)) &&  name.charAt(i)!=' '  )
                  {
                       JOptionPane.showMessageDialog(null, "Name format invalid, should be Letters only ");
                       value=false;
                       return value;
                  }
             }
            return value;
        }
        JOptionPane.showMessageDialog(null, "Name is Empty");
        return false;         
    }
    public static boolean Phonevalidation(String c){
        /*
        if(c.length()==10){
            if(c.charAt(0) !='0' ){ 
                JOptionPane.showMessageDialog(null, "Phone Number format invalid, should start 0XX1234567 ");
                return false;
            }
        boolean b=true ;
        for(int i=1;i<c.length();i++){
             if( !Character.isDigit(c.charAt(i))){
                  b=false;
                  JOptionPane.showMessageDialog(null, "Phone Number format invalid it should be 0XX1234567 ");
                  return b;
             
             }
        }
          return b;
        }
        
        JOptionPane.showMessageDialog(null, "Phone Number format invalid, should contain 10 digits ");
        return false;
    */
        return true;
    } 
    
    public static boolean DistanceValidation(String dis){

        if(!dis.isEmpty()){
            boolean value=true;
            for(int i=0;i<dis.length();i++){
                if( !Character.isDigit(dis.charAt(i))&& dis.charAt(i)!='.'){
                    JOptionPane.showMessageDialog(null, "Distance format invalid, should be numbers & . only ");
                    value=false;
                    return value;
                }
            }
            return value;
        }
        JOptionPane.showMessageDialog(null, "Distance is Empty");
        return false;        
    }
    
    public static boolean RateValidation(String rate){

        if(!rate.isEmpty()){
            boolean value=true;
            for(int i=0;i<rate.length();i++){
                if( !Character.isDigit(rate.charAt(i))&& rate.charAt(i)!='.'){
                    JOptionPane.showMessageDialog(null, "Rate format invalid, should be numbers & . only ");
                    value=false;
                    return value;
                }
            }
            return value;
        }
        JOptionPane.showMessageDialog(null, "Rate is Empty");
        return false;        
    }
    public static boolean OIDValidation(String oid){

        if(!oid.isEmpty()){
            boolean value=true;
            for(int i=0;i<oid.length();i++){
                if( !Character.isDigit(oid.charAt(i))){
                    JOptionPane.showMessageDialog(null, "OID format invalid, should be numbers only ");
                    value=false;
                    return value;
                }
            }
            return value;
        }
        JOptionPane.showMessageDialog(null, "OID is Empty");
        return false;
        
    }
    
    
    
}
