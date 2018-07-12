package com.csu.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.csu.pojo.Auction;
import com.csu.util.Page;
/**
 * 
 * @author xuyiming
 * @description 拍品业务逻辑层
 * 
 */
public interface AuctionService {
	/**
	 * 获取某页拍品信息
	 * @param page
	 * @return
	 */
	public List<Auction> getAuctionsByOnePage(Page page);
	
	/**
	 * 获取全部拍品信息
	 * @return
	 */
	public List<Auction> getAuctions();
	 
	/**
	 * 根据id获取某件拍品信息
	 * @param auctionId
	 * @return
	 */
	public Auction getAuctionByID(int auctionId);
	
	/**
	 * 增加拍品
	 * @param auction
	 */
	public void insert(Auction auction);
	
	/**
	 * 删除拍品
	 * @param auctionId
	 */
	public void delete(int auctionId);
	
	/**
	 * 修改拍品
	 * @param auction
	 */
	public void update(Auction auction);
	
	/**
	 * 统计总拍品数
	 * @return
	 */
	public int total();
	
	/**
	 * 导出拍品信息
	 * @param list
	 * @return
	 */
	public HSSFWorkbook export(List<Auction> list);
}
