-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: ds_assignment1
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `device`
--

DROP TABLE IF EXISTS `device`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `device` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk92m2qj36vn62ctp5pgbt4982` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device`
--

LOCK TABLES `device` WRITE;
/*!40000 ALTER TABLE `device` DISABLE KEYS */;
INSERT INTO `device` VALUES (2,'adr2','desc2',1),(3,'adre3','desc3',1);
/*!40000 ALTER TABLE `device` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `device_device_energy_consumption`
--

DROP TABLE IF EXISTS `device_device_energy_consumption`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `device_device_energy_consumption` (
  `device_id` bigint NOT NULL,
  `device_energy_consumption_id` bigint NOT NULL,
  UNIQUE KEY `UK_51leif90hdd9j1cubfil7jhhw` (`device_energy_consumption_id`),
  KEY `FKg7qyqgu97vuifgj1wb8dyp6o8` (`device_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device_device_energy_consumption`
--

LOCK TABLES `device_device_energy_consumption` WRITE;
/*!40000 ALTER TABLE `device_device_energy_consumption` DISABLE KEYS */;
INSERT INTO `device_device_energy_consumption` VALUES (2,6),(3,7),(3,2),(2,1),(2,5),(3,4),(2,8),(3,9);
/*!40000 ALTER TABLE `device_device_energy_consumption` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `device_energy_consumption`
--

DROP TABLE IF EXISTS `device_energy_consumption`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `device_energy_consumption` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `consumption` bigint DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  `device_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6j0ux6o2gjyom69rbpnb2gvy8` (`device_id`)
) ENGINE=MyISAM AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device_energy_consumption`
--

LOCK TABLES `device_energy_consumption` WRITE;
/*!40000 ALTER TABLE `device_energy_consumption` DISABLE KEYS */;
INSERT INTO `device_energy_consumption` VALUES (1,0,'2022-11-02 10:12:23',2),(2,0,'2022-11-02 10:41:13',3),(3,10,'2022-11-02 10:46:31',2),(4,57,'2022-11-02 11:32:54',3),(5,12,'2022-11-02 11:35:14',2),(6,15,'2022-11-02 11:35:22',2),(7,23,'2022-11-02 11:35:33',3),(8,63,'2022-11-02 11:38:02',2),(9,150,'2022-11-03 10:37:16',3),(10,100,'2022-11-03 23:00:32',3),(11,90,'2022-11-03 22:00:57',3),(12,80,'2022-11-03 21:01:19',3),(13,85,'2022-11-03 20:01:45',3),(14,75,'2022-11-03 19:02:03',3),(15,70,'2022-11-03 18:02:03',3),(16,65,'2022-11-03 15:02:03',3),(17,60,'2022-11-03 14:02:03',3),(18,55,'2022-11-03 13:02:03',3),(19,50,'2022-11-03 12:02:03',3),(20,45,'2022-11-03 11:02:03',3),(21,40,'2022-11-03 10:02:03',3),(22,89,'2022-11-03 09:02:03',3),(23,175,'2022-11-03 08:02:03',3),(24,103,'2022-11-03 07:02:03',3),(25,72,'2022-11-03 06:02:03',3),(26,24,'2022-11-03 05:02:03',3),(27,19,'2022-11-03 04:02:03',3),(28,5,'2022-11-03 03:02:03',3),(29,17,'2022-11-03 02:02:03',3),(30,63,'2022-11-03 01:06:50',3),(31,66,'2022-11-03 00:07:13',3);
/*!40000 ALTER TABLE `device_energy_consumption` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ADMIN'),(2,'USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `age` int DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `role_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn82ha3ccdebhokx3a8fgdqeyy` (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,20,'escutea@gmail.ro','$2a$10$/wzHrdvBU6FlGqhzkGxHsucxw1J8JpcKV78YXuFZF1NPvDFclgLKi','emily',2),(2,20,'escutea@gmail.com','$2a$10$drMnqnajXX6VqNazPsy4P.0XEqDWXS2dAkaszAcsUjsCdJAiNDysq','admin1',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_devices`
--

DROP TABLE IF EXISTS `user_devices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_devices` (
  `user_id` bigint NOT NULL,
  `devices_id` bigint NOT NULL,
  UNIQUE KEY `UK_q2nst6ayxw4vb0jtxkpl438fd` (`devices_id`),
  KEY `FK358opnw93qe6qeqxa2u4t493h` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_devices`
--

LOCK TABLES `user_devices` WRITE;
/*!40000 ALTER TABLE `user_devices` DISABLE KEYS */;
INSERT INTO `user_devices` VALUES (1,2),(1,3);
/*!40000 ALTER TABLE `user_devices` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-06 19:23:22
