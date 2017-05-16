/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pembukuan.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pembukuan.*;

/**
 *
 * @author MS
 */
public class adminMenu extends javax.swing.JFrame {

    /**
     * Creates new form adminMenu
     */
    DefaultTableModel tab = null;
    String id_barang, jumlah_barang;
    String nama_barang;
    String harga_barang;
    String id_paket, jumlah_paket;
    String nama_paket;
    String harga_paket;
    String status_paket;
    String id_pegawai;
    int selRow;
    int[] selCol = new int[5];
    Object value = null;
    int idb = 0;
    void makeEmptyBarang() {
        idBarang.setText("");
        namaBarang.setText("");
        jumlahBarang.setText("");
        hargaBarang.setText("");
    }

    void showJual() {
        String id, nama, jumlah, harga;
        try {
            Object[] row = {"ID", "Nama Barang", "Jumlah", "Harga"};
            tab = new DefaultTableModel(null, row);
            tabelJual.setModel(tab);
            ConnectionClass c = new ConnectionClass();
            c.setConnection();
            ResultSet rs;
            rs = c.statement.executeQuery("select * from tabel_keluar");
            while (rs.next()) {
                id = rs.getString("id_barang");
                nama = rs.getString("nama_barang");
                jumlah = rs.getString("jumlah_barang");
                harga = rs.getString("harga_barang");
                String[] data = {id, nama, jumlah, harga};
                tab.addRow(data);
            }

            System.out.println("Tampilkan Penjualan");
        } catch (Exception e) {
            System.out.println("gagal ");
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
        }
    }

    void showBeli() {
        String id, nama, jumlah, harga;
        try {
            Object[] row = {"ID", "Nama Barang", "Jumlah", "Harga"};
            tab = new DefaultTableModel(null, row);
            tabelBeli.setModel(tab);
            ConnectionClass c = new ConnectionClass();
            c.setConnection();
            ResultSet rs;
            rs = c.statement.executeQuery("select * from tabel_masuk");
            while (rs.next()) {
                id = rs.getString("id_barang");
                nama = rs.getString("nama_barang");
                jumlah = rs.getString("jumlah_barang");
                harga = rs.getString("harga_barang");
                String[] data = {id, nama, jumlah, harga};
                tab.addRow(data);
            }

            System.out.println("Tampilkan Pembelian");
        } catch (Exception e) {
            System.out.println("gagal ");
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
        }
    }

    void showConfirm() {
        try {
            Object[] row = {"ID", "Nama Paket", "Jumlah Barang", "Total Harga", "ID_Pegawai", "Status"};
            tab = new DefaultTableModel(null, row);
            tabelKonfirmasiAdmin.setModel(tab);
            ConnectionClass c = new ConnectionClass();
            c.setConnection();
            ConnectionClass d = new ConnectionClass();
            d.setConnection();
            ResultSet rs;
            ResultSet rs1;
            rs = c.statement.executeQuery("select * from paket where jumlah_barang > 0");
            System.out.println("aa");
            while (rs.next()) {
                System.out.println("bb");

                rs1 = d.statement.executeQuery("select * from paket_ambil where id_paket='" + rs.getString("id") + "'");

                if (rs1.next()) {
                    id_paket = rs.getString("id");
                    nama_paket = rs.getString("nama_paket");
                    jumlah_paket = rs.getString("jumlah_barang");
                    harga_paket = rs.getString("harga");
                    status_paket = rs1.getString("status_paket");
                    id_pegawai = rs1.getString("id_pegawai");
                    String[] data = {id_paket, nama_paket, jumlah_paket, harga_paket, id_pegawai, status_paket};
                    tab.addRow(data);
                    System.out.println("aaa");
                }
            }
            System.out.println("Membaca Paket terambil");
        } catch (Exception e) {
            System.out.println("gagal ");
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
        }
    }

