CREATE DATABASE  IF NOT EXISTS `news` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `news`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: news
-- ------------------------------------------------------
-- Server version	5.1.45-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `ar_id` int(11) NOT NULL AUTO_INCREMENT,
  `ar_title` varchar(45) NOT NULL,
  `ar_author` varchar(70) DEFAULT NULL,
  `ar_url` varchar(45) DEFAULT NULL,
  `ar_url_to_image` varchar(45) DEFAULT NULL,
  `ar_published_at` datetime DEFAULT NULL,
  `ar_content` text,
  PRIMARY KEY (`ar_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `ro_id` int(11) NOT NULL AUTO_INCREMENT,
  `ro_name` varchar(10) NOT NULL,
  PRIMARY KEY (`ro_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin'),(2,'analyst');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `us_id` int(11) NOT NULL AUTO_INCREMENT,
  `us_name` varchar(70) NOT NULL,
  `us_email` varchar(255) NOT NULL,
  `us_password` varchar(128) NOT NULL,
  `us_blacklist` varchar(10) DEFAULT NULL,
  `us_ro_id` int(11) DEFAULT NULL,
  `us_la_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`us_id`),
  KEY `us_ro_id` (`us_ro_id`),
  KEY `us_la_id` (`us_la_id`),
  CONSTRAINT `us_la_id` FOREIGN KEY (`us_la_id`) REFERENCES `language` (`la_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `us_ro_id` FOREIGN KEY (`us_ro_id`) REFERENCES `role` (`ro_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (3,'Karti','vial@gm.coxfjdjf','12344545',NULL,2,1),(4,'Karti','vial@gm.coxfjf','12344545',NULL,2,2),(5,'admin','admin','1234',NULL,1,1),(6,'fsxgfhfh','gfszdgsxg@gmail.com','sfsznjgnhfh',NULL,2,15),(7,'Rahulkamble','rahulkamble01@gmail.com','kamble01',NULL,2,4),(8,'vishal','vishal@gmail.com','123456',NULL,2,10),(9,'vishal','vishal@gmail.co.in','123456',NULL,2,5),(10,'ghadahf','adcamfk@gmail.com','dsabfudhaf',NULL,2,8),(11,'rahuls','rahul@gmail.com','123456',NULL,2,13),(12,'rahulkumar','rahulkumar@gmail.com','123456',NULL,2,3),(13,'akasher','vamsi@gma.coi','akas123456',NULL,2,NULL),(14,'Vishal Sharma','vishalsharma@b.com','akash1023',NULL,2,NULL),(15,'akashhh','vishalcognizantcom','12345678',NULL,2,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `language`
--

DROP TABLE IF EXISTS `language`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `language` (
  `la_id` int(11) NOT NULL AUTO_INCREMENT,
  `la_code` varchar(2) NOT NULL,
  `la_name` varchar(45) NOT NULL,
  PRIMARY KEY (`la_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `language`
--

LOCK TABLES `language` WRITE;
/*!40000 ALTER TABLE `language` DISABLE KEYS */;
INSERT INTO `language` VALUES (1,'ar','Arabic'),(2,'de','Deutsch'),(3,'ud','Urdu'),(4,'en','English'),(5,'es','Spanish'),(7,'fr','French'),(8,'he','Hebrew'),(9,'it','Italian'),(10,'nl','Dutch'),(11,'no','Norwegian'),(12,'pt','Portuguese'),(13,'ru','Russian'),(14,'se','Northern Sami'),(15,'zh','Mandarin');
/*!40000 ALTER TABLE `language` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favorite_article`
--

DROP TABLE IF EXISTS `favorite_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `favorite_article` (
  `fa_id` int(11) NOT NULL,
  `fa_us_id` int(11) DEFAULT NULL,
  `fa_ar_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`fa_id`),
  KEY `fa_us_id` (`fa_ar_id`),
  KEY `fa_ar_id` (`fa_ar_id`),
  CONSTRAINT `fa_ar_id` FOREIGN KEY (`fa_ar_id`) REFERENCES `article` (`ar_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fa_us_id` FOREIGN KEY (`fa_ar_id`) REFERENCES `user` (`us_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorite_article`
--

LOCK TABLES `favorite_article` WRITE;
/*!40000 ALTER TABLE `favorite_article` DISABLE KEYS */;
/*!40000 ALTER TABLE `favorite_article` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-30 11:07:22
