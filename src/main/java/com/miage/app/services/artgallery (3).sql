-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3308
-- Généré le : sam. 15 avr. 2023 à 04:26
-- Version du serveur : 10.6.5-MariaDB
-- Version de PHP : 8.1.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `artgallery`
--

-- --------------------------------------------------------

--
-- Structure de la table `artiste`
--

DROP TABLE IF EXISTS `artiste`;
CREATE TABLE IF NOT EXISTS `artiste` (
  `idArtiste` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `dateNaissance` date DEFAULT NULL,
  `fonction` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idArtiste`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `artiste`
--

INSERT INTO `artiste` (`idArtiste`, `name`, `lastName`, `dateNaissance`, `fonction`) VALUES
(1, NULL, NULL, NULL, NULL),
(2, NULL, NULL, NULL, NULL),
(3, NULL, NULL, NULL, NULL),
(4, NULL, NULL, NULL, NULL),
(5, NULL, NULL, NULL, NULL),
(6, NULL, NULL, NULL, NULL),
(7, NULL, NULL, NULL, NULL),
(8, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `critique`
--

DROP TABLE IF EXISTS `critique`;
CREATE TABLE IF NOT EXISTS `critique` (
  `idCritique` int(11) NOT NULL,
  `commentaire` text DEFAULT NULL,
  `note` int(11) DEFAULT NULL,
  `idOeuvre` int(11) DEFAULT NULL,
  `idUser` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCritique`),
  KEY `critique_FK` (`idOeuvre`),
  KEY `critique_FK_1` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `exhibition`
--

