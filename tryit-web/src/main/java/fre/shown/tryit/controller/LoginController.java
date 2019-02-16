package fre.shown.tryit.controller;

import fre.shown.tryit.pojo.LoginVO;
import fre.shown.tryit.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author Radon Freedom
 * created at 2019.02.12 20:48
 */

@Controller
public class LoginController {


    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping("/login")
    public String login() {

        return "login";
    }


    @ResponseBody
    @RequestMapping(value = "/doAjaxLogin", method = RequestMethod.POST)
    public Object doAjaxLogin(@RequestParam String account, @RequestParam String password, HttpSession httpSession) {

        LoginVO loginVO = new LoginVO();

        if (loginService.loginSuccess(account, password)) {
            loginVO.setSuccess(true);
            httpSession.setAttribute("userInfo", loginService.getUserInfo(account));
        } else {
            loginVO.setSuccess(false);
        }

        return loginVO;
    }
}
