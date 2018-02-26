-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-02-26 05:19:45.555

-- foreign keys
ALTER TABLE Item
    DROP FOREIGN KEY Item_Store;

ALTER TABLE ListLine
    DROP FOREIGN KEY ListLine_Item;

ALTER TABLE ListLine
    DROP FOREIGN KEY ListLine_ShoppingList;

ALTER TABLE Role
    DROP FOREIGN KEY Role_User;

ALTER TABLE ShoppingList
    DROP FOREIGN KEY ShoppingList_User;

-- tables
DROP TABLE Item;

DROP TABLE ListLine;

DROP TABLE Role;

DROP TABLE ShoppingList;

DROP TABLE Store;

DROP TABLE User;

-- End of file.

