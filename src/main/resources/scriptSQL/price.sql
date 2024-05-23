CREATE TABLE "price" (
   id_price SERIAL PRIMARY KEY,
   id_ingredient INT NOT NULL,
   actual_unit_price DOUBLE PRECISION NOT NULL,
   modification_date DATE NOT NULL,
   FOREIGN KEY (id_ingredient) REFERENCES "ingredient"(id_ingredient)
);
