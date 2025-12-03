-- Active: 1764591940568@@127.0.0.1@3306@restaurantdb
CREATE DATABASE restaurantdb;

USE restaurantdb;

CREATE TABLE customer(
    customerId VARCHAR(50) PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL
);

CREATE TABLE menu(
    itemId VARCHAR(50) PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    category VARCHAR(255) NOT NULL
);

CREATE TABLE orders(
    orderId INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    customerId VARCHAR(50) NOT NULL,
    itemId VARCHAR(50) NOT NULL,
    quantity INT NOT NULL,
    totalamt DOUBLE NOT NULL,
    orderdate DATE,
    FOREIGN KEY(customerId) REFERENCES customer(customerId),
    FOREIGN KEY(itemId) REFERENCES menu(itemId)

);



