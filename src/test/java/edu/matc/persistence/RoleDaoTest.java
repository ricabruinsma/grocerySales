package edu.matc.persistence;

import edu.matc.entity.Role;
import edu.matc.entity.User;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * The type Role dao test.
 */
@SuppressWarnings("unchecked")
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
        assertEquals(3, roles.size());
    }

    /**
     * Verifies a role is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        User newUser = new User("testUser4@madisoncollege.edu", "superSecret4", "testUser4", "1701 Wright St.", "Madison", "WI", "53704");
        GenericDao userDao = new GenericDao(User.class);
        userDao.insert(newUser);
        Role newRole = new Role(newUser, "guest", "guestUser");
        int roleId = roleDao.insert(newRole);
        Role retrievedRole = (Role)roleDao.getById(roleId);
        assertNotNull(retrievedRole);
        assertEquals(newRole, retrievedRole);
    }

    /**
     * Verify successful insert of a role
     */
    @Test
    void insertSuccess() {

        User newUser = new User("testUser4@madisoncollege.edu", "superSecret4", "testUser4", "1701 Wright St.", "Madison", "WI", "53704");
        GenericDao userDao = new GenericDao(User.class);
        int id = userDao.insert(newUser);
        Role newRole = new Role(newUser, "guest", "testUser4");
        int roleId = roleDao.insert(newRole);
        assertNotEquals(0,id);
        Role insertedRole = (Role)roleDao.getById(roleId);
        assertEquals(newRole, insertedRole);
    }

    /**
     * Verify successful delete of a role
     */
    @Test
    void deleteSuccess() {
        roleDao.delete(roleDao.getById(1));
        assertNull(roleDao.getById(1));
    }

    /**
     * Verify successful update
     */
    @Test
    void updateSuccess() {
        String newRolename = "newRole";
        Role roleToUpdate = (Role)roleDao.getById(1);
        roleToUpdate.setName(newRolename);
        roleDao.saveOrUpdate(roleToUpdate);
        Role retrievedRole = (Role)roleDao.getById(1);
        assertEquals(roleToUpdate, retrievedRole);
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Role> roles = roleDao.getByPropertyEqual("name", "admin");
        assertEquals(1, roles.size());
        assertEquals(1, roles.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Role> roles = roleDao.getByPropertyLike("name", "adm");
        assertEquals(1, roles.size());
    }
}