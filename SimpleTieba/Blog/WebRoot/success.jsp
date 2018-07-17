<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="bean.User" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'success.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <% User user=(User)session.getAttribute("User"); %>
   <p align="center">
   	欢迎您，新用户<%=user.getUsername() %> </p>
   	<p align>您的账户号码为<%=user.getId() %></p>
   
   <p align="center"><a onclick="window.parent.location.href='index.jsp'">登录</a></p>
  </body>
</html>
