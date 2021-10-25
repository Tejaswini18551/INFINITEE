
<%@page import="com.java.MainDao"%>
<%@page import="com.java.Booking"%>
<%@page import="java.sql.Date"%>
<%@page import="com.java.Booking"%>
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
	Booking book = new Booking();
	book.setBookid(request.getParameter("bookid"));
	book.setRoomid(request.getParameter("roomid"));
	book.setCustname(request.getParameter("cust"));
	book.setCity(request.getParameter("city"));
	long millis=System.currentTimeMillis();  
	java.sql.Date date=new java.sql.Date(millis); 
	book.setBookdate(date);
	book.setChkindate(Date.valueOf(request.getParameter("chkindate")));
	book.setChkoutdate(Date.valueOf(request.getParameter("chkoutdate")));
	MainDao dao= new MainDao();

		String res = dao.addbooking(book); 
		out.println(res); 
	%>
</body>
</html>>