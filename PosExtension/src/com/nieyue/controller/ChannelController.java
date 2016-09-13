package com.nieyue.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nieyue.bean.Channel;
import com.nieyue.comments.StateResult;
import com.nieyue.service.ChannelService;

/**
 * 商品控制类
 * @author yy
 *
 */
@Controller("channelController")
@RequestMapping("/channel")
public class ChannelController {
	@Resource
	private ChannelService channelService;
	
	
	/**
	 * 分页查询渠道 
	 * @return
	 */
	@RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<Channel> searchChannel(
			@RequestParam(value="pageNum",defaultValue="1",required=false)int pageNum,
			@RequestParam(value="pageSize",defaultValue="10",required=false) int pageSize
			,HttpSession session)  {
			List<Channel> list = new ArrayList<Channel>();
			if(pageNum==0 ||pageSize==0){//查询所有
				list= channelService.browseChannel();
				return list;
			}
			list= channelService.searchChannel(pageNum, pageSize);
			return list;
	}
	
	/** 修改注册渠道 */	
	@RequestMapping(value = "/update", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult updateChannel(@ModelAttribute Channel channel,HttpSession session)  {
		Channel newC = channelService.loadChannel(channel.getChannelId());
		newC.setName(channel.getName());
		boolean um = channelService.updateChannel(newC);
		return StateResult.getSR(um);
	}
	/** 新增渠道 */	
	@RequestMapping(value = "/add", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult addChannel(@ModelAttribute Channel channel, HttpSession session)  {
		String salt=UUID.randomUUID().toString().replace("-", "");
		channel.setSalt(salt);
		boolean am = channelService.addChannel(channel);
		Channel newC = channelService.loadChannelBySalt(salt);
		newC.setUrl(newC.getUrl()+"?channel_id="+newC.getChannelId());
		channelService.updateChannel(newC);
		//设置url
		return StateResult.getSR(am);
	}
	/**
	 * 删除渠道
	 * @return
	 */
	@RequestMapping(value = "/{channelId}/delete", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult delChannel(@PathVariable("channelId") Integer channelId,HttpSession session)  {
		boolean dm = channelService.delChannel(channelId);
		return StateResult.getSR(dm);
	}

	 /**装载渠道*/	
	@RequestMapping(value = "/{channelId}", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Channel loadChannel(@PathVariable("channelId") Integer channelId,HttpSession session)  {
		Channel channel=new Channel();
		channel = channelService.loadChannel(channelId);
		return channel;
	}
	
}
