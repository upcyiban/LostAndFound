package cn.edu.upc.yb.service;

import cn.edu.upc.yb.model.User;
import cn.edu.upc.yb.model.UserDao;
import org.springframework.beans.factory.access.BootstrapException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by yyljj on 16-6-1.
 */
@Service
public class UserService {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private UserDao userDao;

    public boolean saveUser(String title,String detail,String what) {
        Boolean wa = true;
        if(what.equals("1")){
            wa = false;
        }
        String date = new Date().toString();
        String ybuserid = httpSession.getAttribute("userid").toString();
        String ybusername = httpSession.getAttribute("username").toString();
        String ybusernick = httpSession.getAttribute("usernick").toString();
        String ybsex = httpSession.getAttribute("usersex").toString();
        User user = new User(ybuserid,ybusername, ybusernick,ybsex,title,detail,0,date,null,false,wa);
        userDao.save(user);
        return true;

    }

}
