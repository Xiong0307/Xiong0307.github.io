<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	登录成功！欢迎您：
	<%
		Cookie cookies[] = request.getCookies();
		for(Cookie cookie: cookies){
			if(cookie.getName().equals("uname")){
				out.print(cookie.getValue());
				break;
			}		
		}
	%>
	<br />
	<!-- 根路径 -->
	<!-- <a href="/mylogin/login/login.jsp">返回到登录界面</a> -->
	<!-- 相对路径 -->
	<a href="login.jsp">返回到登录界面</a>
</body>
</html>