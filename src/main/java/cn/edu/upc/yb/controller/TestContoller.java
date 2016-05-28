package cn.edu.upc.yb.controller;

import cn.edu.upc.yb.model.Official;
import cn.edu.upc.yb.model.OfficialDao;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by yyljj on 2016/5/21.
 */

/**
 * 测试用的可以删掉
 */
@Controller
public class TestContoller {

    @Autowired
    private OfficialDao officialDao;

    @RequestMapping("/test")
    public String test(Model model){
        Iterable<Official> lists = officialDao.findByIsdeletNotOrderByDateDesc(true);
        model.addAttribute("lists",lists);
        return "test";
    }
}
