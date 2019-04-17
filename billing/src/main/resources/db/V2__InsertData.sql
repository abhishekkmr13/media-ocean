INSERT INTO category (category_id, category_name) VALUES ('1', 'Fitness and Sports');
INSERT INTO category (category_id, category_name) VALUES ('2', 'Electronics');
INSERT INTO category (category_id, category_name) VALUES ('3', 'Cosmetics and Health');
INSERT INTO category (category_id, category_name) VALUES ('4', 'Mobile');
INSERT INTO category (category_id, category_name) VALUES ('5', 'Laptop');
INSERT INTO category (category_id, category_name) VALUES ('6', 'Books');

INSERT INTO customer (customer_id, name, email_id, phone) VALUES ('1', 'Abhishek Kumar', 'abhishek.chauhan1309@gmail.com', '45443543');
INSERT INTO customer (customer_id, name, email_id, phone) VALUES ('2', 'Rakesh Sharma', 'rakesh@gmail.com', '23543254');

INSERT INTO product(product_id, product_name, unit_price, category_id) VALUES ('1', 'Yoga Mat', '200', '1');
INSERT INTO product(product_id, product_name, unit_price, category_id) VALUES ('2', 'Yonex GR 303 Badminton Racquet', '499', '1');
INSERT INTO product(product_id, product_name, unit_price, category_id) VALUES ('3', 'Cosco Dribble Basket Balls', '780', '1');
INSERT INTO product(product_id, product_name, unit_price, category_id) VALUES ('4', 'Samsung 192 L Refrigirator', '16490', '2');
INSERT INTO product(product_id, product_name, unit_price, category_id) VALUES ('5', 'Bajaj Cooler', '5490', '2');
INSERT INTO product(product_id, product_name, unit_price, category_id) VALUES ('6', 'Wings of Fire', '223', '6');
INSERT INTO product(product_id, product_name, unit_price, category_id) VALUES ('7', 'ELEVEN MINUTES', '198', '6');
INSERT INTO product(product_id, product_name, unit_price, category_id) VALUES ('8', 'Redmi Note 7', '10900', '4');
INSERT INTO product(product_id, product_name, unit_price, category_id) VALUES ('9', 'Samsung M20', '10499', '4');


INSERT INTO promotional_offer (id, category_id, discount_percentage, valid_from, valid_thru) VALUES ('1', '1', '15', '2019-01-01', '2019-06-01');
INSERT INTO promotional_offer (id, category_id, discount_percentage, valid_from, valid_thru) VALUES ('2', '6', '5', '2019-01-01', '2019-06-01');
INSERT INTO promotional_offer (id, category_id, discount_percentage, valid_from, valid_thru) VALUES ('3', '2', '20', '2019-01-01', '2019-06-01');
INSERT INTO promotional_offer (id, category_id, discount_percentage, valid_from, valid_thru) VALUES ('4', '4', '15', '2019-01-01', '2019-06-01');


INSERT INTO sales_tax (id, category_id, sales_tax, valid_from, valid_thru) VALUES ('3', '1', '10', '2019-01-01', '2019-06-01');
INSERT INTO sales_tax (id, category_id, sales_tax, valid_from, valid_thru) VALUES ('4', '6', '20', '2019-01-01', '2019-06-01');


INSERT INTO shopping_detail (transaction_id, customer_id, product_id, quantity, date, status) VALUES ('1233', '1', '2', '2', '2019-04-01', 'PENDING');
INSERT INTO shopping_detail (transaction_id, customer_id, product_id, quantity, date, status) VALUES ('1234', '1', '1', '1', '2019-04-01', 'PENDING');
INSERT INTO shopping_detail (transaction_id, customer_id, product_id, quantity, date, status) VALUES ('1235', '1', '6', '1', '2019-04-01', 'PENDING');
INSERT INTO shopping_detail (transaction_id, customer_id, product_id, quantity, date, status) VALUES ('1236', '1', '7', '1', '2019-04-01', 'PENDING');
INSERT INTO shopping_detail (transaction_id, customer_id, product_id, quantity, date, status) VALUES ('1237', '1', '9', '1', '2019-04-01', 'PENDING');