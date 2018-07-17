<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'createblog.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
  </head>
  
  <body>
  <%if((Boolean)session.getAttribute("iflogin")){ %>
    <form action="createblog.action" method="post">
    	标题：<input type="text" name="simplearticle.title"><br>
    	简介：<input type="text" name="simplearticle.introdution"><br>
    	内容：<br>
    	<textarea class="ckeditor" rows="10" cols="80" name="article.content"></textarea><br>
    	<input type="submit" value="提交">
    </form>
    	
    <%}
     else {%>
     <p>您还没有登录，无法使用此功能，请先<a href="index.jsp">登录</a></p>
     <%} %>
  </body>
</html>
