package com.nieyue.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nieyue.bean.Admin;
import com.nieyue.dao.AdminDao;
import com.nieyue.service.AdminService;
/**
 * 管理员业务实现
 * @author yy
 *
 */
@Service
public class AdminServiceImpl implements AdminService{
	@Resource
	AdminDao adminDao;
	/**
	 * 登录
	 */
	@Override
	public Admin adminLogin(String name, String password) {
		Admin a = adminDao.adminLogin(name, password);
		return a;
	}
	/**
	 * 检查登录名是否存在
	 */
	@Override
	public boolean chkLoginName(String name) {
		boolean b = adminDao.chkLoginName(name);
		return b;
	}
	/**
	 * 更新单个
	 */
	@Override
	public boolean updateAdmin(Admin admin) {
		boolean b = adminDao.updateAdmin(admin);
		return b;
	}
	/**
	 * 加载单个
	 */
	@Override
	public Admin loadAdmin(Integer adminId) {
		Admin a = adminDao.loadAdmin(adminId);
		return a;
	}

}
