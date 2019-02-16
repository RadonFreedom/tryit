package fre.shown.tryit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author Radon Freedom
 * created at 2019.02.15 14:29
 */


@Controller
public class AdminController {

    @RequestMapping("/admin")
    public String admin() {

        return "admin";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:login";
    }
}
