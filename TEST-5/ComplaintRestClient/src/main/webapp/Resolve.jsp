<%@page import="Infinite.ComplaintRestClient.Resolve"%>
<%@page import="com.sun.jersey.api.client.ClientResponse"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.sun.jersey.api.client.WebResource"%>
<%@page import="com.sun.jersey.api.client.Client"%>
<%@page import="java.sql.Date"%>
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
	Resolve resolve= new Resolve();
	resolve.setComplaintID(Integer.parseInt(request.getParameter("cmpid")));
	resolve.setResolvedBy(request.getParameter("ResolvedBy"));
	resolve.setComments(request.getParameter("comments"));
	//res.setResdate(Date.valueOf(request.getParameter("resdate")));

	
	Client cl=Client.create();
	
	WebResource wb=cl.resource("http://localhost:8080/ComplaintRestServices/webapi/Complaint/resolve");
	
	String result=new Gson().toJson(resolve);
	
	ClientResponse cr=wb.type("application/json").post(ClientResponse.class,result);
	  if (response.getStatus() != 200) {
	         throw new RuntimeException("Failed : HTTP error code : "
	              + cr.getStatus());
	     } 
	  
	  String output=cr.getEntity(String.class);
	  out.println(output);
%>
</body>
</html>