package fre.shown.tryit.service;

import fre.shown.tryit.dao.UserDAO;
import fre.shown.tryit.pojo.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Radon Freedom
 * created at 2019.02.13 21:21
 */


@Service
public class LoginServiceImpl implements LoginService {

    private final UserDAO userDAO;

    @Autowired
    public LoginServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean loginSuccess(String account, String password) {

        String realPasswd = userDAO.getPasswordByAccount(account);
        return realPasswd != null && realPasswd.equals(password);
    }

    @Override
    public UserDO getUserInfo(String account) {
        return userDAO.getUserByAccount(account);
    }
}
