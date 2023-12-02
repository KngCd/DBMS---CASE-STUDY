-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 30, 2023 at 12:39 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ticketing_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `conductor_table`
--

CREATE TABLE `conductor_table` (
  `cond_id` int(11) NOT NULL,
  `cond_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `conductor_table`
--

INSERT INTO `conductor_table` (`cond_id`, `cond_name`) VALUES
(1, 'Meliodas'),
(2, 'Ban'),
(3, 'King'),
(4, 'Dianne'),
(5, 'Gowther'),
(6, 'Merlin'),
(7, 'Escanor'),
(8, 'Arthur');

-- --------------------------------------------------------

--
-- Table structure for table `driver_table`
--

CREATE TABLE `driver_table` (
  `driver_id` int(11) NOT NULL,
  `driver_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `driver_table`
--

INSERT INTO `driver_table` (`driver_id`, `driver_name`) VALUES
(1, 'Jonathan'),
(2, 'Joseph'),
(3, 'Jotaro'),
(4, 'Josuke'),
(5, 'Diorno'),
(6, 'Joline'),
(7, 'Johny'),
(8, 'Gapi');

-- --------------------------------------------------------

--
-- Table structure for table `mjeep_table`
--

CREATE TABLE `mjeep_table` (
  `mjeep_no` int(11) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `driver_id` int(11) NOT NULL,
  `cond_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mjeep_table`
--

INSERT INTO `mjeep_table` (`mjeep_no`, `is_active`, `driver_id`, `cond_id`) VALUES
(1, 1, 1, 1),
(2, 1, 2, 2),
(3, 1, 3, 3),
(4, 0, 4, 4),
(5, 1, 5, 5),
(6, 1, 6, 6),
(7, 1, 7, 7),
(8, 1, 8, 8);

-- --------------------------------------------------------

--
-- Table structure for table `passenger_table`
--

CREATE TABLE `passenger_table` (
  `pass_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `spoint` varchar(100) NOT NULL,
  `destination` varchar(100) NOT NULL,
  `promo` varchar(75) NOT NULL,
  `fare` float NOT NULL,
  `date` date NOT NULL,
  `mjeep_no` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `passenger_table`
--

INSERT INTO `passenger_table` (`pass_id`, `name`, `spoint`, `destination`, `promo`, `fare`, `date`, `mjeep_no`) VALUES
(202311243, 'Cedrick', 'Muzon', 'Taal', 'Discounted', 20.8, '2023-11-29', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `conductor_table`
--
ALTER TABLE `conductor_table`
  ADD PRIMARY KEY (`cond_id`);

--
-- Indexes for table `driver_table`
--
ALTER TABLE `driver_table`
  ADD PRIMARY KEY (`driver_id`);

--
-- Indexes for table `mjeep_table`
--
ALTER TABLE `mjeep_table`
  ADD PRIMARY KEY (`mjeep_no`),
  ADD KEY `driver_idfk` (`driver_id`),
  ADD KEY `cond_idfk` (`cond_id`);

--
-- Indexes for table `passenger_table`
--
ALTER TABLE `passenger_table`
  ADD PRIMARY KEY (`pass_id`),
  ADD KEY `mjeep_nofk` (`mjeep_no`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `mjeep_table`
--
ALTER TABLE `mjeep_table`
  ADD CONSTRAINT `cond_idfk` FOREIGN KEY (`cond_id`) REFERENCES `conductor_table` (`cond_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `driver_idfk` FOREIGN KEY (`driver_id`) REFERENCES `driver_table` (`driver_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `passenger_table`
--
ALTER TABLE `passenger_table`
  ADD CONSTRAINT `mjeep_nofk` FOREIGN KEY (`mjeep_no`) REFERENCES `mjeep_table` (`mjeep_no`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
