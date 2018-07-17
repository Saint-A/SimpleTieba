<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <style type="text/css">
    .main{
    text-align: center; /*让div内部文字居中*/
    background-color: #ededed;
    border-radius: 20px;
    width: 300px;
    height: 350px;
    margin: auto;
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
}

	p{
		font-size:30px;
		color:#337abf;
		margin:0;
	}
	.login{
	border-radius: 4px;
	border-width:1px;
	border-color:#cbcbcb;
	margin-top:30px;
	margin-left:20px;
	height:30px;
	}
	
	#submit{
	margin-top:30px;
		height:50px;
		width:230px;
		border-width:2px;
		border-color:#cbcbcb;
		border-radius: 8px;
		background-color: #337abf;
		color:#fff;
		font-soze:20px;	
	}
	
	b{
		font-soze:20px;	
		color:#337abf;
	}
	
	a{
		font-soze:20px;	
		color:#337abf;
		 text-decoration:none; 
	}
    </style>
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body bgcolor="#ededed">
  	<%session.setAttribute("iflogin", false);
  	  session.setAttribute("User",null); %>
    <div class="main">
    	<p align="center" >MyBlog</p>
    	<form action="login.action" method="post">
    		<b>账户</b><input type="text" name="user.id" class="login"><br>
    		<b>密码</b><input type="password" name="user.password" class="login"><br>
    		<b>验证码：</b><input type="text" name="checkcode" class="login"/>
			<img border="0" src="checkcode"/>
			<input type="submit" value="换一张" onclick="form1.action='changecheckcode'"><br>
    		<input type="submit" value="登录" id="submit"><br>
    		<a href="main.jsp">访客登录</a><br>
    	</form>
    </div>
   		<%String message=(String)request.getAttribute("errormessage");
   		if(message==null) {}
   		else{
   		%>
   			<p><%= message%></p>
   		<% }%>
  </body>
</html>
