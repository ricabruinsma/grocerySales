package edu.matc.persistence;

import edu.matc.entity.Role;
import edu.matc.entity.User;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.net.www.content.text.Generic;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * The type User dao test.
 */
@SuppressWarnings("unchecked")
class UserDaoTest {

    GenericDao userDao;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {

        userDao = new GenericDao(User.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies the gets all users successfuly.
     */
    @Test
    void getAllUsersSuccess() {
        List<User> users = userDao.getAll();
        assertEquals(3, users.size());
    }

    /**
     * Verifies a user is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        User newUser = new User("testUser4@madisoncollege.edu", "superSecret4", "testUser4", "1701 Wright St.", "Madison", "WI", "53704");
        int id = userDao.insert(newUser);

        User retrievedUser = (User)userDao.getById(id);
        assertNotNull(retrievedUser);
        assertEquals(newUser, retrievedUser);
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {

        User newUser = new User("testUser4@madisoncollege.edu", "superSecret4", "testUser4", "1701 Wright St.", "Madison", "WI", "53704");
        int id = userDao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = (User)userDao.getById(id);
        assertEquals(newUser, insertedUser);
    }

    /**
     * Verify successful insert of a user and their role
     */
    @Test
    void insertSuccessWithRole() {

        String username = "testUser4";
        User newUser = new User("testUser4@madisoncollege.edu", "superSecret4", username, "1701 Wright St.", "Madison", "WI", "53704");

        String roleName = "shopper";
        Role role = new Role(newUser, roleName, username);

        newUser.addRole(role);

        int id = userDao.insert(newUser);

        assertNotEquals(0,id);
        User insertedUser = (User)userDao.getById(id);
        assertEquals(newUser, insertedUser);
        assertEquals(1, insertedUser.getRoles().size());
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
     * Verify successful delete of user and their role
     */
    @Test
    void deleteSuccessWithRole() {

        User userToDelete = (User)userDao.getById(3);

        GenericDao roleDao = new GenericDao(Role.class);
        Role roleToDelete = (Role)roleDao.getById(3);
        userToDelete.removeRole(roleToDelete);
        userDao.delete(userToDelete);
        assertNull(userDao.getById(3));
        assertNull(roleDao.getById(3));
    }

    /**
     * Verify successful update of user
     */
    @Test
    void updateSuccess() {
        String newName = "newFirstName";
        User userToUpdate = (User)userDao.getById(1);
        userToUpdate.setFirstName(newName);
        userDao.saveOrUpdate(userToUpdate);
        User retrievedUser = (User)userDao.getById(1);
        assertEquals(userToUpdate, retrievedUser);
    }

    /**
     * Verify successful update of username in User and Role
     */
    @Test
    void updateUserAndRoleUsernameSuccess() {
        String newUsername = "newUserName";
        User userToUpdate = (User)userDao.getById(1);

        //update role record of associated user and username
        GenericDao roleDao = new GenericDao(Role.class);
        List<Role> rolesToUpdate = roleDao.getByPropertyEqual("user", userToUpdate);
        List<Role> rolesRetrieved = new ArrayList<>();
        for (Role role : rolesToUpdate) {
            role.setUsername(newUsername);
            roleDao.saveOrUpdate(role);
            int roleId = role.getId();
            Role retrievedRole = (Role) roleDao.getById(roleId);
            rolesRetrieved.add(retrievedRole);
        }
        assertEquals(rolesToUpdate, rolesRetrieved);

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