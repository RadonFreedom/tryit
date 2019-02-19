package fre.shown.tryit.dao;

import fre.shown.tryit.pojo.UserDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataIntegrityViolationException;

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
     * @param queryText 查询的文本
     * @return 返回从begin开始的数量为cnt个的用户List。
     *          如果剩余用户量不足，将返回所有剩余用户。
     *          如果begin之后（inclusive）没有用户，返回空List。
     */
    List<UserDO> getUsersAsList(@Param("begin") Integer begin, @Param("cnt") Integer cnt, @Param("queryText") String queryText);

    /**
     * 返回user表总记录条数
     * @param queryText 需要查询的文本
     * @return user表总记录条数
     */
    Integer getTotalUserCnt(@Param("queryText") String queryText);


    /**
     * 新增用户，如果用户account已存在将抛出异常。
     * 方法参数 {@code userDO} 的id属性无效，不会被使用。
     * @param userDO 新增用户信息，不包括id（即便包括也不会被使用）
     * @throws DataIntegrityViolationException 待插入用户的account已存在
     */
    void addUser(UserDO userDO);
}
