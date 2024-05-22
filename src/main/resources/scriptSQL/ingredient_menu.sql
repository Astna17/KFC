CREATE TABLE "ingredient_menu" (
      id_ingredient_menu SERIAL PRIMARY KEY,
      id_menu INT NOT NULL,
      id_ingredient INT NOT NULL,
      quantity_required DOUBLE PRECISION NOT NULL,
      id_unity INT NOT NULL,
      FOREIGN KEY (id_menu) REFERENCES menu(id_menu),
      FOREIGN KEY (id_ingredient) REFERENCES ingredient(id_ingredient),
      FOREIGN KEY (id_unity) REFERENCES unity(id_unity)
);
