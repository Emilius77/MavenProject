-- phpMyAdmin SQL Dump
-- version 4.2.12deb2+deb8u2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 28, 2017 at 04:46 PM
-- Server version: 5.5.55-0+deb8u1
-- PHP Version: 5.6.30-0+deb8u1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `Esame`
--

-- --------------------------------------------------------

--
-- Table structure for table `OFFERTE`
--

CREATE TABLE IF NOT EXISTS `OFFERTE` (
`ID_OFFERTA` bigint(20) NOT NULL,
  `IMPORTO` int(11) DEFAULT NULL,
  `PRODOTTO` bigint(20) DEFAULT NULL,
  `UTENTE` bigint(20) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `OFFERTE`
--

INSERT INTO `OFFERTE` (`ID_OFFERTA`, `IMPORTO`, `PRODOTTO`, `UTENTE`) VALUES
(1, 1750, 1, 2),
(2, 2250, 2, 1),
(3, 1800, 3, 5),
(4, 2300, 4, 3),
(5, 3000, 5, 4);

-- --------------------------------------------------------

--
-- Table structure for table `PRODOTTI`
--

CREATE TABLE IF NOT EXISTS `PRODOTTI` (
`ID_PRODOTTO` bigint(20) NOT NULL,
  `DATA_SCADENZA` date DEFAULT NULL,
  `DESCRIZIONE` varchar(255) DEFAULT NULL,
  `IMMAGINE` varchar(255) DEFAULT NULL,
  `NOME` varchar(255) DEFAULT NULL,
  `BASE_ASTA` int(11) DEFAULT NULL,
  `UTENTE_PROPR` bigint(20) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `PRODOTTI`
--

INSERT INTO `PRODOTTI` (`ID_PRODOTTO`, `DATA_SCADENZA`, `DESCRIZIONE`, `IMMAGINE`, `NOME`, `BASE_ASTA`, `UTENTE_PROPR`) VALUES
(1, '2017-06-29', 'DescProdotto1', 'ImgProdotto1', 'NomeProdotto1', 1500, 1),
(2, '2017-06-30', 'DescProdotto2', 'ImgProdotto2', 'NomeProdotto2', 2000, 2),
(3, '2017-06-29', 'DescProdotto3', 'ImgProdotto3', 'NomeProdotto3', 1750, 3),
(4, '2017-06-30', 'DescProdotto4', 'ImgProdotto4', 'NomeProdotto4', 2250, 4),
(5, '2017-07-01', 'DescProdotto5', 'ImgProdotto5', 'NomeProdotto5', 2500, 5);

-- --------------------------------------------------------

--
-- Table structure for table `UTENTI`
--

CREATE TABLE IF NOT EXISTS `UTENTI` (
`ID_UTENTE` bigint(20) NOT NULL,
  `COGNOME` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `NOME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `UTENTI`
--

INSERT INTO `UTENTI` (`ID_UTENTE`, `COGNOME`, `EMAIL`, `NOME`, `PASSWORD`) VALUES
(1, 'Alfieri', 'alf@libero.it', 'Valeria', 'tss2016'),
(2, 'Bellotti', 'bel@tin.it', 'Cinzia', 'tss2016'),
(3, 'Morgeri', 'dig@email.it', 'Giuseppe', 'tss2016'),
(4, 'Bastioni', 'fai@virgilio.it', 'Gianluca', 'tss2016'),
(5, 'Francini', 'fra@libero.it', 'Massimiliano', 'tss2016');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `OFFERTE`
--
ALTER TABLE `OFFERTE`
 ADD PRIMARY KEY (`ID_OFFERTA`), ADD KEY `FK_OFFERTE_PRODOTTO` (`PRODOTTO`), ADD KEY `FK_OFFERTE_UTENTE` (`UTENTE`);

--
-- Indexes for table `PRODOTTI`
--
ALTER TABLE `PRODOTTI`
 ADD PRIMARY KEY (`ID_PRODOTTO`), ADD KEY `FK_PRODOTTI_UTENTE_PROPR` (`UTENTE_PROPR`);

--
-- Indexes for table `UTENTI`
--
ALTER TABLE `UTENTI`
 ADD PRIMARY KEY (`ID_UTENTE`), ADD UNIQUE KEY `EMAIL` (`EMAIL`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `OFFERTE`
--
ALTER TABLE `OFFERTE`
MODIFY `ID_OFFERTA` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `PRODOTTI`
--
ALTER TABLE `PRODOTTI`
MODIFY `ID_PRODOTTO` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `UTENTI`
--
ALTER TABLE `UTENTI`
MODIFY `ID_UTENTE` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `OFFERTE`
--
ALTER TABLE `OFFERTE`
ADD CONSTRAINT `FK_OFFERTE_PRODOTTO` FOREIGN KEY (`PRODOTTO`) REFERENCES `PRODOTTI` (`ID_PRODOTTO`),
ADD CONSTRAINT `FK_OFFERTE_UTENTE` FOREIGN KEY (`UTENTE`) REFERENCES `UTENTI` (`ID_UTENTE`);

--
-- Constraints for table `PRODOTTI`
--
ALTER TABLE `PRODOTTI`
ADD CONSTRAINT `FK_PRODOTTI_UTENTE_PROPR` FOREIGN KEY (`UTENTE_PROPR`) REFERENCES `UTENTI` (`ID_UTENTE`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
