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
 * @description 用户控制器
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
	 * 登陆页面
	 * @return
	 */
	@RequestMapping("")
	public ModelAndView view(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	
	/**
	 * 登陆或者注册
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
					session.setAttribute("message", "请输入密码!");
					mav.setViewName("login");
					return mav;
				}
				if(request.getParameter("password").equals(userPassword)){
					auctionUser.setUserName(userName);
					auctionUser.setUserPassword(userPassword);
					auctionUser = auctionUserService.getAuctionUserByUnAndUpw(auctionUser);
					session.setAttribute("auctionUser", auctionUser);
					
					Page page = new Page();
					//把拍品信息、当前页码和用户信息放入session

					//用户-0  管理员-1
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
					session.setAttribute("message", "账户或密码错误!");
					mav.setViewName("login");
					return mav;
				}
				
			}else{
				session.setAttribute("message", "验证码错误!");
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
	 * 注册
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
	 * 注销
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
	 * 验证码图片
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
            
        //生成随机字串    
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);    
        //存入会话session    
        HttpSession session = request.getSession(true);    
        session.setAttribute("rand", verifyCode.toLowerCase());    
        //生成图片    
        int w = 100, h = 30;    
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);   
    } 
}
