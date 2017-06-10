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
public class Barang {

    String nama, jumlah, harga, id;

    public ResultSet tampilkanBarang(String idpaket) throws SQLException {

        ConnectionClass c = new ConnectionClass();
        c.setConnection();
        ResultSet rs;
        rs = c.statement.executeQuery("select id,nama_barang,harga_barang,jumlah_barang from barang where id_paket = '" + idpaket + "'");
        
        return rs;
    }

}
