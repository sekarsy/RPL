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
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Let's Start!!");
        //new login().setVisible(true);
        new adminMenu().setVisible(true);
        new pegawaiMenu().setVisible(true);
    }
    
}
