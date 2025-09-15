-- Inserindo usuários de exemplo (senha: "senha123" encrypted with BCrypt)
INSERT INTO users (iduser, name, email, password, role) VALUES
('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Admin User', 'admin@email.com', '$2a$10$TKh8H1.PfQx37YgCzwiKb.KjNyWgaHb9cbcoQgdIVFlYg7B77UdFm', 'ADMIN'),
('b1eebc99-9c0b-4ef8-bb6d-6bb9bd380a12', 'John Doe', 'john.doe@email.com', '$2a$10$TKh8H1.PfQx37YgCzwiKb.KjNyWgaHb9cbcoQgdIVFlYg7B77UdFm', 'USER'),
('c2eebc99-9c0b-4ef8-bb6d-6bb9bd380a13', 'Jane Smith', 'jane.smith@email.com', '$2a$10$TKh8H1.PfQx37YgCzwiKb.KjNyWgaHb9cbcoQgdIVFlYg7B77UdFm', 'USER'),
('d3eebc99-9c0b-4ef8-bb6d-6bb9bd380a14', 'Bob Wilson', 'bob.wilson@email.com', '$2a$10$TKh8H1.PfQx37YgCzwiKb.KjNyWgaHb9cbcoQgdIVFlYg7B77UdFm', 'USER'),
('e4eebc99-9c0b-4ef8-bb6d-6bb9bd380a15', 'Alice Brown', 'alice.brown@email.com', '$2a$10$TKh8H1.PfQx37YgCzwiKb.KjNyWgaHb9cbcoQgdIVFlYg7B77UdFm', 'USER');