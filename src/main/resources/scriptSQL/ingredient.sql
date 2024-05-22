CREATE TABLE "ingredient" (
    id_ingredient SERIAL PRIMARY KEY,
    ingredient_name VARCHAR(100) NOT NULL,
    stock DOUBLE PRECISION NOT NULL
);
