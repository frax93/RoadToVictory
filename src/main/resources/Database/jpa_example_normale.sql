-- MySQL dump 10.13  Distrib 8.0.13, for macos10.14 (x86_64)
--
-- Host: localhost    Database: jpa_example
-- ------------------------------------------------------
-- Server version	8.0.13

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
-- Table structure for table `normale`
--

DROP TABLE IF EXISTS `normale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `normale` (
  `nome` varchar(45) NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `continente` varchar(45) NOT NULL,
  PRIMARY KEY (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `normale`
--

LOCK TABLES `normale` WRITE;
/*!40000 ALTER TABLE `normale` DISABLE KEYS */;
INSERT INTO `normale` VALUES ('Abuja',9.072264,7.491302000000019,'Africa'),('Addis Ababa',9.005401,38.76361099999997,'Africa'),('Amsterdam',52.3702157,4.895167899999933,'Europa'),('Anatananarivo',-18.9333,47.516700000000014,'Africa'),('Ansuncion',-25.30066,-57.63590999999997,'Sud_America'),('Ashgabat',37.95,58.38333,'Asia'),('Astana',51.1801,71.44597999999996,'Asia'),('Athens',37.9838096,23.727538800000048,'Europa'),('Baghdad',33.312805,44.36148800000001,'Asia'),('Baku',40.409264,49.86709199999996,'Asia'),('Bamako',12.65,-8,'Africa'),('Bangkok',13.736717,100.52318600000001,'Asia'),('Beijing',39.913818,116.36362499999996,'Asia'),('Berlin',52.52000659999999,13.404953999999975,'Europa'),('Bogota',4.624335,-74.06364400000001,'Sud_America'),('Boise City',43.6187102,-116.21460680000001,'USA'),('Boston',42.3600825,-71.05888010000001,'USA'),('Brasilia',-15.77972,-47.929719999999975,'Sud_America'),('Brussels',50.8503463,4.351721099999963,'Europa'),('Buenos Aires',-34.603722,-58.38159200000001,'Sud_America'),('Cairo',30.044281,31.340002000000027,'Africa'),('Caracas',10.5,-66.91666399999997,'Sud_America'),('Cayenne',4.93333,-52.33333099999999,'Sud_America'),('Chengdu',30.66667,104.06666999999993,'Asia'),('Chicago',41.8781136,-87.62979819999998,'USA'),('Colombo',6.927079,79.86124399999994,'Asia'),('Dakar',14.6937,-17.444060000000036,'Africa'),('Denver',39.7392358,-104.990251,'USA'),('Detroit',42.331427,-83.0457538,'USA'),('Dhaka',23.777176,90.399452,'Asia'),('Dodoma',-6.161184,35.74542599999995,'Africa'),('Dublin',53.3498053,-6.260309699999993,'Europa'),('Georgetown',6.80448,-58.15526999999997,'Sud_America'),('Harare',-17.824858,31.05302800000004,'Africa'),('Houston',29.7604267,-95.3698028,'USA'),('Jacksonville',30.3321838,-81.65565099999998,'USA'),('Jakarta',-6.21462,106.84512999999993,'Asia'),('Johannesburg',-26.195246,28.034087999999997,'Africa'),('Kabul',34.543896,69.16065200000003,'Asia'),('Kampala',0.347596,32.58251999999993,'Africa'),('Kananga',-5.89624,22.416590000000042,'Africa'),('Khartoum',15.564836,32.52983100000006,'Africa'),('Kiev',50.4501,30.523400000000038,'Europa'),('Kinshasa',-4.322447,15.307045000000016,'Africa'),('Koupa',36.726017,3.082667000000015,'Africa'),('La Paz',-16.5,-68.14999999999998,'Sud_America'),('Libreville',0.3901,9.454399999999964,'Africa'),('Lima',-12.046374,-77.04279300000002,'Sud_America'),('Lisbon',38.7222524,-9.139336599999979,'Europa'),('London',51.5073509,-0.12775829999998223,'Europa'),('Los Angeles',34.0522342,-118.2436849,'USA'),('Madrid',40.4167754,-3.7037901999999576,'Europa'),('Manila',14.599512,120.98422200000005,'Asia'),('Maputo',-25.953724,32.58871099999999,'Africa'),('Marrakesh',31.669746,-7.973328000000038,'Africa'),('Mecca',21.42251,39.82616800000005,'Asia'),('Menphis',35.1495343,-90.0489801,'USA'),('Miami',25.7616798,-80.19179020000001,'USA'),('Milan',45.4642035,9.189981999999986,'Europa'),('Minneapolis',44.977753,-93.26501080000003,'USA'),('Minot',48.2329668,-101.2922906,'USA'),('Minsk',53.90453979999999,27.561524400000053,'Europa'),('Mogadishu',2.046934,45.31816100000003,'Africa'),('Montevideo',-34.901112,-56.16453200000001,'Sud_America'),('Montgomery',32.3668052,-86.29996890000001,'USA'),('Muscat',23.614328,58.54528400000004,'Asia'),('Nairobi',-1.28333,36.81666999999993,'Africa'),('New Delhi',28.6448,77.216721,'Asia'),('New York',40.7127837,-74.00594130000002,'USA'),('Oklahoma City',35.4675602,-97.51642759999999,'USA'),('Oslo',59.9138688,10.752245399999993,'Europa'),('Panama',8.983333,-79.51666999999998,'Sud_America'),('Paris',48.856614,2.3522219000000177,'Europa'),('Phoenix',33.4483771,-112.07403729999999,'USA'),('Quito',-0.180653,-78.46783399999998,'Sud_America'),('Riga',56.9496487,24.105186499999945,'Europa'),('Rio Branco',-9.97472,-67.81,'Sud_America'),('Rio de Janeiro',-22.911,-43.20940000000002,'Sud_America'),('Rio Gallegos',-51.62261,-69.21812999999997,'Sud_America'),('Rome',41.9027835,12.496365500000024,'Europa'),('San Francisco',37.7749295,-122.41941550000001,'USA'),('San Jose',9.934739,-84.08750199999997,'Sud_America'),('Santiago',-33.447487,-70.673676,'Sud_America'),('Seattle',47.6062095,-122.3320708,'USA'),('Seoul',37.5326,127.02461199999993,'Asia'),('Stockholm',59.32932349999999,18.068580800000063,'Europa'),('Tegucigalpa',14.0818,-87.20681000000002,'Sud_America'),('Tehran',35.715298,51.404342999999926,'Asia'),('Teresina',-5.08917,-42.80194,'Sud_America'),('Tokyo',35.652832,139.83947799999999,'Asia'),('Tripoli',32.885353,13.180160999999998,'Africa'),('Tunis',36.81897,10.165790000000015,'Africa'),('Ulaanbaatar',47.92123,106.91855599999997,'Asia'),('Urumqi',43.825592,87.616852,'Asia'),('Windhoek',-22.601255,17.092333000000053,'Africa'),('Yaounde',3.86667,11.516669999999976,'Africa'),('Zagreb',45.8150108,15.981918899999982,'Europa');
/*!40000 ALTER TABLE `normale` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-21 20:50:33
