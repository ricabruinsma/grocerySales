-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-02-26 05:19:45.555

-- tables
-- Table: Item
CREATE TABLE Item (
    id int(11) NOT NULL AUTO_INCREMENT,
    createDate timestamp NOT NULL,
    name varchar(120) NOT NULL,
    description varchar(255) NULL,
    size varchar(120) NULL,
    price decimal(4,2) NOT NULL,
    saleStart date NOT NULL,
    saleEnd date NOT NULL,
    updateDate timestamp NOT NULL,
    store_id int(11) NOT NULL,
    CONSTRAINT id PRIMARY KEY (id)
);

-- Table: ListLine
CREATE TABLE ListLine (
    id int(11) NOT NULL AUTO_INCREMENT,
    createDate timestamp NOT NULL,
    quantity int(3) NOT NULL,
    updateDate timestamp NOT NULL,
    shoppinglist_id int(11) NOT NULL,
    item_id int(11) NOT NULL,
    CONSTRAINT ListLine_pk PRIMARY KEY (id)
);

-- Table: Role
CREATE TABLE Role (
    id int(11) NOT NULL AUTO_INCREMENT,
    createDate timestamp NOT NULL,
    name varchar(120) NOT NULL,
    updateDate timestamp NOT NULL,
    username varchar(255) NOT NULL,
    CONSTRAINT Role_pk PRIMARY KEY (id)
);

-- Table: ShoppingList
CREATE TABLE ShoppingList (
    id int(11) NOT NULL AUTO_INCREMENT,
    createDate timestamp NOT NULL,
    totalAmount decimal(4,2) NOT NULL,
    updateDate timestamp NOT NULL,
    user_id int(11) NOT NULL,
    CONSTRAINT ShoppingList_pk PRIMARY KEY (id)
);

-- Table: Store
CREATE TABLE Store (
    id int(11) NOT NULL AUTO_INCREMENT,
    createDate timestamp NOT NULL,
    name varchar(120) NOT NULL,
    address1 varchar(120) NOT NULL,
    address2 varchar(120) NULL,
    city varchar(120) NOT NULL,
    state varchar(2) NOT NULL,
    postalCode varchar(16) NOT NULL,
    lat decimal(9,6) NOT NULL,
    lon decimal(9,6) NOT NULL,
    updateDate timestamp NOT NULL,
    CONSTRAINT Store_pk PRIMARY KEY (id)
);

-- Table: User
CREATE TABLE User (
    id int(11) NOT NULL AUTO_INCREMENT,
    createDate timestamp NOT NULL,
    email varchar(255) NULL,
    firstName varchar(255) NULL,
    password varchar(255) NOT NULL,
    address1 varchar(120) NULL,
    address2 varchar(120) NULL,
    city varchar(120) NULL,
    state varchar(2) NULL,
    postalCode varchar(16) NULL,
    lat decimal(9,6) NULL,
    lon decimal(9,6) NULL,
    updateDate timestamp NOT NULL,
    username varchar(255) NULL,
    UNIQUE INDEX username (username),
    CONSTRAINT User_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: Item_Store (table: Item)
ALTER TABLE Item ADD CONSTRAINT Item_Store FOREIGN KEY Item_Store (store_id)
    REFERENCES Store (id);

-- Reference: ListLine_Item (table: ListLine)
ALTER TABLE ListLine ADD CONSTRAINT ListLine_Item FOREIGN KEY ListLine_Item (item_id)
    REFERENCES Item (id);

-- Reference: ListLine_ShoppingList (table: ListLine)
ALTER TABLE ListLine ADD CONSTRAINT ListLine_ShoppingList FOREIGN KEY ListLine_ShoppingList (shoppinglist_id)
    REFERENCES ShoppingList (id);

-- Reference: Role_User (table: Role)
ALTER TABLE Role ADD CONSTRAINT Role_User FOREIGN KEY Role_User (username)
    REFERENCES User (username);

-- Reference: ShoppingList_User (table: ShoppingList)
ALTER TABLE ShoppingList ADD CONSTRAINT ShoppingList_User FOREIGN KEY ShoppingList_User (user_id)
    REFERENCES User (id);

-- End of file.

