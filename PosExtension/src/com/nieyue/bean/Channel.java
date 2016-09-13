package com.nieyue.bean;

import java.io.Serializable;
import java.util.Date;
/**
 * 渠道类
 * @author yy
 *
 */
public class Channel implements Serializable {
	
	private static final long serialVersionUID = 8198930199550185349L;
	/**
	 * 渠道id
	 */
	private Integer channelId;
	/**
	 * 渠道名
	 */
	private String name;
	/**
	 * 渠道url
	 */
	private String url;
	/**
	 * 盐
	 */
	private String salt;
	/**
	 * 填写时间
	 */
	private Date fillTime;
	public Integer getChannelId() {
		return channelId;
	}
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getFillTime() {
		return fillTime;
	}
	public void setFillTime(Date fillTime) {
		this.fillTime = fillTime;
	}
	public Channel(Integer channelId, String name, String url, Date fillTime,String salt) {
		super();
		this.channelId = channelId;
		this.name = name;
		this.url = url;
		this.fillTime = fillTime;
		this.salt=salt;
	}
	public Channel() {
		super();
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
}
