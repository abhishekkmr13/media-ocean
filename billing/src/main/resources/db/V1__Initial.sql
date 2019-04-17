CREATE TABLE IF NOT EXISTS category (
  	category_id INT NOT NULL AUTO_INCREMENT,
  	category_name VARCHAR(128) NOT NULL,
  	PRIMARY KEY (category_id)
);
  
CREATE TABLE IF NOT EXISTS product (
  	product_id INT NOT NULL AUTO_INCREMENT,
  	product_name VARCHAR(128) NULL,
  	unit_price DECIMAL(8,2) NULL,
  	category_id INT NULL,
  	PRIMARY KEY (product_id),
  	CONSTRAINT product_category
    	FOREIGN KEY (category_id)
    	REFERENCES category (category_id)
);

CREATE TABLE IF NOT EXISTS customer (
	customer_id INT NOT NULL AUTO_INCREMENT,
  	name VARCHAR(128) NULL,
   	email_id VARCHAR(128) NULL,
  	phone INT NULL,
  	PRIMARY KEY (customer_id)
);
  
CREATE TABLE IF NOT EXISTS shopping_detail (
  	transaction_id INT NOT NULL AUTO_INCREMENT,
  	customer_id INT NOT NULL,
  	product_id INT NOT NULL,
  	quantity INT NOT NULL,
  	date DATE NOT NULL,
  	status VARCHAR(64) NOT NULL,
  	PRIMARY KEY (transaction_id)
);
  
CREATE TABLE IF NOT EXISTS promotional_offer (
  	id INT NOT NULL AUTO_INCREMENT,
  	category_id INT NULL,
  	discount_percentage INT NULL,
  	valid_from DATE NULL,
  	valid_thru DATE NULL,
  	PRIMARY KEY (id),
  	CONSTRAINT promotional_cat
    FOREIGN KEY (category_id)
    REFERENCES category (category_id)
 );
 
 CREATE TABLE IF NOT EXISTS sales_tax (
  	id INT NOT NULL AUTO_INCREMENT,
  	category_id INT NULL,
  	sales_tax INT NULL,
  	valid_from DATE NULL,
  	valid_thru DATE NULL,
  	PRIMARY KEY (id),
  	CONSTRAINT salestax_cat
    FOREIGN KEY (category_id)
    REFERENCES category (category_id)
 );
