CREATE TABLE "ingredient_price_history" (
     id_price SERIAL PRIMARY KEY,
     id_ingredient INT NOT NULL,
     unit_price DOUBLE PRECISION NOT NULL,
     start_date TIMESTAMP NOT NULL,
     end_date TIMESTAMP,
     FOREIGN KEY (id_ingredient) REFERENCES "ingredient"(id_ingredient)
);
