<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户注册页面</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="wrap">
  <!-- main begin-->
      <div class="zclf login logns">
        <h1  class="blue">用户注册</h1>
        <form action="register" method="post" name="reg">
          <dl>
            <dd>
              <label> <small>*</small>用户名</label>
              <input type="text" class="inputh lf" value="" name="userName"/>
           
            </dd>
            <dd>
              <label> <small>*</small>密码</label>
              <input type="password" class="inputh lf" value="" name="userPassword"/>
           
            </dd>
           
            <dd>
              <label> <small>*</small>确认密码</label>
              <input type="password" class="inputh lf" value="" name="userPasswordCheck" onkeyup="validate()"/><span id="msg"></span>
           
            </dd>
         
            <dd class="hegas">
              <label>&nbsp;</label>
              <input id="submit" type="submit" value="立即注册" class="spbg buttombg buttombgs f14 lf" />
            </dd>
          </dl>
        </form>
    </div>
<!-- main end-->
<!-- footer begin-->

</div>
 <!--footer end-->
   <script>
   function validate(){
	   var pw1 = document.reg.userPassword.value;
	   var pw2 = document.reg.userPasswordCheck.value;
	   if(pw1 == pw2){
		   document.getElementById("msg").innerHTML="<font color='green'>密码相同</font>";
		   document.getElementById("submit").disabled = false;
	   }
	   else{
		   document.getElementById("msg").innerHTML="<font color='red'>密码不相同</font>";
		   document.getElementById("submit").disabled = true;
	   }
   }
  </script>
</body>
</html>
