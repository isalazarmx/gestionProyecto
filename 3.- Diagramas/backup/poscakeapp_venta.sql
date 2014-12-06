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
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venta` (
  `idVenta` int(11) NOT NULL AUTO_INCREMENT,
  `tipoVenta` int(11) NOT NULL DEFAULT '1',
  `fechaVenta` datetime NOT NULL,
  `fechaEntrega` datetime DEFAULT NULL,
  `kilos` int(11) NOT NULL,
  `precioTotal` decimal(8,2) NOT NULL,
  `eliminado` tinyint(1) DEFAULT '0',
  `usuario_idusuario` int(11) NOT NULL,
  `Cliente_idCliente` int(11) NOT NULL,
  `ventaPedido_idventaPedido` int(11) NOT NULL,
  `Producto_idProducto` varchar(30) NOT NULL,
  `Producto_Empresa_idEmpresa` int(11) NOT NULL,
  PRIMARY KEY (`idVenta`,`usuario_idusuario`,`Cliente_idCliente`,`ventaPedido_idventaPedido`,`Producto_idProducto`,`Producto_Empresa_idEmpresa`),
  UNIQUE KEY `idVenta_UNIQUE` (`idVenta`),
  KEY `fk_Venta_usuario1_idx` (`usuario_idusuario`),
  KEY `fk_Venta_Cliente1_idx` (`Cliente_idCliente`),
  KEY `fk_Venta_ventaPedido1_idx` (`ventaPedido_idventaPedido`),
  KEY `fk_Venta_Producto1_idx` (`Producto_idProducto`,`Producto_Empresa_idEmpresa`),
  CONSTRAINT `fk_Venta_Cliente1` FOREIGN KEY (`Cliente_idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venta_Producto1` FOREIGN KEY (`Producto_idProducto`, `Producto_Empresa_idEmpresa`) REFERENCES `producto` (`idProducto`, `Empresa_idEmpresa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venta_usuario1` FOREIGN KEY (`usuario_idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venta_ventaPedido1` FOREIGN KEY (`ventaPedido_idventaPedido`) REFERENCES `ventapedido` (`idventaPedido`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-12-05 11:28:24
