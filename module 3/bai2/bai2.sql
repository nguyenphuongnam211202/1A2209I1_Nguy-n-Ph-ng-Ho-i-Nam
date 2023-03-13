CREATE DATABASE quan_ly_ban_hang;
Use quan_ly_ban_hang;
Create table customer(
	id int not null auto_increment primary key,
	`name` varchar(50) not null,
	age int not null
);
Create table `order`(
	id int not null auto_increment primary key,
    `date` datetime not null,
    total_price int not null,
    customer_id int,
    Foreign key (customer_id) references customer (id)
);
Create table product(
	id int not null auto_increment primary key,
    `name` varchar(50) not null,
    price int not null
);
Create table order_detail(
	order_id int,
    Foreign key(order_id) references `order`(id),
    product_id int,
    Foreign key(product_id) references product(id)
);
