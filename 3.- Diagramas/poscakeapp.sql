-- MySQL Script generated by MySQL Workbench
-- 12/04/14 17:58:06
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema poscakeapp
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema poscakeapp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `poscakeapp` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `poscakeapp` ;

-- -----------------------------------------------------
-- Table `poscakeapp`.`Empresa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `poscakeapp`.`Empresa` (
  `idEmpresa` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(25) NOT NULL,
  `calle` VARCHAR(45) NULL,
  `numInt` INT NULL,
  `numExt` INT NULL,
  `ciudad` VARCHAR(20) NULL,
  `colonia` VARCHAR(20) NULL,
  `estado` VARCHAR(25) NULL,
  `codigoPostal` INT NULL,
  `RFC` VARCHAR(15) NOT NULL,
  `pagWeb` VARCHAR(250) NULL,
  `email` VARCHAR(45) NULL,
  `eliminado` TINYINT(1) NULL DEFAULT 0,
  PRIMARY KEY (`idEmpresa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `poscakeapp`.`Categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `poscakeapp`.`Categoria` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(250) NULL,
  `tipoProducto` INT NULL,
  `eliminado` TINYINT(1) NULL DEFAULT 0,
  PRIMARY KEY (`idCategoria`),
  UNIQUE INDEX `idCategoria_UNIQUE` (`idCategoria` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `poscakeapp`.`Producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `poscakeapp`.`Producto` (
  `idProducto` VARCHAR(30) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `cantidad` DECIMAL(20,2) NOT NULL DEFAULT 0.0,
  `tipoUnidad` VARCHAR(5) NOT NULL DEFAULT 'kg.',
  `UnidadExistencia` INT NOT NULL,
  `minStock` INT NOT NULL,
  `maxStock` INT NOT NULL,
  `precioCompra` DECIMAL(20,2) NOT NULL DEFAULT 0.0,
  `incrementoVenta` DECIMAL(20,2) NOT NULL DEFAULT 0.0,
  `precioVenta` DECIMAL(20,2) NOT NULL DEFAULT 0.0,
  `Image` BLOB NULL,
  `RutaImage` VARCHAR(400) NULL,
  `tipoProducto` INT NOT NULL DEFAULT 3,
  `eliminado` TINYINT(1) NULL DEFAULT 0,
  `Empresa_idEmpresa` INT NOT NULL,
  `Categoria_idCategoria` INT NOT NULL,
  PRIMARY KEY (`idProducto`, `Empresa_idEmpresa`, `Categoria_idCategoria`),
  UNIQUE INDEX `idProducto_UNIQUE` (`idProducto` ASC),
  INDEX `fk_Producto_Empresa1_idx` (`Empresa_idEmpresa` ASC),
  INDEX `fk_Producto_Categoria1_idx` (`Categoria_idCategoria` ASC),
  CONSTRAINT `fk_Producto_Empresa1`
    FOREIGN KEY (`Empresa_idEmpresa`)
    REFERENCES `poscakeapp`.`Empresa` (`idEmpresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Producto_Categoria1`
    FOREIGN KEY (`Categoria_idCategoria`)
    REFERENCES `poscakeapp`.`Categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `poscakeapp`.`Proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `poscakeapp`.`Proveedor` (
  `idProveedor` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(25) NOT NULL,
  `aPaterno` VARCHAR(20) NOT NULL,
  `aMaterno` VARCHAR(20) NULL,
  `marca` VARCHAR(20) NOT NULL,
  `empresa` VARCHAR(25) NOT NULL,
  `RFC` VARCHAR(15) NULL,
  `telFijo` VARCHAR(12) NULL,
  `telCel` VARCHAR(12) NOT NULL,
  `calle` VARCHAR(45) NULL,
  `numInt` INT NULL,
  `numExt` INT NULL,
  `colonia` VARCHAR(20) NULL,
  `ciudad` VARCHAR(20) NULL,
  `estado` VARCHAR(25) NULL,
  `codigoPostal` INT NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `eliminado` TINYINT(1) NULL DEFAULT 0,
  PRIMARY KEY (`idProveedor`),
  UNIQUE INDEX `idProveedor_UNIQUE` (`idProveedor` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `poscakeapp`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `poscakeapp`.`Usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(25) NOT NULL,
  `aPaterno` VARCHAR(20) NULL,
  `aMaterno` VARCHAR(20) NULL,
  `username` VARCHAR(25) NOT NULL,
  `password` VARCHAR(16) NOT NULL,
  `tipo` INT NOT NULL DEFAULT 2,
  `eliminado` TINYINT(1) NULL DEFAULT 0,
  `Empresa_idEmpresa` INT NOT NULL,
  PRIMARY KEY (`idusuario`, `Empresa_idEmpresa`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  INDEX `fk_Usuario_Empresa1_idx` (`Empresa_idEmpresa` ASC),
  CONSTRAINT `fk_Usuario_Empresa1`
    FOREIGN KEY (`Empresa_idEmpresa`)
    REFERENCES `poscakeapp`.`Empresa` (`idEmpresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `poscakeapp`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `poscakeapp`.`Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(25) NOT NULL,
  `aPaterno` VARCHAR(20) NOT NULL,
  `aMaterno` VARCHAR(20) NULL,
  `RFC` VARCHAR(15) NULL,
  `telFijo` VARCHAR(12) NULL,
  `telCel` VARCHAR(12) NOT NULL,
  `calle` VARCHAR(45) NULL,
  `numInt` INT NULL,
  `numExt` INT NULL,
  `colonia` VARCHAR(20) NULL,
  `ciudad` VARCHAR(20) NULL,
  `estado` VARCHAR(25) NULL,
  `codigoPostal` INT NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `eliminado` TINYINT(1) NULL DEFAULT 0,
  PRIMARY KEY (`idCliente`),
  UNIQUE INDEX `idProveedor_UNIQUE` (`idCliente` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `poscakeapp`.`ventaPedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `poscakeapp`.`ventaPedido` (
  `idventaPedido` INT NOT NULL AUTO_INCREMENT,
  `abono` DECIMAL(8,2) NOT NULL,
  `resto` DECIMAL(8,2) NOT NULL,
  `entregado` TINYINT(1) NOT NULL DEFAULT 0,
  `descripcion` VARCHAR(250) NULL,
  PRIMARY KEY (`idventaPedido`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `poscakeapp`.`Venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `poscakeapp`.`Venta` (
  `idVenta` INT NOT NULL AUTO_INCREMENT,
  `tipoVenta` INT NOT NULL DEFAULT 1,
  `fechaVenta` DATETIME NOT NULL,
  `fechaEntrega` DATETIME NULL,
  `kilos` INT NOT NULL,
  `precioTotal` DECIMAL(8,2) NOT NULL,
  `eliminado` TINYINT(1) NULL DEFAULT 0,
  `usuario_idusuario` INT NOT NULL,
  `Cliente_idCliente` INT NOT NULL,
  `ventaPedido_idventaPedido` INT NOT NULL,
  `Producto_idProducto` VARCHAR(30) NOT NULL,
  `Producto_Empresa_idEmpresa` INT NOT NULL,
  PRIMARY KEY (`idVenta`, `usuario_idusuario`, `Cliente_idCliente`, `ventaPedido_idventaPedido`, `Producto_idProducto`, `Producto_Empresa_idEmpresa`),
  INDEX `fk_Venta_usuario1_idx` (`usuario_idusuario` ASC),
  INDEX `fk_Venta_Cliente1_idx` (`Cliente_idCliente` ASC),
  UNIQUE INDEX `idVenta_UNIQUE` (`idVenta` ASC),
  INDEX `fk_Venta_ventaPedido1_idx` (`ventaPedido_idventaPedido` ASC),
  INDEX `fk_Venta_Producto1_idx` (`Producto_idProducto` ASC, `Producto_Empresa_idEmpresa` ASC),
  CONSTRAINT `fk_Venta_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `poscakeapp`.`Usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venta_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `poscakeapp`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venta_ventaPedido1`
    FOREIGN KEY (`ventaPedido_idventaPedido`)
    REFERENCES `poscakeapp`.`ventaPedido` (`idventaPedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venta_Producto1`
    FOREIGN KEY (`Producto_idProducto` , `Producto_Empresa_idEmpresa`)
    REFERENCES `poscakeapp`.`Producto` (`idProducto` , `Empresa_idEmpresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `poscakeapp`.`Notificacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `poscakeapp`.`Notificacion` (
  `idNotificacion` INT NOT NULL AUTO_INCREMENT,
  `tipoNotificacion` INT NULL,
  `descripcion` VARCHAR(45) NULL,
  `fechaInicioNotificacion` DATETIME NULL,
  `fechaFinNotificacion` DATETIME NULL,
  `Empresa_idEmpresa` INT NOT NULL,
  PRIMARY KEY (`idNotificacion`, `Empresa_idEmpresa`),
  UNIQUE INDEX `idNotificacion_UNIQUE` (`idNotificacion` ASC),
  INDEX `fk_Notificacion_Empresa1_idx` (`Empresa_idEmpresa` ASC),
  CONSTRAINT `fk_Notificacion_Empresa1`
    FOREIGN KEY (`Empresa_idEmpresa`)
    REFERENCES `poscakeapp`.`Empresa` (`idEmpresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `poscakeapp`.`Proveedor_has_Producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `poscakeapp`.`Proveedor_has_Producto` (
  `Proveedor_idProveedor` INT NOT NULL,
  `Producto_idProducto` VARCHAR(30) NOT NULL,
  `Producto_Empresa_idEmpresa` INT NOT NULL,
  `Producto_Categoria_idCategoria` INT NOT NULL,
  PRIMARY KEY (`Proveedor_idProveedor`, `Producto_idProducto`, `Producto_Empresa_idEmpresa`, `Producto_Categoria_idCategoria`),
  INDEX `fk_Proveedor_has_Producto_Producto1_idx` (`Producto_idProducto` ASC, `Producto_Empresa_idEmpresa` ASC, `Producto_Categoria_idCategoria` ASC),
  INDEX `fk_Proveedor_has_Producto_Proveedor1_idx` (`Proveedor_idProveedor` ASC),
  CONSTRAINT `fk_Proveedor_has_Producto_Proveedor1`
    FOREIGN KEY (`Proveedor_idProveedor`)
    REFERENCES `poscakeapp`.`Proveedor` (`idProveedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Proveedor_has_Producto_Producto1`
    FOREIGN KEY (`Producto_idProducto` , `Producto_Empresa_idEmpresa` , `Producto_Categoria_idCategoria`)
    REFERENCES `poscakeapp`.`Producto` (`idProducto` , `Empresa_idEmpresa` , `Categoria_idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
