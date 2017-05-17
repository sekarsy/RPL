-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 17, 2017 at 06:42 AM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pembukuan`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(8) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(11122233, 'admin1', 'admin1');

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `ID` int(8) NOT NULL,
  `Nama_Barang` varchar(20) NOT NULL,
  `Harga_Barang` float NOT NULL,
  `Jumlah_Barang` int(10) NOT NULL,
  `id_paket` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`ID`, `Nama_Barang`, `Harga_Barang`, `Jumlah_Barang`, `id_paket`) VALUES
(43518275, 'Garam Dapur', 42500, 17, 12300005),
(51627334, 'Mizone', 78000, 30, 12300004),
(55162748, 'Aqua', 82000, 48, 12300004),
(73419374, 'Sunco', 213000, 15, 12300005),
(76524183, 'Gulaku', 180000, 12, 12300005),
(77615243, 'Vit', 40000, 24, 12300004),
(88123456, 'Pulpy Orange', 59000, 12, 12300004),
(90167574, 'Pocari Sweat', 168000, 28, 12300004),
(98765432, 'Beras 1 kwintal', 1960000, 4, 12300005);

-- --------------------------------------------------------

--
-- Table structure for table `paket`
--

CREATE TABLE `paket` (
  `id` int(8) NOT NULL,
  `nama_paket` varchar(30) NOT NULL,
  `jumlah_barang` int(3) DEFAULT NULL,
  `harga` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `paket`
--

INSERT INTO `paket` (`id`, `nama_paket`, `jumlah_barang`, `harga`) VALUES
(12300001, 'Makanan Ringan', 0, 0),
(12300002, 'Peralatan Tulis dan Gambar', 0, 0),
(12300003, 'Bumbu Dapur', 0, 0),
(12300004, 'Minuman Ringan', 5, 427000),
(12300005, 'Sembako', 4, 2395500);

-- --------------------------------------------------------

--
-- Table structure for table `paket_ambil`
--

CREATE TABLE `paket_ambil` (
  `id_pegawai` int(8) NOT NULL,
  `id_paket` int(8) NOT NULL,
  `status_paket` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `paket_ambil`
--

INSERT INTO `paket_ambil` (`id_pegawai`, `id_paket`, `status_paket`) VALUES
(22244556, 12300004, 'menunggu Konfirmasi');

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `id` int(8) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`id`, `username`, `password`) VALUES
(22244556, 'pegawai1', 'pegawai1'),
(22244557, 'pegawai2', 'pegawai2'),
(22244558, 'pegawai3', 'pegawai3');

-- --------------------------------------------------------

--
-- Table structure for table `tabel_keluar`
--

CREATE TABLE `tabel_keluar` (
  `id_barang` int(8) NOT NULL,
  `nama_barang` varchar(20) NOT NULL,
  `jumlah_barang` int(10) NOT NULL,
  `harga_barang` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabel_keluar`
--

INSERT INTO `tabel_keluar` (`id_barang`, `nama_barang`, `jumlah_barang`, `harga_barang`) VALUES
(11122234, 'Aha', 20, 7000),
(12345677, 'Pensil', 10, 21000);

-- --------------------------------------------------------

--
-- Table structure for table `tabel_masuk`
--

CREATE TABLE `tabel_masuk` (
  `id_barang` int(8) NOT NULL,
  `nama_barang` varchar(20) NOT NULL,
  `jumlah_barang` int(10) NOT NULL,
  `harga_barang` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabel_masuk`
--

INSERT INTO `tabel_masuk` (`id_barang`, `nama_barang`, `jumlah_barang`, `harga_barang`) VALUES
(11122234, 'Aha', 20, 5000),
(11122235, 'Chip', 10, 10000),
(12345677, 'Pensil', 10, 20000),
(12345678, 'Buku', 5, 10000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `id_paket` (`id_paket`);

--
-- Indexes for table `paket`
--
ALTER TABLE `paket`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `paket_ambil`
--
ALTER TABLE `paket_ambil`
  ADD KEY `id_pegawai` (`id_pegawai`),
  ADD KEY `id_paket` (`id_paket`);

--
-- Indexes for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tabel_keluar`
--
ALTER TABLE `tabel_keluar`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indexes for table `tabel_masuk`
--
ALTER TABLE `tabel_masuk`
  ADD PRIMARY KEY (`id_barang`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `barang`
--
ALTER TABLE `barang`
  ADD CONSTRAINT `barang_ibfk_1` FOREIGN KEY (`id_paket`) REFERENCES `paket` (`id`);

--
-- Constraints for table `paket_ambil`
--
ALTER TABLE `paket_ambil`
  ADD CONSTRAINT `paket_ambil_ibfk_1` FOREIGN KEY (`id_pegawai`) REFERENCES `pegawai` (`id`),
  ADD CONSTRAINT `paket_ambil_ibfk_2` FOREIGN KEY (`id_paket`) REFERENCES `paket` (`id`);

--
-- Constraints for table `tabel_keluar`
--
ALTER TABLE `tabel_keluar`
  ADD CONSTRAINT `tabel_keluar_ibfk_1` FOREIGN KEY (`id_barang`) REFERENCES `tabel_masuk` (`id_barang`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
