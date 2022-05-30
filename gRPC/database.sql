CREATE DATABASE `gRPC-database`;
USE `gRPC-database`;
CREATE TABLE customers(
    id varchar(40) NOT NULL,
    name varchar(40) NOT NULL,
    age int(3) NOT NULL,
    address varchar(100) NOT NULL,
    PRIMARY KEY (id)
);
INSERT INTO
    customers
VALUES
    (
        'a68b823c-7ca6-44bc-b721-fb4d5312cafc',
        'Rogelio Trejo',
        21,
        'Aguascalientes'
    ),
    (
        '34415c7c-f82d-4e44-88ca-ae2a1aaa92b7',
        'Aarón Huerta',
        21,
        'Aguascalientes'
    );