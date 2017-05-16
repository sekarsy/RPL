/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pembukuan;

import java.sql.ResultSet;

/**
 *
 * @author MS
 */
public class Admin{

    public String username[] = new String[100];
    public String password[] = new String[100];
    public int id[] = new int[100];
    public int i = 0;
    
    public Admin() {
        try{
            ConnectionClass c = new ConnectionClass();
            c.setConnection();
            ResultSet rs;
            rs = c.statement.executeQuery("select * from `admin`");
            
            while(rs.next()){
                id[i] = Integer.parseInt(rs.getString("id"));
                username[i] = rs.getString("username");
                password[i] = rs.getString("password");
                i++;
            }
            System.out.println("Membaca table Pegawai");
        }catch(Exception e){
            System.out.println("gagal");
        }
    }
    
    public String getUsername(int j) {
        return username[j];
    }

    public String getPassword(int j) {
        return password[j];
    }

    public int getIdAdmin(int j) {
        return id[j];
    }

    public void tambahPaket() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void editPaket() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void hapusPaket() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void lihatPembukuan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void konfirmasi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
