package com.csu.service;

import java.util.List;

import com.csu.pojo.AuctionRecord;
/**
 * 
 * @author xuyiming
 * @description 拍品记录业务逻辑层
 * 
 */
public interface AuctionRecordService {
	/**
	 * 根据拍品id查询竞拍记录
	 * @param auctionId
	 * @return
	 */
	public List<AuctionRecord> getAuctionRecordsByAuctionId(int auctionId);
	
	/**
	 * 根据用户id查询竞拍记录
	 * @param userId
	 * @return
	 */
	public List<AuctionRecord> getAuctionRecordsByUserId(int userId);
	
	/**
	 * 获取某拍品当前最高价
	 * @param auctionId
	 * @return
	 */
	public int getHighestPriceById(int auctionId);
	
	/**
	 * 竞拍某拍品
	 * @param Auctionrecord
	 */
	public void insert(AuctionRecord Auctionrecord);
	
	/**
	 * 删除相关拍品信息记录
	 * @param auctionId
	 */
	public void delete(int auctionId);

}
