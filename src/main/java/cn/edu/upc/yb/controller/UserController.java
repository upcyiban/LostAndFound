package cn.edu.upc.yb.controller;

import cn.edu.upc.yb.model.User;
import cn.edu.upc.yb.model.UserDao;
import cn.edu.upc.yb.service.LoginService;
import cn.edu.upc.yb.service.UserService;
import com.sun.org.apache.bcel.internal.generic.MONITORENTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by yyljj on 16-6-1.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @RequestMapping("/findloser")
    public String showFindloser(Model model) {
       Iterable<User> lists = userDao.findByIsdeletNotAndIsloserNotOrderByDateDesc(true,false);
        model.addAttribute("lists",lists);
        return "findloser";
    }

    @RequestMapping("/findthing")
    public String showFindthing(Model model) {
        Iterable<User> lists = userDao.findByIsdeletNotAndIsloserNotOrderByDateDesc(true,true);
        model.addAttribute("lists",lists);
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
