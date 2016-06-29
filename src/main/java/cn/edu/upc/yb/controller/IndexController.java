package cn.edu.upc.yb.controller;

import cn.edu.upc.yb.confing.DevConfig;
import cn.edu.upc.yb.model.Official;
import cn.edu.upc.yb.model.OfficialDao;
import cn.edu.upc.yb.model.User;
import cn.edu.upc.yb.model.UserDao;
import cn.edu.upc.yb.service.LoginService;
import cn.edu.upc.yb.util.LinkPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String showIndex(Model model, @RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "15") Integer size) {
        if (!loginService.isLogin()) {
            return loginService.toYibanAuth();
        }
        Pageable pageable = new PageRequest(page,size);
        Page<Official> pages = officialDao.findByIsdeletNotOrderByDateDesc(true,pageable);
        model.addAttribute("page", new LinkPage<Official>(pages,"/"));
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
