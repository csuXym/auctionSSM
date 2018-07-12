<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加拍品</title>
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
      <div class="login logns produce">
        <h1 class="blues">拍卖品信息</h1>
        <form action="publishServlet" method="post" name="publish">
          <dl>
            <dd >
              <label>名称：</label>
              <input name="name" type="text" class="inputh lf" value="" />
              <div class="xzkbg spbg lf"></div>
            </dd>
            <dd>
              <label>起拍价：</label>
              <input name="firstPrice" type="number" class="inputh lf" value="" />
           
            </dd>
         
            <dd>
              <label>开始时间：</label>
              <input name="startTime"  type="date"  class="inputh lf" value="2018-04-27" />
              
            </dd>
            <dd>
              <label>结束时间：</label>
              <input name="endTime"  type="date" class="inputh lf" value="2018-05-07" />
            
            </dd>
            <dd class="dds">
              <label>拍卖品图片：</label>
               <div class="lf salebd">  <input name="picture" type="file" class="offset10 lf" /></div>
                         
            </dd>
             <dd class="dds">
              <label>描述：</label>
              <textarea name="describe" cols="" rows="" class="textarea"></textarea>
            </dd>
            <dd class="hegas">
                <input name="sive" type="submit" value="保 存" class="spbg buttombg buttombgs buttomb f14 lf" />
                <input name="cancel" type="submit" value="取 消" class="spbg buttombg buttombgs buttomb f14 lf" />
            </dd>
          </dl>
          </form>
    </div>
<!-- main end-->
<!-- footer begin-->

</div>
 <!--footer end-->
 

</body>
</html>
