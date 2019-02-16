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
     * {@link UserMaintainServiceImpl#getSpecifiedPageUserData(Integer, Integer)}的单元测试
     */
    @Test
    public void testGetSpecifiedPageUserData(){

        List<UserDO> expectedList = new ArrayList<>();
        Assert.assertEquals(expectedList, userMaintainService.getSpecifiedPageUserData(4, 2));
        expectedList.add(new UserDO(1, "radon", null, "radon"));
        expectedList.add(new UserDO(2, "shawn", null, "shawn"));
        Assert.assertEquals(expectedList, userMaintainService.getSpecifiedPageUserData(4, 1));
    }
}
