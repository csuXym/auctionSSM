<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>拍品信息</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="wrap">
<!-- main begin-->
  <div class="sale">
    <h1 class="lf">在线拍卖系统</h1>
    <div class="logout right"><a href="logoutServlet" title="注销">注销</a></div>
  </div>
  <div class="items sg-font lf">
      <ul class="rows">
        <li>名称：</li>
        <li class="borderno">${sessionScope.auction.auctionName}</li>
      </ul>
      <ul class="rows">
        <li>描述：</li>
        <li class="borderno">${sessionScope.auction.auctionDesc}</li>
      </ul>
      <ul class="rows">
        <li>开始时间：</li>
        <li class="borderno">${sessionScope.auction.auctionStartTime}</li>
      </ul>
      <ul class="rows">
        <li>结束时间：</li>
        <li class="borderno">${sessionScope.auction.auctionEndTime}</li>
      </ul>
      <ul class="rows border-no">
        <li>起拍价：</li>
        <li class="borderno">${sessionScope.auction.auctionStartPrice}</li>
      </ul>
  </div>
  <div class="rg borders"><img src="${sessionScope.auction.auctionPic}" width="270" height="185" alt="" /></div>
  <div class="cl"></div>
  
  <form action="jingpaiServlet" method="post" name="saled">
	  <div class="top10 salebd">
	       <p>
	       <label for="sale">出价：</label>
	       <input type="number"  class="inputwd" id="sale" name="sale" value="" onkeyup="validate()"/>
	       <input id="auctionPrice" name="auctionPrice" type="submit" value="竞 拍" class="spbg buttombg f14  sale-buttom" />
	       </p>
	       <p class="f14 red" id="msg"></p>
	  </div>
	  <div class="top10">
	    <input name="refresh" type="submit" value="刷 新" disabled="true" class="spbg buttombg f14" />
	    <input name="returnList" type="submit" value="返回列表" class="spbg buttombg f14" />
	  </div>
  </form>
  <div class="offer">
    <h3>出价记录</h3>
    <div class="items sg-font">
      <ul class="rows even strong">
        <li>竞拍时间</li>
        <li>竞拍价格</li>
        <li class="borderno">竞拍人</li>
      </ul>
      
      <c:forEach var="list" items="${sessionScope.auctionRecordList}">
	      <ul class="rows">
	        <li>${list.auctionTime}</li>
	        <li>${list.auctionPrice}</li>
	        <li class="borderno">${list.auctionUser.userName}</li>
	      </ul>
	  </c:forEach>
  </div>
  </div>
<!-- main end-->
</div>

   <script>
   function validate(){
	   var priceNow = parseInt(document.getElementById("sale").value);
	   var highestPrice = parseInt("${sessionScope.highestPrice}");
	   if(priceNow > highestPrice){
		   document.getElementById("msg").innerHTML="<font color='green'></font>";
		   document.getElementById("auctionPrice").disabled = false;
	   }
	   else{
		   document.getElementById("msg").innerHTML="<font color='red'>不能低于最高竞拍价</font>";
		   document.getElementById("auctionPrice").disabled = true;
	   }
   }
  </script>
  
</body>
</html>