DROP TABLE product;
CREATE TABLE product(id BIGINT NOT NULL AUTO_INCREMENT, name VARCHAR(255), price NUMERIC, PRIMARY KEY (id));
INSERT INTO product VALUES(1, 'producto1', 100.00);