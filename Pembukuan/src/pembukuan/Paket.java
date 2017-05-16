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
public class Paket {
    
    public String[] id, jumlah,nama,harga = new String[100];
    public int index = 0;
    String[] data_paket;
    public Paket(){
         try{
            ConnectionClass c = new ConnectionClass();
            c.setConnection();
            ResultSet rs;
            rs = c.statement.executeQuery("select * from `paket`");
            System.out.println("Koneksi Berhasil, Tabel paket ditemukan");
        }catch(Exception e){
            System.out.println("gagal ");
            System.out.println(e.getCause());
            System.out.println(e.getMessage()); 
        }
    
    }

    public String getId(int i) {
        return id[i];
    }

    public String getJumlah(int i) {
        return jumlah[i];
    }

    public String getNama(int i) {
        return nama[i];
    }

    public String getHarga(int i) {
        return harga[i];
    }
    
    
    
}
