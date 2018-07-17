<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>注册页面</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function validate(){
		alert("确认注册？");
			var name=document.form1.username.value;
			var pwd=document.form1.pwd.value;
			var pwd1=document.form1.password.value;
			if(name.length<=0) alert("呢称不能为空！");
			else if(pwd!=pwd1) alter("两次输入密码不一致！");
			else return true;
		}
	</script>
	<style type="text/css">
	#nav { width:268px;left:30px; height: 400px; border: 0px solid #D4CD49; position:fixed;top:0 }
	.ab{margin:20px 5px 10px 36px;}
	#c{margin:20px 5px 10px 4px;}
	#submit{
		margin:10px 126px;
	}
	</style>
  </head>
  
  <body bgcolor=" #ededed">
    <div id="nav">
    	<form action="register.action" method="post" name="form1">
    		<span>呢称：</span><input type="text" class="ab" name="username"/> <br>
    		<span>密码：</span><input type="password" class="ab" name="pwd"/> <br>
    		<span>确认密码：</span><input type="password" name="password" id="c"/><br>
    		<input type="submit" value="注册" onclick=" return validate()" id="submit"/ > 
    	</form>
    </div>
  </body>
</html>
