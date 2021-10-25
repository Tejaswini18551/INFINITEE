<%@page import="com.java.Room"%>
<%@page import="com.java.MainDao"%>
<%@page import="com.java.Booking"%>
<%@page import="com.java.Room"%>
<%@page import="com.java.Status"%>
<%@page import="java.util.List"%>
<%@ page import="com.java.MainDao" %><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<form method="post" action="RoomBook.jsp">
	<center>
		<h2>Book Room:</h2>
		Book ID:
		<%
		    String rid= new MainDao().genbookid();
		   
		%>
		<input type="text" name="bookid" value="<%=rid%>" size="25" /><br/><br/>
		
		Room ID:
		<select name="roomid" >
		<%
		
		    MainDao dao= new MainDao();
		
			
		List<Room> lst=dao.showrooms();
		for(Room b:lst){
			String bid = b.getRoomid();
			%>
			<option><%=bid%></option>	
		 <% } %>
		</select> <br/><br/>
		Customer Name:
		<input type="text" name="cust" size="25" /><br/><br/>
		City:
		<input type="text" name="city" size="25" /><br/><br/>
		Check in Date:
		<input type="date" name="chkindate" size="25" /><br/><br/>
		Check out Date:
		<input type="date" name="chkoutdate" size="25" /><br/><br/>
		<input type="submit" value="Insert"/>
	</center>
	</form>
</body>
</html>