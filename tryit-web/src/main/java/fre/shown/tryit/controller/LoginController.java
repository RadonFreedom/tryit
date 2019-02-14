package fre.shown.tryit.controller;

import fre.shown.tryit.pojo.UserDO;
import fre.shown.tryit.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String doLogin(String account, String password, Model model) {


        if (!loginService.loginSuccess(account, password)) {
            //登陆失败，跳转到登陆页面，提示错误信息
            String errorMsg = "用户信息不存在或密码错误！";
            model.addAttribute("errorMsg", errorMsg);
            return "redirect:login";
        } else {
            //登陆成功，跳转到主页面
            return "userpage";
        }
    }
}
