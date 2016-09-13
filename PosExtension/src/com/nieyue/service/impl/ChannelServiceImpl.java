package com.nieyue.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nieyue.bean.Channel;
import com.nieyue.dao.ChannelDao;
import com.nieyue.service.ChannelService;
/**
 * 渠道业务实现
 * @author yy
 *
 */
@Service
public class ChannelServiceImpl implements ChannelService{
	@Resource
	ChannelDao channelDao;
	/**
	 * 更新
	 */
	@Override
	public boolean updateChannel(Channel Channel) {
		boolean b = channelDao.updateChannel(Channel);
		return b;
	}
	/**
	 * 分页浏览
	 */
	@Override
	public List<Channel> searchChannel(Integer pageNum, Integer pageSize) {
		if(pageNum<1){
			pageNum=1;
		}
		if(pageSize<1){
			pageSize=0;//没有数据
		}
		List<Channel> l = channelDao.searchChannel(pageNum-1, pageSize);
		return l;
	}
	/**
	 * 浏览
	 */
	@Override
	public List<Channel> browseChannel() {
		List<Channel> l = channelDao.browseChannel();
		return l;
	}
	/**
	 * 增加单个
	 */
	@Override
	public boolean addChannel(Channel channel) {
		boolean b = channelDao.addChannel(channel);
		return b;
	}
	/**
	 * 删除单个
	 */
	@Override
	public boolean delChannel(Integer channelId) {
		boolean b = channelDao.delChannel(channelId);
		return b;
	}
	/**
	 * 加载单个
	 */
	@Override
	public Channel loadChannel(Integer channelId) {
		Channel c = channelDao.loadChannel(channelId);
		return c;
	}
	/**根据盐装载渠道*/	
	@Override
	public Channel loadChannelBySalt(String salt) {
		Channel c = channelDao.loadChannelBySalt(salt);
		return c;
	}

}
