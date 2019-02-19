package fre.shown.tryit.service.admin;

import fre.shown.tryit.config.ServiceConfig;
import fre.shown.tryit.pojo.UserDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * {@link UserMaintainServiceImpl}的单元测试
 *
 * @author Radon Freedom
 * created at 2019.02.15 17:21
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceConfig.class)
public class UserMaintainServiceTest {


    @Autowired
    private UserMaintainService userMaintainService;

    /**
     * {@link UserMaintainServiceImpl#getSpecifiedPageUserData(Integer, Integer, String)}的单元测试
     */
    @Test
    public void testGetSpecifiedPageUserData(){

        List<UserDO> expectedList = new ArrayList<>();
        Assert.assertEquals(expectedList, userMaintainService.getSpecifiedPageUserData(2, 4, null));
        expectedList.add(new UserDO(20, "radon", null, "radon", "2019-02-19 11:42:47"));
        expectedList.add(new UserDO(21, "shawn", null, "shawn", "2019-02-19 11:43:09"));
        Assert.assertEquals(expectedList, userMaintainService.getSpecifiedPageUserData(1, 4, "n"));
    }
//
    /**
     * {@link UserMaintainServiceImpl#addUser(UserDO)}的单元测试
     */
    @Test
    public void testAddUser() {
        Assert.assertEquals(true, userMaintainService.addUser(new UserDO(1, "radon", "king", "radon", null)));
    }

}
