<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录界面</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>

<center>
    <form action="${pageContext.request.contextPath}/loginServlet" method="post">
         
         <div class="rcorners1">
		<table>
         
                 <h1>登陆页面</h1>
                 </br>
                 用户名  <input type="text" name="username"></br>
                 </br>
                 密&nbsp;&nbsp;码  <input type="password" name="password"></br>
                 </br>
                 
                  <a href="register.jsp">注册</a> <a href="index.html">返回首页</a>
                  <input type="submit" value="登录"> </tr><input type="reset" value="重置"></p>
                 
            
             </table>
             </div>
     </form>
 </center>
</body>
</html>