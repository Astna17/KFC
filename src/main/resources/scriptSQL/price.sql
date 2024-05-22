CREATE TABLE "price" (
   id_price SERIAL PRIMARY KEY,
   id_menu INT NOT NULL,
   actual_unit_price DOUBLE PRECISION NOT NULL,
   modification_date DATE NOT NULL,
   FOREIGN KEY (id_menu) REFERENCES "menu"(id_menu)
);
