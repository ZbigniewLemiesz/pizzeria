create schema pizzadb;

CREATE TABLE IF NOT EXISTS  clients (
  id int NOT NULL AUTO_INCREMENT,
  username varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  password varchar(45) DEFAULT NULL,
  PRIMARY KEY (id)
) ;

INSERT INTO clients VALUES (1,'Jack','jack@gmail.com','123123'),(2,'Ann','ann@gmail.com','123123');


CREATE TABLE IF NOT EXISTS orders (
  id int NOT NULL AUTO_INCREMENT,
  status varchar(45) DEFAULT NULL, 
  createdAt datetime DEFAULT NULL,
  client_id int NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (client_id) REFERENCES clients (id)
);

INSERT INTO orders VALUES (1,'new','2020-01-01 10:10:10',1),(2,'new','2021-01-01 10:10:10',2);



CREATE TABLE IF NOT EXISTS products (
  id bigint NOT NULL,
  name varchar(255) DEFAULT NULL,
  description varchar(255) DEFAULT NULL,
  price decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (id)
);

INSERT INTO products VALUES (1,'Meal1','Lorem ipsum meal1',1.01),(2,'Meal2','Lorem ipsum meal2',2.03),(3,'Meal3','Lorem ipsum meal2',3.05);


CREATE TABLE IF NOT EXISTS orders_products (
  order_id int NOT NULL,
  product_id bigint NOT NULL,
  quantity int DEFAULT NULL,
  PRIMARY KEY (order_id,product_id),
  FOREIGN KEY (order_id) REFERENCES orders (id),
  FOREIGN KEY (product_id) REFERENCES products (id)
);

INSERT INTO orders_products VALUES (1,1,1),(1,2,2),(1,3,3),(2,2,2);






