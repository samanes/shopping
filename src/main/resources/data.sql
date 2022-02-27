INSERT INTO user_info (id, username, first_name, last_name, created_date, last_modified_date) VALUES (1, 'saman', 'Saman', 'Esmi', NOW(), NOW()) ON CONFLICT DO NOTHING;
INSERT INTO user_info (id, username, first_name, last_name, created_date, last_modified_date) VALUES (2, 'peter', 'Peter', 'Young', NOW(), NOW()) ON CONFLICT DO NOTHING;
INSERT INTO shopping_list(id, description, user_id, active, total, created_date, last_modified_date) VALUES (1, 'shopping list 1 description', 1, true, 50, NOW(), NOW()) ON CONFLICT DO NOTHING ;
INSERT INTO shopping_list(id, description, user_id, active, total, created_date, last_modified_date) VALUES (2, 'shopping list 2 description', 1, false, 25, NOW(), NOW()) ON CONFLICT DO NOTHING;
INSERT INTO shopping_item(id, shopping_list_id, product_code, name, description, price, quantity, sub_total, created_date, last_modified_date) VALUES (1, 1, 'CDX03', 'item 1', 'item 1 description', 20, 1, 20, NOW(), NOW()) ON CONFLICT DO NOTHING;
INSERT INTO shopping_item(id, shopping_list_id, product_code, name, description, price, quantity, sub_total, created_date, last_modified_date) VALUES (2, 1, 'P1X093', 'item 2', 'item 2 description', 15, 2, 30, NOW(), NOW()) ON CONFLICT DO NOTHING;
INSERT INTO shopping_item(id, shopping_list_id, product_code, name, description, price, quantity, sub_total, created_date, last_modified_date) VALUES (3, 2, 'P1X012', 'item 3', 'item 3 description', 25, 1, 25, NOW(), NOW()) ON CONFLICT DO NOTHING;

