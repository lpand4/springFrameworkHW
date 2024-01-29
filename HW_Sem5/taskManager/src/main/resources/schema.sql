CREATE TABLE  IF NOT EXISTS tasks (
                         id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         description VARCHAR(250) NOT NULL,
                         status varchar(20) NOT NULL,
                         time_of_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);