-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 22, 2019 at 09:08 AM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `k01`
--

-- --------------------------------------------------------

--
-- Table structure for table `allmember`
--

CREATE TABLE `allmember` (
  `memId` varchar(10) NOT NULL,
  `totalMeal` double NOT NULL,
  `month` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `allmember`
--

INSERT INTO `allmember` (`memId`, `totalMeal`, `month`) VALUES
('ar01', 50, 'Jan'),
('es01', 55, 'Jan'),
('tr01', 60, 'Jan');

-- --------------------------------------------------------

--
-- Table structure for table `bazar`
--

CREATE TABLE `bazar` (
  `bName` varchar(20) NOT NULL,
  `amountOfBazar` int(5) NOT NULL,
  `bId` varchar(10) DEFAULT NULL,
  `date` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bazar`
--

INSERT INTO `bazar` (`bName`, `amountOfBazar`, `bId`, `date`) VALUES
('estiyak', 200, 'es01', '01'),
('arif', 300, 'ar01', '02'),
('arif', 200, 'ar01', '03'),
('trishna', 200, 'tr01', '04'),
('trishna', 300, 'tr01', '05'),
('estiyak', 200, 'es01', '06');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `userid` varchar(8) NOT NULL,
  `password` varchar(10) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`userid`, `password`, `status`) VALUES
('ar01', '123456', 1),
('es01', '12345', 0),
('jc1', '12345678', 0),
('tr01', '1234567', 1);

-- --------------------------------------------------------

--
-- Table structure for table `manager`
--

CREATE TABLE `manager` (
  `manId` varchar(8) NOT NULL,
  `mName` varchar(20) NOT NULL,
  `designation` varchar(15) NOT NULL,
  `totalAmmount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `manager`
--

INSERT INTO `manager` (`manId`, `mName`, `designation`, `totalAmmount`) VALUES
('ar01', 'arif', 'Member', 3050),
('es01', 'estiyak', 'Manager', 4000),
('tr01', 'trishna', 'Member', 2800);

-- --------------------------------------------------------

--
-- Table structure for table `showdetails`
--

CREATE TABLE `showdetails` (
  `userid` varchar(100) DEFAULT NULL,
  `amountOfBazar` int(100) DEFAULT NULL,
  `totalMeal` double DEFAULT NULL,
  `totalCost` double DEFAULT NULL,
  `getOrpaid` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `showdetails`
--

INSERT INTO `showdetails` (`userid`, `amountOfBazar`, `totalMeal`, `totalCost`, `getOrpaid`) VALUES
('es01', 200, 55, 0, 0),
('ar01', 200, 50, 3000, 500),
('tr01', 200, 60, 2500, 200);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `allmember`
--
ALTER TABLE `allmember`
  ADD UNIQUE KEY `memId` (`memId`);

--
-- Indexes for table `bazar`
--
ALTER TABLE `bazar`
  ADD UNIQUE KEY `date` (`date`),
  ADD KEY `date_2` (`date`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`userid`,`password`,`status`),
  ADD UNIQUE KEY `userid` (`userid`),
  ADD UNIQUE KEY `password` (`password`),
  ADD UNIQUE KEY `userid_3` (`userid`,`password`,`status`),
  ADD KEY `status` (`status`),
  ADD KEY `userid_2` (`userid`);

--
-- Indexes for table `manager`
--
ALTER TABLE `manager`
  ADD UNIQUE KEY `memId` (`manId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
