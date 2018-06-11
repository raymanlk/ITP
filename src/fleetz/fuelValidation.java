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
public class fuelValidation {
    public static boolean VIDValidation(String vid){
        if(vid.equals("Choose")){
            JOptionPane.showMessageDialog(null, "Please choose a VID");
            return false;
        }
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
    
    public static boolean QuantityValidation(String quan){

        if(!quan.isEmpty()){
            boolean value=true;
            for(int i=0;i<quan.length();i++){
                if( !Character.isDigit(quan.charAt(i))&& quan.charAt(i)!='.'){
                    JOptionPane.showMessageDialog(null, "Quantity format invalid, should be numbers & . only ");
                    value=false;
                    return value;
                }
            }
            return value;
        }
        JOptionPane.showMessageDialog(null, "Quantity is Empty");
        return false;        
    }
    
    public static boolean CostValidation(String cost){

        if(!cost.isEmpty()){
            boolean value=true;
            for(int i=0;i<cost.length();i++){
                if( !Character.isDigit(cost.charAt(i))&& cost.charAt(i)!='.'){
                    JOptionPane.showMessageDialog(null, "Cost format invalid, should be numbers & . only ");
                    value=false;
                    return value;
                }
            }
            return value;
        }
        JOptionPane.showMessageDialog(null, "Cost is Empty");
        return false;        
    }
}
