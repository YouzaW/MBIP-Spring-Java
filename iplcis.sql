-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 07, 2024 at 05:40 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `iplcis`
--

-- --------------------------------------------------------

--
-- Table structure for table `electricityconsumption`
--

CREATE TABLE `electricityconsumption` (
  `id` int(11) NOT NULL,
  `numDay` int(11) NOT NULL,
  `date` date NOT NULL,
  `propFactor` double NOT NULL,
  `billAmount` double NOT NULL,
  `electricityUsage` double NOT NULL,
  `carbonFootprint` double NOT NULL,
  `participant_id` bigint(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `electricityconsumption`
--

INSERT INTO `electricityconsumption` (`id`, `numDay`, `date`, `propFactor`, `billAmount`, `electricityUsage`, `carbonFootprint`, `participant_id`) VALUES
(1, 31, '2000-01-23', 1.03, 200, 300, 175.2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `participant`
--

CREATE TABLE `participant` (
  `id` bigint(19) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `icNum` bigint(19) NOT NULL,
  `phoneNum` int(11) NOT NULL,
  `status` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `category` varchar(255) NOT NULL,
  `accessLevel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `participant`
--

INSERT INTO `participant` (`id`, `email`, `password`, `icNum`, `phoneNum`, `status`, `address`, `category`, `accessLevel`) VALUES
(1, 'bla@graduate.utm.my', 'zhongzhong', 2147483647, 177890000, 'UnStudent', 'no45,', 'A1', 1),
(2, 'tan@gmail.com', '230506050001', 2305, 1234, 'Student', 'edxvsfnvkla;kfjnedkv ,', 'A1', 0),
(3, 'moasef@gmail.com', 'yesplease', 20503650001, 123456789, 'Employed', 'Block C Taman taman', 'A2', 0),
(4, 'yousef@gmail.com', 'zhongzhong', 1234567890, 1234567890, 'Unemployed', 'No28 Bla Taman', 'A1', 0),
(5, 'aaron@gmail.com', '12345', 12345, 12345, 'Student', 'No39 Tamna Taman', 'A1', 0),
(6, 'bla@graduate.utm.my', 'zhongzhong', 2147483647, 177890000, 'Student', 'no45,', 'A1', 0),
(7, 'great@gmail.com', '12345', 20423650049, 123456789, 'Student', 'wow_great_address', 'A2', 0);

-- --------------------------------------------------------

--
-- Table structure for table `recycleconsumption`
--

CREATE TABLE `recycleconsumption` (
  `id` int(11) NOT NULL,
  `numDay` int(11) NOT NULL,
  `date` date NOT NULL,
  `propFactor` double NOT NULL,
  `billAmount` double NOT NULL,
  `recycleUsage` double NOT NULL,
  `carbonFootprint` double NOT NULL,
  `participant_id` bigint(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `recycleconsumption`
--

INSERT INTO `recycleconsumption` (`id`, `numDay`, `date`, `propFactor`, `billAmount`, `recycleUsage`, `carbonFootprint`, `participant_id`) VALUES
(1, 31, '2002-02-20', 1.2, 300, 400, 1144, 1);

-- --------------------------------------------------------

--
-- Table structure for table `waterconsumption`
--

CREATE TABLE `waterconsumption` (
  `id` int(11) NOT NULL,
  `numDay` int(11) NOT NULL,
  `date` date NOT NULL,
  `propFactor` double NOT NULL,
  `billAmount` double NOT NULL,
  `waterUsage` double NOT NULL,
  `carbonFootprint` double NOT NULL,
  `participant_id` bigint(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `waterconsumption`
--

INSERT INTO `waterconsumption` (`id`, `numDay`, `date`, `propFactor`, `billAmount`, `waterUsage`, `carbonFootprint`, `participant_id`) VALUES
(4, 31, '2000-01-23', 1.01, 20, 30, 12.57, 1),
(5, 30, '2023-04-23', 1.01, 13, 17, 7.12, 1),
(6, 31, '2021-08-29', 1.2, 30, 20, 8.38, 1),
(9, 31, '2000-11-23', 1.02, 20, 50, 20.95, 1),
(18, 28, '2022-02-28', 1.02, 15, 20, 8.38, 1),
(19, 30, '2000-01-30', 1.11, 200, 300, 125.7, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `electricityconsumption`
--
ALTER TABLE `electricityconsumption`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cus_id_fk2` (`participant_id`);

--
-- Indexes for table `participant`
--
ALTER TABLE `participant`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `recycleconsumption`
--
ALTER TABLE `recycleconsumption`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cus_id_fk3` (`participant_id`);

--
-- Indexes for table `waterconsumption`
--
ALTER TABLE `waterconsumption`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cus_id_fk` (`participant_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `electricityconsumption`
--
ALTER TABLE `electricityconsumption`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `participant`
--
ALTER TABLE `participant`
  MODIFY `id` bigint(19) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `recycleconsumption`
--
ALTER TABLE `recycleconsumption`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `waterconsumption`
--
ALTER TABLE `waterconsumption`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `electricityconsumption`
--
ALTER TABLE `electricityconsumption`
  ADD CONSTRAINT `cus_id_fk2` FOREIGN KEY (`participant_id`) REFERENCES `participant` (`id`);

--
-- Constraints for table `recycleconsumption`
--
ALTER TABLE `recycleconsumption`
  ADD CONSTRAINT `cus_id_fk3` FOREIGN KEY (`participant_id`) REFERENCES `participant` (`id`);

--
-- Constraints for table `waterconsumption`
--
ALTER TABLE `waterconsumption`
  ADD CONSTRAINT `cus_id_fk` FOREIGN KEY (`participant_id`) REFERENCES `participant` (`id`);
COMMIT;


ALTER TABLE waterconsumption ADD COLUMN file_data LONGBLOB;
ALTER TABLE electricityconsumption ADD COLUMN file_data LONGBLOB;
ALTER TABLE recycleconsumption ADD COLUMN file_data LONGBLOB;


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
