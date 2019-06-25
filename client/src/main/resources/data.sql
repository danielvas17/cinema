DROP TABLE IF EXISTS client;

CREATE TABLE client (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(128) NOT NULL,
  last_name VARCHAR(128) NOT NULL,
  identification VARCHAR(32) DEFAULT NULL,
  date_birth DATE DEFAULT NULL
);