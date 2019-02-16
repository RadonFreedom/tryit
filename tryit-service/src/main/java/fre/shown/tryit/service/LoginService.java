package fre.shown.tryit.service;

import fre.shown.tryit.pojo.UserDO;

/**
 *
 * 与登陆功能相关的服务
 * @author Radon Freedom
 * created at 2019.02.13 20:10
 */

public interface LoginService {

    /**
     * 判断登录是否成功
     * @param account 用于登录的账户名
     * @param password 用于登录的账户密码
     * @return 登陆成功返回true，否则返回false
     */
    boolean loginSuccess(String account, String password);

    /**
     * 获取除了账户密码之外的用户信息
     * @param account 账户名
     * @return 除了账户密码之外的用户信息
     */
    UserDO getUserInfo(String account);
}
