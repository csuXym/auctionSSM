<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理员系统</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="wrap">
<!-- main begin-->
  <div class="sale">
    <h1 class="lf">在线拍卖系统</h1>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   
	    <div class="logout right"><a href="logoutServlet" title="注销">注销</a></div>
	 <div class="logout right"><a href="exportExcelServlet" title="导出excel">导出excel</a></div>
	  <div class="logout right"><a href="addServlet" title="发布">发布</a></div>
  </div>

  <div class="items">
      <ul class="rows even strong">
        <li>名称</li>
        <li class="list-wd">描述</li>
        <li>开始时间</li>
        <li>结束时间</li>
        <li>起拍价</li>
        <li class="borderno">操作</li>
      </ul>
      
      <c:forEach var="auction" items="${sessionScope.auctionList}">
	      <ul class="rows">
	        <li><a href="alterServlet?auctionId=${auction.auctionId}" title="">${auction.auctionName}</a></li>
        	<li class="list-wd">${auction.auctionDesc}</li>
	        <li>${auction.auctionStartTime}</li>
	        <li>${auction.auctionEndTime}</li>
	        <li>${auction.auctionStartPrice}</li>
	        <li class="borderno red">
	         
	         <a href="delServlet?auctionId=${auction.auctionId}" title="竞拍" onclick="abc();">删除</a>
	        </li>
	      </ul>
	  </c:forEach>
   
 	<div class="page">
        <a href="onePageServlet?curPage=1" title="">首页</a>
        
        <c:if test="${sessionScope.page.curPage > 1}">
        	<a href="onePageServlet?curPage=${sessionScope.page.curPage-1}" title="">上一页</a>
        </c:if>
        <c:if test="${sessionScope.page.curPage == 1}">
        	<a title="">上一页</a>
        </c:if>
        
        <c:if test="${sessionScope.page.curPage < sessionScope.page.maxPage}">
        	<a href="onePageServlet?curPage=${sessionScope.page.curPage+1}" title="">下一页</a>
        </c:if>
        
        <c:if test="${sessionScope.page.curPage == sessionScope.page.maxPage}">
        	<a title="">下一页</a>
        </c:if>
        
        <a href="onePageServlet?curPage=${sessionScope.page.maxPage}" title="">尾页</a> 
    </div>
  </div>
  <script>
   function abc(){
	   
	   if(confirm("你真的确认要删除吗？请确认")){
	    
		   return true;
		 }
		 else{
			 return false;
			 }
			 
	   };
	   function dele(){
		   if(confirm("你真的确认要修改吗？请确认")){
			   return true;
			   }
			   else{
				   return false;
				   }
		   }
  </script>
<!-- main end-->
</div>
</body>
</html>
