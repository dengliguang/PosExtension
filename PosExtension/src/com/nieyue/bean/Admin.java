package com.nieyue.bean;

import java.io.Serializable;
import java.util.Date;
/**
 * 管理员类
 * @author yy
 *
 */
public class Admin implements Serializable {
	
	private static final long serialVersionUID = 8198930199550185349L;
	/**
	 * 管理员id
	 */
	private Integer adminId;
	/**
	 * 管理员名
	 */
	private String name;
	/**
	 * 管理员url
	 */
	private String password;
	/**
	 * 登录时间
	 */
	private Date updateTime;
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Admin(Integer adminId, String name, String password, Date updateTime) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.password = password;
		this.updateTime = updateTime;
	}
	public Admin() {
		super();
	}
}
