package fre.shown.tryit.service.admin;

import fre.shown.tryit.dao.UserDAO;
import fre.shown.tryit.pojo.UserDO;
import fre.shown.tryit.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Radon Freedom
 * created at 2019.02.15 16:58
 */

@Service
public class UserMaintainServiceImpl implements UserMaintainService {

    private static final Integer DEFAULT_PAGE_NUM = 1;
    private static final Integer DEFAULT_PAGE_SIZE = 16;

    private final UserDAO userDAO;

    @Autowired
    public UserMaintainServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<UserDO> getSpecifiedPageUserData(Integer pageNum, Integer pageSize, String queryText) {

        if (pageNum == null) {
            pageNum = DEFAULT_PAGE_NUM;
        }
        if (pageSize == null) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        if ("".equals(queryText)) {
            queryText = null;
        }

        int begin = pageSize * (pageNum - 1);
        return userDAO.getUsersAsList(begin, pageSize, queryText);
    }

    @Override
    public Integer getTotalPageCnt(Integer pageSize, String queryText) {
        Integer totalUserCnt = userDAO.getTotalUserCnt(queryText);
        Integer totalPageCnt = totalUserCnt / pageSize;
        if (totalUserCnt % pageSize != 0) {
            totalPageCnt++;
        }
        return totalPageCnt;
    }

    @Override
    public Boolean addUser(UserDO userDO) {

        try {
            userDO.setCreateTime(DateUtils.getCurrentTime());
            userDAO.addUser(userDO);
        } catch (DataIntegrityViolationException e) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean updateUserByAccount(UserDO userDO) {
        return userDAO.updateUserByAccount(userDO);
    }

    @Override
    public Boolean deleteUserByAccount(String account) {

        try {
            userDAO.deleteUserByAccount(account);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Boolean deleteUsers(String[] accounts) {
        if (accounts == null || accounts.length == 0) {
            return false;
        }

        try {
            for (String account : accounts) {
                userDAO.deleteUserByAccount(account);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}

