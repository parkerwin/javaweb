package com.smh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smh.Dao.StudentDao;

@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		int flag = new StudentDao().deleteStudent(id);
		System.out.println(flag);
		if(flag == 1)
		{
			request.getRequestDispatcher("/ShowStudentServlet").forward(request, response);
		}else{
			request.setAttribute("deleteError", "É¾³ýÊ§°Ü");
			request.getRequestDispatcher("/ShowStudentServlet").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
