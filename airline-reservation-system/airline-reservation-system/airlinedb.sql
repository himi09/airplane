-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 28, 2019 at 10:16 PM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `airlinedb`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `uname` varchar(11) NOT NULL,
  `pass` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`uname`, `pass`) VALUES
('admin123', 'admin123');

-- --------------------------------------------------------

--
-- Table structure for table `bookflight`
--

CREATE TABLE `bookflight` (
  `flightID` varchar(11) NOT NULL,
  `uname` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bookflight`
--

INSERT INTO `bookflight` (`flightID`, `uname`) VALUES
('F123', 'sakil_khan');

-- --------------------------------------------------------

--
-- Table structure for table `flight`
--

CREATE TABLE `flight` (
  `flightID` varchar(11) NOT NULL,
  `fromf` varchar(20) NOT NULL,
  `tof` varchar(20) NOT NULL,
  `class` varchar(11) NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL,
  `price` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `flight`
--

INSERT INTO `flight` (`flightID`, `fromf`, `tof`, `class`, `date`, `time`, `price`) VALUES
('F100', 'Dhaka', 'Cox\'s Bazar', 'Business', '2019-07-30', '03:00:00', '3700'),
('F123', 'dhaka', 'Rajshahi', 'Business', '2019-07-29', '10:15:00', '3500'),
('F321', 'Rajshahi', 'Dhaka', 'Economy', '2019-07-29', '01:50:00', '3000');

-- --------------------------------------------------------

--
-- Table structure for table `registration`
--

CREATE TABLE `registration` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `uname` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `cnumber` decimal(11,0) NOT NULL,
  `pass` varchar(12) NOT NULL,
  `gender` varchar(11) NOT NULL,
  `bdate` date NOT NULL,
  `address` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registration`
--

INSERT INTO `registration` (`id`, `name`, `uname`, `email`, `cnumber`, `pass`, `gender`, `bdate`, `address`) VALUES
(3, 'Mina', 'mina123', 'mina123@gmail.com', '1122145801', 'mina123', 'female', '2018-10-03', 'Dhaka, Bangladesh'),
(2, 'Raju', 'raju123', 'raju123@gmail.com', '1721214996', 'raju123', 'male', '2018-12-25', 'Bangladesh'),
(1, 'Sakil Khan', 'sakil_khan', 'sakilk130@gmail.com', '1721214996', 'sakil123', 'male', '1997-01-12', 'Dhaka, Bangladesh');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`uname`);

--
-- Indexes for table `flight`
--
ALTER TABLE `flight`
  ADD PRIMARY KEY (`flightID`);

--
-- Indexes for table `registration`
--
ALTER TABLE `registration`
  ADD PRIMARY KEY (`uname`),
  ADD UNIQUE KEY `id` (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `registration`
--
ALTER TABLE `registration`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
