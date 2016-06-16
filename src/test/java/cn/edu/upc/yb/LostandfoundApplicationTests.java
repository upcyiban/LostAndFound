package cn.edu.upc.yb;

import cn.edu.upc.yb.model.User;
import cn.edu.upc.yb.model.UserDao;
import cn.edu.upc.yb.model.UserDaoPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LostandfoundApplication.class)
@WebAppConfiguration
public class LostandfoundApplicationTests {

	@Autowired
	private  UserDao userDao;

	@Autowired
	private UserDaoPage userDaoPage;

	@Test
	public void contextLoads() {
		for (int i = 0; i < 100; i++) {
			User user = new User("id" + i, "name" + i, "nickname" + i, "M", "title" + i, "detail" + i, 1, new Date().toString(), null, false, false);
			userDao.save(user);
		}
	}

	@Test
	public Page<User> page(@RequestParam(value = "page", defaultValue = "0") Integer page,
						   @RequestParam(value = "size", defaultValue = "15") Integer size) {
		Pageable pageable = new PageRequest(page,size);
		return userDaoPage.findAll(pageable);
	}



}
