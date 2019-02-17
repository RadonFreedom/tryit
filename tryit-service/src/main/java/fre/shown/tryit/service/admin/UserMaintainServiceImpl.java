package fre.shown.tryit.service.admin;

import fre.shown.tryit.dao.UserDAO;
import fre.shown.tryit.pojo.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Radon Freedom
 * created at 2019.02.15 16:58
 */

@Service
public class UserMaintainServiceImpl implements UserMaintainService {

    private final UserDAO userDAO;

    @Autowired
    public UserMaintainServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<UserDO> getSpecifiedPageUserData(Integer pageNum, Integer pageSize, String queryText) {

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
}

