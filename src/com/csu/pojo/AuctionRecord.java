package com.csu.pojo;

import java.util.Date;
/**
 * 
 * @author xuyiming
 * @description 拍品记录实体类
 *
 */
public class AuctionRecord {
	private int id;
	private int userId;
	private int auctionId;
	private Date auctionTime;
	private int auctionPrice;
	private AuctionUser auctionUser;
	private Auction auction;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAuctionId() {
		return auctionId;
	}
	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}
	public Date getAuctionTime() {
		return auctionTime;
	}
	public void setAuctionTime(Date auctionTime) {
		this.auctionTime = auctionTime;
	}
	public int getAuctionPrice() {
		return auctionPrice;
	}
	public void setAuctionPrice(int auctionPrice) {
		this.auctionPrice = auctionPrice;
	}
	public AuctionUser getAuctionUser() {
		return auctionUser;
	}
	public void setAuctionUser(AuctionUser auctionUser) {
		this.auctionUser = auctionUser;
	}
	public Auction getAuction() {
		return auction;
	}
	public void setAuction(Auction auction) {
		this.auction = auction;
	}
	
	
}
