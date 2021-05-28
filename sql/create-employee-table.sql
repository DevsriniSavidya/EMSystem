CREATE DATABASE 'demo';
USE demo;

create table employees (
	id  int(30) NOT NULL AUTO_INCREMENT,
	name varchar(50) NOT NULL,
	address varchar(100) NOT NULL,
	gender varchar(10),
	age int(90),
	PRIMARY KEY (id)
);

