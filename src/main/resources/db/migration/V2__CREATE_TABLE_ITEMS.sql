CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE IF NOT EXISTS ITEMS (
    iditem UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    model VARCHAR(255),
    brand VARCHAR(255),
    averagePrice DECIMAL(10, 2),
    category VARCHAR(255),
    rating VARCHAR(10),
    reviewCount VARCHAR(10),
    weight VARCHAR(50)
);
