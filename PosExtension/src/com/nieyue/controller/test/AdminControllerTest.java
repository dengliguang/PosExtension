package com.nieyue.controller.test;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.nieyue.controller.AdminController;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:config/spring-dao.xml","classpath:config/spring-service.xml","classpath:config/springmvc-servlet.xml"})
public class AdminControllerTest {

	@Resource
	AdminController adminController;
	@Resource
	WebApplicationContext wac;
	MockHttpServletRequest request=new MockHttpServletRequest();
	MockHttpServletResponse response=new MockHttpServletResponse();
	MockMvc mvc;
	@Before
	public void setUp() throws Exception {
		this.mvc=MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUpdateAdmin() throws Exception {
		String url="/admin/update?sellerId=23&merCateId=1017&name=23";
		//String url="/mer/list?pageNum=2&pageSize=3";
		//String url="/mer/list.xml";
		this.mvc.perform(get(url))
		//.andExpect(status().isOk())
		.andDo(print());
	}

	@Test
	public void testAdminLogin() throws Exception {
		//String url="/admin/login?name=yayao&password=yayao123++";
		//String url="/channel/list?pageNum=1000&pageSize=3";
		String url="/user/add?name=的份上";
		//String url="/mer/list.xml";
		this.mvc.perform(get(url))
		//.andExpect(status().isOk())
		.andDo(print());
	}

	@Test
	public void testLoadAdmin() {
		fail("Not yet implemented");
	}

}
