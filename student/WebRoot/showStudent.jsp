<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showStudent.jsp' starting page</title>
    
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
	<table border="1px" cellspacing="1px">
		<tr>
			<th>姓名</th>
			<th>年龄</th>
			<th>性别</th>
			<th>地址</th>
			<th>学历</th>
			<th>专业</th>
			<th>修改</th>
			<th>删除</th>
		</tr>
		<c:forEach items="${list}" var="students">
		<tr>
			<td>${students.name}</td>
			<td>${students.age}</td>
			<td>${students.gender}</td>
			<td>${students.address}</td>
			<td>${students.education}</td>
			<td>${students.major}</td>
			<td><a href="updateStudent.jsp?id=${students.id}">修改</a></td>
			<td><a href="DeleteStudentServlet?id=${students.id}">删除</a></td>
		</tr>
		</c:forEach>
		<tr>
			<td><a href="addStudent.jsp">添加学生</a></td>
		</tr>
	</table> 
  </body>
</html>
