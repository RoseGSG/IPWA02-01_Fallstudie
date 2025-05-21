-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: require4testing
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Table structure for table `requirement`
--

DROP TABLE IF EXISTS `requirement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `requirement` (
  `ID` bigint NOT NULL,
  `createDate` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requirement`
--

LOCK TABLES `requirement` WRITE;
/*!40000 ALTER TABLE `requirement` DISABLE KEYS */;
INSERT INTO `requirement` VALUES (1,'2025-02-10 01:00:00.000000','Funktioniert der Loginprozess','Anforderung 1'),(2,'2024-12-12 00:00:00.000000','Überprüfen der Pfllichtfelder','Anforderung 2'),(53,'2025-03-16 01:00:00.000000','Integration aller Abteilungen','Anforderung 3'),(502,'2025-05-25 02:00:00.000000','neue Dinge müssen geschehen','Anforderung 4');
/*!40000 ALTER TABLE `requirement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requirement_seq`
--

DROP TABLE IF EXISTS `requirement_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `requirement_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requirement_seq`
--

LOCK TABLES `requirement_seq` WRITE;
/*!40000 ALTER TABLE `requirement_seq` DISABLE KEYS */;
INSERT INTO `requirement_seq` VALUES (601);
/*!40000 ALTER TABLE `requirement_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requirementengineer`
--

DROP TABLE IF EXISTS `requirementengineer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `requirementengineer` (
  `id` bigint NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requirementengineer`
--

LOCK TABLES `requirementengineer` WRITE;
/*!40000 ALTER TABLE `requirementengineer` DISABLE KEYS */;
INSERT INTO `requirementengineer` VALUES (1,'AMUELLER','Anton Müller','anton1'),(2,'AMEIER','Anna Meier','anna2'),(3,'MTHOMAS','Maria Thomas','maria3'),(4,'TSEDLMAIER','Thomas Sedlmaier','thomas4'),(5,'WHERMANN','Walter Hermann','walter5');
/*!40000 ALTER TABLE `requirementengineer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requirementengineer_seq`
--

DROP TABLE IF EXISTS `requirementengineer_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `requirementengineer_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requirementengineer_seq`
--

LOCK TABLES `requirementengineer_seq` WRITE;
/*!40000 ALTER TABLE `requirementengineer_seq` DISABLE KEYS */;
INSERT INTO `requirementengineer_seq` VALUES (1);
/*!40000 ALTER TABLE `requirementengineer_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `testcase`
--

DROP TABLE IF EXISTS `testcase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `testcase` (
  `ID` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `requirement_id` bigint DEFAULT NULL,
  `test_run_id` bigint DEFAULT NULL,
  `tester_id` bigint DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKlnaulj5fl0lalc0q6jwv5p8qr` (`requirement_id`),
  KEY `FK4lnvw51svyhkqy7r9qfjmbq3o` (`test_run_id`),
  KEY `FKlc4kf71jpp7s1s6gropiorkj5` (`tester_id`),
  CONSTRAINT `FK4lnvw51svyhkqy7r9qfjmbq3o` FOREIGN KEY (`test_run_id`) REFERENCES `testrun` (`ID`),
  CONSTRAINT `FKlc4kf71jpp7s1s6gropiorkj5` FOREIGN KEY (`tester_id`) REFERENCES `tester` (`id`),
  CONSTRAINT `FKlnaulj5fl0lalc0q6jwv5p8qr` FOREIGN KEY (`requirement_id`) REFERENCES `requirement` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `testcase`
--

LOCK TABLES `testcase` WRITE;
/*!40000 ALTER TABLE `testcase` DISABLE KEYS */;
INSERT INTO `testcase` VALUES (1,'Überprüfung der Loginfunktion','In Bearbeitung',1,1,4),(2,'Überprüfung der Ausgabewerte','In Bearbeitung',1,3,3),(3,'Überprüfung, ob alle Pflichtfelder gemeldet wurden','Geschlossen',2,2,2),(4,'Überprüfung der Validierung der Pflichtfelder','Offen',2,552,2),(5,'Überprüfung, welche Abteilungen beteiligt sein müssen','In Bearbeitung',53,4,4),(6,'Überprüfung, ob alle Abteilungen berücksichtigt wurden','Offen',53,5,3),(202,'das sollte der Leo dringend testen','offen',1,NULL,3);
/*!40000 ALTER TABLE `testcase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `testcase_seq`
--

DROP TABLE IF EXISTS `testcase_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `testcase_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `testcase_seq`
--

LOCK TABLES `testcase_seq` WRITE;
/*!40000 ALTER TABLE `testcase_seq` DISABLE KEYS */;
INSERT INTO `testcase_seq` VALUES (301);
/*!40000 ALTER TABLE `testcase_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tester`
--

DROP TABLE IF EXISTS `tester`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tester` (
  `id` bigint NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tester`
--

LOCK TABLES `tester` WRITE;
/*!40000 ALTER TABLE `tester` DISABLE KEYS */;
INSERT INTO `tester` VALUES (1,'MMONTAG','Mara Montag','mara10'),(2,'KDAHEIM','Kevin Daheim','kevin11'),(3,'LLUSTIG','Leo Lustig','leo12'),(4,'KBAUER','Karla Bauer','karla13');
/*!40000 ALTER TABLE `tester` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tester_seq`
--

DROP TABLE IF EXISTS `tester_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tester_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tester_seq`
--

LOCK TABLES `tester_seq` WRITE;
/*!40000 ALTER TABLE `tester_seq` DISABLE KEYS */;
INSERT INTO `tester_seq` VALUES (1);
/*!40000 ALTER TABLE `tester_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `testfallersteller`
--

DROP TABLE IF EXISTS `testfallersteller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `testfallersteller` (
  `id` bigint NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `testfallersteller`
--

LOCK TABLES `testfallersteller` WRITE;
/*!40000 ALTER TABLE `testfallersteller` DISABLE KEYS */;
INSERT INTO `testfallersteller` VALUES (1,'ULIEBER','Uschi Lieber','uschi13'),(2,'MMEYER','Melli Meyr','melli14'),(3,'SNEUER','Stefan Neuer','stefan15'),(4,'JBALD','Josef Bald','josef16');
/*!40000 ALTER TABLE `testfallersteller` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `testfallersteller_seq`
--

DROP TABLE IF EXISTS `testfallersteller_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `testfallersteller_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `testfallersteller_seq`
--

LOCK TABLES `testfallersteller_seq` WRITE;
/*!40000 ALTER TABLE `testfallersteller_seq` DISABLE KEYS */;
INSERT INTO `testfallersteller_seq` VALUES (1);
/*!40000 ALTER TABLE `testfallersteller_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `testmanager`
--

DROP TABLE IF EXISTS `testmanager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `testmanager` (
  `id` bigint NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `testmanager`
--

LOCK TABLES `testmanager` WRITE;
/*!40000 ALTER TABLE `testmanager` DISABLE KEYS */;
INSERT INTO `testmanager` VALUES (1,'SGOTHARD','Sven Gothard','sven6'),(2,'MMOND','Mia Mond','mia7'),(3,'TBAUER','Tobi Bauer','tobi8'),(4,'YHAENDL','Yvonne Händl','yvonne9');
/*!40000 ALTER TABLE `testmanager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `testmanager_seq`
--

DROP TABLE IF EXISTS `testmanager_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `testmanager_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `testmanager_seq`
--

LOCK TABLES `testmanager_seq` WRITE;
/*!40000 ALTER TABLE `testmanager_seq` DISABLE KEYS */;
INSERT INTO `testmanager_seq` VALUES (1);
/*!40000 ALTER TABLE `testmanager_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `testrun`
--

DROP TABLE IF EXISTS `testrun`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `testrun` (
  `ID` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `endDate` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `startDate` datetime(6) DEFAULT NULL,
  `main_test_case_id` bigint DEFAULT NULL,
  `testCase_id` bigint DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKfoojlhu52m6ccwtqvsj9rpxpr` (`main_test_case_id`),
  KEY `FK9sj6lx3lppgsfo35xedgr6jie` (`testCase_id`),
  CONSTRAINT `FK9sj6lx3lppgsfo35xedgr6jie` FOREIGN KEY (`testCase_id`) REFERENCES `testcase` (`ID`),
  CONSTRAINT `FKfoojlhu52m6ccwtqvsj9rpxpr` FOREIGN KEY (`main_test_case_id`) REFERENCES `testcase` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `testrun`
--

LOCK TABLES `testrun` WRITE;
/*!40000 ALTER TABLE `testrun` DISABLE KEYS */;
INSERT INTO `testrun` VALUES (1,'Überprüfung, ob der Code korrekt geschrieben wurde','2025-05-12 02:00:00.000000','Codeprüfung','2025-03-03 01:00:00.000000',NULL,NULL),(2,'Überprüfung der Unterlagen bzw. Rückfragen',NULL,'Abfrage Pflichtfelder','2025-03-10 01:00:00.000000',NULL,NULL),(3,'zur Überprüfung, ob die Ausgabe korrekt funktioniert',NULL,'Prüfen und Eingabe von definierten Werten','2025-03-27 01:00:00.000000',NULL,NULL),(4,'Überprüfung, welche Anforderungen erarbeitet wurden und welche Abteilungen dafür benötigt werden',NULL,'Prüfung Anforderungen','2025-04-15 02:00:00.000000',NULL,NULL),(5,'Überprüfung der Unterlagen, ob alle relevanten Abteilungen angerfragt und berücksichtigt wurden','2025-05-20 02:00:00.000000','Prüfung Rückmeldungen Abteilungen','2025-04-23 02:00:00.000000',NULL,NULL),(6,'Prüfung, ob die Validierung der gemeldeten Pflichtfelder funktioniert',NULL,'Prüfung der Validierung','2025-04-06 02:00:00.000000',NULL,NULL),(552,'brauchen wir nicht',NULL,'LAss es drauf ankommen','2025-05-12 02:00:00.000000',NULL,NULL);
/*!40000 ALTER TABLE `testrun` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `testrun_seq`
--

DROP TABLE IF EXISTS `testrun_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `testrun_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `testrun_seq`
--

LOCK TABLES `testrun_seq` WRITE;
/*!40000 ALTER TABLE `testrun_seq` DISABLE KEYS */;
INSERT INTO `testrun_seq` VALUES (651);
/*!40000 ALTER TABLE `testrun_seq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-21  7:13:35
