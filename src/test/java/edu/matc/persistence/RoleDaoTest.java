package edu.matc.persistence;

import edu.matc.entity.Role;
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
 * The type Role dao test.
 */
class RoleDaoTest {

    GenericDao roleDao;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {

        roleDao = new GenericDao(Role.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies the gets all roles successfuly.
     */
    @Test
    void getAllRolesSuccess() {
        List<Role> roles = roleDao.getAll();
        assertEquals(1, roles.size());
    }

    /**
     * Verifies a role is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        User newUser = new User("supersecret1", "rbruinsma");
        newUser.setId(1);
        User retrievedUser = (User)userDao.getById(1);
        assertNotNull(retrievedUser);
        assertEquals(newUser, retrievedUser);
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {

        User newUser = new User("superSecret4", "testUser4");
        int id = userDao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = (User)userDao.getById(id);
        assertEquals(newUser, insertedUser);
    }

    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {
        userDao.delete(userDao.getById(3));
        assertNull(userDao.getById(3));
    }

    /**
     * Verify successful update of user
     */
    @Test
    void updateSuccess() {
        String newUsername = "newUser";
        User userToUpdate = (User)userDao.getById(1);
        userToUpdate.setUsername(newUsername);
        userDao.saveOrUpdate(userToUpdate);
        User retrievedUser = (User)userDao.getById(1);
        assertEquals(userToUpdate, retrievedUser);
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = userDao.getByPropertyEqual("username", "rbruinsma");
        assertEquals(1, users.size());
        assertEquals(1, users.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = userDao.getByPropertyLike("username", "bruin");
        assertEquals(1, users.size());
    }
}