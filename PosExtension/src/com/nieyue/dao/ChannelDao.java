package com.nieyue.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nieyue.bean.Channel;
/**
 * 渠道管理接口
 * @author yy
 *
 */
public interface ChannelDao {
	/** 修改注册渠道 */	
	public boolean updateChannel(Channel Channel) ;
	/** 分页查询渠道  */
	public List<Channel> searchChannel(@Param("pageNum") Integer pageNum,@Param("pageSize")Integer pageSize) ;
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
