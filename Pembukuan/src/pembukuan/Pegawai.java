/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pembukuan;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MS
 */
public class Pegawai {

    public String username[] = new String[100];
    public String password[] = new String[100];
    public int id[] = new int[100];
    public int i = 0;

    public Pegawai() {
        try {
            ConnectionClass c = new ConnectionClass();
            c.setConnection();
            ResultSet rs;
            rs = c.statement.executeQuery("select * from `pegawai`");

            while (rs.next()) {
                id[i] = Integer.parseInt(rs.getString("id"));
                username[i] = rs.getString("username");
                password[i] = rs.getString("password");
                i++;
            }
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

    public int getIdPegawai(int j) {
        return id[j];
    }

    public void memilihPaket(int idpilih, int id_pegawai, String status) {
        if (idpilih != 0) {
            try {
                ConnectionClass c = new ConnectionClass();
                c.setConnection();
                ResultSet rs;
                rs = c.statement.executeQuery("select id from paket where id = '" + idpilih + "'");
                if (!rs.next()) {
                    return;
                }
                c.statement.executeUpdate("INSERT into paket_ambil values("
                        + "'" + id_pegawai + "', "
                        + "'" + idpilih + "', "
                        + "'" + status + "' "
                        + ")");
                System.out.println("Ambil Paket");
            } catch (Exception e) {
                System.out.println("gagal ");
                System.out.println(e.getCause());
                System.out.println(e.getMessage());
            }

        }
    }

    public void mintaKonfirmasi(int idpaket, String status, int pegawai) {
        try {
            ConnectionClass c = new ConnectionClass();
            c.setConnection();
            ResultSet rs;
            rs = c.statement.executeQuery("select id from paket where id = '" + idpaket + "'");
            if (!rs.next()) {
                return;
            }
            c.statement.executeUpdate("UPDATE paket_ambil SET "
                    + "status_paket = '" + status + "' "
                    + "where id_paket = '" + idpaket + "' and id_pegawai ='" + pegawai + "'");

            System.out.println("konfirmasi");
        } catch (Exception e) {
            System.out.println("gagal ");
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
        }

    }

    public ResultSet tambahPembukuan(String[] data) throws SQLException {
        ConnectionClass c = new ConnectionClass();
        c.setConnection();
        ResultSet rs;
        c.statement.executeUpdate("insert into tabel_keluar values("
                + "'" + data[0] + "', '" + data[1] + "', '" + data[2] + "', '" + data[3] + "')");
        System.out.println("Edit gan");
        rs = c.statement.executeQuery("select * from tabel_keluar");
        return rs;
    }

}
