/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pembukuan;
import pembukuan.gui.*;
/**
 *
 * @author MS
 */
public class Pembukuan {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args){
        // TODO code application logic here
        try{
            ConnectionClass c = new ConnectionClass();
            c.setConnection();
            new Login().setVisible(true);
        }catch(Exception e){
            System.out.println("gagal");
        }

    }
    
}
