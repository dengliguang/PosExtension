package com.nieyue.service;

import com.nieyue.bean.Admin;
/**
 * 管理员业务接口
 * @author yy
 *
 */
public interface AdminService {
	/**  管理员登录 */
	public Admin adminLogin(String name,String password);	
	/** 检测登录 管理员是否有效 */	
	public boolean chkLoginName(String name);	
	/** 修改注 管理员信息 */	
	public boolean updateAdmin(Admin admin) ;
	/**装载 管理员账户 */	
	public Admin loadAdmin(Integer adminId);	
}
