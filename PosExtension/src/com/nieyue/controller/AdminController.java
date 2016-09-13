package com.nieyue.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nieyue.bean.Admin;
import com.nieyue.comments.StateResult;
import com.nieyue.service.AdminService;

/**
 * 用户控制类
 * @author yy
 *
 */
@RequestMapping("/Admin")
@Controller("adminController")
public class AdminController {
	@Resource
	private AdminService adminService;
	
	
	/**
	 * 修改注 管理员信息
	 * @return
	 */
	@RequestMapping(value = "/update", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult updateAdmin(@ModelAttribute Admin admin,HttpSession session)  {
		boolean um = adminService.updateAdmin(admin);
		return StateResult.getSR(um);
	}
	
	/**
	 * 管理员登录
	 * @return
	 */
	@RequestMapping(value = "/login", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Admin adminLogin(@ModelAttribute Admin admin,HttpSession session)  {
		Admin a=new Admin();
		if(admin.getName()!=null && adminService.chkLoginName(admin.getName())){
			a = adminService.adminLogin(admin.getName(), admin.getPassword());
			session.setAttribute("admin", a);
		}
		return a;
	}
	/**
	 * *装载 管理员账户
	 * @return
	 */
	@RequestMapping(value = "/{adminId}", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Admin loadAdmin(@PathVariable("adminId") Integer adminId,HttpSession session)  {
		Admin admin=new Admin();
		admin = adminService.loadAdmin(adminId);
		return admin;
	}
	/**
	 * *是否已经登录
	 * @return
	 */
	@RequestMapping(value = "/isLogin", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult isLogin(@RequestParam("adminId") Integer adminId,HttpSession session)  {
		if(session.getAttribute("admin")!=null&&((Admin)session.getAttribute("admin")).getAdminId().equals(adminId)){
			return StateResult.getSR(true);
		}
		return StateResult.getSR(false);
	}
	/**
	 * 登录退出
	 * @return
	 */
	@RequestMapping(value = "/loginOut", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult loginOut(@RequestParam("adminId") Integer adminId,HttpSession session)  {
		if(session.getAttribute("admin")!=null&&((Admin)session.getAttribute("admin")).getAdminId().equals(adminId)){
			session.removeAttribute("admin");
			return StateResult.getSR(true);
		}
		return StateResult.getSR(false);
	}
	
	
	
}
