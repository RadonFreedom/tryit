package fre.shown.tryit.dao;

import fre.shown.tryit.config.DaoConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
}
