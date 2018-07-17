<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="bean.User" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'MyPage.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	#nav { width:270px; height: 400px; border: 0px solid #000; position:fixed;left:30px;top:30px;scrolling:yes;backgroundcolor=" #fff" }
	#comment{
		
		text-decoration:none;
		font-color:#000;
	}
	</style>
	<script type="text/javascript" src="ajax.js"></script>
	<script type="text/javascript">
		function GetFriends(){
			var url="getfriend";
			var params="";
			clear();
			sendRequest(url,params,'POST',ShowFriends);
		}
		function GetFanses(){
			var url="getfanses";
			var params="";
			clearfanses();
			sendRequest(url,params,'POST',ShowFanses);
		}
		function ShowFriends(){
			if(xmlHttpRequest.readyState==4){
				if(xmlHttpRequest.status==200){
					document.getElementById("friends").style.visibility="visible";
					var tbody=document.getElementById("friendtbody");
					var friendslist=null;
					friendslist=xmlHttpRequest.responseText.split(",");
					var friendsnum=friendslist.length;
					console.log(friendsnum);
					for(i=0;i<friendsnum;i++)
					{	
						var newTr=document.createElement('tr');
						var newCell=document.createElement('td');
						var wordText=friendslist[i];
						console.log(friendslist[i]);
						var textNode=document.createTextNode(wordText);
						newCell.onmouseover=setBgColor;
						newCell.onclick=getBlogs;
						newCell.appendChild(textNode);
						newTr.appendChild(newCell);
						tbody.appendChild(newTr);
						
					}
				}
			}
		}
		function ShowFanses(){
			 	if(xmlHttpRequest.readyState==4){
				if(xmlHttpRequest.status==200){
					document.getElementById("fanses").style.visibility="visible";
					var tbody=document.getElementById("fansetbody");
					
					var fanseslist=xmlHttpRequest.responseText.split(",");
					var fansesnum=fanseslist.length;
					for(i=0;i<fansesnum;i++)
					{
						var newTr=document.createElement('tr');
						var newCell=document.createElement('td');
						var textNode=document.createTextNode(fanseslist[i]);
						newCell.onmouseover=setBgColor;
						newCell.onclick=getBlogs;
						newCell.append(textNode);
						newTr.append(newCell);
						
						tbody.append(newTr);
					}
				}
			}
		
		}
		
		function clear(){
			var tbody=document.getElementById("friendtbody");
			var trs=tbody.getElementsByTagName('tr');
			
			for(var i=trs.length-1;i>=0;i--)
			{
				tbody.removeChild(trs[i]);
			}
			
		}
		
		function clearfanses(){
			var tbody=document.getElementById("fansetbody");
			var trs=tbody.getElementsByTagName('tr');
			
			for(var i=trs.length-1;i>=0;i--)
			{
				tbody.removeChild(trs[i]);
			}
		}
		
		function setBgColor(){
		trSrc=event.srcElement;
		if(trSrc)
			trSrc.style.backgroundColor="white";
		
		trSrc.style.backgroundColor="gray";
		}
		
		function getBlogs(){
			var info=trSrc.firstChild.data;
			var infolist=info.split("(");
			var username=infolist[0];
			var idre=infolist[1];
			var id=idre.substr(0,idre.length-1);
			alert(id);
			window.parent.main.location.href="findmyblog.action?id="+id+"&name="+username+"&method=friends";
		}
		
	</script>
  </head>
  
  <body bgcolor=" #ededed" >
  	<% User user =(User)session.getAttribute("User");
  		String userinfo=user.getUsername()+"("+user.getId()+")"; %>
   	<div id="nav"  >
		<p ><%=user.getUsername()%>(<%=user.getId()%>)<p>
		<p id="Guanzhu"><a onclick="GetFriends()">我的关注</a></p>
		<div id="friends" style="visibility:hidden" >
			<table id="friendtable">
				<tbody id="friendtbody"><tr><td></td></tr></tbody>
			</table>
		</div>
		<p><a onclick="GetFanses()">我的粉丝</a></p>
		<div id="fanses" style="visibility:hidden" >
		  	<table id="fansetable">
				<tbody id="fansetbody"><tr><td></td></tr></tbody>
			</table>
		</div>
		<p><a href="getmycomment.action" target="main" id="comment">我的评论</a></p>
   	</div>
  </body>
</html>
