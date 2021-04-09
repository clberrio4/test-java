CREATE TABLE IF NOT EXISTS customers (
    id int NOT NULL AUTO_INCREMENT,
    document varchar(15) NOT NULL,
    name varchar(80)NOT NULL,
    email varchar(50) NOT NULL,
    password varchar(512) NOT NULL,
    created_At TIMESTAMP DEFAULT Now(),
	updated_At TIMESTAMP DEFAULT Now() ON UPDATE Now(),
    CONSTRAINT PK_Customer PRIMARY KEY(id),
    CONSTRAINT UQ_email_customer UNIQUE(email),
    CONSTRAINT UQ_document_customer UNIQUE(document)  
);

CREATE TABLE IF NOT EXISTS customer_info(
    id int NOT NULL AUTO_INCREMENT,
    address varchar(80) NOT NULL,
    phone varchar(80),
    customer_id int,
    created_At TIMESTAMP DEFAULT Now(),
	updated_At TIMESTAMP DEFAULT Now() ON UPDATE Now(),
    CONSTRAINT PK_customer_info PRIMARY KEY (id),
    CONSTRAINT FK_Customer_customer_info FOREIGN KEY(customer_id) REFERENCES customers(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS products(
    id int NOT NULL AUTO_INCREMENT,
    code varchar(80) NOT NULL,
    name varchar(100) NOT NULL,
    description varchar(512) NULL,
    price decimal(13,2) NOT NULL,
    stock int NOT NULL, created_At TIMESTAMP DEFAULT Now(),
	updated_At TIMESTAMP DEFAULT Now() ON UPDATE Now(),
    CONSTRAINT PK_Product PRIMARY KEY(id),
    CONSTRAINT UQ_Product_Code UNIQUE(code) 
);

CREATE TABLE IF NOT EXISTS order_status(
    id int NOT NULL AUTO_INCREMENT,
    status varchar(80) NOT NULL,
    description varchar(512) NULL,
    created_At TIMESTAMP DEFAULT Now(),
	updated_At TIMESTAMP DEFAULT Now() ON UPDATE Now(),
    CONSTRAINT PK_order_status PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS orders(
    id int NOT NULL AUTO_INCREMENT,
    customer_id int NOT NULL,
    code varchar(100) NOT NULL,
    iva decimal(4,2) NOT NULL,
    sub_total decimal(15,2) ,
    total decimal(17,2) ,
    delivery_price decimal(7,2) NOT NULL,
    order_status int  NOT NULL,
    created_At TIMESTAMP DEFAULT Now(),
	updated_At TIMESTAMP DEFAULT Now() ON UPDATE Now(),
    CONSTRAINT PK_Order PRIMARY KEY(id),
    CONSTRAINT UQ_OrderCode UNIQUE(code),
    CONSTRAINT FK_Customer_Order FOREIGN KEY(customer_id) REFERENCES customers(id) ON DELETE CASCADE,
    CONSTRAINT FK_order_status_Order FOREIGN KEY(order_status) REFERENCES order_status(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS order_details(
    order_id int,
    product_id int NOT NULL,
    quantity int NOT NULL,
    CONSTRAINT PK_OrderDetail  PRIMARY KEY(order_id,product_id),
    CONSTRAINT FK_Order FOREIGN KEY (order_id) REFERENCES orders(id),
    CONSTRAINT FK_Product_Order_Detail FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE
);

INSERT INTO products (code,name,stock,price) values('a1','Smart phone',5000,4000),('a2','Republic gamer',6000,12000000),('a5','Macbook pro',600,15700000),('a231','iphone 12',6060,1500000),('a109','Huawei',6060,1500000);

INSERT INTO customers (document,name,email,password) values('029223','Cesar berrio','clberrio4@gmail.com','Dev213'),('29223','Carlos capintero','carlos@gmail.com','Dev213'),('980193804','carmino capintero','camino@gmail.com','Dev213');

INSERT INTO customer_info (phone,address,customer_id)values('3157609809','cr 23 #106b 145',1),('3157609509','cr 23 #106b 144',2),('3127609809','cr 25 #103b 145',3),('3207609809','cr 25 #100b 145',1);

INSERT  INTO order_status(status)values("paid out"),("without paying"),("canceled");

INSERT  INTO orders(code,customer_id,delivery_price,iva,order_status) values('O123',1,6000,19,1),('O1d3',3,9000,19,1),('O163',1,7000,19,2),('O183',2,12000,19,1);

INSERT INTO order_details (order_id,product_id,quantity) values(1,2,100),(1,3,20),(2,2,2),(4,2,4),(3,2,10),(3,3,10),(2,1,2);
