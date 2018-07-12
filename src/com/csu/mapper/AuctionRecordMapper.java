package com.csu.mapper;

import java.util.List;

import com.csu.pojo.AuctionRecord;
/**
 * 
 * @author xuyiming
 * @description 拍品记录的数据库持久层
 * 
 */
public interface AuctionRecordMapper {
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
	 * @param auctionRecord
	 */
	public void insert(AuctionRecord auctionRecord);
	
	/**
	 * 删除相关拍品信息记录
	 * @param auctionId
	 */
	public void delete(int auctionId);

}
