package fre.shown.tryit.service.admin;

import fre.shown.tryit.pojo.UserDO;

import java.util.List;

/**
 * 与用户维护功能相关的服务
 * @author Radon Freedom
 * created at 2019.02.15 16:55
 */


public interface UserMaintainService {

    /**
     *
     * 根据每页数据行数和第几页返回用户信息List
     *
     * @param pageSize 每页的数据行数
     * @param pageNum 第几页
     * @return 指定页的用户List
     */
    List<UserDO> getSpecifiedPageUserData(Integer pageSize, Integer pageNum);

    Integer getTotalPageCnt(Integer pageSize);
}
