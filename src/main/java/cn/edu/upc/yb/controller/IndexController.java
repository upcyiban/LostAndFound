package cn.edu.upc.yb.controller;

import cn.edu.upc.yb.confing.DevConfig;
import cn.edu.upc.yb.model.Official;
import cn.edu.upc.yb.model.OfficialDao;
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
    public String showDetail(int id, Model model) {
        String detail = officialDao.findOne(id).getDetail();
        model.addAttribute("detail", detail);
        return "detail";
    }

}
