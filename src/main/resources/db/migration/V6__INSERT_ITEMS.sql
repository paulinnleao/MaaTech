-- V6__INSERT_ITEMS
-- Inserindo itens de exemplo sem informar o ID (UUID será gerado automaticamente)
INSERT INTO items (name, description, model, brand, averagePrice, category, rating, reviewCount, weight) VALUES
    ('Notebook Dell XPS', 'Notebook premium com 16GB RAM, SSD 512GB', 'XPS 13', 'Dell', 4500.00, 'ELECTRONICS', '4.8', '1250', '1.2kg'),
    ('iPhone 15 Pro', 'Smartphone Apple com câmera avançada', 'iPhone 15 Pro', 'Apple', 5999.00, 'ELECTRONICS', '4.9', '980', '0.2kg'),
    ('Livro Clean Code', 'Livro sobre boas práticas de programação', '1ª Edição', 'Pearson', 89.90, 'BOOKS', '4.7', '350', '0.8kg'),
    ('Cadeira Gamer', 'Cadeira ergonômica para gamers', 'Pro Gamer', 'DX Racer', 1200.00, 'FURNITURE', '4.5', '420', '25kg'),
    ('Smart TV 55"', 'TV LED 4K com Smart TV', 'QLED 55"', 'Samsung', 2899.00, 'ELECTRONICS', '4.6', '670', '15kg'),
    ('Headphone Sony', 'Fone de ouvido wireless com noise cancellation', 'WH-1000XM4', 'Sony', 899.00, 'ELECTRONICS', '4.8', '890', '0.3kg'),
    ('Mesa Escritório', 'Mesa de madeira para escritório', 'Executive', 'Ikea', 450.00, 'FURNITURE', '4.4', '230', '18kg'),
    ('Domain-Driven Design', 'Livro sobre DDD por Eric Evans', '1ª Edição', 'Addison-Wesley', 120.00, 'BOOKS', '4.9', '510', '0.9kg'),
    ('Mouse Logitech', 'Mouse wireless com ergonomia avançada', 'MX Master 3', 'Logitech', 250.00, 'ELECTRONICS', '4.7', '720', '0.14kg'),
    ('Teclado Mecânico', 'Teclado mecânico RGB switches blue', 'K95 RGB', 'Corsair', 380.00, 'ELECTRONICS', '4.6', '380', '1.1kg');