package com.csu.pojo;

import java.util.List;
/**
 * 
 * @author xuyiming
 * @description 用户实体类
 *
 */
public class AuctionUser {
	private int userId;
	private String userName;
	private String userPassword;
	private int userIsAdmin;
	private List<AuctionRecord> auctionRecords;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getUserIsAdmin() {
		return userIsAdmin;
	}
	public void setUserIsAdmin(int userIsAdmin) {
		this.userIsAdmin = userIsAdmin;
	}
	public List<AuctionRecord> getAuctionRecords() {
		return auctionRecords;
	}
	public void setAuctionRecords(List<AuctionRecord> auctionRecords) {
		this.auctionRecords = auctionRecords;
	}

}
