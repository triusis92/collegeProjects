<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:useBean id="MyBeanBeanId" class="com.ass1.MyBean" scope="session" />
<jsp:setProperty name="MyBeanBeanId" property="*" />
<title>Insert title here</title>
</head>
<body>

<%
//This jsp page was used for redirecting the bean inputs

String url="http://localhost:8080/Assignment1/skidMarkServlet";
	response.sendRedirect(url);
%>
</body>
</html>