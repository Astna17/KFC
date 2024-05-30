CREATE TABLE "sale" (
     id_sale SERIAL PRIMARY KEY,
     id_menu INT NOT NULL,
     id_restaurant INT NOT NULL,
     sale_date TIMESTAMP NOT NULL,
     quantity DOUBLE PRECISION NOT NULL,
     total_amount DOUBLE PRECISION NOT NULL,
     FOREIGN KEY (id_menu) REFERENCES "menu"(id_menu),
     FOREIGN KEY (id_restaurant) REFERENCES "restaurant"(id_restaurant)
);
