DROP TABLE IF EXISTS goods;

CREATE TABLE goods (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  price DECIMAL(10, 2) NOT NULL
);

INSERT INTO goods (name, price) VALUES ('Laptop Acer Aspire 5 A515-54G-502N', 600.57);
INSERT INTO goods (name, price) VALUES ('Xiaomi Redmi Note 10 pro', 682.90);
INSERT INTO goods (name, price) VALUES ('Samsung Galaxy S10 Plus', 560);
INSERT INTO goods (name, price) VALUES ('Laptop Apple MacBook Air 13', 1200.80);
INSERT INTO goods (name, price) VALUES ('Laptop Dell Inspiron 3593', 400);
INSERT INTO goods (name, price) VALUES ('Samsung Galaxy S10 Plus', 800.25);