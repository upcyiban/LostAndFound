package cn.edu.upc.yb.controller;

import cn.edu.upc.yb.model.Official;
import cn.edu.upc.yb.model.User;
import cn.edu.upc.yb.model.UserDao;
import cn.edu.upc.yb.service.LoginService;
import cn.edu.upc.yb.service.UserService;
import cn.edu.upc.yb.util.LinkPage;
import com.sun.org.apache.bcel.internal.generic.MONITORENTER;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by yyljj on 16-6-1.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginService loginService;

    @RequestMapping("/findloser")
    public String showFindloser(Model model, @RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "15") Integer size) {
        if (!loginService.isLogin()) {
            return loginService.toYibanAuth();
        }
        Pageable pageable = new PageRequest(page,size);
        Page<User> pages = userDao.findByIsdeletNotAndIsloserNotOrderByDateDesc(true,false,pageable);
        model.addAttribute("page", new LinkPage<User>(pages,"/findloser"));

        return "findloser";
    }

    @RequestMapping("/findthing")
    public String showFindthing(Model model,@RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "15") Integer size) {
        if (!loginService.isLogin()) {
            return loginService.toYibanAuth();
        }
        Pageable pageable = new PageRequest(page,size);
        Page<User> pages = userDao.findByIsdeletNotAndIsloserNotOrderByDateDesc(true,true,pageable);
        model.addAttribute("page", new LinkPage<User>(pages,"/findthing"));
        return "findthing";
    }

    @RequestMapping("/publish")
    public String showPublis() {
        return "publish";
    }

    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public String publish(String title, String detail, String what, Model model) {
        if (userService.saveUser(title, detail, what) == true) {
            model.addAttribute("result", "提交成功!");
        } else {
            model.addAttribute("result", "提交失败!");
        }
        return "result";
    }
}
