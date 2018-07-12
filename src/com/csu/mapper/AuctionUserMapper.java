package com.csu.mapper;

import com.csu.pojo.AuctionUser;
/**
 * 
 * @author xuyiming
 * @description 用户信息的数据库持久层
 * 
 */
public interface AuctionUserMapper {
	/**
	 * 判断是否为本系统用户
	 * @param userName
	 * @return
	 */
	public String isUser(String userName);
	
	/**
	 * 增加用户
	 * @param auctionUser
	 */
	public void insert(AuctionUser auctionUser);
	 
	/**
	 * 根据userId返回用户信息
	 * @param userId
	 * @return
	 */
	public AuctionUser getAuctionUserByUserId(int userId);
	
	/**
	 * 根据userName和userPassword返回用户信息
	 * @param auctionUser
	 * @return
	 */
	public AuctionUser getAuctionUserByUnAndUpw(AuctionUser auctionUser);
	
	
	
}
