package cn.edu.upc.yb.controller;

import cn.edu.upc.yb.confing.DevConfig;
import cn.edu.upc.yb.model.Official;
import cn.edu.upc.yb.model.OfficialDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Objects;

/**
 * Created by yyljj on 2016/5/21.
 */
@Controller
public class AdminController {

    @Autowired
    private OfficialDao officialDao;

    @Autowired
    private HttpSession session = null;


    /**
     * 管理员添加数据库
     * @param title
     * @param detail
     */
    @RequestMapping(value = "/official", method = RequestMethod.POST)
    public String offcialAddData(String title, String detail) {
        Date now = new Date();
        Official official = new Official(title, detail, now.toString());
        officialDao.save(official);
        return "redirect:/officialadmin";
    }

    /**
     * 删除某条数据
     * @param id
     * @return
     */
    @RequestMapping("/delet")
    public String delet(int id) {
        officialDao.delete(id);
        return "redirect:officialadmin";
    }

    /**
     * 改变状态
     * @param id
     * @return
     */
    @RequestMapping("/changestatus")
    public String changestatus(int id){
        Official official = officialDao.findOne(id);
        if(official.getStatus() == 0){
            official.setStatus(1);
        }else{
            official.setStatus(0);
        }
        officialDao.save(official);
        return "redirect:officialadmin";
    }

    /**
     * 管理员登录界面
     * @return
     */
    @RequestMapping("/login")
    public String loginAdmin() {
        if (session.getAttribute("user") == null) {
            return "login";
        } else {return "redirect:officialadmin";}
    }

    /**
     * 验证管理员密码错误自动返回登陆界面，密码正确返回管理员界面
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginResult(String username, String password) {
        if ((Objects.equals(username, DevConfig.adminUsername)) && (Objects.equals(password, DevConfig.adminPassword))) {
            session.setAttribute("user","admin");
            return "redirect:officialadmin";
        } else {
            return "login";//web
        }
    }

    /**
     * 对直接访问管理员界面的拦截
     * @param model
     * @return
     */
    @RequestMapping("/officialadmin")
    public String isAdmin(Model model) {
        if (session.getAttribute("user") == null) {
            return "login";//web
        } else {
            Iterable<Official> lists = officialDao.findAll(sortById());
            model.addAttribute("lists", lists);
            return "officialadmin";
        }
    }

    /**
     * 按照时间排序
     * @return
     */
    private Sort sortById() {
        return new Sort(Sort.Direction.DESC, "date");
    }
}
