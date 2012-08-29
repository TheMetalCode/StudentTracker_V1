CREATE  TABLE `registrar`.`student` (
  `studentID` INT(10) NOT NULL ,
  `firstName` VARCHAR(30) NOT NULL ,
  `lastName` VARCHAR(30) NOT NULL ,
  `gpa` FLOAT NOT NULL ,
  `status` VARCHAR(11) NOT NULL ,
  `mentor` VARCHAR(60) NOT NULL ,
  `level` VARCHAR(10) NOT NULL ,
  `thesisTitle` VARCHAR(60) NOT NULL ,
  `thesisAdvisor` VARCHAR(60) NOT NULL ,
  `company` VARCHAR(30) NOT NULL ,
  `studentType` VARCHAR(15) NOT NULL ,
  PRIMARY KEY (`studentID`) ,
  UNIQUE INDEX `studentID_UNIQUE` (`studentID` ASC) );