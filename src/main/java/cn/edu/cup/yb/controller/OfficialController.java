package cn.edu.cup.yb.controller;

import cn.edu.cup.yb.model.Official;
import cn.edu.cup.yb.model.OfficialDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Created by yyljj on 2016/5/21.
 */
@Controller
public class OfficialController {

    @Autowired
    private OfficialDao officialDao;

    @RequestMapping("/addofficial")
    public String showAddofficialI() {
        return "addofficial";
    }

    @RequestMapping(value = "/official", method = RequestMethod.POST)
    public String offcialAddData(String title, String detail) {
        Date now = new Date();
        Official official = new Official(title, detail, now.toString());
        officialDao.save(official);
        return "redirect:/addofficial";
    }
}
