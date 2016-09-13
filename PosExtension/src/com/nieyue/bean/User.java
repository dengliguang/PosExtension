package com.nieyue.bean;

import java.io.Serializable;
import java.util.Date;
/**
 * 用户类
 * @author yy
 *
 */
public class User implements Serializable {
	
	private static final long serialVersionUID = 8198930199550185349L;
	/**
	 * 用户id
	 */
	private Integer userId;
	/**
	 * 用户名
	 */
	private String name;
	/**
	 * 用户手机号
	 */
	private String phone;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 手机验证码
	 */
	private String phoneCode;
	/**
	 * 用户收货地址
	 */
	private String address;
	/**
	 * 备注 
	 */
	private String remark;
	/**
	 * 填写时间
	 */
	private Date fillTime;
	/**
	 * 渠道id
	 */
	private Integer channelId;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhoneCode() {
		return phoneCode;
	}
	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getFillTime() {
		return fillTime;
	}
	public void setFillTime(Date fillTime) {
		this.fillTime = fillTime;
	}
	public Integer getChannelId() {
		return channelId;
	}
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}
	public User(Integer userId, String name, String phone, String phoneCode,
			String address, String remark, Date fillTime, Integer channelId,String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.phone = phone;
		this.phoneCode = phoneCode;
		this.address = address;
		this.remark = remark;
		this.fillTime = fillTime;
		this.channelId = channelId;
		this.password=password;
	}
	public User() {
		super();
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
