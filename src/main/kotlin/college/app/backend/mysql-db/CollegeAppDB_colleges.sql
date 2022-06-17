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
-- Table structure for table `colleges`
--

DROP TABLE IF EXISTS `colleges`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `colleges` (
  `collegeId` int NOT NULL AUTO_INCREMENT,
  `collegeName` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `image` text NOT NULL,
  `acceptanceRate` float NOT NULL,
  `ranking` int NOT NULL,
  PRIMARY KEY (`collegeId`),
  UNIQUE KEY `collegeName` (`collegeName`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colleges`
--

LOCK TABLES `colleges` WRITE;
/*!40000 ALTER TABLE `colleges` DISABLE KEYS */;
INSERT INTO `colleges` VALUES (7,'Princeton University','Princeton, NJ','',6,1),(9,'Columbia University','New York, NY','',6,2),(10,'Harvard University','Cambridge, MA','',5,2),(11,'Massachusetts Institute of Technology','Cambridge, MA','',7,2),(12,'Yale University','New Haven, CT','',7,5),(13,'Stanford University','Stanford, CA','',5,6),(14,'University of Chicago','Chicago, IL','',7,6),(15,'University of Pennsylvania','Philadelphia, PA','',9,8),(16,'California Institute of Technology','Pasadena, CA','',7,9),(17,'Duke University','Durham, NC','',8,9),(18,'Johns Hopkins University','Baltimore, MD','',9,9),(19,'Northwestern University','Evanston, IL','',9,9),(20,'Dartmouth College','Hanover, NH','',9,13),(21,'Brown University','Providence, RI','',8,14),(22,'Vanderbilt University','Nashville, TN','',12,14),(23,'Washington University in St. Louis','St. Louis, MO','',16,14),(24,'Cornell University','Ithaca, NY','',11,17),(25,'Rice University','Houston, TX','',11,17),(26,'University of Notre Dame','Notre Dame, IN','',19,19),(27,'University of California-Los Angeles','Los Angeles, CA','',14,20),(28,'Emory University','Atlanta, GA','',19,21),(29,'University of California-Berkeley','Berkeley, CA','',18,22),(30,'Georgetown University','Washington, DC','',17,23),(31,'University of Michigan','Ann Arbor, MI','',26,23),(32,'Carnegie Mellon University','Pittsburgh, PA','',17,25),(33,'University of Virginia','Charlottesville, VA','',23,25),(34,'University of Southern California','Los Angeles, CA','',16,27),(35,'New York University','New York, NY','',21,28),(36,'Tufts University','Medford, MA','',16,28),(37,'University of California-Santa Barbara','Santa Barbara, CA','',37,28),(38,'University of Florida','Gainesville, FL','',31,28),(39,'University of North Carolina at Chapel Hill','Chapel Hill, NC','',24,28),(40,'Wake Forest University','Winston-Salem, NC','',32,28),(41,'University of California-San Diego','La Jolla, CA','',38,34),(42,'University of Rochester','Rochester, NY','',35,34),(43,'Boston College','Chestnut Hill, MA','',26,36),(44,'University of California-Irvine','Irvine, CA','',30,36),(45,'Georgia Institute of Technology','Atlanta, GA','',21,38),(46,'University of California-Davis','Davis, CA','',46,38),(47,'University of Texas at Austin','Austin, TX','',32,38),(48,'Boston University','Boston, MA','',20,42),(49,'University of Illinois-Urbana-Champaign','Champaign, IL','',63,47),(50,'University of Wisconsin-Madison','Madison, WI','',57,42),(51,'Northeastern University','Boston, MA','',20,49),(52,'Purdue University','West Lafayette, IN','',67,49),(53,'Ohio State University','Columbus, OH','',68,49),(54,'Florida State University','Tallahassee, FL','',32,55),(55,'University of Miami','Coral Gables, FL','',33,55),(56,'Santa Clara University','Santa Clara, CA','',51,55),(57,'Syracuse University','Syracuse, NY','',69,59),(58,'University of Washington','Seattle, WA','',56,59),(59,'University of Maryland','College Park, MD','',49,59),(60,'University of Pittsburgh','Pittsburgh, PA','',64,59),(61,'Gonzaga University','Spokane, WA','',73,79),(62,'University of Oregon','Eugene, OR','',83,99),(63,'University of Arizona','Tucson, AZ','',85,103),(64,'Arizona State University','Tempe, AZ','',88,117),(65,'Seattle University','Seattle, WA','',83,127),(66,'University of Texas at Dallas','Richardson, TX','',79,136),(67,'University of Alabama','Tuscaloosa, AL','',80,148),(68,'Oregon State University','Corvallis, OR','',84,162),(69,'Washington State University','Pullman, WA','',80,179);
/*!40000 ALTER TABLE `colleges` ENABLE KEYS */;
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
