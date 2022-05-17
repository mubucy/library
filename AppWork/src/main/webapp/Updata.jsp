<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改密码</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>

<center>
	<form action="update" method="Post">
    <div class="rcorners1">
    
		<table>
		</br>
		<h3>请输入用户名和新的密码</h3>
        </br>
		用户名   <input type="text" name="username"></br>
		</br>
   	 	新密码 <input type="password" name="password"></br>
   	 	</br>
   	 	 <a href="Login.jsp">返回登录</a><a href="index.html">返回首页</a>
   		 <input type="submit" value="确认修改" onclick="alert('是否确认修改')">
		<input type="reset" value="重置">
   		 
		
	
		</table>
     </div>
     </form>
 </center>
</body>
</html>