-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema padariateste
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema padariateste
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `padariateste` DEFAULT CHARACTER SET utf8 ;
USE `padariateste` ;

-- -----------------------------------------------------
-- Table `padariateste`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `padariateste`.`Cliente` (
  `id` VARCHAR(150) NOT NULL,
  `nome` VARCHAR(150) NULL,
  `CPF` VARCHAR(14) NULL,
  `dtNasc` VARCHAR(10) NULL,
  `telefone` VARCHAR(15) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `padariateste`.`Chef`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `padariateste`.`Chef` (
  `id` VARCHAR(150) NOT NULL,
  `nome` VARCHAR(150) NULL,
  `CPF` VARCHAR(14) NULL,
  `dtNasc` VARCHAR(45) NULL,
  `specialty` VARCHAR(45) NULL,
  `salario` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
