CREATE DATABASE demo;
use demo;
CREATE TABLE products (
Id INT PRIMARY KEY AUTO_INCREMENT,
product_code VARCHAR(50) NOT NULL,
product_name VARCHAR(255) NOT NULL,
product_price DECIMAL(10,2) NOT NULL,
product_amount INT NOT NULL,
product_description TEXT,
product_status INT NOT NULL
);

INSERT INTO products (product_code, product_name, product_price, product_amount, product_description, product_status)
VALUES
('P001', 'Product 1', 10.50, 100, 'This is product 1', 1),
('P002', 'Product 2', 20.00, 50, 'This is product 2', 1),
('P003', 'Product 3', 15.75, 75, 'This is product 3', 0),
('P004', 'Product 4', 5.99, 200, 'This is product 4', 1),
('P005', 'Product 5', 12.50, 150, 'This is product 5', 0);

select *from products;


CREATE UNIQUE INDEX idx_product_code ON products (product_code);

CREATE INDEX idx_product_name_price ON products (product_name, product_price);

EXPLAIN SELECT *
FROM products 
WHERE product_code = 'P003';

CREATE OR REPLACE VIEW thong_tin_san_pham
AS
	SELECT product_code, product_name, product_price, product_status
    FROM products;

SELECT *
FROM thong_tin_san_pham;

-- sửa view 
UPDATE thong_tin_san_pham
SET product_name = "Áo"
WHERE product_code = "P001";

-- xóa view
DROP view thong_tin_san_pham;

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
DELIMITER $$ 
CREATE PROCEDURE show_info()
	BEGIN 
		SELECT *
        FROM products;
    END $$
DELIMITER ;
CALL show_info();

-- Tạo store procedure thêm một sản phẩm mới
DELIMITER $$ 
CREATE PROCEDURE update_info(in `code` varchar(50), in `name` varchar(255) , in `price` decimal(10,2), in `amount` int, in `description` text, in `status` int)
	BEGIN 
		INSERT INTO products ( product_code , product_name, product_price, product_amount, product_description, product_status)
		VALUES ( `code` , `name` , `price`, `amount`, `description` , `status` );
    END $$
DELIMITER ;

CALL update_info('P006', 'Product 6', 11.50, 10, 'This is product 6', 1);

-- Tạo store procedure sửa thông tin sản phẩm theo id
DELIMITER $$ 
CREATE PROCEDURE update_info_byId(in idpr int, in `code` varchar(50), in `name` varchar(255) , in `price` decimal(10,2), in `amount` int, in `description` text, in `status` int)
	BEGIN 
		UPDATE products
        SET product_code = `code` ,
			product_name = `name` ,
			product_price = `price` ,
			product_amount = `amount` ,
			product_description = `description` ,
			product_status = `status`
		WHERE Id = idpr;
    END $$
DELIMITER ;

CALL update_info_byId(6,'P007', 'Product 7', 11.50, 10, 'This is product 6', 1);

-- Tạo store procedure xoá sản phẩm theo id
DELIMITER $$ 
CREATE PROCEDURE delete_info_byId(in idpr int)
	BEGIN 
		DELETE FROM  products
		WHERE Id = idpr;
    END $$
DELIMITER ;
CALL delete_info_byId(1);


