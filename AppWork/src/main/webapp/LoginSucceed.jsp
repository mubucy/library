<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆成功</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>

<center>
<div class="rcorners2">
<tr>
	<p>登录成功，欢迎您！${sessionScope.username}  <a href="index.html">返回首页</a>
	<a href="Updata.jsp">修改密码</a></p>
</tr>
		</br>
		</br>
		</br>
	<form action="${pageContext.request.contextPath}/WorkServlet1" method="post">
	
             
            <h1>请输入您想寻找的书籍信息</h1>
            </br>
            <p><input name = "workname" type="text"/>  <input type="submit" value="搜索"></p>
           
        
	</form>
</center>
	</div>
</body>
</html>