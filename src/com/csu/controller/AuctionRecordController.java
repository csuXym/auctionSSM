package com.csu.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csu.pojo.Auction;
import com.csu.pojo.AuctionRecord;
import com.csu.pojo.AuctionUser;
import com.csu.service.AuctionRecordService;
/**
 * 
 * @author xuyiming
 * @description ÅÄÆ·¼ÇÂ¼¿ØÖÆÆ÷
 * 
 */

@Controller
@RequestMapping("")
public class AuctionRecordController {
	
	@Autowired
	AuctionRecordService auctionRecordService;
	
	/**
	 * ¾ºÅÄÅÄÆ·
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("jingpaiServlet")
	public ModelAndView auctionAuction(HttpServletRequest request,HttpServletResponse response, HttpSession session){
		ModelAndView mav = new ModelAndView();
		
		String price = request.getParameter("auctionPrice");
		String returnList = request.getParameter("returnList");
		if(price != null){
			if(request.getParameter("sale") == ""){
				mav.setViewName("auction");
				return mav;
			}
		
			int auctionPrice = Integer.parseInt(request.getParameter("sale"));
			int highestPrice = auctionPrice;
			session.setAttribute("highestPrice", highestPrice);
			AuctionRecord auctionRecord = new AuctionRecord();
			AuctionUser user = (AuctionUser) session.getAttribute("auctionUser");
			Auction auction = (Auction) session.getAttribute("auction");
			auctionRecord.setUserId(user.getUserId());
			auctionRecord.setAuctionId(auction.getAuctionId());
			auctionRecord.setAuctionTime(new java.sql.Date(new Date().getTime()));
			auctionRecord.setAuctionPrice(auctionPrice);
			auctionRecordService.insert(auctionRecord);
			List<AuctionRecord> auctionRecordList = auctionRecordService.getAuctionRecordsByAuctionId(auction.getAuctionId());
			session.setAttribute("auctionRecordList", auctionRecordList);

			mav.setViewName("auction");
			return mav;
		}else if(returnList != null){
				mav.setViewName("list");
				return mav;
		}
		return mav;
	
	}
}
