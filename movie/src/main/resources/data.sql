DROP TABLE IF EXISTS movie;

CREATE TABLE movie (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(128) NOT NULL,
  duration INT NOT NULL,
  min_age INT NOT NULL,
  is_publish BOOL DEFAULT FALSE
);