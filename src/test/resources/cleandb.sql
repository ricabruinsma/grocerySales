delete from role;
delete from listline;
delete from shoppinglist;
delete from user;
delete from item;
delete from store;
delete from category;
INSERT INTO user (id, email, password, address1, city, state, postalCode, lat, lon, username) VALUES (1, 'rbruinsma@madisoncollege.edu', 'supersecret1', '1701 Wright St.', 'Madison', 'WI', '53704', 43.121716, -89.328584,  'rbruinsma'), (2, 'testUser@madisoncollege.edu', 'supersecret2', '1701 Wright St.', 'Madison', 'WI', '53704', 43.121716, -89.328584,  'testUser'), (3, 'testUser2@madisoncollege.edu',  'supersecret3', '211 N. Carroll St.', 'Madison', 'WI', '53703', 43.121716, -89.328584,  'testUser2');
insert into role (id, name, username, user_id) values (1, 'admin', 'rbruinsma', 1), (2, 'shopper', 'testUser', 2), (3, 'shopper', 'testUser2', 3);
insert into shoppinglist (id, totalAmount, user_id) VALUES (1, 4.99, 1), (2, 7.98, 1), (3, 4.99, 1);
INSERT INTO store (id, name, address1, city, state, postalCode, lat, lon) VALUES (1, 'Hy-Vee', '3801 East Washington Avenue', 'Madison', 'WI', '53704', 43.117807, -89.317387), (2, 'Willy Street Co-op', '2817 North Sherman Ave', 'Madison', 'WI', '53704', 43.127639, -89.362807);
INSERT INTO category (id, name) VALUES (1, 'beer & wine'), (2, 'body care'), (3, 'bread'), (4, 'frozen foods'), (5, 'bulk'), (6, 'cheese'), (7, 'meat'), (8, 'packaged grocery'), (9, 'refrigerated grocery'), (10, 'wellness');
INSERT INTO item (id, brand, category_id, product, size, salePrice, savingsAmount, saleEndDate, store_id) VALUES (1, 'Kellogs', 8, 'Cream of Wheat', '10 oz', '$1.99', '$1.00', '2018-04-30', 2), (2, 'Organic Valley', 9,  'butter', '1 lb', '$3.99', '$1.50', '2018-04-30', 2), (3, 'Organic Valley', 9, 'milk', '1 gal', '$4.99', '$1.00', '2018-04-30', 2);
insert into listline (id, quantity, shoppinglist_id, item_id) VALUES (1, 2, 2, 2), (2, 1, 3, 3);