package fre.shown.tryit.dao;

import fre.shown.tryit.config.DaoConfig;
import fre.shown.tryit.pojo.UserDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit tests for {@link UserDAO}
 *
 * @author Radon Freedom
 * created at 2019.02.13 20:45
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoConfig.class)
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    /**
     * Unit test for {@link UserDAO#getPasswordByAccount(String)}.
     */
    @Test
    public void testGetPasswordByAccount() {

        String password = userDAO.getPasswordByAccount("radon");
        Assert.assertEquals(password, "king");
    }

    /**
     * Unit test for {@link UserDAO#getUserByAccount(String)}.
     */
    @Test
    public void testGetUserByAccount() {

        UserDO user = userDAO.getUserByAccount("radon");
        UserDO expectedUser = new UserDO(20, "radon", null, "radon", "2019-02-19 11:42:47");
        Assert.assertEquals(expectedUser, user);
    }


    /**
     * Unit test for {@link UserDAO#getUsersAsList(Integer, Integer, String)}.
     */
    @Test
    public void testGetUsersAsList() {

        List<UserDO> expectedList = new ArrayList<>();
        expectedList.add(new UserDO(20, "radon", null, "radon", "2019-02-19 11:42:47"));
        Assert.assertEquals(expectedList, userDAO.getUsersAsList(0, 1, "ra"));
    }


    /**
     * Unit test for {@link UserDAO#getTotalUserCnt(String)}.
     */
    @Test
    public void testGetTotalUserCnt() {

        Integer expectedCnt = 1;
        Assert.assertEquals(expectedCnt, userDAO.getTotalUserCnt("ra"));
        expectedCnt = 2;
        Assert.assertEquals(expectedCnt, userDAO.getTotalUserCnt(null));
    }

    /**
     * Unit test for {@link UserDAO#addUser(UserDO)}.
     */
    @Test
    public void testAddUser() {
        try {
            userDAO.addUser(new UserDO(1, "radon", null, "radon", ""));
        } catch (Exception e) {
            Assert.assertEquals(e.getClass(), DataIntegrityViolationException.class);
        }
    }

    /**
     * Unit test for {@link UserDAO#updateUserByAccount(UserDO)}.
     */
    @Test
    public void testUpdateUserByAccount() {
        userDAO.updateUserByAccount(new UserDO(null, "radon", "king", "Radon", null));
        UserDO result = userDAO.getUserByAccount("radon");
        Assert.assertEquals("Radon", result.getName());
        Assert.assertEquals("king", userDAO.getPasswordByAccount("radon"));
    }

    /**
     * Unit test for {@link UserDAO#deleteUserByAccount(String)}.
     */
    @Test
    public void testDeleteUserByAccount() {
        userDAO.deleteUserByAccount("sadasd");
    }


}
