-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: forestmed
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
  `capability_name` varchar(50) NOT NULL,
  `capability_cost` decimal(10,0) NOT NULL,
  `doctors_users_id` bigint NOT NULL,
  PRIMARY KEY (`doctors_users_id`),
  CONSTRAINT `fk_protocols_doctors2` FOREIGN KEY (`doctors_users_id`) REFERENCES `doctors` (`users_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `capabilities`
--

LOCK TABLES `capabilities` WRITE;
/*!40000 ALTER TABLE `capabilities` DISABLE KEYS */;
/*!40000 ALTER TABLE `capabilities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctors`
--

DROP TABLE IF EXISTS `doctors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctors` (
  `category` enum('first','second','high') NOT NULL,
  `experience` enum('one_year','two_years','three_years','four_years','five_years','six_years','seven_years','eight_years','nine_years','ten_years','eleven_years',' twenty_years','thirteen_years','fourteen_years','fifteen_years','sixteen_years','seventeen_years','eighteen_years','nineteen_years','twenty_year','twenty_one_year','twenty_two_years','twenty_three_years','twenty_four_years','twenty_five_years','twenty_six_years','twenty_seven_years','twenty_eight_years','twenty_nine_years','thirty_years') NOT NULL,
  `speciality` enum('therapy','pediatrics','surgery','dentistry','neurology','cardiology','otolaryngology','ophthalmology','gastroenterology','pulmonology','allergology','dermatology','gynecology','urology','oncology','psychiatry','immunology','endocrinology','nephrology','orthopedics','traumatology') NOT NULL,
  `users_id` bigint NOT NULL,
  PRIMARY KEY (`users_id`),
  CONSTRAINT `fk_doctors_users1` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctors`
--

LOCK TABLES `doctors` WRITE;
/*!40000 ALTER TABLE `doctors` DISABLE KEYS */;
INSERT INTO `doctors` VALUES ('second','five_years','therapy',20),('high','ten_years','neurology',21),('first','ten_years','therapy',23),('high','fifteen_years','gastroenterology',24),('first','seven_years','pulmonology',31),('high','eleven_years','psychiatry',36),('first','nine_years','dermatology',37),('second','ten_years','ophthalmology',41),('second','ten_years','pediatrics',43),('high','ten_years','therapy',44);
/*!40000 ALTER TABLE `doctors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patients`
--

DROP TABLE IF EXISTS `patients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patients` (
  `insurance` tinyint(1) NOT NULL,
  `money_account` decimal(10,0) NOT NULL,
  `discount` int NOT NULL,
  `users_id` bigint NOT NULL,
  PRIMARY KEY (`users_id`),
  CONSTRAINT `fk_patients_users` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patients`
--

LOCK TABLES `patients` WRITE;
/*!40000 ALTER TABLE `patients` DISABLE KEYS */;
INSERT INTO `patients` VALUES (1,176,5,18),(0,155,5,19),(1,526,5,27),(0,216,10,28),(1,135,5,29),(0,300,30,30);
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
  `protocol_payer` enum('insurance','patient') DEFAULT NULL,
  `protocol_cost` decimal(10,0) DEFAULT NULL,
  `application` enum('active','approved') DEFAULT 'active',
  `status` enum('duty','paid') DEFAULT 'duty',
  `patients_users_id` bigint NOT NULL,
  `doctors_users_id` bigint NOT NULL,
  PRIMARY KEY (`protocol_id`),
  KEY `fk_protocols_patients1` (`patients_users_id`),
  KEY `fk_protocols_doctors1` (`doctors_users_id`),
  CONSTRAINT `fk_protocols_doctors1` FOREIGN KEY (`doctors_users_id`) REFERENCES `doctors` (`users_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_protocols_patients1` FOREIGN KEY (`patients_users_id`) REFERENCES `patients` (`users_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `protocols`
--

LOCK TABLES `protocols` WRITE;
/*!40000 ALTER TABLE `protocols` DISABLE KEYS */;
INSERT INTO `protocols` VALUES (1,'2021-11-05','patient',NULL,'approved','duty',18,20),(2,'2021-05-12','patient',NULL,'active','duty',29,44),(3,'2021-02-13','patient',NULL,'active','duty',19,31),(4,'2021-02-13','patient',NULL,'active','duty',30,44),(5,'2021-02-14','insurance',NULL,'active','duty',30,20),(6,'2021-03-12','patient',NULL,'active','duty',30,44);
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
  `capabilities_doctors_users_id` bigint NOT NULL,
  PRIMARY KEY (`protocols_protocol_id`,`capabilities_doctors_users_id`),
  KEY `fk_protocols_has_capabilities_capabilities1_idx` (`capabilities_doctors_users_id`),
  KEY `fk_protocols_has_capabilities_protocols1_idx` (`protocols_protocol_id`),
  CONSTRAINT `fk_protocols_has_capabilities_capabilities1` FOREIGN KEY (`capabilities_doctors_users_id`) REFERENCES `capabilities` (`doctors_users_id`),
  CONSTRAINT `fk_protocols_has_capabilities_protocols1` FOREIGN KEY (`protocols_protocol_id`) REFERENCES `protocols` (`protocol_id`) ON DELETE CASCADE ON UPDATE CASCADE
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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role` enum('admin','doctor','patient') NOT NULL,
  `login` varchar(45) NOT NULL,
  `password` varchar(89) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `data_birthday` date NOT NULL,
  `address` varchar(100) NOT NULL,
  `phone_number` varchar(25) NOT NULL,
  `email` varchar(45) NOT NULL,
  `archiv` enum('activ','inactiv') NOT NULL DEFAULT 'activ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','admin_kozich','B1B3773A05C0ED0176787A4F1574FF0075F7521E','Юлия','Кожич','1982-10-11','Лесной 19-12','+375296401528','yalia@gmail.com','activ'),(2,'admin','admin_kaminskaya','20EABE5D64B0E216796E834F52D61FD0B70332FC','Татьяна','Каминская','1987-12-10','Лесной 19-37','+375291723242','kamma@gmail.com','activ'),(4,'admin','vavilova','1c1f7c1943b9f960d15b39bdb05339a4fb19bc5b7696d61962884f167ea7546c','Дарья','Павлова','1996-01-02','Гольшанская 1-45','+375297894152','vavilova@gmail.com','activ'),(18,'patient','pavlova','3cc319cf200173c152b52e7ad9e1128a8c541b961f9434cd4733dfdaeac2c5f4','Анна','Павлова','1987-05-04','Горького 24-1','+375296341278','pavlova@mail.ru','activ'),(19,'patient','kotov','bdc858842c1d955088b4d851a23f4230bb677d6365a357d3f1e28cf8fef2fc7e','Сергей','Котов','1989-02-03','Гинтовта 54-22','+375296341241','kotov.89@mail.ru','activ'),(20,'doctor','verenich','058d9c16e7b2573654778433348aa34cd035478a1bedca2d98b01b6d91658894','Светлана','Веренич','1978-05-06','Селицкого 56-41','+375294127856','verenich78@gmail.com','activ'),(21,'doctor','doroshevich','76d6369dea7aa3ad319feef667ff55defaf2fd86f6c3ae0e9ef3dd42c20e575d','Руслан','Дорошевич','1982-01-08','Руссиянова 12-214','+375294561278','doroshevich@mail.ru','activ'),(23,'doctor','voitkevich','2277c9e137dc5e641223de83063664a7c8e36fc1883c67c17217d12f4d2162db','Иван','Войткевич','1986-04-09','Ложинская 52-13','+375441254789','voitkevich@mail.ru','activ'),(24,'doctor','selyava','b097ae5755dba8e874f6898a9d0e537725adce76378f572bb1adb614339774a6','Владимир','Селява','1975-01-02','Пушкина 25-14','+375447896325','selyava@mail.ru','activ'),(27,'patient','sidorov','6e6ccd85d4ec1491a30438eb7194b4fc819e05c2a71ec47b282171d36650ce2e','Василий','Сидоров','1976-05-04','Гинтовта 54-21','+375296341243','sidorov@mail.ru','activ'),(28,'patient','volkov','868d5270730fb8059ba6fdc317ef1dc42b35845a85a6041f615bc5b0c79efcc7','Петр','Волков','1978-01-07','Водолажского 2-32','+375297841256','volkov@mail.ru','activ'),(29,'patient','losev','aedb2c61b53a4cdcc216bbea8e2aa3509ae142b4d691ab83c21f13f7dc98ad03','Андрей','Лосев','1989-04-03','Скорины 44-31','+375296341144','losev@gmail.ru','activ'),(30,'patient','lopatin','33bb16d431b3ec84f221031a6c30cc29fc7229f6d3f8009dc7dd3b6994b7ee59','Денис','Лопатин','1988-06-07','Стариновская 14-15','+375257412583','lopatin@mail.ru','inactiv'),(31,'doctor','aksenevich','4fa85edfc28c945deee04a7f52511965c3550039abfbd9857e19d3e59dc9f6a5','Ксения','Аксеневич','1992-10-08','Острошицкая 25-12','+375298974123','aksenevich@mail.ru','activ'),(32,'admin','krotova','70c620dd3594206285f989cc2bb4e387edf9033c6d2044b16e0eb342c1c0e7a5','Александра','Кротова','1996-04-09','Гинтовта 12-12','+375259634125','krotova@mail.ru','activ'),(33,'admin','admin_achremenko','3556c97c699aed7c0918844cf800371432978190ddc06ca1afa37b64a620348e','Алена','Ахременко','1988-05-18','Скорины 46-22','+375296341247','acherenko@mail.ru','activ'),(36,'doctor','kozlov','fd3de7d43e1cfb0a89a43321b22b686fb570e4bedd2cc6ffe234f796f2eb1138','Сергей','Козлов','1987-04-15','Гинтовта 54-20','+375294561237','kozlov@mail.ru','activ'),(37,'doctor','petrov','cf13fe2cff28343e661d1ada6a36a7bc04a734ffa5647c8ea767c632032e930a','Андрей','Петров','1987-06-15','Городецкая 12-15','+375259446315','petrov@mail.ru','activ'),(41,'doctor','ivanov','5c00d8a50ce2679c308f5af180b01430282cd6c9df6afd0e7ccc90a2b3955488','Иван','Иванов','1986-03-14','Гинтовта 12-18','+375294561271','ivanov@mail.ru','activ'),(43,'doctor','nesterovich','1925b1e29ef0e90edd13d8562354e89ef3c78edeb1dbd7e18dd300a19cea5820','Антонина','Нестерович','1992-04-13','Городецкая 15-15','+375293022173','nesterovich@mail.ru','activ'),(44,'doctor','kozlova','f78db50ddce7accc6732dd084bed5d0c40fd79212895b46ba3e8d46f3614f5e1','Алла','Козлова','1976-05-12','Карвата 12-18','+375297894512','kozlova@mail.ru','inactiv'),(45,'admin','admin_kachan','0ee595092acef8ec71661c47fec504377fe7b3947aa132da9fb78d692291eae1','Надежда','Качан','1978-05-12','Кирова 12-15','+375297845612','kachan@mail.ru','inactiv');
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

-- Dump completed on 2022-02-15  0:09:23
