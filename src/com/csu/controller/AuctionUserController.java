package com.csu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csu.pojo.Auction;
import com.csu.pojo.AuctionUser;
import com.csu.service.AuctionService;
import com.csu.service.AuctionUserService;
import com.csu.util.Page;
import com.csu.util.VerifyCodeUtils;
/**
 * 
 * @author xuyiming
 * @description �û�������
 * 
 */

@Controller
@RequestMapping("")
public class AuctionUserController {
	@Autowired
	AuctionUserService auctionUserService;
	@Autowired
	AuctionService auctionService;
	
	/**
	 * ��½ҳ��
	 * @return
	 */
	@RequestMapping("")
	public ModelAndView view(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	
	/**
	 * ��½����ע��
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("loginning")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response, HttpSession session){
		ModelAndView mav = new ModelAndView();
		String login = request.getParameter("login");
		String reg = request.getParameter("reg");
		String check = request.getParameter("check");
		String rand = (String) session.getAttribute("rand");
		rand = rand.toLowerCase();
		check = check.toLowerCase();
		if(login != null){
			if(check.equals(rand)){
				AuctionUser auctionUser = new AuctionUser();
				String userName = request.getParameter("name");
				String userPassword = auctionUserService.isUser(userName);
				if(request.getParameter("password") == null){
					session.setAttribute("message", "����������!");
					mav.setViewName("login");
					return mav;
				}
				if(request.getParameter("password").equals(userPassword)){
					auctionUser.setUserName(userName);
					auctionUser.setUserPassword(userPassword);
					auctionUser = auctionUserService.getAuctionUserByUnAndUpw(auctionUser);
					session.setAttribute("auctionUser", auctionUser);
					
					Page page = new Page();
					//����Ʒ��Ϣ����ǰҳ����û���Ϣ����session

					//�û�-0  ����Ա-1
					if(auctionUser.getUserIsAdmin() == 0){
						page.setCount(10);
						page.caculatemaxPage(auctionService.total());
						page.caculateStart();
						List<Auction> auctionList = auctionService.getAuctionsByOnePage(page);
						session.setAttribute("page", page);
						session.setAttribute("auctionList", auctionList);
						mav.setViewName("list");
						return mav;
					}else{
						page.setCount(5);
						page.caculatemaxPage(auctionService.total());
						page.caculateStart();
						List<Auction> auctionList = auctionService.getAuctionsByOnePage(page);
						session.setAttribute("page", page);
						session.setAttribute("auctionList", auctionList);
						mav.setViewName("auctionmanager");
						return mav;
					}

				}
				else{
					session.setAttribute("message", "�˻����������!");
					mav.setViewName("login");
					return mav;
				}
				
			}else{
				session.setAttribute("message", "��֤�����!");
				mav.setViewName("login");
				return mav;
			}
			
		}
		else {
			mav.setViewName("reg");
			return mav;
		}
	
	}
	
	/**
	 * ע��
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("register")
	public ModelAndView reg(HttpServletRequest request,HttpServletResponse response, HttpSession session){
		ModelAndView mav = new ModelAndView();
		
		String name = request.getParameter("userName");
		String password = request.getParameter("userPassword");
		String userPasswordCheck = request.getParameter("userPasswordCheck");
		AuctionUser user = new AuctionUser();
		
		if(password.equals(userPasswordCheck)){
			user.setUserName(name);
			user.setUserPassword(password);
			user.setUserIsAdmin(0);
			auctionUserService.insert(user);
			mav.setViewName("login");
			return mav;
		}
		else{
			mav.setViewName("reg");
			return mav;
		}
	}
	
	/**
	 * ע��
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("logoutServlet")
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response, HttpSession session){
		ModelAndView mav = new ModelAndView();
		session.setAttribute("auctionUser", null);
		session.setAttribute("page", null);
		session.setAttribute("auctionList", null);
		session.setAttribute("auctionRecordList", null);
		mav.setViewName("login");
		return mav;
	}
	
	/**
	 * ��֤��ͼƬ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("authImage")
    public void service(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
          
        response.setHeader("Pragma", "No-cache");    
        response.setHeader("Cache-Control", "no-cache");    
        response.setDateHeader("Expires", 0);    
        response.setContentType("image/jpeg");    
            
        //��������ִ�    
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);    
        //����Ựsession    
        HttpSession session = request.getSession(true);    
        session.setAttribute("rand", verifyCode.toLowerCase());    
        //����ͼƬ    
        int w = 100, h = 30;    
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);   
    } 
}
