<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'header.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	#nav { width:100%; height: 76px; border: 1px solid #D4CD49; position:fixed;left:0;top:0 }
	td{
		height:80px;
		font-size:24px;
		padding:40px;
	}
	a{
		text-decoration:none;
	}
	</style>
	</head>
  
  <body bgcolor=" #ededed">
   <div id="nav" align="center">
  		<table>
  			<tr height="80px">
  				<td ><a href="findallblog.action" target="main">推荐博客</a></td>
  				<td><a href="findmyblog.action" target="main">我的博客</a></td>
  			</tr>
  		</table>
  		
  	</div>
  </body>
</html>
