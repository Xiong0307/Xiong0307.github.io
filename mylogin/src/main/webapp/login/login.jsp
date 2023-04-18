<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	String uname ;
%>
<%
	String upwd = "";
	if(request.getCookies() != null){
		Cookie cookies[] = request.getCookies();
		for(Cookie cookie: cookies){
			
			if(cookie.getName().equals("uname")){		
				uname = cookie.getValue();
			}
			if(cookie.getName().equals("upwd")){		
				upwd = cookie.getValue();
			}
		}
		if(request.getAttribute("errorMessage") != null){
			upwd = "";
		}
	}	
%>
 <h1>欢迎登录</h1>
    <form action="LoginServlet" method="post">
        <label>用户名：</label>
        <input type="text" name="uname" value=<%=uname==null?"":uname%> ><br/>
        <label> 密&ensp;&ensp;码：</label>
        <input type="password" name="upwd" value=<%=upwd.equals("")?"":upwd%> ><br/>
         记住密码<input type="checkbox" name="remember" value="yes" /><br/>
        <input type="submit" value="登录"/><br/>
       
        <%-- 显示错误信息 --%>
        <%
        String errorMessage = (String)request.getAttribute("errorMessage");
        %>
       <%=errorMessage==null?"":errorMessage%>
    </form>

</body>
</html>