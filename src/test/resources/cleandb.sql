delete from role;
delete from user;
INSERT INTO user (id, email, password, address1, city, state, postalCode, username) VALUES (1, 'rbruinsma@madisoncollege.edu', 'supersecret1', '1701 Wright St.', 'Madison', 'WI', '53704', 'rbruinsma'), (2, 'testUser@madisoncollege.edu', 'supersecret2', '1701 Wright St.', 'Madison', 'WI', '53704', 'testUser'), (3, 'testUser2@madisoncollege.edu',  'supersecret3', '211 N. Carroll St.', 'Madison', 'WI', '53703', 'testUser2');
insert into role (id, name, username, user_id) values (1, 'admin', 'rbruinsma', 1);