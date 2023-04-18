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
		//ֱ�ӽ������жϣ����򱨴�
				if(request.getParameter("uname") == null || request.getParameter("upwd") == null){
					//request.getRequestDispatcher("/login/login.jsp").forward(request,response);//����ת��
					response.sendRedirect("/mylogin/login/login.jsp");//�ض���
					return; //�ض��򲻼�rutrun�Ļ� ��ִ���·�������ᱨ��
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
					response.sendRedirect("/mylogin/login/success.jsp");//�ض���
					
				}else{
					request.setAttribute("errorMessage", "�û������������");
					request.getRequestDispatcher("/login/login.jsp").forward(request,response);//����ת��
				}
				
		
	}

}
