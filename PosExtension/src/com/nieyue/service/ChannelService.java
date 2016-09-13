package com.nieyue.service;

import java.util.List;

import com.nieyue.bean.Channel;
/**
 * 管理员业务接口
 * @author yy
 *
 */
public interface ChannelService {
	/** 修改注册渠道 */	
	public boolean updateChannel(Channel Channel) ;
	/** 分页查询渠道  */
	public List<Channel> searchChannel( Integer pageNum,Integer pageSize) ;
	/** 浏览渠道*/
	public List<Channel> browseChannel() ;
	/** 新增渠道 */	
	public boolean addChannel(Channel channel) ;
	/** 删除渠道 */	
	public boolean delChannel(Integer channelId) ;
	/**装载渠道*/	
	public Channel loadChannel(Integer channelId);
	/**根据盐装载渠道*/	
	public Channel loadChannelBySalt(String salt);
}
