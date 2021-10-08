# Football

-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: football
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `club`
--

DROP TABLE IF EXISTS `club`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `club` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name_club` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `ward` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `time_start` varchar(255) DEFAULT NULL,
  `time_end` varchar(255) DEFAULT NULL,
  `time_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `club`
--

LOCK TABLES `club` WRITE;
/*!40000 ALTER TABLE `club` DISABLE KEYS */;
INSERT INTO `club` VALUES (1,'Play in','trungnguyen4541@gmail.com','password','116 TCH18','Binh An','Quan 12','Ho Chi Minh','8:00','24:00','2021-10-06 09:43:17'),(2,'Trung Play','trung1009@gmail.com','password','116 TCH18','Binh An','Quan 12','Ho Chi Minh','8:00','24:00','2021-10-08 16:23:10'),(3,'Trung 88','trung100920@gmail.com','password','116 TCH18','Binh An','Quan 1','Ho Chi Minh','08:00','22:00','2021-10-08 16:45:19');
/*!40000 ALTER TABLE `club` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contact` (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_contact` varchar(255) NOT NULL,
  `agree_contact` varchar(255) NOT NULL,
  `state` int DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_state` (`state`),
  KEY `fk_create_mail` (`create_contact`),
  CONSTRAINT `fk_create_mail` FOREIGN KEY (`create_contact`) REFERENCES `player` (`email`),
  CONSTRAINT `fk_state` FOREIGN KEY (`state`) REFERENCES `state_contact` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` VALUES (1,'trung66636@gmail.com','trungnguyen4541@gmail.com',1,'2021-09-19 08:30:33'),(2,'trungnguyen4541@gmail.com','trung@gmail.com',1,'2021-09-19 08:29:47'),(3,'trung@gmail.com','trung66636@gmail.com',1,'2021-09-15 07:48:38'),(4,'trung@gmail.com','trungvip@gmail.com',1,'2021-09-16 05:15:46'),(5,'trungnguyen4541@gmail.com','trungvip@gmail.com',1,'2021-09-19 08:29:47'),(6,'trungvip@gmail.com','trung66636@gmail.com',1,'2021-09-16 09:51:14');
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `match_stt_club`
--

DROP TABLE IF EXISTS `match_stt_club`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `match_stt_club` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_stt_club` int DEFAULT NULL,
  `time_start` varchar(255) DEFAULT NULL,
  `time_end` varchar(255) DEFAULT NULL,
  `list_player` varchar(255) DEFAULT NULL,
  `state` int DEFAULT NULL,
  `time_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `date` varchar(45) DEFAULT NULL,
  `month` varchar(45) DEFAULT NULL,
  `year` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_match_club` (`id_stt_club`),
  CONSTRAINT `fk_match_club` FOREIGN KEY (`id_stt_club`) REFERENCES `stt_club` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `match_stt_club`
--

LOCK TABLES `match_stt_club` WRITE;
/*!40000 ALTER TABLE `match_stt_club` DISABLE KEYS */;
INSERT INTO `match_stt_club` VALUES (1,1,'8:00','10:00','trung66636@gmail.com',1,'2021-10-06 09:46:20','7','10','2021'),(11,1,'6:00','8:00',NULL,NULL,'2021-10-08 08:40:42','8','10','2021'),(12,1,'8:00','10:00',NULL,NULL,'2021-10-08 08:40:42','8','10','2021'),(13,1,'10:00','12:00',NULL,NULL,'2021-10-08 08:40:42','8','10','2021'),(14,1,'12:00','14:00',NULL,NULL,'2021-10-08 08:40:42','8','10','2021'),(15,1,'14:00','16:00',NULL,NULL,'2021-10-08 08:40:42','8','10','2021'),(16,1,'16:00','18:00',NULL,NULL,'2021-10-08 08:40:42','8','10','2021'),(17,1,'18:00','20:00',NULL,NULL,'2021-10-08 08:40:42','8','10','2021'),(18,1,'20:00','22:00',NULL,NULL,'2021-10-08 08:40:42','8','10','2021'),(19,1,'22:00','24:00',NULL,NULL,'2021-10-08 08:40:42','8','10','2021'),(20,2,'6:00','8:00',NULL,NULL,'2021-10-08 08:40:42','8','10','2021'),(21,2,'8:00','10:00',NULL,NULL,'2021-10-08 08:40:42','8','10','2021'),(22,2,'10:00','12:00',NULL,NULL,'2021-10-08 08:40:42','8','10','2021'),(23,2,'12:00','14:00',NULL,NULL,'2021-10-08 08:40:42','8','10','2021'),(24,2,'14:00','16:00',NULL,NULL,'2021-10-08 08:40:42','8','10','2021'),(25,2,'16:00','18:00',NULL,NULL,'2021-10-08 08:40:42','8','10','2021'),(26,2,'18:00','20:00',NULL,NULL,'2021-10-08 08:40:42','8','10','2021'),(27,2,'20:00','22:00',NULL,NULL,'2021-10-08 08:40:42','8','10','2021'),(28,2,'22:00','24:00',NULL,NULL,'2021-10-08 08:40:42','8','10','2021');
/*!40000 ALTER TABLE `match_stt_club` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player`
--

DROP TABLE IF EXISTS `player`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `player` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name_player` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role_player` int DEFAULT NULL,
  `time_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `position` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `district` varchar(45) DEFAULT NULL,
  `ward` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `fk_player_role` (`role_player`),
  CONSTRAINT `fk_player_role` FOREIGN KEY (`role_player`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player`
--

LOCK TABLES `player` WRITE;
/*!40000 ALTER TABLE `player` DISABLE KEYS */;
INSERT INTO `player` VALUES (1,'Nguyen Vanaaa','trungnguyen4541@gmail.com','password',1,'2021-10-04 05:56:33','GK','','','','a'),(2,'NguyenVanTrung','trung66636@gmail.com','password',1,'2021-09-14 03:36:32','GK',NULL,NULL,NULL,NULL),(3,'TrungPro','trung@gmail.com','password',1,'2021-09-14 03:37:10','GK',NULL,NULL,NULL,NULL),(4,'Trung VipPro','trungvip@gmail.com','password',1,'2021-09-18 06:15:02','GK',NULL,NULL,NULL,NULL),(5,'Trung4541','trungpro4541@gmail.com','password',1,'2021-10-06 07:51:08','GK','a','Quan 1','a','Ho Chi Minh');
/*!40000 ALTER TABLE `player` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `time_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin','2021-09-08 06:20:45'),(2,'user','2021-09-08 06:20:45');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state_contact`
--

DROP TABLE IF EXISTS `state_contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `state_contact` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name_state` varchar(45) DEFAULT NULL,
  `time_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state_contact`
--

LOCK TABLES `state_contact` WRITE;
/*!40000 ALTER TABLE `state_contact` DISABLE KEYS */;
INSERT INTO `state_contact` VALUES (1,'wait','2021-09-14 10:37:33'),(2,'enable','2021-09-14 10:37:33'),(3,'unable','2021-09-14 10:37:33'),(4,'block','2021-09-14 10:37:33');
/*!40000 ALTER TABLE `state_contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stt_club`
--

DROP TABLE IF EXISTS `stt_club`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stt_club` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `enable` int DEFAULT NULL,
  `updated_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_club_stt` (`email`),
  CONSTRAINT `fk_club_stt` FOREIGN KEY (`email`) REFERENCES `club` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stt_club`
--

LOCK TABLES `stt_club` WRITE;
/*!40000 ALTER TABLE `stt_club` DISABLE KEYS */;
INSERT INTO `stt_club` VALUES (1,'trungnguyen4541@gmail.com','San 1',1,'2021-10-06 09:54:49'),(2,'trungnguyen4541@gmail.com','aaaa',1,'2021-10-08 06:47:28');
/*!40000 ALTER TABLE `stt_club` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `virtual_match`
--

DROP TABLE IF EXISTS `virtual_match`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `virtual_match` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_match` int DEFAULT NULL,
  `list_player` varchar(255) DEFAULT NULL,
  `updated_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_virtual` (`id_match`),
  CONSTRAINT `fk_virtual` FOREIGN KEY (`id_match`) REFERENCES `match_stt_club` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `virtual_match`
--

LOCK TABLES `virtual_match` WRITE;
/*!40000 ALTER TABLE `virtual_match` DISABLE KEYS */;
INSERT INTO `virtual_match` VALUES (4,1,'trungnguyen4541@gmail.com','2021-10-08 15:40:36');
/*!40000 ALTER TABLE `virtual_match` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-09  0:16:00
