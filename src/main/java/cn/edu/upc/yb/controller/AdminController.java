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

    @RequestMapping(value = "/official", method = RequestMethod.POST)
    public String offcialAddData(String title, String detail) {
        Date now = new Date();
        Official official = new Official(title, detail, now.toString());
        officialDao.save(official);
        return "redirect:/officialadmin";
    }

    @RequestMapping("/delet")
    public String delet(int id) {
        officialDao.delete(id);
        return "redirect:officialadmin";
    }

    @RequestMapping("/changestatus")
    public String changestatus(int id){
        Official official = new Official();
        official = officialDao.findOne(id);
        official.setId(-1);
        if(officialDao.findOne(id).getStatus() == 0){
            officialDao.delete(id);
            official.setId(id);
            official.setStatus(1);
        }else{
            officialDao.delete(id);
            official.setId(id);
            official.setStatus(0);
        }
        officialDao.save(official);
        return "redirect:officialadmin";
    }
    //login admin and official auth

    @RequestMapping("/login")
    public String loginAdmin() {
        if (session.getAttribute("user") == null) {
            return "login";
        } else {return "redirect:officialadmin";}
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginResult(String username, String password) {
        if ((Objects.equals(username, DevConfig.adminUsername)) && (Objects.equals(password, DevConfig.adminPassword))) {
            session.setAttribute("user","admin");
            return "redirect:officialadmin";
        } else {
            return "login";//web
        }
    }

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
    //end login admin and official auth

    private Sort sortById() {
        return new Sort(Sort.Direction.DESC, "date");
    }
}
