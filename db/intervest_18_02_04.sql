-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: intervest_hrms
-- ------------------------------------------------------
-- Server version	5.7.10-log

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
-- Table structure for table `applied_leaves`
--

DROP TABLE IF EXISTS `applied_leaves`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `applied_leaves` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `leave_type` int(11) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `fromDate` date DEFAULT NULL,
  `toDate` date DEFAULT NULL,
  `leave_amount` int(11) DEFAULT NULL,
  `reason` text,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='status: pending=1, approved=2, removed=0';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applied_leaves`
--

LOCK TABLES `applied_leaves` WRITE;
/*!40000 ALTER TABLE `applied_leaves` DISABLE KEYS */;
INSERT INTO `applied_leaves` VALUES (1,1,2,'2018-02-01','2018-02-03',1,'Bade amaruwa',2),(2,2,1,'2018-02-15','2018-02-17',1,'svergeg',2),(3,2,2,'2018-02-08','2018-02-09',1,'dvsdvsfve',1),(4,2,2,'2018-02-16','2018-02-16',1,'wrgergege',1);
/*!40000 ALTER TABLE `applied_leaves` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `designations`
--

DROP TABLE IF EXISTS `designations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `designations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `designations`
--

LOCK TABLES `designations` WRITE;
/*!40000 ALTER TABLE `designations` DISABLE KEYS */;
INSERT INTO `designations` VALUES (1,'Software Architect',1),(2,'Technical Lead',1),(3,'Senior Software Engineer',1),(4,'Software Engineer',1),(5,'Associate Software Engineer',1),(6,'Project Manager',1),(7,'Business Analyst',1);
/*!40000 ALTER TABLE `designations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_trainings`
--

DROP TABLE IF EXISTS `employee_trainings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_trainings` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(250) DEFAULT NULL,
  `provider` varchar(100) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `description` text,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_trainings`
--

