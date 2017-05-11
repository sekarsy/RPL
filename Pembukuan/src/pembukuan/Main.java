/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pembukuan;

/**
 *
 * @author MS
 */
public interface Main {
    
    public interface admin{
        
        public String getUsername();
        public String getPassword();
        public String getIdAdmin();
        public void tambahPaket();
        public void editPaket();
        public void hapusPaket();
        public void lihatPembukuan();
        public void konfirmasi();
    }
    
    public interface pegawai{
        
        public String getUsername();
        public String getPassword();
        public String getIdPegawai();
        public void ambilPaket();
        public void konfirmasi();
        public void insertDataJual();
    }

    
    public interface Paket{
        public int getID();
        public String getNama();
        public String getJumlahBarang();
        public void lihatPaket();
    }
    
    public interface Barang{
        public int getID();
        public String getNama();
        public int getJumlah();
        public int getHarga();
    }
    
    public interface Konfirmasi{
        public void lihatRequest();
        public void tambahRequest();
        public void cekRequest();
    }
    
    public interface Pembukuan{
        public void lihatDataJual();
        public void lihatDataBeli();
    }
}


