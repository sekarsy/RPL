/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pembukuan;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author MS
 */
public class Admin {

    public String username[] = new String[100];
    public String password[] = new String[100];
    public int id[] = new int[100];
    public int i = 0;

    public Admin() {
        try {
            ConnectionClass c = new ConnectionClass();
            c.setConnection();
            ResultSet rs;
            rs = c.statement.executeQuery("select * from `admin`");

            while (rs.next()) {
                id[i] = Integer.parseInt(rs.getString("id"));
                username[i] = rs.getString("username");
                password[i] = rs.getString("password");
                i++;
            }
            System.out.println("Membaca table Pegawai");
        } catch (Exception e) {
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

    public void tambahPaket(String item) throws SQLException {
        int idpaket = 0;
        ConnectionClass c = new ConnectionClass();
        c.setConnection();
        ResultSet rs;
        rs = c.statement.executeQuery("select id from paket where nama_paket = '" + item + "'");
        System.out.println("bb");
        while (rs.next()) {
            idpaket = Integer.parseInt(rs.getString("id"));
        }
        System.out.println(idpaket);
        c.statement.executeUpdate("UPDATE  paket SET "
                + "jumlah_barang=(select count(*) from barang where id_paket = '" + idpaket + "'), "
                + "harga=(select SUM(harga_barang) from barang where id_paket = '" + idpaket + "') "
                + "WHERE id = '" + idpaket + "';"
        );
        System.out.println("Paket Disimpan");
    }

    public void editPaket(String item) throws SQLException {
        int idpaket = 0;
        ConnectionClass c = new ConnectionClass();
        c.setConnection();
        ResultSet rs;
        rs = c.statement.executeQuery("select id from paket where nama_paket = '" + item + "'");
        System.out.println("bb");
        while (rs.next()) {
            idpaket = Integer.parseInt(rs.getString("id"));
        }
        System.out.println(idpaket);
        c.statement.executeUpdate("UPDATE  paket SET "
                + "jumlah_barang=(select count(*) from barang where id_paket = '" + idpaket + "'), "
                + "harga=(select SUM(harga_barang) from barang where id_paket = '" + idpaket + "') "
                + "WHERE id = '" + idpaket + "';"
        );
        System.out.println("Paket Disimpan");
    }

    public void hapusPaket(int idpilih) {
        if (idpilih != 0) {
            int confirm = JOptionPane.showConfirmDialog(null,
                    "Hapus Data ini?", "Hapus",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == 0) {
                try {

                    ConnectionClass c = new ConnectionClass();
                    c.setConnection();
                    ResultSet rs;

                    c.statement.executeUpdate("delete from barang where id_paket = '" + idpilih + "'");
                    c.statement.executeUpdate("UPDATE  paket SET "
                            + "jumlah_barang='0', "
                            + "harga='0' "
                            + "WHERE id = '" + idpilih + "';"
                    );
                    System.out.println("Menghapus paket");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                            "Gagal mengakses",
                            "Warning", JOptionPane.WARNING_MESSAGE);
                    System.out.println(e.getMessage());
                    System.out.println(e.getCause());
                }
            }
        }
    }

    public ResultSet lihatPembukuanMasuk() throws SQLException {
        ConnectionClass c = new ConnectionClass();
        c.setConnection();
        ResultSet rs;
        rs = c.statement.executeQuery("select * from tabel_masuk");
        return rs;
    }

    public ResultSet lihatPembukuanKeluar() throws SQLException {
        ConnectionClass c = new ConnectionClass();
        c.setConnection();
        ResultSet rs;
        rs = c.statement.executeQuery("select * from tabel_keluar");
        return rs;
    }
    
    public void konfirmasi(int idpilih) {
        if (idpilih != 0) {
            try {
                ConnectionClass c = new ConnectionClass();
                c.setConnection();
                ConnectionClass d = new ConnectionClass();
                d.setConnection();
                ResultSet rs;
                ResultSet rs1;
                rs = c.statement.executeQuery("select * from paket where id = '" + idpilih + "'");
                if (!rs.next()) {
                    return;
                }
                //hapus data ambil
                c.statement.executeUpdate("DELETE FROM paket_ambil where id_paket = '" + idpilih + "'");
                //pindah data paket ke tabel_masuk
                rs1 = c.statement.executeQuery("select * from barang where id_paket = '" + idpilih + "'");
                while (rs1.next()) {
                    d.statement.executeUpdate("insert into tabel_masuk values("
                            + "'" + rs1.getString("id") + "', "
                            + "'" + rs1.getString("nama_barang") + "', "
                            + "'" + rs1.getString("jumlah_barang") + "', "
                            + "'" + rs1.getString("harga_barang") + "')");

                }
                //hapus data barang
                c.statement.executeUpdate("delete from barang where id_paket = '" + idpilih + "'");
                //hapus data paket
                c.statement.executeUpdate("UPDATE  paket SET "
                        + "jumlah_barang='0', "
                        + "harga='0' "
                        + "WHERE id = '" + idpilih + "';"
                );
                //refres tabel konfirmasi
                System.out.println("konfirmasi");
            } catch (Exception e) {
                System.out.println("gagal ");
                System.out.println(e.getCause());
                System.out.println(e.getMessage());
            }
        }
    }

}
