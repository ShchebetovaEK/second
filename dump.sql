-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: clinic
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `capabilities`
--

DROP TABLE IF EXISTS `capabilities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `capabilities` (
  `capability_id` int NOT NULL AUTO_INCREMENT,
  `capability_name` varchar(45) DEFAULT NULL,
  `capability_cost` decimal(10,0) DEFAULT NULL,
  `specialities_id_speciality` bigint NOT NULL,
  PRIMARY KEY (`capability_id`),
  KEY `fk_capabilities_specialities1_idx` (`specialities_id_speciality`),
  CONSTRAINT `fk_capabilities_specialities1` FOREIGN KEY (`specialities_id_speciality`) REFERENCES `specialities` (`speciality_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `capabilities`
--

LOCK TABLES `capabilities` WRITE;
/*!40000 ALTER TABLE `capabilities` DISABLE KEYS */;
INSERT INTO `capabilities` VALUES (1,'consultation',37,0),(2,'recipe',10,0),(3,'description analysis',15,0),(4,'injection',21,0),(5,'vaccination',23,0),(6,'infusion',26,0),(7,'operation',102,0),(8,'X-Ray',27,0),(9,'UltraSound',45,0),(10,'MRI',89,0);
/*!40000 ALTER TABLE `capabilities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctors`
--

DROP TABLE IF EXISTS `doctors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctors` (
  `category` varchar(45) NOT NULL,
  `experience` varchar(15) NOT NULL,
  `users_id` bigint NOT NULL,
  `specialities_id_speciality` bigint NOT NULL,
  PRIMARY KEY (`users_id`,`specialities_id_speciality`),
  KEY `fk_doctors_specialities1_idx` (`specialities_id_speciality`),
  CONSTRAINT `fk_doctors_specialities1` FOREIGN KEY (`specialities_id_speciality`) REFERENCES `specialities` (`speciality_id`),
  CONSTRAINT `fk_doctors_users` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctors`
--

LOCK TABLES `doctors` WRITE;
/*!40000 ALTER TABLE `doctors` DISABLE KEYS */;
INSERT INTO `doctors` VALUES ('first','5 years',104,6),('high','11 years',105,15),('second','5 years',109,2),('first','7 years',110,18);
/*!40000 ALTER TABLE `doctors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patients`
--

DROP TABLE IF EXISTS `patients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patients` (
  `insurance` tinyint NOT NULL,
  `account` decimal(10,0) DEFAULT NULL,
  `users_id` bigint NOT NULL,
  PRIMARY KEY (`users_id`),
  CONSTRAINT `fk_patients_users1` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patients`
--

LOCK TABLES `patients` WRITE;
/*!40000 ALTER TABLE `patients` DISABLE KEYS */;
INSERT INTO `patients` VALUES (1,8999,106),(0,741,107),(1,749,108),(0,325,109);
/*!40000 ALTER TABLE `patients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `protocols`
--

DROP TABLE IF EXISTS `protocols`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `protocols` (
  `protocol_id` bigint NOT NULL AUTO_INCREMENT,
  `protocol_data` date NOT NULL,
  `protocol_payer` varchar(20) NOT NULL,
  `patients_users_id` bigint NOT NULL,
  `doctors_users_id` bigint NOT NULL,
  `protocol_cost` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`protocol_id`,`patients_users_id`,`doctors_users_id`),
  KEY `fk_protocols_patients1_idx` (`patients_users_id`),
  KEY `fk_protocols_doctors1_idx` (`doctors_users_id`),
  CONSTRAINT `fk_protocols_doctors1` FOREIGN KEY (`doctors_users_id`) REFERENCES `doctors` (`users_id`),
  CONSTRAINT `fk_protocols_patients1` FOREIGN KEY (`patients_users_id`) REFERENCES `patients` (`users_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `protocols`
--

LOCK TABLES `protocols` WRITE;
/*!40000 ALTER TABLE `protocols` DISABLE KEYS */;
INSERT INTO `protocols` VALUES (1,'2021-05-12','patient',106,104,NULL),(2,'2021-05-12','patient',107,105,NULL),(3,'2021-05-12','patient',108,110,NULL),(5,'2021-05-12','patient',109,110,NULL);
/*!40000 ALTER TABLE `protocols` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `protocols_has_capabilities`
--

DROP TABLE IF EXISTS `protocols_has_capabilities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `protocols_has_capabilities` (
  `protocols_protocol_id` bigint NOT NULL,
  `capabilities_capability_id` int NOT NULL,
  PRIMARY KEY (`protocols_protocol_id`,`capabilities_capability_id`),
  KEY `fk_protocols_has_capabilities_capabilities1_idx` (`capabilities_capability_id`),
  KEY `fk_protocols_has_capabilities_protocols1_idx` (`protocols_protocol_id`),
  CONSTRAINT `fk_protocols_has_capabilities_capabilities1` FOREIGN KEY (`capabilities_capability_id`) REFERENCES `capabilities` (`capability_id`),
  CONSTRAINT `fk_protocols_has_capabilities_protocols1` FOREIGN KEY (`protocols_protocol_id`) REFERENCES `protocols` (`protocol_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `protocols_has_capabilities`
--

LOCK TABLES `protocols_has_capabilities` WRITE;
/*!40000 ALTER TABLE `protocols_has_capabilities` DISABLE KEYS */;
/*!40000 ALTER TABLE `protocols_has_capabilities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `specialities`
--

DROP TABLE IF EXISTS `specialities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `specialities` (
  `speciality_id` bigint NOT NULL AUTO_INCREMENT,
  `speciality_name` varchar(45) NOT NULL,
  PRIMARY KEY (`speciality_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specialities`
--

LOCK TABLES `specialities` WRITE;
/*!40000 ALTER TABLE `specialities` DISABLE KEYS */;
INSERT INTO `specialities` VALUES (1,'pediatrics'),(2,'therapy'),(3,'surgery'),(4,'otolaryngology'),(5,'ophthalmology'),(6,'urology'),(7,'gynecology'),(8,'orthopedics'),(9,'oncology'),(10,'mammalogy'),(11,'gastroenterology'),(12,'endocrinology'),(13,'pulmonology'),(14,'immunology'),(15,'dermatology'),(16,'neurology'),(17,'cardiology'),(18,'psychiatry');
/*!40000 ALTER TABLE `specialities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role` enum('admin','doctor','patient') NOT NULL,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `data_birthday` date NOT NULL,
  `address` varchar(100) NOT NULL,
  `phone_number` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (102,'admin','kogich','koshich82','Юлия','Кожич','1982-11-10','Лесной 11-33','+375446581214','kogich82@gmail.com'),(103,'admin','kaminskaya','tanysha','Татьяна','Каминская','1989-11-25','Лесной 15-56','+375297894656','kogich82@gmail.com'),(104,'doctor','mars','mars345','Руслан','Дорошевич','1982-07-12','Руссиянова 41-23','+375291452689','doroshevich@mail.ru'),(105,'doctor','venera','veNera','Наталья','Дорошевич','1982-11-02','Руссиянова 41-23','+375449634521','doroshevichN@mail.ru'),(106,'patient','filon','filon92','Никита','Филон','1992-02-12','Стариновская 4-123','+375337967625','filon92@gmail.com'),(107,'patient','selyava','qwerty','Светлана','Селява','1972-12-03','Фогеля 1в -29','+375294561235','selyava@mail.ru'),(108,'patient','pilot','pilot','Павел','Гринцевич','1994-02-11','Острошицкая 23-120','+375298767625','pavelpilot@gmail.com'),(109,'patient','svetik','flour','Светлана','Алексеевич','1983-07-03','Фогеля 1г -223','+375448561235','svetlanaAlecseevich@mail.ru'),(110,'doctor','marina','marina12/12','Марина','Дягелевич','1987-11-12','Логойский тракт 20-25','+375294587635','doсMarina@mail.ru'),(111,'doctor','vanyasha','machine78','Иван','Войткевич','1978-03-02','Притыцкого 81-83','+375337412358','borisich78@mail.ru'),(124,'doctor','metro','metro89','andrei','polelei','1989-11-11','galiza','+375259854171','polelei@mail.ru');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-25  9:05:22
