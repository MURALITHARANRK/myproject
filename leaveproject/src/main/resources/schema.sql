DROP TABLE IF EXISTS Department;
CREATE TABLE Department(
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(16) NOT NULL
);

DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee(
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(20) NOT NULL,
  middle_name VARCHAR(20) NOT NULL,
  last_name VARCHAR(20) NOT NULL,
  date_of_birth DATE NOT NULL,
  gender VARCHAR(10) NOT NULL,
  joining_date DATE NOT NULL,
  leaving_date NULL,
  status VARCHAR(10) NOT NULL,
  location VARCHAR(50) NOT NULL  
);

DROP TABLE IF EXISTS Leave;
CREATE TABLE Leave(
	id INT AUTO_INCREMENT PRIMARY KEY,
	from_date DATE NOT NULL,
	to_date DATE NOT NULL,
	number_of_days FLOAT NOT NULL,
	requested_by INT NOT NULL,
	requested_date DATE NOT NULL,
	approved_by INT NULL,
	approved_date DATE NULL
);