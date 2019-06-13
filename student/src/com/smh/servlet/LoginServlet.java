package com.smh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smh.Dao.UserDao;
import com.smh.Model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//User user = new User(username, password);
		Boolean flag = new UserDao().login(username, password);
		if(flag)
		{
			request.getSession().setAttribute("username", username);
			request.getRequestDispatcher("/ShowStudentServlet").forward(request, response);
		}else{
			request.setAttribute("errorMessage", "账号或密码不正确");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
