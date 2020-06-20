CREATE DATABASE  IF NOT EXISTS `retail_banking` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `retail_banking`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: retail_banking
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `account` (
  `Customer_ID` int DEFAULT NULL,
  `Customer_adhar` int DEFAULT NULL,
  `Account_ID` int NOT NULL,
  `Account_type` varchar(250) DEFAULT NULL,
  `Amount` int DEFAULT NULL,
  `status` varchar(250) DEFAULT NULL,
  `message` varchar(1000) DEFAULT NULL,
  `Last_updated` date DEFAULT NULL,
  `Last_time` time DEFAULT NULL,
  PRIMARY KEY (`Account_ID`),
  foreign key (`Customer_adhar`) references `customer` (`Customer_adhar`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (6052003,523654,1062000,'Current Account',20900,'Active',NULL,'2020-06-16'),(6052003,523654,1062001,'Current Account',324099,'Active',NULL,'2020-06-16'),(6052006,536784,1062002,'Current Account',21700,'Active',NULL,'2020-06-16'),(6052012,58456245,1062003,'Saving Account',199990,'Active',NULL,'2020-06-18'),(6052013,66993998,1062004,'Saving Account',11415,'Active',NULL,'2020-06-18');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
  `Customer_adhar` int NOT NULL,
  `Customer_name` varchar(300) DEFAULT NULL,
  `Age` int DEFAULT NULL,
  `Address` varchar(1000) DEFAULT NULL,
  `City` varchar(250) DEFAULT NULL,
  `State` varchar(200) DEFAULT NULL,
  `Customer_ID` int DEFAULT NULL,
  `Account_ID` int DEFAULT NULL,
  `Account_type` varchar(100) DEFAULT NULL,
  `status` varchar(120) DEFAULT NULL,
  `message` varchar(500) DEFAULT NULL,
  `last_updated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Last_time` time DEFAULT NULL,
  PRIMARY KEY (`Customer_adhar`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1235,'Ash',4,'shdd','Select City','Select State',6052009,1052009,'saving','Active','This user has saving','2020-06-18 01:02:22'),(12351,'fghgjbn',45,'jhhkkk',NULL,NULL,6052011,1052011,'current','Active','This user has current','2020-06-18 01:10:47'),(45685,'Abdg',22,'bvjfflg','BiharSharif','Mumbai',6052007,1052007,'current','Active','This user has current','2020-06-17 17:18:53'),(85645,'Raj',85,'delhi','Delhi','Delhi',6052008,1052008,'current','Active','This user has current','2020-06-17 18:08:47'),(523654,'Anvya',22,'Mumbai','select',NULL,6052003,1052003,'saving','Active','This user has saving','2020-06-13 18:59:18'),(536784,'Ankita',22,'ihar','BiharSharif','Bihar',6052006,1052006,'current','Active','This user has current','2020-06-14 20:56:47'),(3345453,'sDfgbfvcd',23,'32444444444442','BiharSharif',NULL,6052004,1052004,'current','Active','This user has current','2020-06-14 11:41:18'),(5232156,'Aarya',23,'bihar,patna','BiharSharif',NULL,6052001,1052001,'current','Active','This user has current','2020-06-13 12:50:19'),(52012356,'Avni',22,'Thane,Mumbai','select',NULL,6052002,1052002,'saving','Active','This user has saving','2020-06-13 18:48:45'),(52350005,'Ankit',25,'cheran,harnaut,803110','Nalanda',NULL,6052000,1052000,NULL,'Active','This user has null','2020-06-13 12:37:13'),(58456245,'fayfxytz',14,'6872592','Alipur','Andhra Pradesh',6052012,1052012,'current','Active','This user has current','2020-06-18 10:30:19'),(66993998,'kinjarapu sravani',21,'42-800/6','Hyderabad','Telangana',6052013,1052013,'saving','Active','This user has saving','2020-06-18 12:30:36'),(153645215,'abcdefg',21,'male','BiharSharif',NULL,6052005,1052005,NULL,'Active','This user has null','2020-06-14 14:13:09');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `execstore`
--

DROP TABLE IF EXISTS `execstore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `execstore` (
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `execstore`
--

LOCK TABLES `execstore` WRITE;
/*!40000 ALTER TABLE `execstore` DISABLE KEYS */;
INSERT INTO `execstore` VALUES ('admin','TCS123'),('admin2020','Admin@2020');
/*!40000 ALTER TABLE `execstore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `transaction` (
  `TransactionId` int NOT NULL,
  `CustomerId` int DEFAULT NULL,
  `SoureAccountId` int DEFAULT NULL,
  `SourceAccountType` varchar(150) DEFAULT NULL,
  `TargetAccountId` int DEFAULT NULL,
  `TargetAccountType` varchar(150) DEFAULT NULL,
  `TransDesc` varchar(150) DEFAULT NULL,
  `amount` int DEFAULT NULL,
  `Last_updated` date DEFAULT NULL,
  `Last_time` time DEFAULT NULL,
  PRIMARY KEY (`TransactionId`),
   foreign key (`SoureAccountId`) references `account` (`Account_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (10100,6052003,NULL,NULL,NULL,NULL,'Deposit',200,NULL,NULL),(10101,6052003,NULL,NULL,NULL,NULL,'Deposit',200,'2020-06-16',NULL),(10102,6052003,NULL,NULL,NULL,NULL,'Deposit',200,'2020-06-16','07:55:32'),(10103,6052006,NULL,NULL,NULL,NULL,'Deposit',200,'2020-06-16','08:03:43'),(10100,6052006,1062002,'Current Account',1062002,'Current Account','Deposit',200,'2020-06-17','08:07:02'),(10104,6052006,1062002,'Current Account',1062002,'Current Account','Deposit',200,'2020-06-17','08:09:28'),(10105,6052003,1062001,'Current Account',1062001,'Current Account','Withdraw',500,'2020-06-17','11:27:02'),(10106,6052003,1062001,'Current Account',1062001,'Current Account','Deposit',500,'2020-06-17','11:28:32'),(10107,6052003,1062001,'Current Account',1062001,'Current Account','Withdraw',2000,'2020-06-17','11:28:37'),(10108,6052003,1062001,'Current Account',1062001,'Current Account','Deposit',2000,'2020-06-17','11:29:21'),(10109,6052003,1062001,'Current Account',1062001,'Current Account','Withdraw',100,'2020-06-17','11:29:37'),(10110,6052003,1062000,'Current Account',1062000,'Current Account','Deposit',500,'2020-06-17','16:49:02'),(10111,6052003,1062001,'Current Account',1062001,'Current Account','Deposit',500,'2020-06-17','16:50:49'),(10112,6052003,1062000,'Current Account',1062000,'Current Account','Withdraw',300,'2020-06-17','16:58:08'),(10113,6052003,1062000,'Current Account',1062000,'Current Account','Withdraw',300,'2020-06-17','17:00:27'),(10114,6052003,1062000,'Current Account',1062000,'Current Account','Withdraw',300,'2020-06-17','17:01:13'),(10115,6052003,1062000,'Current Account',1062000,'Current Account','Deposit',600,'2020-06-17','17:20:17'),(10116,6052003,1062000,'Current Account',1062000,'Current Account','Withdraw',8000,'2020-06-17','17:20:55'),(10117,6052003,1062000,'Current Account',1062000,'Current Account','Withdraw',500,'2020-06-17','17:25:39'),(10118,6052003,1062000,'Current Account',1062000,'Current Account','Deposit',500,'2020-06-18','09:17:50'),(10119,6052003,1062000,'Current Account',1062000,'Current Account','Deposit',500,'2020-06-18','09:18:56'),(10120,6052003,1062000,'Current Account',1062000,'Current Account','Deposit',500,'2020-06-18','09:19:54'),(10121,6052003,1062000,'Current Account',1062000,'Current Account','Withdraw',500,'2020-06-18','09:22:14'),(10122,6052003,1062000,'Current Account',1062000,'Current Account','Withdraw',500,'2020-06-18','09:24:39'),(10123,6052012,1062003,'Saving Account',1062003,'Saving Account','Withdraw',500,'2020-06-18','10:33:39'),(10124,6052012,1062003,'Saving Account',1062003,'Saving Account','Deposit',485,'2020-06-18','10:46:36'),(10125,6052012,1062003,'Saving Account',1062003,'Saving Account','Deposit',5,'2020-06-18','10:46:44'),(10126,6052013,1062004,'Saving Account',1062004,'Saving Account','Deposit',522,'2020-06-18','12:33:08'),(10127,6052013,1062004,'Saving Account',1062004,'Saving Account','Withdraw',1452,'2020-06-18','12:33:39');
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userstore`
--

DROP TABLE IF EXISTS `userstore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `userstore` (
  `username` varchar(25) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL,
  `last_updated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userstore`
--

LOCK TABLES `userstore` WRITE;
/*!40000 ALTER TABLE `userstore` DISABLE KEYS */;
INSERT INTO `userstore` VALUES ('6052001','5232156','2020-06-13 14:16:30'),('6052001','5232156','2020-06-14 11:44:12'),('6052001','5232156','2020-06-14 14:07:21'),('6052003','523654','2020-06-14 14:17:51');
/*!40000 ALTER TABLE `userstore` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-18 12:47:51
