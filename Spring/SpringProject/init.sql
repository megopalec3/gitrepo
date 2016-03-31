--CREATE DATABASE spitter;
--USE spitter;

DROP TABLE IF EXISTS user;

CREATE TABLE user (
    id MEDIUMINT AUTO_INCREMENT,
    name VARCHAR(50),
    password VARCHAR(50),
    PRIMARY KEY (id)
);