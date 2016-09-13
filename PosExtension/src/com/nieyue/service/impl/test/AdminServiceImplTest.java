package com.nieyue.service.impl.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.nieyue.bean.Admin;
import com.nieyue.bean.Channel;
import com.nieyue.bean.User;
import com.nieyue.service.AdminService;
import com.nieyue.service.ChannelService;
import com.nieyue.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/spring-dao.xml","classpath:config/spring-service.xml"})
@TransactionConfiguration(transactionManager="txManager",defaultRollback=false)
public class AdminServiceImplTest {
	@Resource
	AdminService  adminService;
	@Resource
	ChannelService  channelService;
	@Resource
	UserService  iserService;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdminLogin() {
		Admin a = adminService.adminLogin("yayao", "yayao123++");
		System.out.println(a.getAdminId());
	}

	@Test
	public void testChkLoginName() {
		List<Channel> l = channelService.searchChannel(1, 1);
		System.out.println(l);
	}

	@Test
	public void testUpdateAdmin() {
		User user =new User();
		user.setName("sdf地方");
		user.setAddress("第三方士大夫");
		user.setPhone("234234");
		user.setRemark("dsf的份上");
		//user.setChannelId(1001);
		iserService.addUser(user);
	}

	@Test
	public void testLoadAdmin() {
		fail("Not yet implemented");
	}

}
