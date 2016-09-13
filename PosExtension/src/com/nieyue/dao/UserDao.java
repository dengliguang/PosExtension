package com.nieyue.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nieyue.bean.User;
/**
 * 用户管理接口
 * @author yy
 *
 */
public interface UserDao {
	/** 账户登录 */
	public User userLogin(@Param("name")String name,@Param("password")String password);	
	/** 检测登录帐号是否有效 */	
	public boolean chkLoginName(String name) ;	
	/** 找回账户 */	
	public User retrieveAccount(String name) ;	
	/** 新增注册账户 */	
	public boolean addUser(User user) ;
	/** 修改注册账户信息 */	
	public boolean updateUser(User user) ;
	/** 分页查询注册账户  */
	public List<User> searchUser(@Param("pageNum") Integer pageNum,@Param("pageSize")Integer pageSize) ;
	/** 浏览注册账户*/
	public List<User> browseUser() ;
	/** 根据渠道分页查询注册账户  */
	public List<User> searchUserByChannel(@Param("channelId") Integer channelId,@Param("pageNum") Integer pageNum,@Param("pageSize")Integer pageSize) ;
	/** 根据渠道浏览注册账户*/
	public List<User> browseUserByChannel(@Param("channelId") Integer channelId) ;
	/** 删除注册账户 */	
	public boolean delUser(Integer userId) ;
	/**装载注册账户 */	
	public User loadUser(Integer userId);	
}
