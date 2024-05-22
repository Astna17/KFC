CREATE TABLE "stock_movement" (
      id_stock_movement SERIAL PRIMARY KEY,
      id_ingredient INT NOT NULL,
      movement_date TIMESTAMP NOT NULL,
      movement_type VARCHAR(10) NOT NULL,
      quantity DOUBLE PRECISION NOT NULL,
      id_unity INT NOT NULL,
      FOREIGN KEY (id_ingredient) REFERENCES "ingredient"(id_ingredient),
      FOREIGN KEY (id_unity) REFERENCES "unity"(id_unity)
);