LOCK TABLES `employee_trainings` WRITE;
/*!40000 ALTER TABLE `employee_trainings` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_trainings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `name_with_initials` varchar(250) DEFAULT NULL,
  `name_in_full` varchar(250) DEFAULT NULL,
  `personal_address` varchar(45) DEFAULT NULL,
  `current_address` varchar(45) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `nic_no` varchar(10) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `contact_no` varchar(20) DEFAULT NULL,
  `heighest_qualifications` varchar(45) DEFAULT NULL,
  `skills_and_specializations` text,
  `years_of_experiance` double DEFAULT NULL,
  `university` text,
  `year_graduated` int(11) DEFAULT NULL,
  `currently_followings` text,
  `date_of_appoinment` date DEFAULT NULL,
  `designation` int(11) DEFAULT NULL,
  `supervisor` int(11) DEFAULT NULL,
  `basic_salary` double DEFAULT NULL,
  `image` varchar(45) DEFAULT NULL,
  `cv` varchar(45) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='personal details, contact details, professional details, education, company details';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Dinesh','Madushanka','S.H.Dinesh Madushanka','S.H.Dinesh Madushanka','Colombo road, Galle','Colombo road, Galle',1,'1990-08-17','901302364v','cl.shdinesh@gmail.com','0712098765','Hora pol Kadeema, Mal kadeema','Batta paneema, pisssu nateema',100,'OUSL ',2017,'Driving, Oracle, EJB','2018-01-30',2,1,120000,'-','-',1),(2,'Hasini','Ravindi','C.K.Hasini Ravindi','C.K.Hasini Ravindi','Galle road, Tangalle','Galle road, Tangalle',2,'1995-04-01','955465354v','hasiniravindi123@gmail.com','0771656545','Hora pol kadeema, Mal Neleema, Butter gama, ','Expert in applying butter on any person.',4,'University of Moratuwa',2018,'Laptop dancing','2018-02-07',6,1,100000,NULL,NULL,2);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entitlement_details`
--

DROP TABLE IF EXISTS `entitlement_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entitlement_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `entitlement_id` int(11) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `leave_type` int(11) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entitlement_details`
--

LOCK TABLES `entitlement_details` WRITE;
/*!40000 ALTER TABLE `entitlement_details` DISABLE KEYS */;
INSERT INTO `entitlement_details` VALUES (1,1,1,1,14,1),(2,1,2,1,14,1),(3,2,1,2,14,1),(4,2,2,2,14,1),(5,3,1,3,7,1),(6,3,2,3,7,1),(7,4,1,4,7,1),(8,4,2,4,7,1);
/*!40000 ALTER TABLE `entitlement_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leave_amount`
--

DROP TABLE IF EXISTS `leave_amount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `leave_amount` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount_name` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leave_amount`
--

LOCK TABLES `leave_amount` WRITE;
/*!40000 ALTER TABLE `leave_amount` DISABLE KEYS */;
INSERT INTO `leave_amount` VALUES (1,'Full Day',1),(2,'Half Day',1);
/*!40000 ALTER TABLE `leave_amount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leave_entitlements`
--

DROP TABLE IF EXISTS `leave_entitlements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `leave_entitlements` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_from` varchar(45) DEFAULT NULL,
  `date_to` varchar(45) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leave_entitlements`
--

LOCK TABLES `leave_entitlements` WRITE;
/*!40000 ALTER TABLE `leave_entitlements` DISABLE KEYS */;
INSERT INTO `leave_entitlements` VALUES (1,'2018-01-01','2018-12-31',1),(2,'2018-01-01','2018-12-31',1),(3,'2018-01-01','2018-12-31',1),(4,'2018-01-01','2018-12-31',1);
/*!40000 ALTER TABLE `leave_entitlements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leave_periods`
--

DROP TABLE IF EXISTS `leave_periods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `leave_periods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_from` date DEFAULT NULL,
  `date_to` date DEFAULT NULL,
  `reason` text,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leave_periods`
--

LOCK TABLES `leave_periods` WRITE;
/*!40000 ALTER TABLE `leave_periods` DISABLE KEYS */;
/*!40000 ALTER TABLE `leave_periods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leave_status`
--

DROP TABLE IF EXISTS `leave_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `leave_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leave_status`
--

LOCK TABLES `leave_status` WRITE;
/*!40000 ALTER TABLE `leave_status` DISABLE KEYS */;
INSERT INTO `leave_status` VALUES (1,'Pending'),(2,'Approved'),(3,'Rejected'),(4,'Deleted');
/*!40000 ALTER TABLE `leave_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leave_types`
--

DROP TABLE IF EXISTS `leave_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `leave_types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `leave_type_name` varchar(200) DEFAULT NULL,
  `description` text,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leave_types`
--

LOCK TABLES `leave_types` WRITE;
/*!40000 ALTER TABLE `leave_types` DISABLE KEYS */;
INSERT INTO `leave_types` VALUES (1,'Annual Leave','Annual Leave',1),(2,'Casual Leave','Casual Leave',1),(3,'Medical Leave','Medical Leave',1),(4,'Duty Leave','Duty Leave',1);
/*!40000 ALTER TABLE `leave_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_holidays`
--

DROP TABLE IF EXISTS `tbl_holidays`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_holidays` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `reason` text,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_holidays`
--

LOCK TABLES `tbl_holidays` WRITE;
/*!40000 ALTER TABLE `tbl_holidays` DISABLE KEYS */;
INSERT INTO `tbl_holidays` VALUES (1,'2018-01-16','vvthryhh',1),(2,'2018-01-17','sdcsf',1),(3,'2018-01-25','Poya Day',1),(4,'2018-01-31','Thaipongal day',1),(5,'2018-02-13','wfrwfref',1);
/*!40000 ALTER TABLE `tbl_holidays` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `training_employees`
--

DROP TABLE IF EXISTS `training_employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `training_employees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `training_id` int(11) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `training_employees`
--

LOCK TABLES `training_employees` WRITE;
/*!40000 ALTER TABLE `training_employees` DISABLE KEYS */;
/*!40000 ALTER TABLE `training_employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'HR Admin','HR Admin',1),(2,'Employee','Employee',1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(200) NOT NULL,
  `type` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'dinesh','$2a$10$yK6u9//zjGXuc0qvvqt9u.3Hnc5BB0PAlm8Q9KDPlkSW6eZsHZSHG',1,1),(2,'hasini','$2a$10$xdqg7BFIxuH9Np6n8fN1deDQPg.3nmGET18WprUJXjySS9poSEFPS',2,1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `variable_deduction`
--

DROP TABLE IF EXISTS `variable_deduction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `variable_deduction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) DEFAULT NULL,
  `amount` decimal(18,2) DEFAULT NULL,
  `mode` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `variable_deduction`
--

LOCK TABLES `variable_deduction` WRITE;
/*!40000 ALTER TABLE `variable_deduction` DISABLE KEYS */;
INSERT INTO `variable_deduction` VALUES (2,'loan',12000.00,'fixed'),(3,'Other',4500.00,'fixed');
/*!40000 ALTER TABLE `variable_deduction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `variable_pay`
--

DROP TABLE IF EXISTS `variable_pay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `variable_pay` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) DEFAULT NULL,
  `Amount` decimal(18,2) DEFAULT NULL,
  `mode` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `variable_pay`
--

LOCK TABLES `variable_pay` WRITE;
/*!40000 ALTER TABLE `variable_pay` DISABLE KEYS */;
INSERT INTO `variable_pay` VALUES (1,'newDes',45000.00,'fixed'),(2,'fuel allowance',30000.00,'variable');
/*!40000 ALTER TABLE `variable_pay` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_week`
--

DROP TABLE IF EXISTS `work_week`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work_week` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `day` varchar(60) DEFAULT NULL,
  `day_id` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_week`
--

LOCK TABLES `work_week` WRITE;
/*!40000 ALTER TABLE `work_week` DISABLE KEYS */;
INSERT INTO `work_week` VALUES (8,'Monday',1,1),(9,'Tuesday',2,1),(10,'Wednesday',3,1),(11,'Thursday',4,1),(12,'Friday',5,1),(13,'Saturday',6,2),(14,'Sunday',7,2);
/*!40000 ALTER TABLE `work_week` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-04 19:40:39
