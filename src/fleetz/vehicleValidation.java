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
public class vehicleValidation {
    public static boolean BrandValidation(String brand){

        if(!brand.isEmpty()){
            boolean value=true ;
            for(int i=0;i<brand.length();i++)
             {
                 if( !Character.isAlphabetic(brand.charAt(i)) || brand.length()>25  )
                  {
                       JOptionPane.showMessageDialog(null, "Brand format invalid, should be Letters only ");
                       value=false;
                       return value;
                  }
             }
            return value;
        }
        JOptionPane.showMessageDialog(null, "Brand is Empty");
        return false;         
    }
    public static boolean ModelValidation(String model){

        if(!model.isEmpty()){
            boolean value=true ;
            for(int i=0;i<model.length();i++)
             {
                 if( !Character.isAlphabetic(model.charAt(i)) || model.length()>25  )
                  {
                       JOptionPane.showMessageDialog(null, "Model format invalid, should be Letters only ");
                       value=false;
                       return value;
                  }
             }
            return value;
        }
        JOptionPane.showMessageDialog(null, "Model is Empty");
        return false;         
    }
    public static boolean ChassisValidation(String chassis){

        if(!chassis.isEmpty()){
            boolean value=true ;
            return value;
        }
        JOptionPane.showMessageDialog(null, "Chassis is Empty");
        return false;        
    }
    public static boolean RegValidation(String reg){

        if(!reg.isEmpty()){
            boolean value=true ;
            return value;
        }
        JOptionPane.showMessageDialog(null, "Reg No is Empty");
        return false;        
    }
    public static boolean OdoValidation(String odo){

        if(!odo.isEmpty()){
            boolean value=true;
            for(int i=0;i<odo.length();i++){
                if( !Character.isDigit(odo.charAt(i))&& odo.charAt(i)!='.'){
                    JOptionPane.showMessageDialog(null, "Vehicle ID format invalid, should be numbers & . only ");
                    value=false;
                    return value;
                }
            }
            return value;
        }
        JOptionPane.showMessageDialog(null, "Odometer No is Empty");
        return false;        
    }
    public static boolean TypeValidation(String type){
        if(!type.equals("Choose")){
            boolean value=true;
            return value;
        }
        JOptionPane.showMessageDialog(null, "Please choose a type");
        return false;        
    }
    public static boolean AvValidation(String av){
        if(!av.equals("Choose")){
            boolean value=true;
            return value;
        }
        JOptionPane.showMessageDialog(null, "Please choose availability");
        return false;        
    }
}
