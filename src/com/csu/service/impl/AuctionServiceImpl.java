package com.csu.service.impl;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csu.mapper.AuctionMapper;
import com.csu.pojo.Auction;
import com.csu.service.AuctionService;
import com.csu.util.Page;
/**
 * 
 * @author xuyiming
 * @description 拍品业务逻辑层实现
 * 
 */

@Service
public class AuctionServiceImpl implements AuctionService{
	@Autowired
	AuctionMapper auctionMapper;
	
	public List<Auction> getAuctionsByOnePage(Page page) {
		return auctionMapper.getAuctionsByOnePage(page);
	}

	public List<Auction> getAuctions() {
		return auctionMapper.getAuctions();
	}

	public Auction getAuctionByID(int auctionId) {
		return auctionMapper.getAuctionByID(auctionId);
	}

	public void insert(Auction auction) {
		auctionMapper.insert(auction);
	}

	public void delete(int auctionId) {
		auctionMapper.delete(auctionId);
	}

	public void update(Auction auction) {
		auctionMapper.update(auction);
	}

	public int total() {
		return auctionMapper.total();
	}


	public HSSFWorkbook export(List<Auction> list) {
		 String[] excelHeader = { "商品编号", "商品名称", "商品起拍价","商品竞拍开始时间","商品竞拍结束时间","商品图片地址","商品描述"};
		 HSSFWorkbook wb = new HSSFWorkbook();
		 HSSFSheet sheet = wb.createSheet("Auction");  
	     HSSFRow row = sheet.createRow((int) 0);  
	     HSSFCellStyle style = wb.createCellStyle();  
	     //style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
	  
	     for (int i = 0; i < excelHeader.length; i++) {
	    	 HSSFCell cell = row.createCell(i);  
	         cell.setCellValue(excelHeader[i]);  
	         cell.setCellStyle(style);  
	         sheet.autoSizeColumn(i);  
	         //sheet.SetColumnWidth(i, 100 * 256);  
	     }  
	  
	     for (int i = 0; i < list.size(); i++) {
	    	 row = sheet.createRow(i + 1);  
	         Auction auction = list.get(i);  
	         row.createCell(0).setCellValue(auction.getAuctionId());  
	         row.createCell(1).setCellValue(auction.getAuctionName());  
	         row.createCell(2).setCellValue(auction.getAuctionStartPrice());
	         row.createCell(3).setCellValue(auction.getAuctionStartTime());  
	         row.createCell(4).setCellValue(auction.getAuctionEndTime());  
	         row.createCell(5).setCellValue(auction.getAuctionPic());
	         row.createCell(6).setCellValue(auction.getAuctionDesc());
	     }  
	     return wb;  
	}

}
