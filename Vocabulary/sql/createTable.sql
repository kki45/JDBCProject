-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema word
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema word
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `word` DEFAULT CHARACTER SET utf8 ;
USE `word` ;

-- -----------------------------------------------------
-- Table `word`.`form`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `word`.`form` (
  `form_id` INT NOT NULL AUTO_INCREMENT,
  `form_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`form_id`),
  UNIQUE INDEX `form_id_UNIQUE` (`form_id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `word`.`word`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `word`.`word` (
  `word_id` INT NOT NULL AUTO_INCREMENT,
  `english_word` VARCHAR(45) NOT NULL,
  `korean_word` VARCHAR(45) NOT NULL,
  `form_id` INT NOT NULL,
  PRIMARY KEY (`word_id`),
  UNIQUE INDEX `word_id_UNIQUE` (`word_id` ASC) VISIBLE,
  INDEX `fk_word_form1_idx` (`form_id` ASC) VISIBLE,
  CONSTRAINT `fk_word_form1`
    FOREIGN KEY (`form_id`)
    REFERENCES `word`.`form` (`form_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `word`.`myword`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `word`.`myword` (
  `my_number` INT NOT NULL AUTO_INCREMENT,
  `word_id` INT NOT NULL,
  PRIMARY KEY (`my_number`),
  UNIQUE INDEX `number_UNIQUE` (`my_number` ASC) VISIBLE,
  INDEX `fk_myword_word_idx` (`word_id` ASC) VISIBLE,
  CONSTRAINT `fk_myword_word`
    FOREIGN KEY (`word_id`)
    REFERENCES `word`.`word` (`word_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `word`.`wordGame`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `word`.`wordGame` (
  `game_number` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(45) NOT NULL,
  `score` INT NOT NULL DEFAULT 0,
  `date` DATE NOT NULL,
  PRIMARY KEY (`game_number`),
  UNIQUE INDEX `game_number_UNIQUE` (`game_number` ASC) VISIBLE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
