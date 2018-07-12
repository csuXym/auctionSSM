package com.csu.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csu.pojo.Auction;
import com.csu.pojo.AuctionRecord;
import com.csu.pojo.AuctionUser;
import com.csu.service.AuctionService;
import com.csu.service.AuctionRecordService;
import com.csu.util.Page;
/**
 * 
 * @author xuyiming
 * @description 拍品控制器
 * 
 */

@Controller
@RequestMapping("")
public class AuctionController {
	@Autowired
	AuctionService auctionService;
	@Autowired
	AuctionRecordService auctionRecordService;
	
	
	/**
	 * 查询某页拍品列表
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("onePageServlet")
	public ModelAndView getOnePage(HttpServletRequest request,HttpServletResponse response, HttpSession session){
		ModelAndView mav = new ModelAndView();

		int curPage = Integer.parseInt(request.getParameter("curPage"));
		Page page = (Page) session.getAttribute("page");
		page.setCurPage(curPage);
		List<Auction> auctionList = auctionService.getAuctionsByOnePage(page);
		session.setAttribute("auctionList", auctionList);
		AuctionUser user = (AuctionUser) session.getAttribute("auctionUser");
		if(user.getUserIsAdmin() == 0){
			mav.setViewName("list");
			return mav;
		}else{
			mav.setViewName("auctionmanager");
			return mav;
		}

	}
	
	/**
	 * 获取拍品信息
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("auctionServlet")
	public ModelAndView getAuction(HttpServletRequest request,HttpServletResponse response, HttpSession session){
		ModelAndView mav = new ModelAndView();
		
		int auctionId = Integer.parseInt(request.getParameter("auctionId"));
		Auction auction = auctionService.getAuctionByID(auctionId);
		List<AuctionRecord> auctionRecordList = auctionRecordService.getAuctionRecordsByAuctionId(auctionId);
		int highestPrice = 0;
		if(!auctionRecordList.isEmpty()){
			highestPrice = auctionRecordService.getHighestPriceById(auctionId);
		}
		else{
			
			highestPrice = auction.getAuctionStartPrice();
		}
		session.setAttribute("auction", auction);
		session.setAttribute("highestPrice", highestPrice);
		session.setAttribute("auctionRecordList", auctionRecordList);
		mav.setViewName("auction");
		return mav;
	}
	
	
	/**
	 * 跳转到添加拍品页面
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("addServlet")
	public ModelAndView addAuction(HttpServletRequest request,HttpServletResponse response, HttpSession session){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("add");
		return mav;
	
	}
	
	/**
	 * 添加拍品
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("publishServlet")
	public ModelAndView publishAuction(HttpServletRequest request,HttpServletResponse response, HttpSession session){
		ModelAndView mav = new ModelAndView();
		
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	
		String sive = request.getParameter("sive");
		String cancel = request.getParameter("cancel");
		Auction auction = new Auction();
		if(sive != null){			
			String name = request.getParameter("name");
			int firstPrice = Integer.parseInt(request.getParameter("firstPrice"));
			Date startTime= java.sql.Date .valueOf(request.getParameter("startTime"));
			Date endTime= java.sql.Date .valueOf(request.getParameter("endTime"));
			String picture = request.getParameter("picture");
			String describe = request.getParameter("describe");
			auction.setAuctionName(name);
			auction.setAuctionStartPrice(firstPrice);
			auction.setAuctionStartTime(startTime);
			auction.setAuctionEndTime(endTime);
			auction.setAuctionPic(picture);
			auction.setAuctionDesc(describe);
			auctionService.insert(auction);
			
			Page page = (Page) session.getAttribute("page");
			page.caculatemaxPage(auctionService.total());

			List<Auction> auctionList = auctionService.getAuctionsByOnePage(page);
			session.setAttribute("page", page);
			session.setAttribute("auctionList", auctionList);
			mav.setViewName("auctionmanager");
		}else if(cancel != null){
			mav.setViewName("auctionmanager");
		}
		
		return mav;
	
	}
	
	/**
	 * 删除拍品
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("delServlet")
	public ModelAndView delAuction(HttpServletRequest request,HttpServletResponse response, HttpSession session){
		ModelAndView mav = new ModelAndView();
		
		int auctionId = Integer.parseInt(request.getParameter("auctionId"));
		auctionRecordService.delete(auctionId);
		auctionService.delete(auctionId);

		Page page = (Page) session.getAttribute("page");
		page.caculatemaxPage(auctionService.total());
		if(page.getMaxPage() < page.getCurPage()){
			page.setCurPage(page.getMaxPage());
		}
		List<Auction> auctionList = auctionService.getAuctionsByOnePage(page);
		session.setAttribute("page", page);
		session.setAttribute("auctionList", auctionList);
	
		mav.setViewName("auctionmanager");
		return mav;
	}
	
	/**
	 * 跳转到修改界面
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("alterServlet")
	public ModelAndView alterAuction(HttpServletRequest request,HttpServletResponse response, HttpSession session){
		ModelAndView mav = new ModelAndView();
		int auctionId = Integer.parseInt(request.getParameter("auctionId"));
		Auction auction = auctionService.getAuctionByID(auctionId);
		session.setAttribute("auction", auction);		
		mav.setViewName("update");
		return mav;
	}
	
	/**
	 * 修改拍品
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("updateServlet")
	public ModelAndView updateAuction(HttpServletRequest request,HttpServletResponse response, HttpSession session){
		ModelAndView mav = new ModelAndView();
	
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String sive = request.getParameter("sive");
		String cancel = request.getParameter("cancel");
		Auction auc = (Auction) session.getAttribute("auction");
		if(sive != null){
			Auction auction = new Auction();
			String name = request.getParameter("name");
			int firstPrice = Integer.parseInt(request.getParameter("firstPrice"));
			Date startTime= java.sql.Date .valueOf(request.getParameter("startTime"));
			Date endTime= java.sql.Date .valueOf(request.getParameter("endTime"));
			String picture = request.getParameter("picture");
			String describe = request.getParameter("describe");
			auction.setAuctionId(auc.getAuctionId());
			auction.setAuctionName(name);
			auction.setAuctionStartPrice(firstPrice);
			auction.setAuctionStartTime(startTime);
			auction.setAuctionEndTime(endTime);
			auction.setAuctionPic(picture);
			auction.setAuctionDesc(describe);
			
			auctionService.update(auction);
			Page page = (Page) session.getAttribute("page");
			List<Auction> auctionList = auctionService.getAuctionsByOnePage(page);
			session.setAttribute("auctionList", auctionList);
			mav.setViewName("auctionmanager");
		}else if(cancel != null){
			mav.setViewName("auctionmanager");
		}
		
		return mav;
	}
	
	/**
	 * 导出拍品信息
	 * @param request
	 * @param response
	 * @param session
	 * @throws IOException
	 */
	@RequestMapping("exportExcelServlet")
	public void exportExcel(HttpServletRequest request,HttpServletResponse response, HttpSession session) throws IOException{

        List<Auction> list = auctionService.getAuctions();  

        HSSFWorkbook wb = auctionService.export(list);
        response.setContentType("application/vnd.ms-excel");  
        response.setHeader("Content-disposition", "attachment;filename=auction.xls");  
        OutputStream ouputStream = response.getOutputStream();  
        wb.write(ouputStream);  
        ouputStream.flush();  
        ouputStream.close(); 

	}

}
