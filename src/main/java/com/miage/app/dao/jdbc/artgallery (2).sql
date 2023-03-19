-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3308
-- Généré le : sam. 18 mars 2023 à 13:49
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  PRIMARY KEY (`idOeuvre`),
  KEY `oeuvre_FK` (`idArtiste`),
  KEY `oeuvre_FK_1` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `idReservation` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `price` double DEFAULT NULL,
  `idUser` int(11) DEFAULT NULL,
  `idExhibition` int(11) NOT NULL,
  PRIMARY KEY (`idReservation`),
  KEY `reservation_FK` (`idUser`),
  KEY `reservation_FK_1` (`idExhibition`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`idUser`, `firstName`, `lastName`, `email`, `password`, `status`) VALUES
(19, 'ghulam', 'meryam', 'meryamghulam@gmail.com', 'Europe123456.', 'proprietaire'),
(20, 'ghulam', 'meryam', 'meryamghulam@gmail.com', 'Europe-123456.', 'proprietaire'),
(21, 'drfg', 'zedrf', 'mer@gmail.com', 'azer', 'proprietaire'),
(22, 'Otto', 'Mark', 'aeed@ggj.cuk', 'Azerty-1zd', 'proprietaire'),
(23, 'Otto', 'Mark', 'dd', 'azer', 'visiteur'),
(24, 'Otto', 'Mark', 'dd', 'azer', 'proprietaire'),
(25, 'Otto', 'Mark', '', '', 'proprietaire'),
(26, 'Otto', 'Mark', 'sesx', 'j', 'proprietaire'),
(27, 'Otto', 'Mark', 'lok', 'jk', 'proprietaire');

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
  ADD CONSTRAINT `oeuvre_FK_1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`);

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
