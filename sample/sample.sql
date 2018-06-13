-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: sample
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `city_idx_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(125) NOT NULL,
  `address` varchar(250) NOT NULL,
  `cityName` varchar(45) NOT NULL,
  `state` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `company_idx_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (39,'Polaris','kukatpally','Hyd','Telangana'),(40,'FirstSource','jp nagar','Banglore','Karnataka'),(43,'MyApps Solutions','jp nagar','Banglore','Karnataka'),(44,'Capgemini','BTM','Banglore','Karnataka'),(45,'TechMahindra','HitechCity','Hyd','Telangana');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `empName` varchar(45) NOT NULL,
  `joinDate` date NOT NULL,
  `salary` double NOT NULL,
  `emailId` varchar(45) NOT NULL,
  `status` int(1) NOT NULL,
  `cityName` varchar(45) NOT NULL,
  `companyName` varchar(45) NOT NULL,
  `desig` varchar(45) NOT NULL,
  `exp` int(11) NOT NULL,
  `mobileNo` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `employee_idx_email` (`emailId`),
  UNIQUE KEY `mobileNo_UNIQUE` (`mobileNo`),
  UNIQUE KEY `empName_UNIQUE` (`empName`),
  KEY `employee_company_idx` (`companyName`),
  CONSTRAINT `employee_company` FOREIGN KEY (`companyName`) REFERENCES `company` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (50,'chc','aaa','2017-01-11',15000,'aaa@gmail.com',1,'Hyd','Polaris','R&D Engineer',453,'+919263784562'),(51,'ch','venky','2013-01-10',12000,'venky@gmail.com',1,'Banglore','MyApps Solutions','R&D Engineer',1915,'+918885531102'),(53,'chevula','bhanu','2017-02-03',20000,'bhanu.chevula@gmail.com',1,'Hyd','Capgemini','R&D Engineer',479,'+919475874657'),(55,'chevula','kalyani','2016-01-03',25000,'kalyani.chevula@gmail.com',0,'Banglore','Capgemini','R&D Engineer',876,'+919364872988'),(56,'ch','raja','2017-06-03',17000,'raj.ch@gmail.com',0,'Banglore','MyApps Solutions','Software Engineer',359,'+919473892748');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locality`
--

DROP TABLE IF EXISTS `locality`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `locality` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `cityId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `locality_name` (`name`),
  KEY `city_id_idx` (`cityId`),
  CONSTRAINT `city_id` FOREIGN KEY (`cityId`) REFERENCES `city` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locality`
--

LOCK TABLES `locality` WRITE;
/*!40000 ALTER TABLE `locality` DISABLE KEYS */;
/*!40000 ALTER TABLE `locality` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `landmark` varchar(45) NOT NULL,
  `nearBy` varchar(45) NOT NULL,
  `cityId` int(11) NOT NULL,
  `localityId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `locality_id_idx` (`localityId`),
  KEY `city_id_idx` (`cityId`),
  CONSTRAINT `location_city_id` FOREIGN KEY (`cityId`) REFERENCES `city` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `location_locality_id` FOREIGN KEY (`localityId`) REFERENCES `locality` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `state` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_unique` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` VALUES (1,'All'),(2,'Andaman and Nicobar Islands'),(3,'Andhra Pradesh'),(4,'Arunachal Pradesh'),(5,'Assam'),(6,'Bihar'),(7,'Chandigarh'),(8,'Chhattisgarh'),(9,'Dadra and Nagar Haveli'),(10,'Daman and Diu'),(11,'Delhi'),(12,'Goa'),(13,'Gujarat'),(14,'Haryana'),(15,'Himachal Pradesh'),(16,'Jammu and Kashmir'),(17,'Jharkhand'),(18,'Karnataka'),(19,'Kerala'),(20,'Lakshadweep'),(21,'Madhya Pradesh'),(22,'Maharashtra'),(23,'Manipur'),(24,'Meghalaya'),(25,'Mizoram'),(26,'Nagaland'),(27,'Odisha'),(28,'Puducherry'),(29,'Punjab'),(30,'Rajasthan'),(31,'Sikkim'),(32,'Tamil Nadu'),(33,'Telangana'),(34,'Tripura'),(35,'Uttar Pradesh'),(36,'Uttarakhand'),(37,'West Bengal');
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_type`
--

DROP TABLE IF EXISTS `user_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_type` (
  `id` tinyint(1) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_unique` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_type`
--

LOCK TABLES `user_type` WRITE;
/*!40000 ALTER TABLE `user_type` DISABLE KEYS */;
INSERT INTO `user_type` VALUES (1,'Administrator'),(2,'Advisor'),(3,'Consumer'),(4,'Service Provider');
/*!40000 ALTER TABLE `user_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'sample'
--

--
-- Dumping routines for database 'sample'
--
/*!50003 DROP PROCEDURE IF EXISTS `employee_filter` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `employee_filter`(IN v_cityName VARCHAR(120), IN v_companyName VARCHAR(120), IN v_desig VARCHAR(120))
BEGIN

            SET @query = "SELECT e.id, e.firstName, e.empName, e.joinDate, e.salary, e.emailId, e.status, e.cityName, e.companyName, e.desig, e.exp, e.mobileNo
            FROM sample.employee e WHERE e.cityName = 'v_cityName' AND e.companyName = 'v_companyName' AND e.desig = 'v_desig' group by id";

     IF(v_cityName IS NULL)THEN
			SET @query = REPLACE(@query, "v_cityName", "v_cityName");
		ELSE
        SET @query = REPLACE(@query, "v_cityName", "v_cityName");
		END IF;
       IF(v_companyName IS NULL)THEN
            SET @query = REPLACE(@query, 'AND e.companyName = v_companyName AND e.desig = v_desig', '');
        ELSE
            SET @query = REPLACE(@query, "v_companyName",v_companyName);
        END IF;
        IF(v_desig IS NULL)THEN
            SET @query = REPLACE(@query, 'AND e.desig = v_desig','');
            select @query;
        ELSE
            SET @query = REPLACE(@query, "v_desig",v_desig);
        END IF;

        SET @query = REPLACE(@query, "v_cityName", v_cityName);
		SET @query = REPLACE(@query, "v_companyName", v_companyName);
		SET @query = REPLACE(@query, "v_desig", v_desig);


        PREPARE stmt FROM @query;
        EXECUTE stmt;
        END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `emp_exp` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `emp_exp`(IN v_id INT, OUT v_exp INT)
BEGIN

DECLARE v_joinDate DATE;

SELECT joinDate, exp into v_joinDate, v_exp FROM sample.employee where v_id = id;
SET v_exp = DATEDIFF(now(), v_joinDate);

if(v_id != 0) then

update sample.employee e set e.exp =v_exp where v_id = id;
select e.* from sample.employee e where v_id = id;

end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `view_exp` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `view_exp`(IN v_id INT)
BEGIN

SELECT DATE_FORMAT(FROM_DAYS(DATEDIFF(now(), joinDate)), '%Y-%m-%d') AS `exp` From employee e where v_id = e.id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-13 15:54:37
