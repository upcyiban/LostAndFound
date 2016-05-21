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
    public int loginAdmin=0;
    @RequestMapping("/officialadmin")
    public String showAddofficialI(Model model) {

        Iterable<Official> lists = officialDao.findAll(sortById());
        model.addAttribute("lists",lists);
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
    public String delet(int id){
        officialDao.delete(id);
        return "redirect:officialadmin";
    }
    //login admin and official auth
    @RequestMapping("/login")
    public String loginAdmin(){
        if(loginAdmin==0){
            return "login";
        }
        else {
            return "officialadmin";
        }
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String loginResult(String username,String password,Model model){
        Collection<Admin> admins = adminDao.findByUsernameAndPassword(username, password);
        if(admins.isEmpty()){
            loginAdmin=0;
            return "login";//web
        }
        else{
            loginAdmin=1;
            return "redirect:officialadmin";
        }
    }
    @RequestMapping("/official")
    public String isAdmin(){
        if(loginAdmin != 1)
            return "login";
        else
            return "official";
    }
    //end login admin and official auth
    private Sort sortById(){
        return new Sort(Sort.Direction.DESC,"id");
    }
}
