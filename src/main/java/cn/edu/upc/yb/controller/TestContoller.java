package cn.edu.upc.yb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by yyljj on 2016/5/21.
 */

/**
 * 测试用的可以删掉
 */
@RestController
public class TestContoller {

    @RequestMapping("test")
    public String test(){
        Date date = new Date();
        return date.toString();
    }
}
