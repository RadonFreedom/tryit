package fre.shown.tryit.dao;

/**
 * 与类{@link fre.shown.tryit.pojo.UserDO}相关的DAO类，与表user对应。
 *
 * @author Radon Freedom
 * created at 2019.02.13 20:39
 */

public interface UserDAO {

    /**
     * 查找表user对应的account列，返回查找到的行的password列，若未找到返回 {@code null}。
     * @param account 表user的account列
     * @return 返回查找到的行的password列，或{@code null}如果没有找到。
     */
    String getPasswordByAccount(String account);
}
