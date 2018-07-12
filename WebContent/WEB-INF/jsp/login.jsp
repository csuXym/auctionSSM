<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录页面</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="wrap">
<!-- main begin-->
 <div class="main">
   <div class="sidebarg fnone">
     <form class="loginForm" action="loginning" method="post" target='_blank'>
    <div class="login">
      <dl>
        <dt>用户登陆</dt>
        <dd><label for="name">用户名：</label><input type="text" class="inputh"  id="name" name="name"/></dd>
        <dd><label for="password">密 码：</label><input type="password" class="inputh" value="" id="password" name="password"/></dd>
       	<dd><label for="checkpassword">验证码：</label><input type="text" name="check" class="inputh">  
	       <img   
	           alt=""   
	           src="<%= request.getContextPath() %>/authImage"  
	           align="bottom"  
	           title="看不清可单击图片刷新"   
	           onclick="this.src='<%= request.getContextPath() %>/authImage?d='+Math.random();"  
	       />  
       	</dd>
        <dd class="buttom">
           <input name="login" type="submit" value="登 录" class="spbg buttombg buttomb f14 lf" />
           <input name="reg" type="submit" value="注 册" class="spbg buttombg buttomb f14 lf" />
          
           <div class="cl"></div>
        </dd>
       	
       	<dd>
       		 <font color="red">  
			    <%= request.getSession().getAttribute("message") == null   
			        ? "" : request.getSession().getAttribute("message")   
			    %>  
    		</font>  
       	</dd>
      </dl>
    </div>
    </form>
   </div>
  <div class="cl"></div>
 </div>
<!-- main end-->
 
<!-- footer begin-->
</div>
 <!--footer end-->
 
</body>
</html>