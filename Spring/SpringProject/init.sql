--CREATE DATABASE spitter;
--USE spitter;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id MEDIUMINT AUTO_INCREMENT,
    name VARCHAR(50),
    password VARCHAR(50),
    PRIMARY KEY (id)
);