-- MySQL dump 10.13  Distrib 8.0.28, for macos11 (x86_64)
--
-- Host: 127.0.0.1    Database: CollegeAppDB
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `applicantProfiles`
--

DROP TABLE IF EXISTS `applicantProfiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `applicantProfiles` (
  `profileId` int NOT NULL AUTO_INCREMENT,
  `collegeId` int DEFAULT NULL,
  `profileDate` datetime NOT NULL,
  `city` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL,
  `ethnicity` varchar(255) NOT NULL,
  `classOf` int NOT NULL,
  `firstGen` tinyint(1) NOT NULL,
  `legacyStudent` tinyint(1) NOT NULL,
  `gender` int NOT NULL,
  `familyIncome` int NOT NULL,
  `GPA` float NOT NULL,
  `SAT` int NOT NULL,
  `ACT` int NOT NULL,
  `intendedMajor` varchar(255) NOT NULL,
  `extracurriculars` text NOT NULL,
  `advice` text NOT NULL,
  `likes` int NOT NULL,
  `outcome` int NOT NULL,
  `isVerified` tinyint(1) NOT NULL,
  PRIMARY KEY (`profileId`),
  KEY `collegeId` (`collegeId`),
  CONSTRAINT `applicantProfiles_ibfk_1` FOREIGN KEY (`collegeId`) REFERENCES `colleges` (`collegeId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applicantProfiles`
--

LOCK TABLES `applicantProfiles` WRITE;
/*!40000 ALTER TABLE `applicantProfiles` DISABLE KEYS */;
/*!40000 ALTER TABLE `applicantProfiles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-28 20:58:31
