<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'main.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		#parent{
		}
	</style>
  </head>
  
      <frameset rows="80,*" id="parent" frameborder="0" >
    	<frame src="header.jsp" scrolling="no" bordercolor="">
    	<frameset cols="300,*">
    		
    		<%if((Boolean)session.getAttribute("iflogin")) {%>
    		<frame src="MyPage.jsp" name="right" scrolling="no">
    		<%}
    		  else{	 %>
    		<frame src="register.jsp" name="right" scrolling="no">
    		  <%} %>
    		<frame src="findallblog.action" scrolling="auto" name="main">
    	</frameset>
    </frameset>
</html>
  	
  