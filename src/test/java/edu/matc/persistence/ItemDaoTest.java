package edu.matc.persistence;

import edu.matc.entity.Item;
import edu.matc.entity.Store;
import edu.matc.entity.User;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * The type Item dao test.
 */
class ItemDaoTest {

    GenericDao itemDao;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {

        itemDao = new GenericDao(Item.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies the gets all items successfuly.
     */
    @Test
    void getAllItemsSuccess() {
        List<Item> items = itemDao.getAll();
        assertEquals(3, items.size());
    }

    /**
     * Verifies a item is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        Store newStore = new Store("Festival Foods", "810 East Washington Ave", "Madison", "WI", "53703");
        GenericDao storeDao = new GenericDao(Store.class);
        storeDao.insert(newStore);
        Item newItem = new Item("Kellogs", "Corn Flakes", "16 oz", "$2.99", "$1.00", "2018-04-30", true, newStore);
        int itemId = itemDao.insert(newItem);
        Item retrievedItem = (Item)itemDao.getById(itemId);
        assertNotNull(retrievedItem);
        assertEquals(newItem, retrievedItem);
    }

    /**
     * Verify successful insert of a item
     */
    @Test
    void insertSuccess() {

        Store newStore = new Store("Festival Foods", "810 East Washington Ave", "Madison", "WI", "53703");
        GenericDao storeDao = new GenericDao(Store.class);
        int id = storeDao.insert(newStore);
        Item newItem = new Item("Kellogs", "Corn Flakes", "16 oz", "$2.99", "$1.00", "2018-04-30", true, newStore);
        int itemId = itemDao.insert(newItem);
        assertNotEquals(0,id);
        Item insertedItem = (Item)itemDao.getById(itemId);
        assertEquals(newItem, insertedItem);
    }

    /**
     * Verify successful delete of an item
     */
    @Test
    void deleteSuccess() {
        itemDao.delete(itemDao.getById(1));
        assertNull(itemDao.getById(1));
    }

    /**
     * Verify successful update of item
     */
    @Test
    void updateSuccess() {
        String newItemBrand = "brand X";
        Item itemToUpdate = (Item)itemDao.getById(1);
        itemToUpdate.setBrand(newItemBrand);
        itemDao.saveOrUpdate(itemToUpdate);
        Item retrievedItem = (Item)itemDao.getById(1);
        assertEquals(itemToUpdate, retrievedItem);
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Item> items = itemDao.getByPropertyEqual("product", "butter");
        assertEquals(1, items.size());
        assertEquals(2, items.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Item> items = itemDao.getByPropertyLike("brand", "Kell");
        assertEquals(1, items.size());
    }
}