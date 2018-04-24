package edu.matc.persistence;

import edu.matc.entity.*;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * The type ListLine dao test.
 */
@SuppressWarnings("unchecked")
class ListLineDaoTest {

    GenericDao listLineDao;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {

        listLineDao = new GenericDao(ListLine.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies the gets all listLines successfuly.
     */
    @Test
    void getAllListLinesSuccess() {
        List<ListLine> listLines = listLineDao.getAll();
        assertEquals(2, listLines.size());
    }

    /**
     * Verifies a listLine is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        // new Item object for bridging table
        Store newStore = new Store("Festival Foods", "810 East Washington Ave", "Madison", "WI", "53703");
        GenericDao storeDao = new GenericDao(Store.class);
        storeDao.insert(newStore);
        Item newItem = new Item("Kellogs", "Corn Flakes", "16 oz", "$2.99", "$1.00", "2018-04-30", true, newStore);
        GenericDao itemDao = new GenericDao(Item.class);
        itemDao.insert(newItem);

        // new ShoppingList object for bridging table
        User newUser = new User("testUser4@madisoncollege.edu", "superSecret4", "testUser4", "1701 Wright St.", "Madison", "WI", "53704");
        GenericDao userDao = new GenericDao(User.class);
        userDao.insert(newUser);
        ShoppingList newShoppingList = new ShoppingList(5.99, newUser);
        GenericDao shoppingListDao = new GenericDao(ShoppingList.class);
        shoppingListDao.insert(newShoppingList);

        //building new listLine
        int quantity = 3;
        ListLine newListLine = new ListLine(quantity, newShoppingList, newItem);
        int listLineId = listLineDao.insert(newListLine);
        ListLine retrievedListLine = (ListLine)listLineDao.getById(listLineId);
        assertNotNull(retrievedListLine);
        assertEquals(newListLine, retrievedListLine);
    }

    /**
     * Verify successful insert of a listLine
     */
    @Test
    void insertSuccess() {

        // new Item object for bridging table
        Store newStore = new Store("Festival Foods", "810 East Washington Ave", "Madison", "WI", "53703");
        GenericDao storeDao = new GenericDao(Store.class);
        storeDao.insert(newStore);
        Item newItem = new Item("Kellogs", "Corn Flakes", "16 oz", "$2.99", "$1.00", "2018-04-30", true, newStore);
        GenericDao itemDao = new GenericDao(Item.class);
        itemDao.insert(newItem);

        // new ShoppingList object for bridging table
        User newUser = new User("testUser4@madisoncollege.edu", "superSecret4", "testUser4", "1701 Wright St.", "Madison", "WI", "53704");
        GenericDao userDao = new GenericDao(User.class);
        userDao.insert(newUser);
        ShoppingList newShoppingList = new ShoppingList(5.99, newUser);
        GenericDao shoppingListDao = new GenericDao(ShoppingList.class);
        shoppingListDao.insert(newShoppingList);

        //building new listLine
        int quantity = 3;
        ListLine newListLine = new ListLine(quantity, newShoppingList, newItem);
        int listLineId = listLineDao.insert(newListLine);
        assertNotEquals(0, listLineId);
        ListLine insertedListLine = (ListLine)listLineDao.getById(listLineId);
        assertEquals(newListLine, insertedListLine);
    }

    /**
     * Verify successful delete of a listLine
     */
    @Test
    void deleteSuccess() {
        listLineDao.delete(listLineDao.getById(1));
        assertNull(listLineDao.getById(1));
    }

    /**
     * Verify successful update
     */
    @Test
    void updateSuccess() {
        int newQuantity = 10;
        ListLine listLineToUpdate = (ListLine)listLineDao.getById(1);
        listLineToUpdate.setQuantity(newQuantity);
        listLineDao.saveOrUpdate(listLineToUpdate);
        ListLine retrievedListLine = (ListLine)listLineDao.getById(1);
        assertEquals(listLineToUpdate, retrievedListLine);
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<ListLine> listLines = listLineDao.getByPropertyEqual("quantity", 2);
        assertEquals(1, listLines.size());
        assertEquals(1, listLines.get(0).getId());
    }

}