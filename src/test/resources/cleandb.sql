delete from role;
delete from listline;
delete from shoppinglist;
delete from user;
delete from item;
delete from store;
INSERT INTO user (id, email, password, address1, city, state, postalCode, lat, lon, updateDate, username) VALUES (1, 'rbruinsma@madisoncollege.edu', 'supersecret1', '1701 Wright St.', 'Madison', 'WI', '53704', 43.121716, -89.328584, '2018-03-20 20:16:05', 'rbruinsma'), (2, 'testUser@madisoncollege.edu', 'supersecret2', '1701 Wright St.', 'Madison', 'WI', '53704', 43.121716, -89.328584, '2018-03-20 20:16:05', 'testUser'), (3, 'testUser2@madisoncollege.edu',  'supersecret3', '211 N. Carroll St.', 'Madison', 'WI', '53703', 43.121716, -89.328584, '2018-03-20 20:16:05', 'testUser2');
insert into role (id, name, updateDate, username, user_id) values (1, 'admin', '2018-03-20 20:16:05', 'rbruinsma', 1);
INSERT INTO store VALUES (1, '2018-03-20 07:25:03', 'Hy-Vee', '3801 East Washington Avenue', NULL, 'Madison', 'WI', '53704', 43.117807, -89.317387, '2018-03-20 07:25:03'), (2, '2018-03-20 07:25:03', 'Willy Street Co-op', '2817 North Sherman Ave', NULL, 'Madison', 'WI', '53704', 43.127639, -89.362807, '2018-03-20 07:25:03');