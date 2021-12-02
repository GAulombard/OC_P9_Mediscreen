CREATE DATABASE IF NOT EXISTS mediscreen_db;

USE mediscreen_db;

CREATE TABLE IF NOT EXISTS patients (
                                        id BIGINT AUTO_INCREMENT NOT NULL,
                                        last_name VARCHAR(125) NOT NULL,
                                        first_name VARCHAR(125) NOT NULL,
                                        date_of_birth VARCHAR(10) NOT NULL,
                                        sex CHAR (1) NOT NULL,
                                        address VARCHAR(150) DEFAULT NULL,
                                        phone_number VARCHAR(20) DEFAULT NULL,
                                        PRIMARY KEY (id)
);
