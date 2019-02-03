CREATE DATABASE `messenger`;
USE `messenger`;

CREATE TABLE `user` (
	`id` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(30) NOT NULL UNIQUE,
    `password` VARCHAR(30) NOT NULL,
    `fname` VARCHAR(30),
    `lname` VARCHAR(30),
    `type` varchar(20) NOT NULL,
    PRIMARY KEY (`id`, `username`)
);

CREATE TABLE `messages` (
	`id` INT NOT NULL AUTO_INCREMENT,
    `sender` VARCHAR(30) NOT NULL,
    `receiver` VARCHAR(30) NOT NULL,
    `date` VARCHAR(30) NOT NULL,
    `data` VARCHAR(250) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`sender`) REFERENCES `user` (`username`)
);


INSERT INTO `messenger`.`user` (`username`,`password`, `fname`, `lname`,`type`) VALUES ( 'admin','admin','Sophia','Jebelikou','superadmin')