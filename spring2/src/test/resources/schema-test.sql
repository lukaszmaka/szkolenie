CREATE TABLE IF NOT EXISTS employee(
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	surname VARCHAR(100) NOT NULL,
	city VARCHAR(100) NOT NULL,
	salary INT NOT NULL DEFAULT 2000);
	
INSERT INTO employee(name, surname, city, salary)
VALUES('Jan', 'Kowalski', 'Wroclaw', 3000);