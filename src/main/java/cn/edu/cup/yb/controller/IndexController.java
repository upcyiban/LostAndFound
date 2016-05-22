package cn.edu.cup.yb.controller;

import cn.edu.cup.yb.confing.DevConfig;
import cn.edu.cup.yb.model.AdminDao;
import cn.edu.cup.yb.model.Official;
import cn.edu.cup.yb.model.OfficialDao;
import cn.edu.cup.yb.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by yyljj on 2016/5/21.
 */
@Controller
public class IndexController {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private LoginService loginService;

    @Autowired
    private OfficialDao officialDao;

    public boolean isLogin() {
        return httpSession.getAttribute("userid") != null;
    }

    public String toYibanAuth() {
        String auth = "redirect:https://openapi.yiban.cn/oauth/authorize?client_id=" + DevConfig.client_id + "&redirect_uri=" + DevConfig.redirect_uri;
        return auth;
    }

    @RequestMapping("/")
    public String showIndex(Model model) {
        if (!loginService.isLogin()) {
            return loginService.toYibanAuth();
        }

        Iterable<Official> lists = officialDao.findAll(sortById());
        model.addAttribute("lists", lists);

        return "index";
    }


    private Sort sortById() {
        return new Sort(Sort.Direction.DESC, "id");
    }
}
