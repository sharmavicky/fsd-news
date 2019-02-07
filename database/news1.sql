SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';



-- -----------------------------------------------------
-- Table `news`.`article`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `news`.`article` ;

CREATE  TABLE IF NOT EXISTS `news`.`article` (
  `ar_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `ar_title` VARCHAR(45) NULL ,
  `ar_author` VARCHAR(70) NULL DEFAULT NULL ,
  `ar_url` VARCHAR(45) NULL DEFAULT NULL ,
  `ar_url_to_image` VARCHAR(45) NULL DEFAULT NULL ,
  `ar_published_at` DATETIME NULL DEFAULT NULL ,
  `ar_content` TEXT NULL DEFAULT NULL ,
  PRIMARY KEY (`ar_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `news`.`language`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `news`.`language` ;

CREATE  TABLE IF NOT EXISTS `news`.`language` (
  `la_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `la_code` VARCHAR(2) NOT NULL ,
  `la_name` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`la_id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `news`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `news`.`role` ;

CREATE  TABLE IF NOT EXISTS `news`.`role` (
  `ro_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `ro_name` VARCHAR(10) NOT NULL ,
  PRIMARY KEY (`ro_id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `news`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `news`.`user` ;

CREATE  TABLE IF NOT EXISTS `news`.`user` (
  `us_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `us_name` VARCHAR(70) NOT NULL ,
  `us_email` VARCHAR(255) NOT NULL ,
  `us_password` VARCHAR(128) NOT NULL ,
  `us_blacklist` TINYINT(1) NOT NULL ,
  `us_ro_id` INT(11) NULL DEFAULT NULL ,
  `us_la_id` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`us_id`) ,
  INDEX `us_ro_id` (`us_ro_id` ASC) ,
  INDEX `us_la_id` (`us_la_id` ASC) ,
  CONSTRAINT `us_la_id`
    FOREIGN KEY (`us_la_id` )
    REFERENCES `news`.`language` (`la_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `us_ro_id`
    FOREIGN KEY (`us_ro_id` )
    REFERENCES `news`.`role` (`ro_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `news`.`favorite_article`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `news`.`favorite_article` ;

CREATE  TABLE IF NOT EXISTS `news`.`favorite_article` (
  `fa_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `fa_us_id` INT(11) NULL DEFAULT NULL ,
  `fa_ar_id` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`fa_id`) ,
  INDEX `fa_us_id` (`fa_us_id` ASC) ,
  INDEX `fa_ar_id` (`fa_ar_id` ASC) ,
  CONSTRAINT `fa_ar_id`
    FOREIGN KEY (`fa_ar_id` )
    REFERENCES `news`.`article` (`ar_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fa_us_id`
    FOREIGN KEY (`fa_us_id` )
    REFERENCES `news`.`user` (`us_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
