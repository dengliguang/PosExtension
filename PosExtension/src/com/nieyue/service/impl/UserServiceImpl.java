package com.nieyue.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nieyue.bean.User;
import com.nieyue.dao.UserDao;
import com.nieyue.service.UserService;
/**
 * 用户业务实现
 * @author yy
 *
 */
@Service
public class UserServiceImpl implements UserService{
	@Resource
	UserDao userDao;
	/**
	 * 登录
	 */
	@Override
	public User userLogin(String name, String password) {
		User u = userDao.userLogin(name, password);
		return u;
	}
	/**
	 * 检查用户是否存在
	 */
	@Override
	public boolean chkLoginName(String name) {
		boolean b = userDao.chkLoginName(name);
		return b;
	}
	/**
	 * 找回
	 */
	@Override
	public User retrieveAccount(String name) {
		User u = userDao.retrieveAccount(name);
		return u;
	}
	/**
	 *添加
	 */
	@Override
	public boolean addUser(User user) {
		boolean b = userDao.addUser(user);
		return b;
	}
	/**
	 * 更新
	 */
	@Override
	public boolean updateUser(User user) {
		boolean b = userDao.updateUser(user);
		return b;
	}
	/**
	 * 分页查询
	 */
	@Override
	public List<User> searchUser(Integer pageNum, Integer pageSize) {
		if(pageNum<1){
			pageNum=1;
		}
		if(pageSize<1){
			pageSize=0;//没有数据
		}
		List<User> l = userDao.searchUser(pageNum-1, pageSize);
		return l;
	}
	/**
	 * 查询
	 */
	@Override
	public List<User> browseUser() {
		List<User> l = userDao.browseUser();
		return l;
	}
	/**
	 * 删除
	 */
	@Override
	public boolean delUser(Integer userId) {
		boolean b = delUser(userId);
		return b;
	}
	/**
	 * 登录
	 */
	@Override
	public User loadUser(Integer userId) {
		User u = loadUser(userId);
		return u;
	}
	/** 根据渠道分页查询注册账户  */
	@Override
	public List<User> searchUserByChannel(Integer channelId, Integer pageNum,
			Integer pageSize) {
		if(pageNum<1){
			pageNum=1;
		}
		if(pageSize<1){
			pageSize=0;//没有数据
		}
		List<User> l = userDao.searchUserByChannel(channelId,pageNum-1, pageSize);
		return l;
	}
	/** 根据渠道浏览注册账户*/
	@Override
	public List<User> browseUserByChannel(Integer channelId) {
		List<User> l = userDao.browseUserByChannel(channelId);
		return l;
	}
	
	
}
