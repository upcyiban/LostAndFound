package cn.edu.cup.yb.controller;

import cn.edu.cup.yb.confing.DevConfig;
import cn.edu.cup.yb.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
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

    public boolean isLogin() {
        return httpSession.getAttribute("userid") != null;
    }

    public String toYibanAuth() {
        String auth = "redirect:https://openapi.yiban.cn/oauth/authorize?client_id=" + DevConfig.client_id + "&redirect_uri=" + DevConfig.redirect_uri;
        return auth;
    }

    @RequestMapping("/")
    public String showIndex(Model model){
        if (!loginService.isLogin()){
            return loginService.toYibanAuth();
        }


       return "index";
    }

}