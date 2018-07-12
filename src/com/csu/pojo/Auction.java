package com.csu.pojo;

import java.util.Date;
import java.util.List;
/**
 * 
 * @author xuyiming
 * @description 拍品实体类
 *
 */
public class Auction {
	private int auctionId;
	private String auctionName;
	private int auctionStartPrice;
	private Date auctionStartTime;
	private Date auctionEndTime;
	private String auctionPic;
	private String auctionDesc;
	private List<AuctionRecord> auctionRecords;
	
	public int getAuctionId() {
		return auctionId;
	}
	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}
	public String getAuctionName() {
		return auctionName;
	}
	public void setAuctionName(String auctionName) {
		this.auctionName = auctionName;
	}
	public int getAuctionStartPrice() {
		return auctionStartPrice;
	}
	public void setAuctionStartPrice(int auctionStartPrice) {
		this.auctionStartPrice = auctionStartPrice;
	}
	public Date getAuctionStartTime() {
		return auctionStartTime;
	}
	public void setAuctionStartTime(Date auctionStartTime) {
		this.auctionStartTime = auctionStartTime;
	}
	public Date getAuctionEndTime() {
		return auctionEndTime;
	}
	public void setAuctionEndTime(Date auctionEndTime) {
		this.auctionEndTime = auctionEndTime;
	}
	public String getAuctionPic() {
		return auctionPic;
	}
	public void setAuctionPic(String auctionPic) {
		this.auctionPic = auctionPic;
	}
	public String getAuctionDesc() {
		return auctionDesc;
	}
	public void setAuctionDesc(String auctionDesc) {
		this.auctionDesc = auctionDesc;
	}
	public List<AuctionRecord> getAuctionRecords() {
		return auctionRecords;
	}
	public void setAuctionRecords(List<AuctionRecord> auctionRecords) {
		this.auctionRecords = auctionRecords;
	}
	
}
