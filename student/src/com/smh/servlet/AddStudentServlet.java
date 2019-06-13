package com.smh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smh.Dao.StudentDao;
import com.smh.Model.Student;
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String education = request.getParameter("education");
		String major = request.getParameter("major");
		Student stu = new Student(name, age, gender, address, education, major);
		int i = new StudentDao().addStudent(stu);
		if(i == 1){
			request.getRequestDispatcher("/ShowStudentServlet").forward(request, response);
		}else{
			request.setAttribute("insertError", "ÃÌº” ß∞‹");
			request.setAttribute("student", stu);
			request.getRequestDispatcher("/addStudent.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
