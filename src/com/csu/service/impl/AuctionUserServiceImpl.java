package com.csu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csu.mapper.AuctionUserMapper;
import com.csu.pojo.AuctionUser;
import com.csu.service.AuctionUserService;
/**
 * 
 * @author xuyiming
 * @description 用户业务逻辑层实现
 * 
 */

@Service
public class AuctionUserServiceImpl implements AuctionUserService{
	
	@Autowired
	AuctionUserMapper auctionUserMapper;

	public String isUser(String userName) {
		return auctionUserMapper.isUser(userName);
	}

	public void insert(AuctionUser auctionUser) {
		auctionUserMapper.insert(auctionUser);
	}

	public AuctionUser getAuctionUserByUserId(int userId) {
		return auctionUserMapper.getAuctionUserByUserId(userId);
	}

	public AuctionUser getAuctionUserByUnAndUpw(AuctionUser auctionUser) {
		return auctionUserMapper.getAuctionUserByUnAndUpw(auctionUser);
	}



}
