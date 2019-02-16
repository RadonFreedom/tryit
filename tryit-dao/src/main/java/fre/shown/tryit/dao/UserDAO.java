package fre.shown.tryit.dao;

import fre.shown.tryit.pojo.UserDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 与类{@link fre.shown.tryit.pojo.UserDO}相关的DAO操作，与表user对应。
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

    /**
     * 根据账户名account查找user表除了password列的所有列
     * @param account 输入的账户名
     * @return 除了password列之外的所有用户信息
     */
    UserDO getUserByAccount(String account);

    /**
     * 返回从begin开始的数量为cnt个的用户List。
     *
     * @param begin 从第<B>begin</B>用户开始(exclusive)（按id升序排序）
     * @param cnt 返回的用户数目
     * @return 返回从begin开始的数量为cnt个的用户List。
     *          如果剩余用户量不足，将返回所有剩余用户。
     *          如果begin之后（inclusive）没有用户，返回空List。
     */
    List<UserDO> getUsersAsList(@Param("begin") Integer begin, @Param("cnt") Integer cnt);

    /**
     * 返回user表总记录条数
     * @return user表总记录条数
     */
    Integer getTotalUserCnt();
}
