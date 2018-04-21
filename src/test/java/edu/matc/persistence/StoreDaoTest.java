package edu.matc.persistence;

import edu.matc.entity.Store;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * The type Store dao test.
 */
class StoreDaoTest {

    GenericDao storeDao;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {

        storeDao = new GenericDao(Store.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies the gets all stores successfuly.
     */
    @Test
    void getAllStoresSuccess() {
        List<Store> stores = storeDao.getAll();
        assertEquals(2, stores.size());
    }

    /**
     * Verifies a store is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        Store newStore = new Store("Festival Foods", "810 East Washington Ave", "Madison", "WI", "53703");
        int id = storeDao.insert(newStore);

        Store retrievedStore = (Store)storeDao.getById(id);
        assertNotNull(retrievedStore);
        assertEquals(newStore, retrievedStore);
    }

    /**
     * Verify successful insert of a store
     */
    @Test
    void insertSuccess() {

        Store newStore = new Store("Festival Foods", "810 East Washington Ave", "Madison", "WI", "53703");
        int id = storeDao.insert(newStore);
        assertNotEquals(0,id);
        Store insertedStore = (Store)storeDao.getById(id);
        assertEquals(newStore, insertedStore);
    }

    /**
     * Verify successful delete of store
     */
    @Test
    void deleteSuccess() {
        storeDao.delete(storeDao.getById(1));
        assertNull(storeDao.getById(1));
    }

    /**
     * Verify successful update of store
     */
    @Test
    void updateSuccess() {
        String newStoreName = "newStore";
        Store storeToUpdate = (Store)storeDao.getById(1);
        storeToUpdate.setName(newStoreName);
        storeDao.saveOrUpdate(storeToUpdate);
        Store retrievedStore = (Store)storeDao.getById(1);
        assertEquals(storeToUpdate, retrievedStore);
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Store> stores = storeDao.getByPropertyEqual("name", "Hy-Vee");
        assertEquals(1, stores.size());
        assertEquals(1, stores.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Store> stores = storeDao.getByPropertyLike("name", "Hy");
        assertEquals(1, stores.size());
        assertEquals(1, stores.get(0).getId());
    }
}