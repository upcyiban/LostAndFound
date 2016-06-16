package cn.edu.upc.yb;

import cn.edu.upc.yb.model.User;
import cn.edu.upc.yb.model.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LostandfoundApplication.class)
@WebAppConfiguration
public class LostandfoundApplicationTests {

	@Autowired
	private  UserDao userDao;

	@Test
	public void contextLoads() {
		for (int i = 0; i < 100; i++) {
			User user = new User("id" + i, "name" + i, "nickname" + i, "M", "title" + i, "detail" + i, 1, new Date().toString(), null, false, false);
			userDao.save(user);
		}
	}



}
