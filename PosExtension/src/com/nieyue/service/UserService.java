package com.nieyue.service;

import java.util.List;

import com.nieyue.bean.User;
/**
 * 用户业务接口
 * @author yy
 *
 */
public interface UserService {
	/** 账户登录 */
	public User userLogin(String name,String password);	
	/** 检测登录帐号是否有效 */	
	public boolean chkLoginName(String name) ;	
	/** 找回账户 */	
	public User retrieveAccount(String name) ;	
	/** 新增注册账户 */	
	public boolean addUser(User user) ;
	/** 修改注册账户信息 */	
	public boolean updateUser(User user) ;
	/** 分页查询注册账户  */
	public List<User> searchUser(Integer pageNum,Integer pageSize) ;
	/** 浏览注册账户*/
	public List<User> browseUser() ;
	/** 根据渠道分页查询注册账户  */
	public List<User> searchUserByChannel( Integer channelId,Integer pageNum,Integer pageSize) ;
	/** 根据渠道浏览注册账户*/
	public List<User> browseUserByChannel(Integer channelId) ;
	/** 删除注册账户 */	
	public boolean delUser(Integer userId) ;
	/**装载注册账户 */	
	public User loadUser(Integer userId);	
}
