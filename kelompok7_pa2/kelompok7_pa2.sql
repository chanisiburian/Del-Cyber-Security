-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 07, 2021 at 04:43 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.3.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kelompok7_pa2`
--

-- --------------------------------------------------------

--
-- Table structure for table `about_us`
--

CREATE TABLE `about_us` (
  `id_anggota` int(11) NOT NULL,
  `nama` varchar(10) NOT NULL,
  `deskripsi` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_adm` int(11) NOT NULL,
  `username` varchar(225) NOT NULL,
  `password` varchar(225) NOT NULL,
  `nama` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_adm`, `username`, `password`, `nama`) VALUES
(1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `bem`
--

CREATE TABLE `bem` (
  `id_departemen` int(11) NOT NULL,
  `nama` int(11) NOT NULL,
  `deskripsi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `id` int(11) NOT NULL,
  `nim` varchar(225) NOT NULL,
  `username` varchar(225) NOT NULL,
  `password` varchar(225) NOT NULL,
  `prodi` varchar(225) NOT NULL,
  `angkatan` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`id`, `nim`, `username`, `password`, `prodi`, `angkatan`) VALUES
(1, '11319018', 'andre', '19984dcaea13176bbb694f62ba6b5b35', 'D3 Teknologi Informasi', '2019'),
(2, '11', 'aa', '4124bc0a9335c27f086f24ba207a4912', 'D4 Teknologi Rekayasa Perangkat Lunak', '2020'),
(3, '11319012', 'chani', 'e009f5792375df93a942409ce911a7f5', 'D3 Teknologi Informasi', '2019');

-- --------------------------------------------------------

--
-- Table structure for table `profil_itdel`
--

CREATE TABLE `profil_itdel` (
  `id_profil` int(11) NOT NULL,
  `judul` varchar(10) NOT NULL,
  `deskripsi` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `registrasi`
--

CREATE TABLE `registrasi` (
  `nim` varchar(10) NOT NULL,
  `nama` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `prodi` varchar(10) NOT NULL,
  `angkatan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `registrasi_bem`
--

CREATE TABLE `registrasi_bem` (
  `id_register` int(11) NOT NULL,
  `link_pendaftaran` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registrasi_bem`
--

INSERT INTO `registrasi_bem` (`id_register`, `link_pendaftaran`) VALUES
(1, 'https://docs.google.com/forms/d/e/1FAIpQLSdoeG0I-3FVLzxaa6iT7UPQGFfA6mIV1NQCSdyWp--b7jWx9g/viewform?usp=sf_link');

-- --------------------------------------------------------

--
-- Table structure for table `registrasi_ukm`
--

CREATE TABLE `registrasi_ukm` (
  `id_ukm` int(11) NOT NULL,
  `link_pendaftaran` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registrasi_ukm`
--

INSERT INTO `registrasi_ukm` (`id_ukm`, `link_pendaftaran`) VALUES
(1, 'https://docs.google.com/forms/d/e/1FAIpQLSdoeG0I-3FVLzxaa6iT7UPQGFfA6mIV1NQCSdyWp--b7jWx9g/viewform?usp=sf_link');

-- --------------------------------------------------------

--
-- Table structure for table `tambah_aturan_asrama`
--

CREATE TABLE `tambah_aturan_asrama` (
  `id_aturan` int(11) NOT NULL,
  `judul` varchar(225) NOT NULL,
  `deskripsi` mediumtext NOT NULL,
  `poin` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tambah_aturan_asrama`
--

INSERT INTO `tambah_aturan_asrama` (`id_aturan`, `judul`, `deskripsi`, `poin`) VALUES
(20, 'Aturan', 'Minuman Keras', '20poin'),
(22, 'Aturan', 'Minunan Keras', '50 poin'),
(23, 'Aturan', 'Menyontek', '5 poin'),
(26, 'Aturan', 'Tidur ', '2 poin'),
(35, 'Aturan', 'Menghina Dosen/Staff', '30 poin');

-- --------------------------------------------------------

--
-- Table structure for table `ukm`
--

CREATE TABLE `ukm` (
  `id_ukm` int(11) NOT NULL,
  `nama` varchar(10) NOT NULL,
  `deskripsi` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_adm`);

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `registrasi`
--
ALTER TABLE `registrasi`
  ADD PRIMARY KEY (`nim`);

--
-- Indexes for table `registrasi_bem`
--
ALTER TABLE `registrasi_bem`
  ADD PRIMARY KEY (`id_register`);

--
-- Indexes for table `registrasi_ukm`
--
ALTER TABLE `registrasi_ukm`
  ADD PRIMARY KEY (`id_ukm`);

--
-- Indexes for table `tambah_aturan_asrama`
--
ALTER TABLE `tambah_aturan_asrama`
  ADD PRIMARY KEY (`id_aturan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id_adm` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `registrasi_bem`
--
ALTER TABLE `registrasi_bem`
  MODIFY `id_register` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `registrasi_ukm`
--
ALTER TABLE `registrasi_ukm`
  MODIFY `id_ukm` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tambah_aturan_asrama`
--
ALTER TABLE `tambah_aturan_asrama`
  MODIFY `id_aturan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
