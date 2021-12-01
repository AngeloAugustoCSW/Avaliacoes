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
-- -----------------------------------------------------
-- Schema padariateste
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema padariateste
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `padariateste` DEFAULT CHARACTER SET utf8 ;
USE `padariateste` ;

-- -----------------------------------------------------
-- Table `padariateste`.`chef`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `padariateste`.`chef` (
  `id` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `cpf` VARCHAR(11) NULL DEFAULT NULL,
  `dtNasc` VARCHAR(8) NULL DEFAULT NULL,
  `specialty` VARCHAR(25) NULL DEFAULT NULL,
  `salario` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `padariateste`.`Receita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `padariateste`.`Receita` (
  `id` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NULL,
  `etapas` VARCHAR(45) NULL,
  `numEtapas` VARCHAR(45) NULL,
  `valor` DOUBLE NULL,
  `idChef` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Receita_idChefx` (`idChef` ASC) ,
  CONSTRAINT `fk_Receita_chef`
    FOREIGN KEY (`idChef`)
    REFERENCES `padariateste`.`chef` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `padariateste`.`Padaria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `padariateste`.`Padaria` (
  `id` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NULL,
  `dtAbertura` VARCHAR(45) NULL,
  `cep` VARCHAR(9) NULL,
  `rua` VARCHAR(45) NULL,
  `numero` VARCHAR(45) NULL,
  `bairro` VARCHAR(45) NULL,
  `cidade` VARCHAR(45) NULL,
  `horario` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `padariateste`.`ReceitaPadaria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `padariateste`.`ReceitaPadaria` (
  `idReceita` VARCHAR(45) NOT NULL,
  `idPadaria` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idReceita`, `idPadaria`),
  INDEX `fk_Receita_has_Padaria_Padaria1_idx` (`idPadaria` ASC) ,
  INDEX `fk_Receita_has_Padaria_Receita1_idx` (`idReceita` ASC) ,
  CONSTRAINT `fk_Receita_has_Padaria_Receita1`
    FOREIGN KEY (`idReceita`)
    REFERENCES `padariateste`.`Receita` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Receita_has_Padaria_Padaria1`
    FOREIGN KEY (`idPadaria`)
    REFERENCES `padariateste`.`Padaria` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `padariateste`.`Mercado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `padariateste`.`Mercado` (
  `id` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NULL,
  `dtAbertura` VARCHAR(45) NULL,
  `cep` VARCHAR(9) NULL,
  `rua` VARCHAR(45) NULL,
  `numero` VARCHAR(45) NULL,
  `bairro` VARCHAR(45) NULL,
  `cidade` VARCHAR(45) NULL,
  `promo` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `padariateste`.`ReceitaMercado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `padariateste`.`ReceitaMercado` (
  `idReceita` VARCHAR(45) NOT NULL,
  `idMercado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idReceita`, `idMercado`),
  INDEX `fk_Receita_has_Mercado_Mercado1_idx` (`idMercado` ASC) ,
  INDEX `fk_Receita_has_Mercado_Receita1_idx` (`idReceita` ASC) ,
  CONSTRAINT `fk_Receita_has_Mercado_Receita1`
    FOREIGN KEY (`idReceita`)
    REFERENCES `padariateste`.`Receita` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Receita_has_Mercado_Mercado1`
    FOREIGN KEY (`idMercado`)
    REFERENCES `padariateste`.`Mercado` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `padariateste` ;

-- -----------------------------------------------------
-- Table `padariateste`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `padariateste`.`cliente` (
  `id` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `cpf` VARCHAR(11) NULL DEFAULT NULL,
  `dtNasc` VARCHAR(8) NULL DEFAULT NULL,
  `telefone` VARCHAR(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
