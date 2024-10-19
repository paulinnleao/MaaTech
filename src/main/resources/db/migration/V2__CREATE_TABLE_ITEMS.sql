CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE ITEMS (
    idItem UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL,
    description TEXT,
    model VARCHAR(255),
    brand VARCHAR(255),
    avaragePrice DECIMAL(10, 2),
    category VARCHAR(255),
    rating VARCHAR(10),
    reviewCount VARCHAR(10),
    weight VARCHAR(50)
);
