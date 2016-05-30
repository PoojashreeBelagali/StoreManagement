create database store_management;

use store_management;

CREATE TABLE `CITY` (
  `CITY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CITY_NAME` varchar(255) NOT NULL,
  `ZIP_CODE` int(10) NOT NULL,
  PRIMARY KEY (`CITY_ID`),
  UNIQUE KEY `CITY_NAME` (`CITY_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;


CREATE TABLE `store` (
  `STORE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `STORE_NAME` varchar(255) NOT NULL,
  `CITY_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`STORE_ID`),
  KEY `FK2EF5CA29842F7F9` (`CITY_ID`),
  CONSTRAINT `FK2EF5CA29842F7F9` FOREIGN KEY (`CITY_ID`) REFERENCES `CITY` (`CITY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;


