package cn.edu.cup.yb.controller;

import cn.edu.cup.yb.model.Admin;
import cn.edu.cup.yb.model.AdminDao;
import cn.edu.cup.yb.model.Official;
import cn.edu.cup.yb.model.OfficialDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.Date;

/**
 * Created by yyljj on 2016/5/21.
 */
@Controller
public class AdminController {

    @Autowired
    private OfficialDao officialDao;
    @Autowired
    private AdminDao adminDao;

    @RequestMapping("/officialadmin")
    public String showAddofficialI(Model model) {

        Iterable<Official> lists = officialDao.findAll(sortById());
        model.addAttribute("lists", lists);
        return "officialadmin";
    }

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

    @RequestMapping("/login")
    public String loginAdmin() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginResult(String username, String password, Model model) {
        Collection<Admin> admins = adminDao.findByUsernameAndPassword(username, password);
        if (admins.isEmpty()) {
            return "login";//web
        } else {
            return "redirect:officialadmin";
        }
    }

    private Sort sortById() {
        return new Sort(Sort.Direction.DESC, "date");
    }
}
