
<%@page import="com.java.Billing"%>
<%@page import="com.java.Room"%>
<%@page import="com.java.Status"%>
<%@page import="java.util.List"%>
<%@ page import="com.java.MainDao" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	Billing bill = new Billing();
	bill.setBookid(request.getParameter("bookid"));
	bill.setRoomid(request.getParameter("roomid"));
	  MainDao obj= new MainDao();
		int res = obj.billing(bill); 
		out.println("The Amount Due is "+res); 
	%>
</body>
</html>