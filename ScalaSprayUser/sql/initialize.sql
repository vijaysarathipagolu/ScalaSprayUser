CREATE DATABASE IF NOT EXISTS scalaspray;


use scalaspray;

CREATE TABLE IF NOT EXISTS `user` (
  `userid` INT AUTO_INCREMENT COMMENT 'user id - unique',
  `firstname` varchar(128) NOT NULL COMMENT 'first name of the user',
  `lastname` varchar(128) NOT NULL COMMENT 'last name of the user',
  `gender` varchar(10) NOT NULL COMMENT 'gender of the user',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;