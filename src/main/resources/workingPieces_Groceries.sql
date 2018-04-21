drop table listline;
drop table shoppinglist;
drop table role;
drop table user;
drop table item;
drop table store;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `email` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `address1` varchar(120) DEFAULT NULL,
  `address2` varchar(120) DEFAULT NULL,
  `city` varchar(120) DEFAULT NULL,
  `state` varchar(2) DEFAULT NULL,
  `postalCode` varchar(16) DEFAULT NULL,
  `lat` decimal(9,6) DEFAULT NULL,
  `lon` decimal(9,6) DEFAULT NULL,
  `updateDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP  ON UPDATE CURRENT_TIMESTAMP,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `name` varchar(120) NOT NULL,
  `updateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `username` varchar(255) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Role_User` (`username`),
  KEY `role_user_id_fk` (`user_id`),
  CONSTRAINT `role_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
CREATE TABLE `shoppinglist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `totalAmount` decimal(4,2) NOT NULL,
  `updateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ShoppingList_User` (`user_id`),
  CONSTRAINT `ShoppingList_User` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `store` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `name` varchar(120) NOT NULL,
  `address1` varchar(120) NOT NULL,
  `address2` varchar(120) DEFAULT NULL,
  `city` varchar(120) NOT NULL,
  `state` varchar(2) NOT NULL,
  `postalCode` varchar(16) NOT NULL,
  `lat` decimal(9,6) DEFAULT NULL,
  `lon` decimal(9,6) DEFAULT NULL,
  `updateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `brand` varchar(120) NOT NULL,
  `category` varchar(120) DEFAULT NULL,
  `product` varchar(255) NOT NULL,
  `size` varchar(120) NOT NULL,
  `salePrice` varchar(255) NOT NULL,
  `savingsAmount` varchar(255) NOT NULL,
  `saleStartDate` varchar(255) DEFAULT NULL,
  `saleEndDate` varchar(255) NOT NULL,
  `updateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `store_id` int(11) NOT NULL,
  `active` TINYINT(4) DEFAULT 1,
  PRIMARY KEY (`id`),
  KEY `Item_Store` (`store_id`),
  CONSTRAINT `Item_Store` FOREIGN KEY (`store_id`) REFERENCES `store` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `listline` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `quantity` int(3) NOT NULL,
  `updateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `shoppinglist_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ListLine_Item` (`item_id`),
  KEY `ListLine_ShoppingList` (`shoppinglist_id`),
  CONSTRAINT `ListLine_Item` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`),
  CONSTRAINT `ListLine_ShoppingList` FOREIGN KEY (`shoppinglist_id`) REFERENCES `shoppinglist` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO user (id, email, password, address1, city, state, postalCode, username) VALUES (1, 'rbruinsma@madisoncollege.edu', 'supersecret1', '1701 Wright St.', 'Madison', 'WI', '53704', 'rbruinsma'), (2, 'testUser@madisoncollege.edu', 'supersecret2', '1701 Wright St.', 'Madison', 'WI', '53704', 'testUser'), (3, 'testUser2@madisoncollege.edu',  'supersecret3', '211 N. Carroll St.', 'Madison', 'WI', '53703', 'testUser2');
insert into role (id, name, username, user_id) values (1, 'admin', 'rbruinsma', 1);
insert into shoppinglist (id, totalAmount, user_id) VALUES (1, 4.99, 1), (2, 7.98, 1);
INSERT INTO store (id, name, address1, city, state, postalCode, lat, lon, updateDate) VALUES (1, 'Hy-Vee', '3801 East Washington Avenue', 'Madison', 'WI', '53704', 43.117807, -89.317387, '2018-03-20 07:25:03'), (2, 'Willy Street Co-op', '2817 North Sherman Ave', 'Madison', 'WI', '53704', 43.127639, -89.362807, '2018-03-20 07:25:03');
INSERT INTO item (id, brand, product, size, salePrice, savingsAmount, saleEndDate, store_id) VALUES (1, 'Kellogs', 'Cream of Wheat', '10 oz', '$1.99', '$1.00', '2018-04-30', 2), (2, 'Organic Valley', 'butter', '1 lb', '$3.99', '$1.50', '2018-04-30', 2), (3, 'Organic Valley', 'milk', '1 gal', '$4.99', '$1.00', '2018-04-30', 2);
insert into listline (id, quantity, shoppinglist_id, item_id) VALUES (1, 1, 1, 3), (3, 2, 2, 2);