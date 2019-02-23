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
     * @param queryText 查询文本
     * @return 指定页的用户List
     */
    List<UserDO> getSpecifiedPageUserData(Integer pageSize, Integer pageNum, String queryText);

    /**
     * 根据查询文本和每页条目数返回总页数
     *
     * @param pageSize 每页条目数
     * @param queryText 查询文本
     * @return 根据查询文本和每页条目数返回总页数
     */
    Integer getTotalPageCnt(Integer pageSize, String queryText);

    /**
     * 新增用户，如果新增失败（UserDO的account属性值已存在）返回false。
     * 将调用{@link UserDO#setCreateTime(String)}来设置传入参数userDO的创建时间为执行到这个方法的时间。
     *
     * @param userDO 待新增的用户
     * @return 如果新增失败（UserDO的account属性值已存在）返回false，否则返回true
     */
    Boolean addUser(UserDO userDO);

    /**
     * 据account确认user表需要更新的<B>唯一</B>条目，更新传入参数中的name和password属性
     * @param userDO account属性不能为null，否则将抛出异常
     * @return 如果用户account不存在返回false，否则返回true
     */
    Boolean updateUserByAccount(UserDO userDO);


    /**
     * 根据account确认user表需要删除的<B>唯一</B>条目
     * @param account 需要删除的account值
     * @return 若执行出现异常则返回false
     */
    Boolean deleteUserByAccount(String account);

    /**
     * 根据account确认user表需要删除的所有条目
     * @param accounts 包含所有需要删除的account值
     * @return 若accounts为空，长度为0，执行出现异常则返回false
     */
    Boolean deleteUsers(String[] accounts);
}
