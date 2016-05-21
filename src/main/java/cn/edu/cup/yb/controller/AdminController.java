package cn.edu.cup.yb.controller;

import cn.edu.cup.yb.model.Admin;
import cn.edu.cup.yb.model.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * Created by 77dfeba on 2016/5/21.
 */
@Controller
public class AdminController {
    @Autowired
    private AdminDao adminDao;
    @RequestMapping("/login")
    public String reAdmin(){
        Admin admin = new Admin();
        admin.setUsername("admin");
        admin.setPassword("upcyiban");
        adminDao.save(admin);
        return "success!";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String loginResult(String username,String password,Model model){
        Collection<Admin> admins = adminDao.findByUsernameAndPassword(username, password);
        if(admins.isEmpty()){
            model.addAttribute("result","无用户");
        }
        else{
            model.addAttribute("result","登录成功！");
        }
        return "result";//web
    }
}
