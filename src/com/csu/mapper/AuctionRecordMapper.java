package com.csu.mapper;

import java.util.List;

import com.csu.pojo.AuctionRecord;
/**
 * 
 * @author xuyiming
 * @description ��Ʒ��¼�����ݿ�־ò�
 * 
 */
public interface AuctionRecordMapper {
	/**
	 * ������Ʒid��ѯ���ļ�¼
	 * @param auctionId
	 * @return
	 */
	public List<AuctionRecord> getAuctionRecordsByAuctionId(int auctionId);
	
	/**
	 * �����û�id��ѯ���ļ�¼
	 * @param userId
	 * @return
	 */
	public List<AuctionRecord> getAuctionRecordsByUserId(int userId);
	
	/**
	 * ��ȡĳ��Ʒ��ǰ��߼�
	 * @param auctionId
	 * @return
	 */
	public int getHighestPriceById(int auctionId);
	
	/**
	 * ����ĳ��Ʒ
	 * @param auctionRecord
	 */
	public void insert(AuctionRecord auctionRecord);
	
	/**
	 * ɾ�������Ʒ��Ϣ��¼
	 * @param auctionId
	 */
	public void delete(int auctionId);

}
