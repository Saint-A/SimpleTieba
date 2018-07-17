<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="bean.Comment" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'showmycomment.jsp' starting page</title>

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
     <%

    List<Comment> commentlist=(ArrayList<Comment>)request.getAttribute("comments");
    System.out.println("进入评论输出页面"+commentlist.size());
	if(commentlist==null)
	{
	%>
		<h3>您暂未评论</h3>
	<%
	}
    else{%>
  	 		<% Iterator it=commentlist.iterator();
  	 		
  	 		while(it.hasNext()){
  	 		Comment comment=(Comment)it.next();
  	 		 %>
 			<div class="comment">
 			 <h3><%= comment.getUser().getUsername()%></h3>
 			 <p><%= comment.getComment()%></p>
 			 <hr></hr>
 			</div>
 			<%}} %>
 	  </body>
</html>
