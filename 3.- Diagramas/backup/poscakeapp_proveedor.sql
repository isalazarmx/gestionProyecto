CREATE DATABASE  IF NOT EXISTS `poscakeapp` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `poscakeapp`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: poscakeapp
-- ------------------------------------------------------
-- Server version	5.6.20

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
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedor` (
  `idProveedor` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) NOT NULL,
  `aPaterno` varchar(20) NOT NULL,
  `aMaterno` varchar(20) DEFAULT NULL,
  `marca` varchar(20) NOT NULL,
  `empresa` varchar(25) NOT NULL,
  `RFC` varchar(15) DEFAULT NULL,
  `telFijo` varchar(12) DEFAULT NULL,
  `telCel` varchar(12) NOT NULL,
  `calle` varchar(45) DEFAULT NULL,
  `numInt` int(11) DEFAULT NULL,
  `numExt` int(11) DEFAULT NULL,
  `colonia` varchar(20) DEFAULT NULL,
  `ciudad` varchar(20) DEFAULT NULL,
  `estado` varchar(25) DEFAULT NULL,
  `codigoPostal` int(11) NOT NULL,
  `email` varchar(45) NOT NULL,
  `eliminado` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`idProveedor`),
  UNIQUE KEY `idProveedor_UNIQUE` (`idProveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (1,'Jose Alberto','Garcia','Hernandez','3 Coronas','Tia Rosa','JOASD12345','7224162531','7282816237','Calle Reforma',102,12,'Las Golondrinas','Villa Victoria','Durango',12341,'josaslde@gmail.com',0),(2,'Juan','Villavicencio','Colin','Corona','Nestle','JOVASD3451','7224162531','7282816237','Calle Reforma',102,12,'Las Golondrinas','Villa Victoria','Durango',12341,'joseasjd@gmail.com',0),(3,'Lorena','Perez','Ramirez','Harina','Tia Rosa','JOVI1ASD45','7224162531','7282816237','Calle Reforma',102,12,'Las Golondrinas','Villa Victoria','Durango',12341,'sade@gmail.com',0),(4,'Hugo','Salazar','Hernandez','Azucareras','San Cristobal','QJOVD12345','7224162531','7282816237','Calle Reforma',102,12,'Las Golondrinas','Villa Victoria','Durango',12341,'sada@gmail.com',0),(5,'Gabriel','Villavicencio','Perez','Limonada','Los Mochis','JOVIHE1235','7224162531','7282816237','Calle Reforma',102,12,'Las Golondrinas','Villa Victoria','Durango',12341,'asldla@gmail.com',0),(6,'Mariana','Cuadros','Hernandez','Nueces','Tia Juana','JOOWIE1235','7224162531','7282816237','Calle Reforma',102,12,'Las Golondrinas','Villa Victoria','Durango',12341,'asdlkj@gmail.com',0),(7,'Maria','Martinez','Colin','Papeleria','Tio Nacho','JOVHE12345','7224162531','7282816237','Calle Reforma',102,12,'Las Golondrinas','Villa Victoria','Durango',12341,'asld1@gmail.com',0),(8,'Fernanda','Hernnadez','Hernandez','Lecheria','La casa lopez','JOVILS0345','7224162531','7282816237','Calle Reforma',102,12,'Las Golondrinas','Villa Victoria','Durango',12341,'asldla@gmail.com',0),(9,'Carlos','Villavicencio','Sanchez','Chocolates','Los casa nova','JOVILSO235','7224162531','7282816237','Calle Reforma',102,12,'Las Golondrinas','Villa Victoria','Durango',12341,'12da@gmail.com',0),(10,'Luis','Perez','Garcia','Mantequillas','Los Ramones','JOVPWOE345','7224162531','7282816237','Calle Reforma',102,12,'Las Golondrinas','Villa Victoria','Durango',12341,'asd1s@gmail.com',0),(11,'Roberto','Villavicencio','Hernandez','Harinas','Los Juanes','JQSHE12345','7224162531','7282816237','Calle Reforma',102,12,'Las Golondrinas','Villa Victoria','Durango',12341,'aslkdj9@gmail.com',0),(12,'Vanessa','Torres','Nuñez','Pasas','Casanova','JOV1SI2345','7224162531','7282816237','Calle Reforma',102,12,'Las Golondrinas','Villa Victoria','Durango',12341,'asdlkj2@gmail.com',0),(13,'Nadia','Orihuela','Hernandez','Cremeria','Crema y nata','JOVASD2345','7224162531','7282816237','Calle Reforma',102,12,'Las Golondrinas','Villa Victoria','Durango',12341,'joasd@gmail.com',0),(14,'Abril','Martinez','Ruiz','Merengues','Castillos','JOVIHEA145','7224162531','7282816237','Calle Reforma',102,12,'Las Golondrinas','Villa Victoria','Durango',12341,'jdsw1@gmail.com',0),(15,'Ximena','Villavicencio','Hernandez','Caas','Los nas','12A1E12345','7224162531','7282816237','Calle Reforma',102,12,'Las Golondrinas','Villa Victoria','Durango',12341,'jasd1e@gmail.com',0),(16,'Zuleima','Perez','Colin','Paqueteria','Billazico','JO1VIHASO5','7224162531','7282816237','Calle Reforma',102,12,'Las Golondrinas','Villa Victoria','Durango',12341,'jsad1e@gmail.com',0),(17,'Juan','Villavicencio','Hernandez','Quesos','Julians','JOIHASOQ45','7224162531','7282816237','Calle Reforma',102,12,'Las Golondrinas','Villa Victoria','Durango',12341,'joasd1@gmail.com',0),(18,'Nadia Alberto','Garcia','Perez','Villan','Simones','AQSDLAKSD2','7224162531','7282816237','Calle Reforma',102,12,'Las Golondrinas','Villa Victoria','Durango',12341,'joasd1e@gmail.com',0),(19,'Daniel','Ruiz','Hernandez','Lian','Colorado','JOVASD1203','7224162531','7282816237','Calle Reforma',102,12,'Las Golondrinas','Villa Victoria','Durango',12341,'joasde@gmail.com',0),(20,'Daniela','Villavicencio','Cuadros','Calima','Castas','ASDPQ12345','7224162531','7282816237','Calle Reforma',102,12,'Las Golondrinas','Villa Victoria','Durango',12341,'joasd1se@gmail.com',0);
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-12-05 11:28:23
