package cn.edu.upc.yb.controller;

import cn.edu.upc.yb.confing.DevConfig;
import cn.edu.upc.yb.model.Official;
import cn.edu.upc.yb.model.OfficialDao;
import cn.edu.upc.yb.model.User;
import cn.edu.upc.yb.model.UserDao;
import cn.edu.upc.yb.service.LoginService;
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
    private LoginService loginService;

    @Autowired
    private OfficialDao officialDao;

    @Autowired
    private UserDao userDao;

    @RequestMapping("/")
    public String showIndex(Model model) {
        if (!loginService.isLogin()) {
            return loginService.toYibanAuth();
        }
        Iterable<Official> lists = officialDao.findByIsdeletNotOrderByDateDesc(true);
        model.addAttribute("lists", lists);

        return "index";
    }

    @RequestMapping("/detail")
    public String showDetail(int id,int type, Model model) {
        String detail = null;
        if(type == 0) {
           detail = officialDao.findOne(id).getDetail();
        }else {
            detail = userDao.findOne(id).getDetail();
        }
        model.addAttribute("detail", detail);
        return "detail";
    }

}