DROP TABLE IF EXISTS `exhibition`;
CREATE TABLE IF NOT EXISTS `exhibition` (
  `idExhibition` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `startDate` datetime DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `place` varchar(100) DEFAULT NULL,
  `maxVisitorNb` int(11) DEFAULT NULL,
  `rooms` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idExhibition`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `exhibition`
--

INSERT INTO `exhibition` (`idExhibition`, `name`, `startDate`, `endDate`, `place`, `maxVisitorNb`, `rooms`) VALUES
(1, 'pali', '2002-12-12 00:00:00', '2004-01-12 00:00:00', 'paris', 44, 'A'),
(2, 'nali', '2024-04-05 00:00:00', NULL, 'london', 454, 'Z'),
(3, 'fari', '2024-04-05 00:00:00', NULL, 'paris', 545, 'D'),
(4, 'poazi', '2023-05-02 00:00:00', NULL, 'Rome', 466, 'D'),
(5, 'coki', '2024-04-05 00:00:00', NULL, 'london', 3, 'F'),
(6, 'mazi', '2023-05-02 00:00:00', NULL, 'paris', 45, 'E'),
(7, 'milo', '2009-12-09 00:00:00', NULL, 'Madrid', 4546, 'A'),
(8, 'nalo', '2024-04-05 00:00:00', NULL, 'london', 56, 'A'),
(9, 'casi', '2002-03-03 00:00:00', NULL, 'paris', 345, 'S'),
(10, 'copsa', '2002-12-12 00:00:00', NULL, 'Rome', 67, 'S'),
(11, 'jana', '2023-05-02 00:00:00', NULL, 'london', 456, 'F'),
(12, 'cera', '2002-03-03 00:00:00', NULL, 'paris', 36, 'F'),
(13, 'neli', '2024-04-05 00:00:00', NULL, 'london', 346, 'Z'),
(14, 'velom', '2023-05-02 00:00:00', NULL, 'Rome', 56, 'A'),
(15, 'pador', '2002-03-03 00:00:00', NULL, 'paris', 653, 'A'),
(16, 'leron', '2009-12-09 00:00:00', NULL, 'Madrid', 56, 'S'),
(17, 'pelora', '2009-12-09 00:00:00', NULL, 'Rome', 56, 'S'),
(18, 'nelioad', '2023-05-02 00:00:00', NULL, 'paris', 356, 'S'),
(19, 'maliope', '2002-12-12 00:00:00', NULL, 'london', 35656, 'D'),
(20, 'meprea', '2024-04-05 00:00:00', NULL, 'paris', 56, 'F'),
(21, 'nao', '2002-12-12 00:00:00', NULL, 'Rome', 56, 'F');

-- --------------------------------------------------------

--
-- Structure de la table `oeuvre`
--

DROP TABLE IF EXISTS `oeuvre`;
CREATE TABLE IF NOT EXISTS `oeuvre` (
  `idOeuvre` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `idArtiste` int(11) DEFAULT NULL,
  `idUser` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `nom_type` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idOeuvre`),
  KEY `oeuvre_FK` (`idArtiste`),
  KEY `oeuvre_FK_1` (`idUser`),
  KEY `oeuvre_FK_2` (`nom_type`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `oeuvre`
--

INSERT INTO `oeuvre` (`idOeuvre`, `title`, `idArtiste`, `idUser`, `price`, `nom_type`) VALUES
(1, 'utopi', 8, 41, 135, 'sculpture'),
(2, 'erali', 7, 41, 8765, 'tableau'),
(3, 'venom', 6, 41, 2433, 'tableau'),
(4, 'veir', 5, 41, 753, 'sculpture'),
(5, 'vilo', 6, 41, 6857, 'photographie'),
(6, 'pilom', 4, 41, 345, 'gravure'),
(7, 'paser', 5, 41, 75, 'sculpture'),
(8, 'hyji', 5, 41, 56757, 'photographie'),
(9, 'teri', 2, 41, 786, 'gravure'),
(10, 'beli', 5, 41, 3456, 'sculpture');

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `idReservation` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `idUser` int(11) DEFAULT NULL,
  `idExhibition` int(11) NOT NULL,
  PRIMARY KEY (`idReservation`),
  KEY `reservation_FK` (`idUser`),
  KEY `reservation_FK_1` (`idExhibition`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`idReservation`, `date`, `idUser`, `idExhibition`) VALUES
(22, NULL, 48, 5);

-- --------------------------------------------------------

--
-- Structure de la table `typeoeuvre`
--

DROP TABLE IF EXISTS `typeoeuvre`;
CREATE TABLE IF NOT EXISTS `typeoeuvre` (
  `nom_type` varchar(100) NOT NULL,
  `caracteristique` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`nom_type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `typeoeuvre`
--

INSERT INTO `typeoeuvre` (`nom_type`, `caracteristique`) VALUES
('gravure', NULL),
('photographie', NULL),
('sculpture', ''),
('tableau', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`idUser`, `firstName`, `lastName`, `email`, `password`, `status`) VALUES
(40, 'Otto', 'Mark', '', '', 'proprietaire'),
(41, ',iij', 'Markijijij', 'af@gmai.com', 'ijij', 'proprietaire'),
(42, ',iij', 'Markijijij', 'af@gmai.com', 'ijij', 'visiteur'),
(44, 'mhbhb', 'hbjb', 'mrm@gmail.com', 'ijij', 'visiteur'),
(45, 'GHULaM', 'Meryam', 'meryamghulam@gmail.com', 'azer', 'visiteur'),
(46, 'aze', 'Markert', 'Jcc@gmai.com', 'xd', 'proprietaire'),
(47, 'gj', 'Markert', 'dcc@gmai.com', 'azer', 'proprietaire'),
(48, 'Otto', 'Mark', 'Jcc@gmai.compo', 'p', 'proprietaire');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `critique`
--
ALTER TABLE `critique`
  ADD CONSTRAINT `critique_FK` FOREIGN KEY (`idOeuvre`) REFERENCES `oeuvre` (`idOeuvre`),
  ADD CONSTRAINT `critique_FK_1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`);

--
-- Contraintes pour la table `oeuvre`
--
ALTER TABLE `oeuvre`
  ADD CONSTRAINT `oeuvre_FK` FOREIGN KEY (`idArtiste`) REFERENCES `artiste` (`idArtiste`),
  ADD CONSTRAINT `oeuvre_FK_1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`),
  ADD CONSTRAINT `oeuvre_FK_2` FOREIGN KEY (`nom_type`) REFERENCES `typeoeuvre` (`nom_type`);

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservation_FK` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`),
  ADD CONSTRAINT `reservation_FK_1` FOREIGN KEY (`idExhibition`) REFERENCES `exhibition` (`idExhibition`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
