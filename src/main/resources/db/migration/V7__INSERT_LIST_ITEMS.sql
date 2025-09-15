-- V7__INSERT_LIST_ITEMS
-- Inserindo itens na lista dos usuários
-- Os IDs de usuário e item são obtidos via SELECT, evitando conflitos de UUID

INSERT INTO list_items (iduser, iditem, quantity, added_at)
SELECT u.iduser, i.iditem, 1, NOW()
FROM users u, items i
WHERE u.email = 'admin@email.com' AND i.name IN ('Notebook Dell XPS', 'iPhone 15 Pro', 'Smart TV 55"');

INSERT INTO list_items (iduser, iditem, quantity, added_at)
SELECT u.iduser, i.iditem, 1, NOW()
FROM users u, items i
WHERE u.email = 'john.doe@email.com' AND i.name IN ('Livro Clean Code', 'Headphone Sony', 'Mouse Logitech');

INSERT INTO list_items (iduser, iditem, quantity, added_at)
SELECT u.iduser, i.iditem, 1, NOW()
FROM users u, items i
WHERE u.email = 'jane.smith@email.com' AND i.name IN ('Livro Clean Code', 'Domain-Driven Design', 'Cadeira Gamer');

INSERT INTO list_items (iduser, iditem, quantity, added_at)
SELECT u.iduser, i.iditem, 1, NOW()
FROM users u, items i
WHERE u.email = 'bob.wilson@email.com' AND i.name IN ('Mesa Escritório', 'Teclado Mecânico');

INSERT INTO list_items (iduser, iditem, quantity, added_at)
SELECT u.iduser, i.iditem, 1, NOW()
FROM users u, items i
WHERE u.email = 'alice.brown@email.com' AND i.name IN ('Livro Clean Code', 'Headphone Sony');
