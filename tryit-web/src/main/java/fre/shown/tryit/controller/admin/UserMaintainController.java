package fre.shown.tryit.controller.admin;

import fre.shown.tryit.pojo.admin.PageQueryVO;
import fre.shown.tryit.service.admin.UserMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Radon Freedom
 * created at 2019.02.15 16:13
 */

@Controller
public class UserMaintainController {

    private static final Integer DEFAULT_PAGE_NUM = 1;
    private static final Integer DEFAULT_PAGE_SIZE = 16;
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
        if (pageNum == null) {
            pageNum = DEFAULT_PAGE_NUM;
        }
        if (pageSize == null) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        if ("".equals(queryText)) {
            queryText = null;
        }

        return new PageQueryVO<>(userMaintainService.getSpecifiedPageUserData(pageNum, pageSize, queryText),
                pageNum, userMaintainService.getTotalPageCnt(pageSize, queryText));
    }

    @RequestMapping("/admin/userMaintain/addUser")
    public String addUser() {
        return "/admin/userMaintain/addUser";
    }
}
