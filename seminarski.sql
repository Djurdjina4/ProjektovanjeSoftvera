-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 01, 2020 at 10:59 PM
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
-- Database: `seminarski`
--

-- --------------------------------------------------------

--
-- Table structure for table `izvrsava`
--

CREATE TABLE `izvrsava` (
  `zahtevID` int(11) NOT NULL,
  `rbStavke` int(11) NOT NULL,
  `zaposleniID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `izvrsava`
--

INSERT INTO `izvrsava` (`zahtevID`, `rbStavke`, `zaposleniID`) VALUES
(1, 1, 1),
(2, 3, 1),
(4, 4, 1),
(5, 6, 2),
(5, 7, 2),
(6, 8, 1),
(6, 9, 2);

-- --------------------------------------------------------

--
-- Table structure for table `klijent`
--

CREATE TABLE `klijent` (
  `klijentID` int(11) NOT NULL,
  `kompanija` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `osoba` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `grad` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `brojTelefona` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `klijent`
--

INSERT INTO `klijent` (`klijentID`, `kompanija`, `osoba`, `grad`, `email`, `brojTelefona`) VALUES
(1, 'Telenor d.o.o.', 'Marko Petrovic', 'Beograd', 'telenor@gmail.com', '+381631231231'),
(2, 'Srbotrade', 'Zika Jovanovic', 'Beograd', 'zika@srbostrade.rs', '+381111231233'),
(3, 'Vip', 'Janko Jankovic', 'Novi Sad', 'janko@gmail.com', '+381631233211'),
(4, 'Fondacija Novak Djokovic', 'Novak Djokovic', 'Beograd', 'ndf@gmail.com', '+38160123456'),
(5, 'Lilly Drogerija', 'Marko Markovic', 'Beograd', 'lilly@gmail.com', '+38160787878778');

-- --------------------------------------------------------

--
-- Table structure for table `stavkazahteva`
--

CREATE TABLE `stavkazahteva` (
  `rbStavke` int(11) NOT NULL,
  `ucestalost` int(11) NOT NULL,
  `uslugaID` int(11) NOT NULL,
  `zahtevID` int(11) NOT NULL,
  `naziv` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `stavkazahteva`
--

INSERT INTO `stavkazahteva` (`rbStavke`, `ucestalost`, `uslugaID`, `zahtevID`, `naziv`) VALUES
(1, 30, 3, 1, 'RTS'),
(3, 10, 3, 2, 'Facebook'),
(4, 7, 3, 4, 'Tik-Tok'),
(5, 10, 2, 4, 'Play radio'),
(6, 30, 1, 5, 'RTS'),
(7, 4, 4, 5, 'Bilbordi na Vozdovcu'),
(8, 15, 3, 6, 'Instagram'),
(9, 15, 3, 6, 'Instagram story');

-- --------------------------------------------------------

--
-- Table structure for table `usluga`
--

CREATE TABLE `usluga` (
  `uslugaID` int(11) NOT NULL,
  `nazivUsluge` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `cena` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `usluga`
--

INSERT INTO `usluga` (`uslugaID`, `nazivUsluge`, `cena`) VALUES
(1, 'reklama na TV-u', 1000),
(2, 'reklama na radiu', 500),
(3, 'reklama na drustvenim mrezama', 200),
(4, 'reklama na bilbordu', 500);

-- --------------------------------------------------------

--
-- Table structure for table `zahtev`
--

CREATE TABLE `zahtev` (
  `zahtevID` int(11) NOT NULL,
  `datumOD` date NOT NULL,
  `datumDO` date NOT NULL,
  `klijentID` int(11) NOT NULL,
  `ukupnaCena` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `zahtev`
--

INSERT INTO `zahtev` (`zahtevID`, `datumOD`, `datumDO`, `klijentID`, `ukupnaCena`) VALUES
(1, '2020-01-01', '2020-01-01', 4, 6000),
(2, '2019-01-11', '2020-01-07', 4, 2000),
(3, '2020-01-01', '2020-01-02', 4, 6600),
(4, '2020-01-02', '2020-01-03', 4, 7000),
(5, '2020-01-01', '2020-01-02', 4, 1000),
(6, '2020-01-01', '2020-01-02', 4, 30000),
(7, '2020-01-12', '2021-01-12', 4, 43000);

-- --------------------------------------------------------

--
-- Table structure for table `zaposleni`
--

CREATE TABLE `zaposleni` (
  `zaposleniID` int(11) NOT NULL,
  `imeZaposlenog` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `prezimeZaposlenog` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `datumRodjenja` date NOT NULL,
  `datumZaposlenja` date NOT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `plata` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `zaposleni`
--

INSERT INTO `zaposleni` (`zaposleniID`, `imeZaposlenog`, `prezimeZaposlenog`, `datumRodjenja`, `datumZaposlenja`, `username`, `password`, `plata`) VALUES
(1, 'Djurdjina', 'Misic', '1997-05-06', '2020-01-01', 'djina', 'djina', 100000),
(2, 'Pera', 'Peric', '1985-02-10', '2020-02-01', 'pera', 'pera', 80000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `izvrsava`
--
ALTER TABLE `izvrsava`
  ADD PRIMARY KEY (`zahtevID`,`rbStavke`,`zaposleniID`),
  ADD KEY `stavka_fk` (`rbStavke`),
  ADD KEY `zaposleni_fk` (`zaposleniID`);

--
-- Indexes for table `klijent`
--
ALTER TABLE `klijent`
  ADD PRIMARY KEY (`klijentID`);

--
-- Indexes for table `stavkazahteva`
--
ALTER TABLE `stavkazahteva`
  ADD PRIMARY KEY (`rbStavke`),
  ADD KEY `usluga_fk` (`uslugaID`),
  ADD KEY `zahtev_fk` (`zahtevID`);

--
-- Indexes for table `usluga`
--
ALTER TABLE `usluga`
  ADD PRIMARY KEY (`uslugaID`);

--
-- Indexes for table `zahtev`
--
ALTER TABLE `zahtev`
  ADD PRIMARY KEY (`zahtevID`),
  ADD KEY `klijent_fk` (`klijentID`);

--
-- Indexes for table `zaposleni`
--
ALTER TABLE `zaposleni`
  ADD PRIMARY KEY (`zaposleniID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `klijent`
--
ALTER TABLE `klijent`
  MODIFY `klijentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT for table `usluga`
--
ALTER TABLE `usluga`
  MODIFY `uslugaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `zahtev`
--
ALTER TABLE `zahtev`
  MODIFY `zahtevID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `zaposleni`
--
ALTER TABLE `zaposleni`
  MODIFY `zaposleniID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `izvrsava`
--
ALTER TABLE `izvrsava`
  ADD CONSTRAINT `stavka_fk` FOREIGN KEY (`rbStavke`) REFERENCES `stavkazahteva` (`rbStavke`) ON DELETE CASCADE,
  ADD CONSTRAINT `zaposleni_fk` FOREIGN KEY (`zaposleniID`) REFERENCES `zaposleni` (`zaposleniID`) ON DELETE CASCADE;

--
-- Constraints for table `stavkazahteva`
--
ALTER TABLE `stavkazahteva`
  ADD CONSTRAINT `usluga_fk` FOREIGN KEY (`uslugaID`) REFERENCES `usluga` (`uslugaID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `zahtev_fk` FOREIGN KEY (`zahtevID`) REFERENCES `zahtev` (`zahtevID`) ON DELETE CASCADE;

--
-- Constraints for table `zahtev`
--
ALTER TABLE `zahtev`
  ADD CONSTRAINT `klijent_fk` FOREIGN KEY (`klijentID`) REFERENCES `klijent` (`klijentID`) ON DELETE CASCADE ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
