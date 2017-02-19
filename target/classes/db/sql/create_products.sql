CREATE TABLE products (
id INTEGER NOT NULL PRIMARY KEY,
description VARCHAR(255),
price DECIMAL(15, 2)
);
CREATE INDEX products_description ON products(description);