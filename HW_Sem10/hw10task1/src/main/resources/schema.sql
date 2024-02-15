CREATE TABLE  IF NOT EXISTS notes (
                         id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         header VARCHAR(250) NOT NULL,
                         description varchar(20) NOT NULL,
                         date_of_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);