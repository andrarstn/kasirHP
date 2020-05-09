-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 08, 2020 at 12:24 PM
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
  `nama` varchar(70) NOT NULL,
  `tanggal` varchar(12) NOT NULL,
  `smartphone` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `smartphone`
--

CREATE TABLE `smartphone` (
  `id` int(11) NOT NULL,
  `nama` varchar(30) DEFAULT NULL,
  `merk` varchar(30) DEFAULT NULL,
  `harga` int(11) DEFAULT NULL,
  `rilis` date DEFAULT NULL,
  `layar` varchar(30) DEFAULT NULL,
  `kamera` varchar(50) DEFAULT NULL,
  `os` varchar(20) DEFAULT NULL,
  `cpu` varchar(20) DEFAULT NULL,
  `gpu` varchar(20) DEFAULT NULL,
  `ram` varchar(6) DEFAULT NULL,
  `battery` varchar(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
(2, 'Andra Ristiano 17', 'Andra', 'andra');

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
  ADD PRIMARY KEY (`id`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `smartphone`
--
ALTER TABLE `smartphone`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
