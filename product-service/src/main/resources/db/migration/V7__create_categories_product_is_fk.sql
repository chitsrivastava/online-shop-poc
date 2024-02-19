
ALTER TABLE products
  ADD CONSTRAINT fk1_assign FOREIGN KEY (category_id) REFERENCES categories (category_id);
