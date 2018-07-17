<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="bean.Simplearticle" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'MyBlog.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	a{
		margin:100px;
		text-decoration:none;
	}
	</style>
  </head>
  
  <body>
    <h3><a href="findmyblog.action" target="main">已发博客</a><a href="createblog.jsp" target="main">新建博客</a></h3>
      <%

    List<Simplearticle> salist=(ArrayList<Simplearticle>)session.getAttribute("salist");
    System.out.println("进入输出页面");
    %>
  	 		<% Iterator it=salist.iterator();
  	 		
  	 		while(it.hasNext()){
  	 		Simplearticle sa=(Simplearticle)it.next();
  	 		System.out.println(sa.getTitle());
  	 		int articleId=sa.getArticleId();
  	 		 %>
 			<div onclick="location.href='getarticle.action?articleId=<%= articleId%>';">
 			 <h3><%= sa.getTitle()%></h3>
 			 <p><%= sa.getIntrodution()%></p>
 			 <p><%= sa.getUpdateTime()%></p>
 			 <hr></hr>
 			</div>
 	 		
  	 		<% }%>
   
  </body>
</html>
