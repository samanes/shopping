INSERT INTO user_info (id, username, first_name, last_name, created_date, last_modified_date) VALUES (1, 'saman', 'Saman', 'Esmi', NOW(), NOW()) ON CONFLICT DO NOTHING;
INSERT INTO user_info (id, username, first_name, last_name, created_date, last_modified_date) VALUES (2, 'peter', 'Peter', 'Young', NOW(), NOW()) ON CONFLICT DO NOTHING;
INSERT INTO shopping_list(id, description, user_id, active, total, created_date, last_modified_date) VALUES (1, 'shopping list 1 description', 1, true, 50, NOW(), NOW()) ON CONFLICT DO NOTHING;
INSERT INTO shopping_list(id, description, user_id, active, total, created_date, last_modified_date) VALUES (2, 'shopping list 2 description', 1, false, 25, NOW(), NOW()) ON CONFLICT DO NOTHING;
INSERT INTO product(id, name, description, created_date, last_modified_date) VALUES (1, 'product 1', 'product 1 description', NOW(), NOW()) ON CONFLICT DO NOTHING;
INSERT INTO product(id, name, description, created_date, last_modified_date) VALUES (2, 'product 2', 'product 2 description', NOW(), NOW()) ON CONFLICT DO NOTHING;
INSERT INTO product(id, name, description, created_date, last_modified_date) VALUES (3, 'product 3', 'product 3 description', NOW(), NOW()) ON CONFLICT DO NOTHING;
INSERT INTO product(id, name, description, created_date, last_modified_date) VALUES (4, 'product 4', 'product 4 description', NOW(), NOW()) ON CONFLICT DO NOTHING;
INSERT INTO product(id, name, description, created_date, last_modified_date) VALUES (5, 'product 5', 'product 5 description', NOW(), NOW()) ON CONFLICT DO NOTHING;
INSERT INTO shopping_item(id, shopping_list_id, product_id, price, quantity, sub_total, created_date, last_modified_date) VALUES (1, 1, 1, 20, 1, 20, NOW(), NOW()) ON CONFLICT DO NOTHING;
INSERT INTO shopping_item(id, shopping_list_id, product_id, price, quantity, sub_total, created_date, last_modified_date) VALUES (2, 1, 2, 15, 2, 30, NOW(), NOW()) ON CONFLICT DO NOTHING;
INSERT INTO shopping_item(id, shopping_list_id, product_id, price, quantity, sub_total, created_date, last_modified_date) VALUES (3, 2, 3, 25, 1, 25, NOW(), NOW()) ON CONFLICT DO NOTHING;

