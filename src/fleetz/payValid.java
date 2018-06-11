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
public class payValid {
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
    
    public static boolean AmountValidation(String am){

        if(!am.isEmpty()){
            boolean value=true;
            for(int i=0;i<am.length();i++){
                if( !Character.isDigit(am.charAt(i))&& am.charAt(i)!='.'){
                    JOptionPane.showMessageDialog(null, "Amount format invalid, should be numbers & . only ");
                    value=false;
                    return value;
                }
            }
            return value;
        }
        JOptionPane.showMessageDialog(null, "Amount is Empty");
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
}
