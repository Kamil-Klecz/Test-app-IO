-- Create database if it doesn't exist
CREATE DATABASE IF NOT EXISTS rower;

USE rower;

CREATE TABLE IF NOT EXISTS items (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255)
    );

INSERT INTO items (name) VALUES
                             ('Bike 1'),
                             ('Bike 2'),
                             ('Bike 3');