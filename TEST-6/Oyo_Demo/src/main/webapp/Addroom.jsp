<%@page import="com.java.MainDao"%>
<%@page import="com.java.Status"%>
<%@page import="com.java.Room"%>
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
	Room room = new Room();
	room.setType(request.getParameter("type"));
	room.setStatus(Status.valueOf(request.getParameter("status")));
	room.setCostperday(Integer.parseInt(request.getParameter("cost")));
		MainDao obj= new MainDao();

		String res = obj.addRoom(room); 
		out.println(res); 
	%>	
</body>
</html>