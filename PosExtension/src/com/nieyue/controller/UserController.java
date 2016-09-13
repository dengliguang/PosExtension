package com.nieyue.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nieyue.bean.User;
import com.nieyue.comments.StateResult;
import com.nieyue.myView.PDFView;
import com.nieyue.myView.XLSView;
import com.nieyue.service.UserService;

/**
 * 用户控制类
 * @author yy
 *
 */
@RequestMapping("/user")
@Controller("userController")
public class UserController {
	@Resource
	private UserService userService;
	@Resource(name = "xlsView")
	private XLSView xlsView;
	@Resource(name = "pdfView")
	private PDFView pdfView;
	/**
	 * 分页查询渠道 
	 * @return
	 */
	@RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<User> searchUser(
			@RequestParam(value="pageNum",defaultValue="1",required=false)int pageNum,
			@RequestParam(value="pageSize",defaultValue="10",required=false) int pageSize
			,HttpSession session)  {
			List<User> list = new ArrayList<User>();
			if(pageNum==0 ||pageSize==0){//查询所有
				list=userService.browseUser();
				return list;
			}
			list= userService.searchUser(pageNum, pageSize);
			return list;
	}
	/**
	 * 分页查询渠道 
	 * @return
	 */
	@RequestMapping(value = "/{channelId}/list", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<User> searchUserByChannelId(
			@PathVariable(value="channelId") int channelId,
			@RequestParam(value="pageNum",defaultValue="1",required=false)int pageNum,
			@RequestParam(value="pageSize",defaultValue="10",required=false) int pageSize
			,HttpSession session)  {
		List<User> list = new ArrayList<User>();
		if(pageNum==0 ||pageSize==0){//查询所有
			list=userService.browseUserByChannel(channelId);
			return list;
		}
		list= userService.searchUserByChannel(channelId, pageNum, pageSize);
		return list;
	}
	
	/** 找回账户 */	
	@RequestMapping(value = "/retrieveAccount", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody User addUser(@RequestParam("name")String name,HttpSession session)  {
		 User u = userService.retrieveAccount(name);
		return u;
	}
	/** 新增注册账户 */	
	@RequestMapping(value = "/add", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult addUser(@ModelAttribute User user,HttpSession session)  {
		boolean b = userService.addUser(user);
		return StateResult.getSR(b);
	}
	/** 删除注册账户 */	
	@RequestMapping(value = "/{userId}/delete", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult delUser(@RequestParam("userId")Integer userId,HttpSession session)  {
		 boolean b = userService.delUser(userId);
		return StateResult.getSR(b);
	}
	
	/** 修改注册账户信息 */	
	@RequestMapping(value = "/update", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult updateUser(@ModelAttribute User user,HttpSession session)  {
		boolean um = userService.updateUser(user);
		return StateResult.getSR(um);
	}
	
	/** 账户登录 */
	@RequestMapping(value = "/login", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody User userLogin(@ModelAttribute User user,HttpSession session)  {
		User u=new User();
		if(user.getName()!=null && userService.chkLoginName(user.getName())){
			u = userService.userLogin(user.getName(), user.getPassword());
		}
		return u;
	}
	/**装载注册账户 */	
	@RequestMapping(value = "/{userId}", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody User loadUser(@PathVariable("userId") Integer userId,HttpSession session)  {
		User user=new User();
		user =userService.loadUser(userId);
		return user;
	}
	/**
	 * xls
	 * 
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping(value = {"/downloadXLS/{channelId}"}, method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public XLSView downloadXLS(@PathVariable("channelId")int channelId ,HttpSession session,Model model) {
		List<User> list = userService.browseUserByChannel(channelId);
		model.addAttribute("userList", list);
		xlsView.setFileName("渠道ID为"+channelId+"的PDF文件用户信息");
		return xlsView;
		
	}
	/**
	 * pdf
	 * 
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping(value = {"/downloadPDF/{channelId}"}, method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody PDFView downloadPDF(@PathVariable("channelId")int channelId ,HttpSession session,Model model) {
		List<User> list = userService.browseUserByChannel(channelId);
		model.addAttribute("userList", list);
		pdfView.setFileName("渠道ID为"+channelId+"的excel文件用户信息");
		return pdfView;
		
	}
	
}
