-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 18, 2020 at 09:44 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projek_smartphone`
--

-- --------------------------------------------------------

--
-- Table structure for table `pesanan`
--

CREATE TABLE `pesanan` (
  `id` int(11) NOT NULL,
  `username` varchar(70) NOT NULL,
  `tanggal` varchar(20) NOT NULL,
  `smartphone` varchar(70) NOT NULL,
  `jumlah` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pesanan`
--

INSERT INTO `pesanan` (`id`, `username`, `tanggal`, `smartphone`, `jumlah`) VALUES
(1, 'andra', '2020/05/12 16:03:10', 'iPhone SE', 1),
(2, 'andra', '2020/05/12 16:03:10', 'iPhone SE', 1),
(3, 'andra', '2020/05/12 16:03:10', 'iPhone SE', 1),
(4, 'andra', '2020/05/12 16:03:10', 'iPhone SE', 1),
(5, 'andra', '2020/05/12 16:03:10', 'iPhone SE', 1),
(6, '', '2020/05/12 16:04:51', 'iPhone SE', 2),
(7, '', '2020/05/12 16:05:26', 'iPhone SE', 1),
(8, '', '2020/05/12 16:06:30', 'iPhone SE', 3),
(9, '', '2020/05/12 16:08:27', 'iPhone SE', 3),
(10, '', '2020/05/12 16:10:10', 'iPhone SE', 3),
(11, '', '2020/05/12 16:13:25', 'iPhone SE', 1),
(12, '', '2020/05/12 16:13:55', 'iPhone SE', 1);

-- --------------------------------------------------------

--
-- Table structure for table `smartphone`
--

CREATE TABLE `smartphone` (
  `id` int(11) NOT NULL,
  `nama` varchar(30) DEFAULT NULL,
  `merk` varchar(30) DEFAULT NULL,
  `harga` int(11) DEFAULT NULL,
  `rilis` varchar(12) DEFAULT NULL,
  `layar` varchar(30) DEFAULT NULL,
  `kamera` varchar(50) DEFAULT NULL,
  `os` varchar(20) DEFAULT NULL,
  `cpu` varchar(20) DEFAULT NULL,
  `gpu` varchar(20) DEFAULT NULL,
  `ram` varchar(6) DEFAULT NULL,
  `battery` varchar(9) DEFAULT NULL,
  `stok` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `smartphone`
--

INSERT INTO `smartphone` (`id`, `nama`, `merk`, `harga`, `rilis`, `layar`, `kamera`, `os`, `cpu`, `gpu`, `ram`, `battery`, `stok`) VALUES
(1, 'iPhone SE', 'Apple', 6000000, '2020', 'IPS Full HD', '12 MP', 'iOS 11', 'A13 Bionic', 'Adreno', '2 GB', '1850 mAh', 4);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `nama` varchar(70) NOT NULL,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `nama`, `username`, `password`) VALUES
(1, 'admin', 'admin', 'admin'),
(3, 'andra', 'andra', 'andra'),
(4, 'adr', 'adra', 'adr');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pesanan`
--
ALTER TABLE `pesanan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `smartphone`
--
ALTER TABLE `smartphone`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nama` (`nama`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pesanan`
--
ALTER TABLE `pesanan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `smartphone`
--
ALTER TABLE `smartphone`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
