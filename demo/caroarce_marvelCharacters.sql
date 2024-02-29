-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 29, 2024 at 10:32 PM
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
-- Database: `caroarce_marvelCharacters`
--

-- --------------------------------------------------------

--
-- Table structure for table `CHARACTERS`
--

CREATE TABLE `CHARACTERS` (
  `ID` decimal(20,0) NOT NULL,
  `RANKING` decimal(20,0) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `MOVIE` varchar(100) DEFAULT NULL,
  `POWER` varchar(100) DEFAULT NULL,
  `ORIGIN` varchar(100) DEFAULT NULL,
  `KIND` varchar(100) DEFAULT NULL,
  `SPECIES` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `CHARACTERS`
--

INSERT INTO `CHARACTERS` (`ID`, `RANKING`, `NAME`, `MOVIE`, `POWER`, `ORIGIN`, `KIND`, `SPECIES`) VALUES
(1, 1, 'Spider-Man', 'Spider-man', 'Superhuman senses', 'United States', 'Hero', 'Human'),
(2, 2, 'Iron Man', 'Iron Man', 'Super Intelligence', 'United States', 'Hero', 'Human'),
(3, 3, 'Captain America', 'Cap. America the first avenger', 'Superhuman strength', 'United States', 'Hero', 'Human'),
(4, 4, 'Thor', 'Thor', 'Superhuman strength', 'Asgard', 'Hero', 'Asgardian'),
(5, 5, 'Prof. Charles Xavier', 'X-Men', 'Mind control', 'United States', 'Hero', 'Mutant'),
(6, 6, 'Black Widow', 'Iron Man 2', 'Martial artist', 'Russia', 'Hero', 'Human'),
(7, 7, 'Phoenix / Jean Grey', 'X-Men', 'Mind control', 'United States', 'Both', 'Mutant'),
(8, 8, 'Black Panther', 'Cap. America Civil War', 'Superhuman strength', 'Wakanda', 'Hero', 'Human'),
(9, 9, 'Scarlet Witch', 'Cap. America Winter soldier', 'Mind control', 'Sokovia', 'Both', 'Mutant'),
(10, 10, 'Spider-Man Miles Morales', 'Spider-Man Into the Spider-Verse', 'Superhuman senses', 'United States', 'Hero', 'Human'),
(11, 11, 'Ghost Rider', 'Ghost Rider ', 'Hellfire Manipulation', 'United States', 'Anti-hero', 'Hybrid'),
(12, 12, 'Ant-Man', 'Ant-Man', 'Super powerful suit', 'United States', 'Hero', 'Human'),
(13, 13, 'Rocket Raccoon', 'Guardians Of The Galaxy', 'Super Intelligence', 'Planet Halfworld', 'Anti-hero', 'Raccoon'),
(14, 14, 'Groot', 'Guardians Of The Galaxy', 'Regeneration', 'Planet X', 'Hero', 'Coloso Flora'),
(15, 15, 'Star Lord', 'Guardians Of The Galaxy', 'Super powerful suit', 'United States', 'Hero', 'Hybrid'),
(16, 16, 'Silver Surfer', 'Fantastic Four: Rise of the Silver Surfer', 'Flight', 'Zenn-La', 'Both', 'Humanoid'),
(17, 17, 'The Punisher', 'Daredevil', 'Superhuman strenght', 'United States', 'Anti-hero', 'Human'),
(18, 18, 'Vision', 'Avengers Age of Ultron', 'Flight', 'United States', 'Both', 'Android'),
(19, 19, 'Daredevil', '2003 Daredevil', 'Superhuman senses', 'United States', 'Hero', 'Human'),
(20, 20, 'Moon Knight ', 'Moon Knight', 'Superhuman strength', 'United States', 'Hero', 'Human'),
(21, 21, 'Hulk', 'Hulk (2003)', 'Superhuman strength', 'United States', 'Hero', 'Human'),
(22, 22, 'Dr. Strange', 'Doctor Strange', 'Mystical powers', 'United States', 'Hero', 'Human'),
(23, 23, 'Wolverine', 'X-Men', 'Regeneration', 'Canada', 'Anti-hero', 'Mutant'),
(24, 24, 'Deadpool ', 'X-Men Origins Wolverine', 'Regeneration', 'Canada', 'Anti-hero', 'Human (modified)'),
(25, 25, 'Magneto', 'X-Men', 'Control magnetic fields', 'Germany', 'Villain', 'Mutant'),
(26, 26, 'Thanos', 'The Avengers', 'Omnipotent', 'Titan', 'Villain', 'Titanian'),
(27, 27, 'Loki', 'Thor', 'Astral projection', 'Asgard', 'Anti-hero', 'Asgardian'),
(28, 28, 'Hawkeye', 'Thor', 'No Power', 'United States', 'Hero', 'Human'),
(29, 29, 'Captain Marvel', 'Captain Marvel', 'Absorbing energy', 'United States', 'Hero', 'Human'),
(30, 30, 'Shang-Chi', 'Shang-Chi And The Legend Of The Ten Rings', 'Martial artist', 'China', 'Hero', 'Human'),
(31, 31, 'Dr. Octopus', 'Spider-man 2', 'Super Intelligence', 'United States', 'Villain', 'Human'),
(32, 32, 'Daredevil', 'Daredevil', 'Superhuman senses', 'United States', 'Hero', 'Human'),
(33, 33, 'Jessica Jones', 'Jessica Jones', 'Superhuman strength', 'United States', 'Anti-hero', 'Human'),
(34, 34, 'Nick Fury', 'Iron Man', 'No Power', 'United States', 'Hero', 'Human'),
(35, 35, 'Killmonger', 'Black Panther', 'Martial artist', 'Wakanda', 'Villain', 'Human'),
(36, 36, 'Cable', 'Deadpool 2', 'Telepathy', 'United States', 'Villain', 'Mutant'),
(37, 37, 'Peggy Carter', 'Cap. America The first avenger', 'No Power', 'Britain', 'Hero', 'Human'),
(38, 38, 'Winter Soldier', 'Cap. America Winter soldier', 'Superhuman strength', 'United States', 'Hero', 'Human'),
(39, 39, 'Kingpin', 'Daredevil', 'Superhuman strength', 'United States', 'Villain', 'Human'),
(40, 40, 'Drax the Destroyer', 'Guardians Of The Galaxy', 'Superhuman strength', 'United States', 'Hero', 'Human Mutated'),
(41, 41, 'Falcon', 'Cap. America Winter soldier', 'Super powerful suit', 'United States', 'Hero', 'Human'),
(42, 42, 'Gamora', 'Guardians Of The Galaxy', 'Superhuman strength', 'Zen-Whoberian', 'Hero', 'Zen-Whoberi'),
(43, 43, 'Wong', 'Doctor Strange', 'Mystical powers', 'United States', 'Hero', 'Human'),
(44, 44, 'Shuri', 'Black Panther', 'Super Intelligence', 'Wakanda', 'Hero', 'Human'),
(45, 45, 'Nebula', 'Guardians Of The Galaxy', 'Superhuman strength', 'Luphom', 'Anti-hero', 'Luphomoid'),
(46, 46, 'Mystique', 'X-Men', 'Shapeshifter', 'Austria', 'Villain', 'Mutant'),
(47, 47, 'Hela', 'Thor: Ragnarok', 'Astral projection', 'Jotunheim', 'Villain', 'Goddess of the Dead'),
(48, 48, 'Yelena Bolova', 'Black Widow', 'Martial artist', 'Russia', 'Anti-hero', 'Human'),
(49, 49, 'Agent Phil Coulson', 'Iron Man', 'No Power', 'United States', 'Hero', 'Human'),
(50, 50, 'Green Goblin', 'Spider-Man', 'Superhuman strength', 'United States', 'Villain', 'Human');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `CHARACTERS`
--
ALTER TABLE `CHARACTERS`
  ADD PRIMARY KEY (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
