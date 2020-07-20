DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(250) NOT NULL,
    last_name VARCHAR(250) NOT NULL,
    email_address VARCHAR(250) NOT NULL
);

INSERT INTO users (id, first_name, last_name, email_address) VALUES
(1, 'John', 'Doe', 'john@domain');
