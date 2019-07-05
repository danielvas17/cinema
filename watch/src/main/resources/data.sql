DROP TABLE IF EXISTS client_watch;

CREATE TABLE client_watch (
  id INT AUTO_INCREMENT PRIMARY KEY,
  client_id INT NOT NULL,
  movie_id INT NOT NULL,
  watch_datetime timestamp NOT NULL
);