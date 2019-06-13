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
    
    <title>My JSP 'addStudent.jsp' starting page</title>
    
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
    <font style="color:red">
  		<c:if test="${insertError != null}">
  			<c:out value="${insertError}"></c:out></br>
  		</c:if>
  	</font>
    <form action="AddStudentServlet" method="post">
    	姓名：<input type="text" name="name"/>
    	年龄：<input type="text" name="age"/></br>
    	性别：<input type="text" name="gender"/>
    	住址：<input type="text" name="address"/></br>
    	学历：<input type="text" name="education"/>
    	专业：<input type="text" name="major"/></br>
    	<input type="submit" value="提交"/></br>
    </form>
  </body>
</html>
