package com.nieyue.dao;

import org.apache.ibatis.annotations.Param;

import com.nieyue.bean.Admin;
/**
 * 管理员接口
 * @author yy
 *
 */
public interface AdminDao {
	/**  管理员登录 */
	public Admin adminLogin(@Param("name")String name,@Param("password")String password);	
	/** 检测登录 管理员是否有效 */	
	public boolean chkLoginName(String name);	
	/** 修改注 管理员信息 */	
	public boolean updateAdmin(Admin admin) ;
	/**装载 管理员账户 */	
	public Admin loadAdmin(Integer adminId);	
}
