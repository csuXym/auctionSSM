package com.csu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csu.mapper.AuctionRecordMapper;
import com.csu.pojo.AuctionRecord;
import com.csu.service.AuctionRecordService;
/**
 * 
 * @author xuyiming
 * @description 拍品记录业务逻辑层实现
 */

@Service
public class AuctionRecordServiceImpl implements AuctionRecordService{
	@Autowired
	AuctionRecordMapper auctionRecordMapper;

	public List<AuctionRecord> getAuctionRecordsByAuctionId(int auctionId) {
		return auctionRecordMapper.getAuctionRecordsByAuctionId(auctionId);
	}

	public List<AuctionRecord> getAuctionRecordsByUserId(int userId) {
		return auctionRecordMapper.getAuctionRecordsByUserId(userId);
	}

	public int getHighestPriceById(int auctionId) {
		return auctionRecordMapper.getHighestPriceById(auctionId);
	}

	public void insert(AuctionRecord Auctionrecord) {
		auctionRecordMapper.insert(Auctionrecord);
	}

	public void delete(int auctionId) {
		auctionRecordMapper.delete(auctionId);
	}

}
