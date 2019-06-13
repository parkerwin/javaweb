<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.smh.Dao.StudentDao"%>
<%@page import="com.smh.Model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateStudent.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
    	int studentId = Integer.parseInt(request.getParameter("id"));
   		Student student = new StudentDao().selectStudent(studentId);
    %>
    <font style="color:red">
  		<c:if test="${updateError != null}">
  			<c:out value="${updateError}"></c:out></br>
  		</c:if>
  	</font>
    <form action="UpdateStudentServlet"  method="post">
    	<input type="hidden" name="id" value="<%= student.getId()%>">
    	姓名：<input type="text" name="name" value="<%= student.getName()%>"/>
    	年龄：<input type="text" name="age" value="<%= student.getAge()%>"/></br>
    	性别：<input type="text" name="gender" value="<%= student.getGender()%>"/>
    	住址：<input type="text" name="address" value="<%= student.getAddress()%>"/></br>
    	学历：<input type="text" name="education" value="<%= student.getEducation()%>"/>
    	专业：<input type="text" name="major" value="<%= student.getMajor()%>"/></br>
    	<input type="submit" value="提交"/></br>
    </form>
  </body>
  
</html>
