package com.csu.mapper;

import java.util.List;

import com.csu.pojo.Auction;
import com.csu.util.Page;
/**
 * 
 * @author xuyiming
 * @description ��Ʒ�����ݿ�־ò�
 *
 */
public interface AuctionMapper {
	 
	/**
	 * ��ȡĳҳ��Ʒ��Ϣ
	 * @param page
	 * @return
	 */
	public List<Auction> getAuctionsByOnePage(Page page);
	
	/**
	 * ��ȡȫ����Ʒ��Ϣ
	 * @return
	 */
	public List<Auction> getAuctions();
	 
	/**
	 * ����id��ȡĳ����Ʒ��Ϣ
	 * @param auctionId
	 * @return
	 */
	public Auction getAuctionByID(int auctionId);
	
	/**
	 * ������Ʒ
	 * @param auction
	 */
	public void insert(Auction auction);
	
	/**
	 * ɾ����Ʒ
	 * @param auctionId
	 */
	public void delete(int auctionId);
	
	/**
	 * �޸���Ʒ
	 * @param auction
	 */
	public void update(Auction auction);
	
	/**
	 * ͳ������Ʒ��
	 * @return
	 */
	public int total();

}
