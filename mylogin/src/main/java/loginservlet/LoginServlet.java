package loginservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/login/LoginServlet")
@WebServlet(urlPatterns = {"/login/LoginServlet","/aaa"})
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//直接进入需判断，否则报错
				if(request.getParameter("uname") == null || request.getParameter("upwd") == null){
					//request.getRequestDispatcher("/login/login.jsp").forward(request,response);//请求转发
					response.sendRedirect("/mylogin/login/login.jsp");//重定向
					return; //重定向不加rutrun的话 会执行下方代码则会报错
				}
				request.setCharacterEncoding("utf-8");
				String name = request.getParameter("uname");
				String pwd = request.getParameter("upwd");
				String rem = request.getParameter("remember");
				if(name.equals("zs") && pwd.equals("123")){
					Cookie cookie1 = new Cookie("uname","zs");
					
					response.addCookie(cookie1);
					if(rem != null) {
						Cookie cookie2 = new Cookie("upwd","123");
						response.addCookie(cookie2);
						cookie2.setMaxAge(5);
					}
					response.sendRedirect("/mylogin/login/success.jsp");//重定向
					
				}else{
					request.setAttribute("errorMessage", "用户名或密码错误！");
					request.getRequestDispatcher("/login/login.jsp").forward(request,response);//请求转发
				}
				
		
	}

}
