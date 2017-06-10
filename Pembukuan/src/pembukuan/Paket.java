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
    
    public String[] nama = new String[100];
    public int[] id,jumlah = new int[100];
    public float[] harga = new float[100];
    public Paket(){
         try{
            ConnectionClass c = new ConnectionClass();
            c.setConnection();
            ResultSet rs;
            rs = c.statement.executeQuery("select * from `paket`");
            System.out.println("Koneksi Berhasil, Tabel paket ditemukan");
            int i = 0;
            while(rs.next()){
                id[i] = Integer.parseInt(rs.getString("id"));
                nama[i] = rs.getString("nama_barang");
                jumlah[i] = Integer.parseInt(rs.getString("jumlah_barang"));
                harga[i] = Float.parseFloat(rs.getString("harga_barang"));
                i++;
            }
        }catch(Exception e){
            System.out.println("gagal ");
            System.out.println(e.getCause());
            System.out.println(e.getMessage()); 
        }
    
    }

    public int getId(int i) {
        return id[i];
    }

    public int getJumlah(int i) {
        return jumlah[i];
    }

    public String getNama(int i) {
        return nama[i];
    }

    public float getHarga(int i) {
        return harga[i];
    }
    
    
}
