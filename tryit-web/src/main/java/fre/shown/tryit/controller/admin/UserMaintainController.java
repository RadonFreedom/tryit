package fre.shown.tryit.controller.admin;

import fre.shown.tryit.pojo.UserDO;
import fre.shown.tryit.pojo.admin.PageQueryVO;
import fre.shown.tryit.service.admin.UserMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Radon Freedom
 * created at 2019.02.15 16:13
 */

@Controller
public class UserMaintainController {

    private final UserMaintainService userMaintainService;

    @Autowired
    public UserMaintainController(UserMaintainService userMaintainService) {
        this.userMaintainService = userMaintainService;
    }

    @RequestMapping("/admin/userMaintain")
    public String userMaintain() {
        return "admin/userMaintain";
    }

    @RequestMapping("/admin/userMaintain/pageQuery")
    @ResponseBody
    public Object pageQuery(@RequestParam(required = false) Integer pageNum,
                            @RequestParam(required = false) Integer pageSize,
                            @RequestParam(required = false) String queryText) {


        return new PageQueryVO<>(userMaintainService.getSpecifiedPageUserData(pageNum, pageSize, queryText),
                pageNum, userMaintainService.getTotalPageCnt(pageSize, queryText));
    }

    @RequestMapping("/admin/userMaintain/addUser")
    public String addUser() {
        return "/admin/userMaintain/addUser";
    }

    @ResponseBody
    @RequestMapping("/admin/userMaintain/doAddUser")
    public Boolean doAddUser(UserDO userDO) {

        return userMaintainService.addUser(userDO);
    }

    @RequestMapping("/admin/userMaintain/updateUser")
    public String updateUser(String account, Model model) {
        model.addAttribute("account", account);
        return "/admin/userMaintain/updateUser";
    }

    @ResponseBody
    @RequestMapping("/admin/userMaintain/doUpdateUser")
    public Boolean doUpdateUser(UserDO userDO) {
        return userMaintainService.updateUserByAccount(userDO);
    }

    @ResponseBody
    @RequestMapping("/admin/userMaintain/doDeleteUser")
    public Boolean doDeleteUser(String account) {
        return userMaintainService.deleteUserByAccount(account);
    }
}
