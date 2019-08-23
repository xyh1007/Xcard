package com.xyh.game;

import com.xyh.game.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {XcardApplication.class},webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class XcardApplicationTests {

	@Resource
	private UserDao userDao;

	@Test
	public void contextLoads() {
		System.out.println(userDao.findById(1L).get().toString());
	}

}
