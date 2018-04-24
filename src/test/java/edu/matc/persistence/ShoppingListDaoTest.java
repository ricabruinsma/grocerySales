package edu.matc.persistence;

import edu.matc.entity.ShoppingList;
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
 * The type ShoppingList dao test.
 */
@SuppressWarnings("unchecked")
class ShoppingListDaoTest {

    GenericDao shoppingListDao;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {

        shoppingListDao = new GenericDao(ShoppingList.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies the gets all shoppingLists successfuly.
     */
    @Test
    void getAllShoppingListsSuccess() {
        List<ShoppingList> shoppingLists = shoppingListDao.getAll();
        assertEquals(3, shoppingLists.size());
    }

    /**
     * Verifies a shoppingList is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        User newUser = new User("testUser4@madisoncollege.edu", "superSecret4", "testUser4", "1701 Wright St.", "Madison", "WI", "53704");
        GenericDao userDao = new GenericDao(User.class);
        userDao.insert(newUser);
        ShoppingList newShoppingList = new ShoppingList(5.99, newUser);
        int shoppingListId = shoppingListDao.insert(newShoppingList);
        ShoppingList retrievedShoppingList = (ShoppingList)shoppingListDao.getById(shoppingListId);
        assertNotNull(retrievedShoppingList);
        assertEquals(newShoppingList, retrievedShoppingList);
    }

    /**
     * Verify successful insert of a shoppingList
     */
    @Test
    void insertSuccess() {

        User newUser = new User("testUser4@madisoncollege.edu", "superSecret4", "testUser4", "1701 Wright St.", "Madison", "WI", "53704");
        GenericDao userDao = new GenericDao(User.class);
        int id = userDao.insert(newUser);
        ShoppingList newShoppingList = new ShoppingList(5.99, newUser);
        int shoppingListId = shoppingListDao.insert(newShoppingList);
        assertNotEquals(0,id);
        ShoppingList insertedShoppingList = (ShoppingList)shoppingListDao.getById(shoppingListId);
        assertEquals(newShoppingList, insertedShoppingList);
    }

    /**
     * Verify successful delete of a shoppingList
     */
    @Test
    void deleteSuccess() {
        shoppingListDao.delete(shoppingListDao.getById(1));
        assertNull(shoppingListDao.getById(1));
    }

    /**
     * Verify successful update
     */
    @Test
    void updateSuccess() {
        double newShoppingListTotal = 19.99;
        ShoppingList shoppingListToUpdate = (ShoppingList)shoppingListDao.getById(1);
        shoppingListToUpdate.setTotalAmount(newShoppingListTotal);
        shoppingListDao.saveOrUpdate(shoppingListToUpdate);
        ShoppingList retrievedShoppingList = (ShoppingList)shoppingListDao.getById(1);
        assertEquals(shoppingListToUpdate, retrievedShoppingList);
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<ShoppingList> shoppingLists = shoppingListDao.getByPropertyEqual("totalAmount", 7.98);
        assertEquals(1, shoppingLists.size());
        assertEquals(2, shoppingLists.get(0).getId());
    }

}