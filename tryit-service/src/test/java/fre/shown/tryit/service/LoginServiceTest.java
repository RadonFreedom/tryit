package fre.shown.tryit.service;

import fre.shown.tryit.config.ServiceConfig;
import fre.shown.tryit.pojo.UserDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * {@link LoginServiceImpl}的单元测试。
 *
 * @author Radon Freedom
 * created at 2019.02.13 21:14
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceConfig.class)
public class LoginServiceTest {

    @Autowired
    private LoginService loginService;

    @Test
    public void testLoginSuccess() {
        Assert.assertTrue(loginService.loginSuccess("radon", "king"));
    }

    @Test
    public void testGetUserInfo() {
        UserDO user = loginService.getUserInfo("radon");
        System.out.println(user);
        UserDO equalUser = new UserDO(1, "radon", null, "radon");
        Assert.assertEquals(equalUser, user);
    }
}
