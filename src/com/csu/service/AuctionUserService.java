package com.csu.service;

import com.csu.pojo.AuctionUser;
/**
 * 
 * @author xuyiming
 * @description �û�ҵ���߼���
 * 
 */
public interface AuctionUserService {

	/**
	 * �ж��Ƿ�Ϊ��ϵͳ�û�
	 * @param userName
	 * @return
	 */
	public String isUser(String userName);
	
	/**
	 * �����û�
	 * @param auctionUser
	 */
	public void insert(AuctionUser auctionUser);
	
	/**
	 * ����userId�����û���Ϣ
	 * @param userId
	 * @return
	 */
	public AuctionUser getAuctionUserByUserId(int userId);
	
	/**
	 * ����userName��userPassword�����û���Ϣ
	 * @param auctionUser
	 * @return
	 */
	public AuctionUser getAuctionUserByUnAndUpw(AuctionUser auctionUser);
}
