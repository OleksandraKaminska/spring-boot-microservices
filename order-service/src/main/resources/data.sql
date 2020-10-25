DROP TABLE IF EXISTS order_info cascade;
DROP TABLE IF EXISTS item;

CREATE TABLE order_info (
  order_id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT NOT NULL,
  shipping_destination VARCHAR(250) NOT NULL,
  order_date DATE NOT NULL
);

CREATE TABLE item (
  item_id  INT AUTO_INCREMENT PRIMARY KEY,
  order_id INT NOT NULL,
  goods_id INT NOT NULL
);

INSERT INTO order_info (user_id, shipping_destination, order_date) VALUES (1, 'Ukraine', '2020-11-11');
INSERT INTO order_info (user_id, shipping_destination, order_date) VALUES (2, 'UK', '2020-10-11');

INSERT INTO item (order_id, goods_id) VALUES (1, 1);
INSERT INTO item (order_id, goods_id) VALUES (1, 2);
INSERT INTO item (order_id, goods_id) VALUES (1, 5);
INSERT INTO item (order_id, goods_id) VALUES (2, 2);
INSERT INTO item (order_id, goods_id) VALUES (2, 3);