<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="bean.Simplearticle" %>
<%@ page import="bean.Article" %>
<%@ page import="bean.Comment" %>
<%@ page import="bean.User" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'BlogArticle.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="ajax.js"></script>
	<script type="text/javascript">
		function checkJurisdiction(){
			console.log("asafasfas");
			var isadmin=document.getElementById("button1");
			console.log(isadmin.value);
			if(isadmin.value>=10000){
				window.alert("您没有权限进行此次操作！");
			}
			else{
				window.location.href="deleteblog.action";
			}
		}
		
		function Like(){
		
			 var img=document.getElementById("like");
			 if(img.getAttribute("src",2)=="img/like2.jpg")
			 {
			 	return;
			 }
			 img.src="img/like2.jpg";
			 var url="addlikecounts";
			var params="";
			sendRequest(url,params,'GET',Like_Count);
		}
		
		function Like_Count(){
			if(xmlHttpRequest.readyState==4)
			{
				if(xmlHttpRequest.status==200)
				{
				    
					var likecounts=document.getElementById("likecounts");
					var counts=xmlHttpRequest.responseText;
					likecounts.innerHTML=counts;
				}
			}		
		}
	</script>
  	<style type="text/css">
  		h3{
  			font:italic bold 20px arial,sans-serif;
  		}
  	</style>
  
  </head>
  
  <body>
   <%Simplearticle sa=(Simplearticle)session.getAttribute("sa");
     Article article=(Article)session.getAttribute("article");
     User user=(User)session.getAttribute("User");
       %>
     <div id="article">
     <h3><%= sa.getTitle()%></h3>
 			<p><%= sa.getIntrodution()%></p>
 			<p><%= sa.getUser().getUsername()%></p>
 			<p><%= sa.getUpdateTime()%></p>
 			<hr></hr>
 			<p><%= article.getContent()%></p>
 			<p align="right"> <a onclick="Like()"><img id="like" src="img/like1.jpg" width="16" height="16"></img></a>
 			<b id="likecounts">${ sa.getLike_count()}</b>
 			 &nbsp;&nbsp;
 			<a href="addfriend.action" >关注</a>
 			<button id="button1" value=<%=user.getId() %> onclick="checkJurisdiction()">封禁</button>
 			</p>
 	</div>
 	 <%

    List<Comment> commentlist=(ArrayList<Comment>)session.getAttribute("commentlist");
    System.out.println("进入评论输出页面");
    %>
  	 		<% Iterator it=commentlist.iterator();
  	 		
  	 		while(it.hasNext()){
  	 		Comment comment=(Comment)it.next();
  	 		 %>
 			<div class="comment">
 				<hr></hr>
 			 <h3><%= comment.getUser().getUsername()%></h3>
 			 <p><%= comment.getComment()%></p>
 			</div>
 			<%} %>
 		<form action="savecomment.action" method="post">
 		 <textarea rows="4" cols="80" name="comment.comment"></textarea>
 		 <input type="hidden"  name="articleId" value=<%= sa.getArticleId() %>>
 		 <input type="submit" value="评论" />
 		</form>
 		 
  </body>
</html>
