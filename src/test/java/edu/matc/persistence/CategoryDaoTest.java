package edu.matc.persistence;

import edu.matc.entity.Category;
import edu.matc.entity.Item;
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
 * The type Category dao test.
 */
@SuppressWarnings("unchecked")
class CategoryDaoTest {

    GenericDao categoryDao;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {

        categoryDao = new GenericDao(Category.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies the gets all categories successfuly.
     */
    @Test
    void getAllCategoriesSuccess() {
        List<Category> categories = categoryDao.getAll();
        assertEquals(10, categories.size());
    }

    /**
     * Verifies a category is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        Category newCategory = new Category("produce");
        int id = categoryDao.insert(newCategory);

        Category retrievedCategory = (Category)categoryDao.getById(id);
        assertNotNull(retrievedCategory);
        assertEquals(newCategory, retrievedCategory);
    }

    /**
     * Verify successful insert of a category
     */
    @Test
    void insertSuccess() {

        Category newCategory = new Category("produce");
        int id = categoryDao.insert(newCategory);
        assertNotEquals(0,id);
        Category insertedCategory = (Category)categoryDao.getById(id);
        assertEquals(newCategory, insertedCategory);
    }

    /**
     * Verify successful delete of category and associated items
     */
    @Test
    void deleteSuccessWithItems() {
        Category temporaryCategory = new Category("temporaryCategory");
        int categoryId = categoryDao.insert(temporaryCategory);

        GenericDao storeDao = new GenericDao(Store.class);
        Store existingStore = (Store)storeDao.getById(1);

        GenericDao itemDao = new GenericDao(Item.class);
        Item temporaryItem = new Item("Kellogs", temporaryCategory, "Corn Flakes", "16 oz", "$2.99", "$1.00", "2018-04-30", true, existingStore);
        int itemId = itemDao.insert(temporaryItem);

        itemDao.delete(temporaryItem);
        categoryDao.delete(temporaryCategory);
        assertNull(categoryDao.getById(categoryId));
        assertNull(itemDao.getById(itemId));
    }

    /**
     * Verify successful delete of category
     */
    @Test
    void deleteSuccess() {
        categoryDao.delete(categoryDao.getById(1));
        assertNull(categoryDao.getById(1));
    }

    /**
     * Verify successful update of category
     */
    @Test
    void updateSuccess() {
        String newCategoryName = "newCategory";
        Category categoryToUpdate = (Category)categoryDao.getById(1);
        categoryToUpdate.setName(newCategoryName);
        categoryDao.saveOrUpdate(categoryToUpdate);
        Category retrievedCategory = (Category)categoryDao.getById(1);
        assertEquals(categoryToUpdate, retrievedCategory);
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Category> categories = categoryDao.getByPropertyEqual("name", "bread");
        assertEquals(1, categories.size());
        assertEquals(3, categories.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Category> categories = categoryDao.getByPropertyLike("name", "brea");
        assertEquals(1, categories.size());
        assertEquals(3, categories.get(0).getId());
    }
}