CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    image_url JSON,
    price FLOAT,
    display_price FLOAT
);

CREATE TABLE inventory (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT,
    quantity INT,
    is_empty BOOLEAN,
    FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE TABLE category (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT,
    name VARCHAR(255),
    FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email_id VARCHAR(255),
    role ENUM('admin', 'user'),
    password VARCHAR(255)
);