    void showPaket() {
        try {
            Object[] row = {"ID", "Nama Paket", "Jumlah Barang", "Total Harga"};
            tab = new DefaultTableModel(null, row);
            tabel_paket.setModel(tab);
            ConnectionClass c = new ConnectionClass();
            c.setConnection();
            ConnectionClass d = new ConnectionClass();
            d.setConnection();
            ResultSet rs;
            ResultSet rs1;
            rs = c.statement.executeQuery("select * from paket where jumlah_barang > 0");
            System.out.println("aa");
            while (rs.next()) {
                System.out.println("bb");

                rs1 = d.statement.executeQuery("select * from paket_ambil where id_paket='" + rs.getString("id") + "'");

                if (!rs1.next()) {
                    id_paket = rs.getString("id");
                    nama_paket = rs.getString("nama_paket");
                    jumlah_paket = rs.getString("jumlah_barang");
                    harga_paket = rs.getString("harga");
                    String[] data = {id_paket, nama_paket, jumlah_paket, harga_paket};
                    tab.addRow(data);
                    System.out.println("aaa");
                }
            }
            System.out.println("Membaca table Paket");
        } catch (Exception e) {
            System.out.println("gagal ");
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
        }
    }

    public adminMenu() {
        initComponents();
        this.setLocationRelativeTo(null);
        data.setVisible(true);
        paketPost.setVisible(true);
        addPaket.setVisible(false);

        konfirmasi.setVisible(false);

        pembukuan.setVisible(false);
        showPaket();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        btnMenuData = new javax.swing.JButton();
        btnMenuKonfirmasi = new javax.swing.JButton();
        btnLihatPembukuan = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        data = new javax.swing.JPanel();
        paketPost = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_paket = new javax.swing.JTable();
        editPack = new javax.swing.JButton();
        deletePack = new javax.swing.JButton();
        addPack = new javax.swing.JButton();
        addPaket = new javax.swing.JPanel();
        paketSelect = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        idBarang = new javax.swing.JTextField();
        namaBarang = new javax.swing.JTextField();
        jumlahBarang = new javax.swing.JTextField();
        hargaBarang = new javax.swing.JTextField();
        addBarang = new javax.swing.JButton();
        savePack = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelPaketBarang = new javax.swing.JTable();
        backPaketPost = new javax.swing.JButton();
        btnHapusBarang = new javax.swing.JButton();
        simpanEditBarang = new javax.swing.JButton();
        konfirmasi = new javax.swing.JPanel();
        panelKonfirmasi = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelKonfirmasiAdmin = new javax.swing.JTable();
        konfirmasiPaket = new javax.swing.JButton();
        detailKonf = new javax.swing.JButton();
        panelLihat = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabelBarangK = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        idPegawai = new javax.swing.JLabel();
        stats = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        namaPack = new javax.swing.JLabel();
        pembukuan = new javax.swing.JPanel();
        penjualanPane = new javax.swing.JTabbedPane();
        Pembelian = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelBeli = new javax.swing.JTable();
        Penjualan = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelJual = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnMenuData.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        btnMenuData.setText("Data Post");
        btnMenuData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuDataActionPerformed(evt);
            }
        });

        btnMenuKonfirmasi.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        btnMenuKonfirmasi.setText("Konfirmasi");
        btnMenuKonfirmasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuKonfirmasiActionPerformed(evt);
            }
        });

        btnLihatPembukuan.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        btnLihatPembukuan.setText("Lihat Pembukuan");
        btnLihatPembukuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLihatPembukuanActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new java.awt.CardLayout());

        data.setLayout(new java.awt.CardLayout());

        tabel_paket.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabel_paket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Jenis Paket", "Jumlah Barang", "Harga"
            }
        ));
        jScrollPane1.setViewportView(tabel_paket);

        editPack.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        editPack.setText("Edit");
        editPack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPackActionPerformed(evt);
            }
        });

        deletePack.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        deletePack.setText("Delete");
        deletePack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePackActionPerformed(evt);
            }
        });

        addPack.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addPack.setText("Add");
        addPack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paketPostLayout = new javax.swing.GroupLayout(paketPost);
        paketPost.setLayout(paketPostLayout);
        paketPostLayout.setHorizontalGroup(
            paketPostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paketPostLayout.createSequentialGroup()
                .addContainerGap(474, Short.MAX_VALUE)
                .addComponent(addPack, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(editPack, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deletePack)
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paketPostLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        paketPostLayout.setVerticalGroup(
            paketPostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paketPostLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paketPostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deletePack)
                    .addComponent(editPack)
                    .addComponent(addPack))
                .addGap(14, 14, 14))
        );

        data.add(paketPost, "card2");

        paketSelect.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        paketSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----------", "Makanan Ringan", "Peralatan Tulis dan Gambar", "Bumbu Dapur", "Minuman Ringan", "Sembako", "Olahan Ternak", "Olahan Tani" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nama");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Jumlah");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Harga");

        idBarang.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        namaBarang.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jumlahBarang.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        hargaBarang.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        addBarang.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addBarang.setText("Add");
        addBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBarangActionPerformed(evt);
            }
        });

        savePack.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        savePack.setText("Save");
        savePack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePackActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Jenis Paket");

        tabelPaketBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nama", "Jumlah", "Harga"
            }
        ));
        jScrollPane5.setViewportView(tabelPaketBarang);

        backPaketPost.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        backPaketPost.setText("Kembali");
        backPaketPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backPaketPostActionPerformed(evt);
            }
        });

        btnHapusBarang.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnHapusBarang.setText("Hapus");
        btnHapusBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusBarangActionPerformed(evt);
            }
        });

        simpanEditBarang.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        simpanEditBarang.setText("Simpan");
        simpanEditBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanEditBarangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addPaketLayout = new javax.swing.GroupLayout(addPaket);
        addPaket.setLayout(addPaketLayout);
        addPaketLayout.setHorizontalGroup(
            addPaketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPaketLayout.createSequentialGroup()
                .addGroup(addPaketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addPaketLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(addPaketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addPaketLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(paketSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(addPaketLayout.createSequentialGroup()
                                .addGroup(addPaketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(26, 26, 26)
                                .addGroup(addPaketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(addPaketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(addPaketLayout.createSequentialGroup()
                                    .addComponent(simpanEditBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(addBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(addPaketLayout.createSequentialGroup()
                                    .addGroup(addPaketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                    .addGap(18, 18, 18)
                                    .addGroup(addPaketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(hargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jumlahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addPaketLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backPaketPost)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHapusBarang)
                        .addGap(18, 18, 18)
                        .addComponent(savePack)))
                .addContainerGap())
        );
        addPaketLayout.setVerticalGroup(
            addPaketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPaketLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addPaketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addPaketLayout.createSequentialGroup()
                        .addGroup(addPaketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(paketSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(26, 26, 26)
                        .addGroup(addPaketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(idBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(addPaketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(addPaketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jumlahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(addPaketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(hargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(addPaketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addBarang)
                            .addComponent(simpanEditBarang))
                        .addGap(0, 71, Short.MAX_VALUE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addPaketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(savePack)
                    .addComponent(backPaketPost)
                    .addComponent(btnHapusBarang))
                .addGap(17, 17, 17))
        );

        data.add(addPaket, "card3");

        jPanel1.add(data, "card2");

        konfirmasi.setLayout(new java.awt.CardLayout());

        tabelKonfirmasiAdmin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabelKonfirmasiAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Jenis Paket", "Jumlah Barang", "Harga", "ID Pegawai", "Status"
            }
        ));
        jScrollPane2.setViewportView(tabelKonfirmasiAdmin);

        konfirmasiPaket.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        konfirmasiPaket.setText("Konfirmasi");
        konfirmasiPaket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                konfirmasiPaketActionPerformed(evt);
            }
        });

        detailKonf.setText("Lihat Detail");
        detailKonf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailKonfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelKonfirmasiLayout = new javax.swing.GroupLayout(panelKonfirmasi);
        panelKonfirmasi.setLayout(panelKonfirmasiLayout);
        panelKonfirmasiLayout.setHorizontalGroup(
            panelKonfirmasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKonfirmasiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelKonfirmasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelKonfirmasiLayout.createSequentialGroup()
                        .addComponent(detailKonf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(konfirmasiPaket))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelKonfirmasiLayout.setVerticalGroup(
            panelKonfirmasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelKonfirmasiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelKonfirmasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(detailKonf)
                    .addComponent(konfirmasiPaket))
                .addContainerGap())
        );

        konfirmasi.add(panelKonfirmasi, "card2");

        tabelBarangK.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabelBarangK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nama", "Jumlah", "Harga"
            }
        ));
        jScrollPane6.setViewportView(tabelBarangK);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("ID_Pegawai");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Status");

        idPegawai.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        idPegawai.setText("nama");

        stats.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        stats.setText("stat");

        jButton13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton13.setText("Kembali");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Jenis Paket");

        namaPack.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        namaPack.setText("paket");

        javax.swing.GroupLayout panelLihatLayout = new javax.swing.GroupLayout(panelLihat);
        panelLihat.setLayout(panelLihatLayout);
        panelLihatLayout.setHorizontalGroup(
            panelLihatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLihatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLihatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton13)
                    .addGroup(panelLihatLayout.createSequentialGroup()
                        .addGroup(panelLihatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(panelLihatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namaPack)
                            .addComponent(stats)
                            .addComponent(idPegawai))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelLihatLayout.setVerticalGroup(
            panelLihatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLihatLayout.createSequentialGroup()
                .addGroup(panelLihatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLihatLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 31, Short.MAX_VALUE))
                    .addGroup(panelLihatLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelLihatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(namaPack))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLihatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(idPegawai))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLihatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(stats))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton13)))
                .addContainerGap())
        );

        konfirmasi.add(panelLihat, "card3");

        jPanel1.add(konfirmasi, "card3");

        penjualanPane.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        penjualanPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                penjualanPaneMouseClicked(evt);
            }
        });

        tabelBeli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nama", "Jumlah", "Harga"
            }
        ));
        jScrollPane4.setViewportView(tabelBeli);

        javax.swing.GroupLayout PembelianLayout = new javax.swing.GroupLayout(Pembelian);
        Pembelian.setLayout(PembelianLayout);
        PembelianLayout.setHorizontalGroup(
            PembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
        );
        PembelianLayout.setVerticalGroup(
            PembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
        );

        penjualanPane.addTab("Pembelian", Pembelian);

        tabelJual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tabelJual);

        javax.swing.GroupLayout PenjualanLayout = new javax.swing.GroupLayout(Penjualan);
        Penjualan.setLayout(PenjualanLayout);
        PenjualanLayout.setHorizontalGroup(
            PenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
        );
        PenjualanLayout.setVerticalGroup(
            PenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
        );

        penjualanPane.addTab("Penjualan", Penjualan);

        javax.swing.GroupLayout pembukuanLayout = new javax.swing.GroupLayout(pembukuan);
        pembukuan.setLayout(pembukuanLayout);
        pembukuanLayout.setHorizontalGroup(
            pembukuanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pembukuanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(penjualanPane)
                .addContainerGap())
        );
        pembukuanLayout.setVerticalGroup(
            pembukuanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pembukuanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(penjualanPane)
                .addContainerGap())
        );

        jPanel1.add(pembukuan, "card4");

        jDesktopPane1.setLayer(btnMenuData, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnMenuKonfirmasi, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnLihatPembukuan, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(btnMenuData, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMenuKonfirmasi, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(btnLihatPembukuan)
                .addGap(66, 66, 66))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMenuKonfirmasi)
                    .addComponent(btnLihatPembukuan)
                    .addComponent(btnMenuData))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuDataActionPerformed
        // TODO add your handling code here:
        data.setVisible(true);
        konfirmasi.setVisible(false);
        pembukuan.setVisible(false);
    }//GEN-LAST:event_btnMenuDataActionPerformed

    private void btnMenuKonfirmasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuKonfirmasiActionPerformed
        // TODO add your handling code here:
        data.setVisible(false);
        konfirmasi.setVisible(true);
        pembukuan.setVisible(false);

        panelKonfirmasi.setVisible(true);
        panelLihat.setVisible(false);

        showConfirm();
    }//GEN-LAST:event_btnMenuKonfirmasiActionPerformed

    private void btnLihatPembukuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLihatPembukuanActionPerformed
        // TODO add your handling code here:
        data.setVisible(false);
        konfirmasi.setVisible(false);
        pembukuan.setVisible(true);

        showBeli();

    }//GEN-LAST:event_btnLihatPembukuanActionPerformed

    private void savePackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePackActionPerformed
        // TODO add your handling code here:
        paketPost.setVisible(true);
        addPaket.setVisible(false);

        try {
            int idpaket = 0;
            String item = (String) paketSelect.getSelectedItem();
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
            showPaket();
        } catch (Exception e) {
            System.out.println("gagal ");
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_savePackActionPerformed

    private void addPackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPackActionPerformed
        // TODO add your handling code here:
        paketPost.setVisible(false);
        addPaket.setVisible(true);

        Object[] row = {"ID", "Nama Barang", "Jumlah", "Harga"};
        tab = new DefaultTableModel(null, row);
        tabelPaketBarang.setModel(tab);

        simpanEditBarang.setVisible(false);
    }//GEN-LAST:event_addPackActionPerformed

    private void detailKonfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailKonfActionPerformed
        // TODO add your handling code here:

        int idpilih = Integer.parseInt(JOptionPane.showInputDialog(null, "Masukkan ID Paket : "));

        if (idpilih != 0) {
            try {
                panelKonfirmasi.setVisible(false);
                panelLihat.setVisible(true);
                Object[] row = {"ID", "Nama Barang", "Jumlah", "Harga"};
                tab = new DefaultTableModel(null, row);
                tabelBarangK.setModel(tab);
                ConnectionClass c = new ConnectionClass();
                c.setConnection();
                ResultSet rs;
                rs = c.statement.executeQuery("select * from barang where id_paket = '" + idpilih + "'");
                while (rs.next()) {
                    id_barang = rs.getString("id");
                    nama_barang = rs.getString("nama_barang");
                    harga_barang = rs.getString("harga_barang");
                    jumlah_barang = rs.getString("jumlah_barang");
                    String[] data = {id_barang, nama_barang, jumlah_barang, harga_barang};
                    tab.addRow(data);
                }

                rs = c.statement.executeQuery("select * from paket_ambil where id_paket = '" + idpilih + "'");
                if (rs.next()) {
                    idPegawai.setText(rs.getString("id_pegawai"));
                    stats.setText(rs.getString("status_paket"));
                }

                rs = c.statement.executeQuery("select * from paket where id = '" + idpilih + "'");
                if (rs.next()) {
                    namaPack.setText(rs.getString("nama_paket"));
                }

                System.out.println("lihat Paket");
            } catch (Exception e) {
                System.out.println("gagal ");
                System.out.println(e.getCause());
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_detailKonfActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        panelKonfirmasi.setVisible(true);
        panelLihat.setVisible(false);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void backPaketPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backPaketPostActionPerformed
        // TODO add your handling code here:   
        try {
            int idpaket = 0;
            String item = (String) paketSelect.getSelectedItem();
            ConnectionClass c = new ConnectionClass();
            c.setConnection();
            ResultSet rs;
            System.out.println("aa");
            rs = c.statement.executeQuery("select id from paket where nama_paket = '" + item + "'");
            System.out.println("bb");
            while (rs.next()) {
                idpaket = Integer.parseInt(rs.getString("id"));
            }
            c.statement.executeUpdate("delete from barang where id_paket = '" + idpaket + "'");
            paketPost.setVisible(true);
            addPaket.setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Gagal Menghapus Data",
                    "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_backPaketPostActionPerformed

    private void addBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBarangActionPerformed
        // TODO add your handling code here:

        try {
            int idpaket = 0;
            String item = (String) paketSelect.getSelectedItem();
            ConnectionClass c = new ConnectionClass();
            c.setConnection();
            ResultSet rs;
            rs = c.statement.executeQuery("select id from paket where nama_paket = '" + item + "'");
            while (rs.next()) {
                idpaket = Integer.parseInt(rs.getString("id"));
            }

            c.statement.executeUpdate("insert into barang values("
                    + "'" + Integer.parseInt(idBarang.getText()) + "'"
                    + ",'" + namaBarang.getText() + "'"
                    + ",'" + Float.parseFloat(hargaBarang.getText()) + "'"
                    + ",'" + Integer.parseInt(jumlahBarang.getText()) + "'"
                    + ",'" + idpaket + "'"
                    + ")");

            rs = c.statement.executeQuery("select id,nama_barang,harga_barang,jumlah_barang from barang where id_paket = '" + idpaket + "'");
            int row = tab.getRowCount();
            for (int i = 0; i < row; i++) {
                tab.removeRow(0);
            }
            while (rs.next()) {
                id_barang = rs.getString("id");
                nama_barang = rs.getString("nama_barang");
                harga_barang = rs.getString("harga_barang");
                jumlah_barang = rs.getString("jumlah_barang");
                String[] data = {id_barang, nama_barang, jumlah_barang, harga_barang};
                tab.addRow(data);
            }
            makeEmptyBarang();
            System.out.println("Menulis barang");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Gagal Memasukkan Data",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }

    }//GEN-LAST:event_addBarangActionPerformed

    private void btnHapusBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusBarangActionPerformed
        // TODO add your handling code here:
        int idpilih = Integer.parseInt(JOptionPane.showInputDialog(null, "Masukkan ID Barang : "));

        if (idpilih != 0) {

            try {

                ConnectionClass c = new ConnectionClass();
                c.setConnection();
                ResultSet rs;

                c.statement.executeUpdate("delete from barang where id = '" + idpilih + "'");

                rs = c.statement.executeQuery("select id,nama_barang,harga_barang,jumlah_barang from barang");
                int row = tab.getRowCount();
                for (int i = 0; i < row; i++) {
                    tab.removeRow(0);
                }
                while (rs.next()) {
                    id_barang = rs.getString("id");
                    nama_barang = rs.getString("nama_barang");
                    harga_barang = rs.getString("harga_barang");
                    jumlah_barang = rs.getString("jumlah_barang");
                    String[] data = {id_barang, nama_barang, jumlah_barang, harga_barang};
                    tab.addRow(data);
                }
                System.out.println("Menghapus barang barang");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Gagal mengakses",
                        "Warning", JOptionPane.WARNING_MESSAGE);
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
            }
        }
    }//GEN-LAST:event_btnHapusBarangActionPerformed

    private void simpanEditBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanEditBarangActionPerformed
        // TODO add your handling code here:
        if(idb!=0){
        simpanEditBarang.setVisible(false);
        addBarang.setVisible(true);
        
        try {
            int idpaket = 0;
            String item = (String) paketSelect.getSelectedItem();
            ConnectionClass c = new ConnectionClass();
            c.setConnection();
            ResultSet rs;
            

            c.statement.executeUpdate("UPDATE  barang SET "
                    + "nama_barang='" + namaBarang.getText() + "', "
                    + "harga_barang='" + Float.parseFloat(hargaBarang.getText()) + "', "
                    + "jumlah_barang='" + Integer.parseInt(jumlahBarang.getText()) + "' "
                    + " WHERE id_barang='" + idb + "' "
            );

            rs = c.statement.executeQuery("select id,nama_barang,harga_barang,jumlah_barang from barang where id_paket = '" + idpaket + "'");

            int row = tab.getRowCount();
            for (int i = 0; i < row; i++) {
                tab.removeRow(0);
            }
            while (rs.next()) {
                id_barang = rs.getString("id");
                nama_barang = rs.getString("nama_barang");
                harga_barang = rs.getString("harga_barang");
                jumlah_barang = rs.getString("jumlah_barang");
                String[] data = {id_barang, nama_barang, jumlah_barang, harga_barang};
                tab.addRow(data);
            }
            makeEmptyBarang();
            System.out.println("Barang di Edit");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Gagal mengakses",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
        }
    }//GEN-LAST:event_simpanEditBarangActionPerformed

    private void editPackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPackActionPerformed
        // TODO add your handling code here:
        int idpilih = Integer.parseInt(JOptionPane.showInputDialog(null, "Masukkan ID Paket : "));

        if (idpilih != 0) {
//        tabel_paket.addMouseListener(new MouseAdapter() {
//            public void mousePressed(MouseEvent me) {
//                selRow = tabel_paket.getSelectedRow();
//                selCol = tabel_paket.getSelectedColumns();
//                value = tabel_paket.getValueAt(selRow, selCol[0]);
//                idB = value.toString();
//            }
//        });
            paketPost.setVisible(false);
            addPaket.setVisible(true);
            Object[] row = {"ID", "Nama Barang", "Jumlah", "Harga"};
            tab = new DefaultTableModel(null, row);
            tabelPaketBarang.setModel(tab);

            simpanEditBarang.setVisible(false);

            try {
                ConnectionClass c = new ConnectionClass();
                c.setConnection();
                ResultSet rs;
                rs = c.statement.executeQuery("select * from barang where id_paket = '" + idpilih + "'");
                while (rs.next()) {
                    id_barang = rs.getString("id");
                    nama_barang = rs.getString("nama_barang");
                    jumlah_barang = rs.getString("jumlah_barang");
                    harga_barang = rs.getString("harga_barang");
                    String[] data = {id_barang, nama_barang, jumlah_barang, harga_barang};
                    tab.addRow(data);
                }
                System.out.println("Membaca table barang");
            } catch (Exception e) {
                System.out.println("gagal ");
                System.out.println(e.getCause());
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_editPackActionPerformed

    private void deletePackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePackActionPerformed
        // TODO add your handling code here:
        int idpilih = Integer.parseInt(JOptionPane.showInputDialog(null, "Masukkan ID Paket : "));

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
                    showPaket();
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
    }//GEN-LAST:event_deletePackActionPerformed

    private void konfirmasiPaketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_konfirmasiPaketActionPerformed
        // TODO add your handling code here:
        int idpilih = Integer.parseInt(JOptionPane.showInputDialog(null, "Masukkan ID Paket : "));

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
                showConfirm();
                //Bismillah isohh!!!
                System.out.println("konfirmasi");
            } catch (Exception e) {
                System.out.println("gagal ");
                System.out.println(e.getCause());
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_konfirmasiPaketActionPerformed

    private void penjualanPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_penjualanPaneMouseClicked
        // TODO add your handling code here:

        int tabpane = penjualanPane.getSelectedIndex();
        if (tabpane == 0) {
            showBeli();
        } else if (tabpane == 1) {
            showJual();
        }

    }//GEN-LAST:event_penjualanPaneMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(adminMenu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminMenu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminMenu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminMenu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pembelian;
    private javax.swing.JPanel Penjualan;
    private javax.swing.JButton addBarang;
    private javax.swing.JButton addPack;
    private javax.swing.JPanel addPaket;
    private javax.swing.JButton backPaketPost;
    private javax.swing.JButton btnHapusBarang;
    private javax.swing.JButton btnLihatPembukuan;
    private javax.swing.JButton btnMenuData;
    private javax.swing.JButton btnMenuKonfirmasi;
    private javax.swing.JPanel data;
    private javax.swing.JButton deletePack;
    private javax.swing.JButton detailKonf;
    private javax.swing.JButton editPack;
    private javax.swing.JTextField hargaBarang;
    private javax.swing.JTextField idBarang;
    private javax.swing.JLabel idPegawai;
    private javax.swing.JButton jButton13;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField jumlahBarang;
    private javax.swing.JPanel konfirmasi;
    private javax.swing.JButton konfirmasiPaket;
    private javax.swing.JTextField namaBarang;
    private javax.swing.JLabel namaPack;
    private javax.swing.JPanel paketPost;
    private javax.swing.JComboBox<String> paketSelect;
    private javax.swing.JPanel panelKonfirmasi;
    private javax.swing.JPanel panelLihat;
    private javax.swing.JPanel pembukuan;
    private javax.swing.JTabbedPane penjualanPane;
    private javax.swing.JButton savePack;
    private javax.swing.JButton simpanEditBarang;
    private javax.swing.JLabel stats;
    private javax.swing.JTable tabelBarangK;
    private javax.swing.JTable tabelBeli;
    private javax.swing.JTable tabelJual;
    private javax.swing.JTable tabelKonfirmasiAdmin;
    private javax.swing.JTable tabelPaketBarang;
    private javax.swing.JTable tabel_paket;
    // End of variables declaration//GEN-END:variables
}
