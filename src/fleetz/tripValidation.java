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
public class tripValidation {
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
    
    public static boolean CurrentValidation(String cur){

        if(!cur.isEmpty()){
            boolean value=true;
            for(int i=0;i<cur.length();i++){
                if( !Character.isDigit(cur.charAt(i))&& cur.charAt(i)!='.'){
                    JOptionPane.showMessageDialog(null, "Current KM format invalid, should be numbers & . only ");
                    value=false;
                    return value;
                }
            }
            return value;
        }
        JOptionPane.showMessageDialog(null, "Current KM is Empty");
        return false;        
    }
}
