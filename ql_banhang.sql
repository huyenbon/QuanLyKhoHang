-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 15, 2020 at 05:34 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ql_banhang`
--

-- --------------------------------------------------------

--
-- Table structure for table `ct_don_dat_hang`
--

CREATE TABLE `ct_don_dat_hang` (
  `ma_don_dh` varchar(30) NOT NULL,
  `ma_san_pham` varchar(30) NOT NULL,
  `so_luong_dat` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ct_don_dat_hang`
--

INSERT INTO `ct_don_dat_hang` (`ma_don_dh`, `ma_san_pham`, `so_luong_dat`) VALUES
('dh01', 'sp01', 50),
('dh01', 'sp02', 30);

-- --------------------------------------------------------

--
-- Table structure for table `ct_don_nhap`
--

CREATE TABLE `ct_don_nhap` (
  `ma_don_nhap` varchar(30) NOT NULL,
  `ma_san_pham` varchar(30) NOT NULL,
  `so_luong_nhap` int(11) DEFAULT NULL,
  `don_gia_nhap` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ct_don_nhap`
--

INSERT INTO `ct_don_nhap` (`ma_don_nhap`, `ma_san_pham`, `so_luong_nhap`, `don_gia_nhap`) VALUES
('dh03', 'sp02', 122, 120000);

-- --------------------------------------------------------

--
-- Table structure for table `ct_don_xuat`
--

CREATE TABLE `ct_don_xuat` (
  `ma_don_xuat` varchar(30) NOT NULL,
  `ma_san_pham` varchar(30) NOT NULL,
  `so_luong_xuat` int(11) DEFAULT NULL,
  `don_gia_xuat` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ct_don_xuat`
--

INSERT INTO `ct_don_xuat` (`ma_don_xuat`, `ma_san_pham`, `so_luong_xuat`, `don_gia_xuat`) VALUES
('dx01', 'sp02', 134, 300000);

-- --------------------------------------------------------

--
-- Table structure for table `danh_muc`
--

CREATE TABLE `danh_muc` (
  `ma_danh_muc` varchar(30) NOT NULL,
  `ten_danh_muc` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `danh_muc`
--

INSERT INTO `danh_muc` (`ma_danh_muc`, `ten_danh_muc`) VALUES
('dm01', 'Sản phẩm đông lạnh'),
('dm02', 'Sản phẩm tươi sống'),
('dm03', 'Hoa quả, rau tươi');

-- --------------------------------------------------------

--
-- Table structure for table `don_dat_hang`
--

CREATE TABLE `don_dat_hang` (
  `ma_don_dh` varchar(30) NOT NULL,
  `ngay_dh` date NOT NULL,
  `ma_nha_cc` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `don_dat_hang`
--

INSERT INTO `don_dat_hang` (`ma_don_dh`, `ngay_dh`, `ma_nha_cc`) VALUES
('dh01', '2020-09-04', 'ncc01'),
('dh02', '2020-07-04', 'ncc02');

-- --------------------------------------------------------

--
-- Table structure for table `don_nhap`
--

CREATE TABLE `don_nhap` (
  `ma_don_nhap` varchar(30) NOT NULL,
  `ngay_nhap` date DEFAULT NULL,
  `ma_don_dh` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `don_nhap`
--

INSERT INTO `don_nhap` (`ma_don_nhap`, `ngay_nhap`, `ma_don_dh`) VALUES
('dh03', '2021-03-06', 'dh01'),
('dn01', '2020-05-04', 'dh02');

-- --------------------------------------------------------

--
-- Table structure for table `don_xuat`
--

CREATE TABLE `don_xuat` (
  `ma_don_xuat` varchar(30) NOT NULL,
  `ngay_xuat` date DEFAULT NULL,
  `ma_khach_hang` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `don_xuat`
--

INSERT INTO `don_xuat` (`ma_don_xuat`, `ngay_xuat`, `ma_khach_hang`) VALUES
('dx01', '2020-01-06', 'kh01');

-- --------------------------------------------------------

--
-- Table structure for table `khach_hang`
--

CREATE TABLE `khach_hang` (
  `ma_khach_hang` varchar(30) NOT NULL,
  `ten_khach_hang` varchar(100) DEFAULT NULL,
  `so_dien_thoai` varchar(30) DEFAULT NULL,
  `dia_chi` varchar(100) DEFAULT NULL,
  `CMND` varchar(30) DEFAULT NULL,
  `than_thiet` int(2) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `khach_hang`
--

INSERT INTO `khach_hang` (`ma_khach_hang`, `ten_khach_hang`, `so_dien_thoai`, `dia_chi`, `CMND`, `than_thiet`) VALUES
('kh01', 'Bon ăn cứt', '045645456454', 'Hà Nội	', '0145645645', 1),
('kh02', 'Liên ăn cứt', '0823928932', 'Hà Nội	', '0920392013', 1);

-- --------------------------------------------------------

--
-- Table structure for table `nhan_vien`
--

CREATE TABLE `nhan_vien` (
  `ma_nhan_vien` varchar(30) NOT NULL,
  `ten_nhan_vien` varchar(100) DEFAULT NULL,
  `ngay_sinh` date DEFAULT NULL,
  `dia_chi` varchar(100) DEFAULT NULL,
  `CMND` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nhan_vien`
--

INSERT INTO `nhan_vien` (`ma_nhan_vien`, `ten_nhan_vien`, `ngay_sinh`, `dia_chi`, `CMND`) VALUES
('nv01', 'Nguyễn Thị Huyền', '1998-01-09', 'Hà Nội	', '001098009437');

-- --------------------------------------------------------

--
-- Table structure for table `nha_cung_cap`
--

CREATE TABLE `nha_cung_cap` (
  `ma_nha_cc` varchar(30) NOT NULL,
  `ten_nha_cc` varchar(100) DEFAULT NULL,
  `dia_chi` varchar(100) DEFAULT NULL,
  `so_dien_thoai` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nha_cung_cap`
--

INSERT INTO `nha_cung_cap` (`ma_nha_cc`, `ten_nha_cc`, `dia_chi`, `so_dien_thoai`) VALUES
('ncc01', 'Siêu thị BC', 'Hà Nội', '012644788'),
('ncc02', 'Bách hoá Hà Lan', 'Hồ Chí Minh', '045454545');

-- --------------------------------------------------------

--
-- Table structure for table `san_pham`
--

CREATE TABLE `san_pham` (
  `ma_san_pham` varchar(30) NOT NULL,
  `ten_san_pham` varchar(100) DEFAULT NULL,
  `don_vi_tinh` varchar(30) DEFAULT NULL,
  `don_gia` float DEFAULT NULL,
  `ma_danh_muc` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `san_pham`
--

INSERT INTO `san_pham` (`ma_san_pham`, `ten_san_pham`, `don_vi_tinh`, `don_gia`, `ma_danh_muc`) VALUES
('sp01', 'Cá ngừ đại dương', 'Cái', 120000, 'dm01'),
('sp02', 'Cá hồi tươi sống', 'Kg', 300000, 'dm02');

-- --------------------------------------------------------

--
-- Table structure for table `ton_kho`
--

CREATE TABLE `ton_kho` (
  `ngay_thang` date NOT NULL,
  `ma_san_pham` varchar(30) NOT NULL,
  `so_luong_dau` int(11) DEFAULT NULL COMMENT 'số lượng đầu',
  `tong_so_luong_nhap` int(11) DEFAULT NULL,
  `tong_so_luong_xuat` int(11) DEFAULT NULL,
  `so_luong_cuoi` int(11) DEFAULT NULL COMMENT 'số lượng cuối'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ct_don_dat_hang`
--
ALTER TABLE `ct_don_dat_hang`
  ADD PRIMARY KEY (`ma_don_dh`,`ma_san_pham`),
  ADD KEY `ma_san_pham` (`ma_san_pham`);

--
-- Indexes for table `ct_don_nhap`
--
ALTER TABLE `ct_don_nhap`
  ADD PRIMARY KEY (`ma_don_nhap`,`ma_san_pham`),
  ADD KEY `ma_san_pham` (`ma_san_pham`);

--
-- Indexes for table `ct_don_xuat`
--
ALTER TABLE `ct_don_xuat`
  ADD PRIMARY KEY (`ma_don_xuat`,`ma_san_pham`),
  ADD KEY `ma_san_pham` (`ma_san_pham`);

--
-- Indexes for table `danh_muc`
--
ALTER TABLE `danh_muc`
  ADD PRIMARY KEY (`ma_danh_muc`);

--
-- Indexes for table `don_dat_hang`
--
ALTER TABLE `don_dat_hang`
  ADD PRIMARY KEY (`ma_don_dh`),
  ADD KEY `ma_nha_cc` (`ma_nha_cc`);

--
-- Indexes for table `don_nhap`
--
ALTER TABLE `don_nhap`
  ADD PRIMARY KEY (`ma_don_nhap`),
  ADD KEY `ma_don_dh` (`ma_don_dh`);

--
-- Indexes for table `don_xuat`
--
ALTER TABLE `don_xuat`
  ADD PRIMARY KEY (`ma_don_xuat`);

--
-- Indexes for table `khach_hang`
--
ALTER TABLE `khach_hang`
  ADD PRIMARY KEY (`ma_khach_hang`);

--
-- Indexes for table `nhan_vien`
--
ALTER TABLE `nhan_vien`
  ADD PRIMARY KEY (`ma_nhan_vien`);

--
-- Indexes for table `nha_cung_cap`
--
ALTER TABLE `nha_cung_cap`
  ADD PRIMARY KEY (`ma_nha_cc`);

--
-- Indexes for table `san_pham`
--
ALTER TABLE `san_pham`
  ADD PRIMARY KEY (`ma_san_pham`),
  ADD KEY `ma_danh_muc` (`ma_danh_muc`);

--
-- Indexes for table `ton_kho`
--
ALTER TABLE `ton_kho`
  ADD PRIMARY KEY (`ngay_thang`,`ma_san_pham`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ct_don_dat_hang`
--
ALTER TABLE `ct_don_dat_hang`
  ADD CONSTRAINT `ct_don_dat_hang_ibfk_1` FOREIGN KEY (`ma_don_dh`) REFERENCES `don_dat_hang` (`ma_don_dh`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ct_don_dat_hang_ibfk_2` FOREIGN KEY (`ma_san_pham`) REFERENCES `san_pham` (`ma_san_pham`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ct_don_nhap`
--
ALTER TABLE `ct_don_nhap`
  ADD CONSTRAINT `ct_don_nhap_ibfk_1` FOREIGN KEY (`ma_don_nhap`) REFERENCES `don_nhap` (`ma_don_nhap`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ct_don_nhap_ibfk_2` FOREIGN KEY (`ma_san_pham`) REFERENCES `san_pham` (`ma_san_pham`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ct_don_xuat`
--
ALTER TABLE `ct_don_xuat`
  ADD CONSTRAINT `ct_don_xuat_ibfk_1` FOREIGN KEY (`ma_don_xuat`) REFERENCES `don_xuat` (`ma_don_xuat`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ct_don_xuat_ibfk_2` FOREIGN KEY (`ma_san_pham`) REFERENCES `san_pham` (`ma_san_pham`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `don_dat_hang`
--
ALTER TABLE `don_dat_hang`
  ADD CONSTRAINT `don_dat_hang_ibfk_1` FOREIGN KEY (`ma_nha_cc`) REFERENCES `nha_cung_cap` (`ma_nha_cc`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `don_nhap`
--
ALTER TABLE `don_nhap`
  ADD CONSTRAINT `don_nhap_ibfk_1` FOREIGN KEY (`ma_don_dh`) REFERENCES `don_dat_hang` (`ma_don_dh`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `san_pham`
--
ALTER TABLE `san_pham`
  ADD CONSTRAINT `san_pham_ibfk_1` FOREIGN KEY (`ma_danh_muc`) REFERENCES `danh_muc` (`ma_danh_muc`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
