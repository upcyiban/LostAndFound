package cn.edu.cup.yb.controller;

import cn.edu.cup.yb.confing.DevConfig;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

/**
 * Created by yyljj on 2016/5/21.
 */
public class IndexController {

    @Autowired
    private HttpSession httpSession;

    public boolean isLogin() {
        return httpSession.getAttribute("userid") != null;
    }

    public String toYibanAuth() {
        String auth = "redirect:https://openapi.yiban.cn/oauth/authorize?client_id=" + DevConfig.client_id + "&redirect_uri=" + DevConfig.redirect_uri;
        return auth;
    }
}
